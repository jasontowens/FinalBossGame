package entity;

import java.util.ArrayList;
import java.util.HashMap;

import gameobject.GameObject;
import inventory.Inventory;
import stats.PlayerStats;
import item.Takeable;
import map.GameMap;
import item.Equipable;
import inventory.EquipSlot;
import map.CoordinatePair;

public class Entity extends GameObject{
	
	private MotionType myMotion;
	private Inventory myInventory;
	private Occupation myOccupation;
	private PlayerStats myStats;
    private GameMap map;
	
    /*---------CONSTRUCTORS---------------*/
	public Entity(String name, String description, MotionType mobility, Inventory inventory, Occupation occ, PlayerStats stats, GameMap m){
		super("Entity", name, description); 
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
