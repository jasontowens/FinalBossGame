package entity;

//need changeMoney(int) that adds the int to current amount of currency

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
        
        GameMap map;
	
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
}
