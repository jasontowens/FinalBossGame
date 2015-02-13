package entity;

//need changeMoney(int) that adds the int to current amount of currency

import gameobject.GameObject;
import inventory.Inventory;
import stats.PlayerStats;
import item.Takeable;
import map.MotionType;


public class Entity extends GameObject{
	
	MotionType myMotion;
	Inventory myInventory;
	Occupation myOccupation;
	PlayerStats myStats;
	
	public Entity(String name, String description, MotionType mobility, Inventory inventory, Occupation occ, PlayerStats stats){
		super("Entity", name, description); //generates ID
		myMotion = mobility;
		myOccupation = occ;
		myStats = stats;		
	}
	
	public void levelUp(){
		myStats.levelUp();
		//could update occupation abilities here
	}
	
	
	public void dropItem(Takeable item){
		myInventory.removeItem(item);
		//the item should drop to map                
	}
        /*
	public void move(int xDirection, int yDirection){
		
		
	}
        */
	public void addItem(Takeable item){
		
	
	}
	public MotionType getMotionType(){
		return myMotion;
	}
}
