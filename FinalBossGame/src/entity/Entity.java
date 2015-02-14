package entity;

//need changeCurrency(int) that adds the int to current amount of currency

import gameobject.GameObject;
import inventory.Inventory;
import stats.PlayerStats;
import item.Takeable;
import map.GameMap;
import map.CoordinatePair;


public class Entity extends GameObject{
	
	MotionType myMotion;
	Inventory myInventory;
	Occupation myOccupation;
	PlayerStats myStats;
        
        private GameMap map;
	
	public Entity(String name, String description, MotionType mobility, Inventory inventory, Occupation occ, PlayerStats stats, GameMap m){
		super("Entity", name, description); 
		myMotion = mobility;
		myOccupation = occ;
		myStats = stats;
                
                this.map = m; 
	}
	
	public void levelUp(){
		myStats.levelUp();
		//could update occupation abilities here
	}
	
	
	public void dropItem(Takeable item){	
            CoordinatePair tmp = map.getLocation(this);
            tmp.add(1, 0); //puts item one tile to the right of entity
            map.addItem( myInventory.removeItem(item), tmp);
            //the item should drop to map                
	}
        
        public void dropItem(int location){
            CoordinatePair tmp = map.getLocation(this);
            tmp.add(1, 0); //puts item one tile to the right of entity
            map.addItem( myInventory.removeItem(location), tmp);
        }
        
	public void move(int xDirection, int yDirection){
            //waiting on GameMap object
            CoordinatePair change = new CoordinatePair(xDirection, yDirection);
            map.requestMovement(this, change);
	}
        
	public void addItem(Takeable item){
            myInventory.addItem(item);
	}
	public MotionType getMotionType(){
            return myMotion;
	}
        
        public void setOccupation(String occupationName){
            myOccupation.name = occupationName;
        }
        
        
        //returns false if not enough money for mod
        public boolean changeMoney(int change){
            if(myInventory.getCurrency() + change >= 0){
                myInventory.modCurrency(change);
                return true;
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
        public int getMoney(){
            return myInventory.getCurrency();
        }
}
