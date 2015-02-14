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

public class Entity extends GameObject{
	
	private MotionType myMotion;
	private Inventory myInventory;
	private Occupation myOccupation;
	private PlayerStats myStats;
    private GameMap map;
	
    /*---------CONSTRUCTORS---------------*/
	public Entity(String name, String description, String spriteFilePath, MotionType mobility, Inventory inventory, Occupation occ, PlayerStats stats, GameMap m){
		super("Entity", name, description, spriteFilePath); 
		myMotion = mobility;
		myOccupation = occ;
		myStats = stats;
        this.map = m; 
	}
	
	/*------------COORDINATOR LEVEL OPERATIONS------------*/
    public void dropItem(int location){
            CoordinatePair tmp = map.getLocation(this);
            map.addItem(myInventory.removeItem(location), tmp);
    }    
	public void move(CoordinatePair change){
            map.requestMovement(this, change);
	}   
	
	/*------------ITEM LEVEL OPERATIONS---------------*/
	public void addItem(Takeable item){
        myInventory.addItem(item);
	}
	public void setOccupation(String occupationName){
    	myOccupation.name = occupationName;
    }
	public boolean changeMoney(int change){
    	if(myInventory.getCurrency() + change >= 0){
    		myInventory.modCurrency(change);
    		return true;
    	}
    	else
    	return false;
    }
	public void removeItem(Takeable item){	
		myInventory.removeItem(item);                
	}
	public boolean setMoney(int newAmount){
        if(newAmount >= 0){
            myInventory.modCurrency(newAmount); 
            return true;
        }
        else 
            return false;
    }
	
	public void mergeStats(Stats modifiers){
		this.myStats.mergeStats(modifiers);
	}
	
	/*------------MAP LEVEL OPERATIONS----------------*/
	public void levelUp(){
		myStats.levelUp();
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
		return null;
	}
	public ArrayList<Takeable> getSack(){
		
	}
}
