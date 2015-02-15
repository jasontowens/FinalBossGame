package entity;

import gameobject.GameObject;
import inventory.EquipSlot;
import inventory.Inventory;
import item.Equipable;
import item.Takeable;

import java.util.ArrayList;
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
	private PlayerStats myStats;
    private GameMap map;			// TODO: is this necessary?
    
    //Entities should have a CoordinatePair.  TODO: Update Constructor!
    //private CoordinatePair myLocation;
	
    /*---------CONSTRUCTORS---------------*/
	public Entity(String name, String description, String spriteFilePath, MotionType mobility, Inventory inventory, Occupation occ, PlayerStats stats, GameMap m){
		super("Entity", name, description, spriteFilePath); 
		myMotion = mobility;
		myOccupation = occ;
		myStats = stats;
                this.map = m; 
	}
	
	//needed to add this for testing.  And should Entity really have a GameMap? 
	public Entity(String name, String description, String spriteFilePath, MotionType mobility, Inventory inventory, Occupation occ, PlayerStats stats){
		super("Entity", name, description, spriteFilePath); 
		myMotion = mobility;
		myOccupation = occ;
		myStats = stats;
                 
	}
	
	/*------------COORDINATOR LEVEL OPERATIONS------------*/
    public void dropItem(int location){
    	map.addItem(myInventory.removeItem(location), map.getLocation(this));
    }    
    public void useItem(int location){
    	myInventory.useItem(location, this);
    }
	public void move(CoordinatePair change){
		map.requestMovement(this, change);
	}   
	
	/*------------ITEM LEVEL OPERATIONS---------------*/
	public void addItem(Takeable item){
        myInventory.addItem(item);
	}
	public boolean equipItem(Equipable item){
		return myInventory.equipItem(item);
	}
	public void removeItem(Takeable item){	
		myInventory.removeItem(item);                
	}
	public boolean changeMoney(int change){
    	if(myInventory.getCurrency() + change >= 0){
    		return myInventory.modCurrency(change);
    	}
    	else
    	return false;
    }
	public boolean setMoney(int newAmount){
        if(newAmount >= 0){
            myInventory.modCurrency(newAmount); 
            return true;
        }
        else 
            return false;
    }
        public void setOccupation(String occupationName){
            myOccupation.name = occupationName;
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
	public ArrayList<Takeable> getSack(){
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
		str += "<entity occupation=\"" + myOccupation.name + "\"" + " x=\"" + this.getLocation().getX() +
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
