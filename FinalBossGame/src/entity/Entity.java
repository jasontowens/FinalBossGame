package entity;

import coordinators.CoordinatorScheduler;
import coordinators.CoordinatorType;
import gameobject.GameObject;
import inventory.EquipSlot;
import inventory.Inventory;
import item.Equipable;
import item.Takeable;

import java.util.HashMap;

import map.CoordinatePair;
import map.GameMap;
import stats.PlayerStats;
import stats.Stats;
import util.Saveable;

public class Entity extends GameObject implements Saveable{
	
	private MotionType myMotion;
	private Inventory myInventory;
	private Occupation myOccupation;
	private static String occupationName  = null;
	private PlayerStats myStats;
        private GameMap map;			// TODO: is this necessary?
   // private int id;
    
    //Entities should have a CoordinatePair.  TODO: Update Constructor!
    //private CoordinatePair myLocation;
	
    /*---------CONSTRUCTORS---------------*/
	public Entity(String name, String description, int ID, MotionType mobility, Inventory inventory, Occupation occ, PlayerStats stats, GameMap m){
		super("Entity", name, description , 85); //TODO: change ID to how Hanif wants it set up 
		myMotion = mobility;
		myOccupation = occ;
		myStats = stats;
		myInventory = inventory;
		setOccupation("Smasher");
                this.map = m; 
        //id = 85; 	// TODO: get the directions working.
	}
	
	//needed to add this for testing.  And should Entity really have a GameMap? 
	public Entity(String name, String description, int ID, MotionType mobility, Inventory inventory, Occupation occ, PlayerStats stats){
		super("Entity", name, description, ID); //TODO: change ID to how Hanif wants it set up 
		myMotion = mobility;
		myOccupation = occ;
		myInventory = inventory;
		myStats = stats;
		setOccupation("Smasher");                
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	/*------------COORDINATOR LEVEL OPERATIONS------------*/
        public void dropItem(int location){
            map.addItem(myInventory.removeItem(location), new CoordinatePair(map.getLocation(this).getX(),map.getLocation(this).getY()));
        }    
        public void useItem(int location){
            myInventory.useItem(location, this);
        }
	public void move(CoordinatePair change){
            map.requestMovement(this, change);
	}   
	
	/*------------ITEM LEVEL OPERATIONS---------------*/
	public boolean addItem(Takeable item){
            return myInventory.addItem(item);
	}
	public boolean equipItem(Equipable item){
		boolean result = myInventory.equipItem(item, this);
		if(result) {
			item.onEquip(this);
		}
		return result;
	}
	public void removeItem(Takeable item){	
		myInventory.removeItem(item);                
	}
	public boolean changeMoney(int change){
            return myInventory.modCurrency(change);
        }
	public boolean setMoney(int newAmount){
            return myInventory.setCurrency(newAmount);
        }
        public void setOccupation(String occupationName){
    		if(this.occupationName != null){
    			switch(this.occupationName){
    			case "Smasher": myStats.modStrength(-10); break;
    			case "Summoner": myStats.modIntellect(-10); break;
    			case "Sneak": myStats.modAgility(-10); break;
    			}
    		}
            this.occupationName = occupationName;
            switch(this.occupationName){
			case "Smasher": myStats.modStrength(10); break;
			case "Summoner": myStats.modIntellect(10); break;
			case "Sneak": myStats.modAgility(10); break;
			}
        }
	public void mergeStats(Stats modifiers){
            this.myStats.mergeStats(modifiers);
	}
	
	/*------------MAP LEVEL OPERATIONS----------------*/
	public void levelUp(){
		myStats.levelUp();
	}
	//TODO: BE ABLE TO DIE
	public void die(){
		myStats.modLivesLeft(-1);
		map.removeEntity(this);
		if(myStats.getLivesLeft() > 0){
		map.addEntity(this, new CoordinatePair(15,15));
		myStats.sethpCurrent(1);
		}
                else{
                    CoordinatorScheduler.getInstance().changeCoordinator(CoordinatorType.MENU);
                }
	}
     
	public String getOccupationName(){
            return this.occupationName;
	}
	
	/*------------ACCESSORS----------------------*/	
	public int getMoney(){
		return myInventory.getCurrency();
	}
	public MotionType getMotionType(){
            return myMotion;
	}
	public PlayerStats getStats(){
		return myStats;
	}
	public Occupation getOccupation(){
		return myOccupation;
	}
	public HashMap<EquipSlot, Equipable> getArmory(){
		return myInventory.getArmoryHMap();
	}
	public Takeable[] getSack(){
		return myInventory.getSack();
	}

	public void setMotionType(MotionType myMotion2) {
		myMotion = myMotion2;
		
	}
	
	/*-------------@Override------------*/	
	//TODO: should MotionType also be saved?
	public String toXML(){	
		String str = "";
		
		/*
		 * As of right now, Occupation's name field does not have an access modifier. 
		 * I won't add one because I don't know if that will break anyone else's code or tests.
		 * 
		 * If Occupation's name becomes private, change the access below to use a getter.
		 * 
		 * -Hanif
		 */
		
		//opening <entity x=".." y=".."> tag
		str += "<entity occupation=\"" + myOccupation.getName() + "\"" + " x=\"" + this.getLocation().getX() +
				"\"" + " y=" + "\"" + this.getLocation().getY() + "\"" + ">";
		
		//Newline is probably not strictly necessary, but makes XML file much more readable
		str += "\n";
		
		if(myStats != null){
			str += myStats.toXML();
			str += "\n";
		}
		
		if(myInventory != null){
			str += myInventory.toXML();
			str += "\n";
		}
		

		str += "</entity>";
		
		
		
		return str;
	}
	
	
}
