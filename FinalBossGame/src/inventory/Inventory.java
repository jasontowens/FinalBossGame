package inventory;

import entity.Entity;
import item.*;

import java.util.ArrayList;
import java.util.HashMap;

import util.Saveable;


public class Inventory implements Saveable {
	private int currency;
	private Sack mySack;
	private Armory myArmory;
	
	
	/*---------CONSTRUCTORS----------*/
	public Inventory(Sack sack, Armory armory){
            mySack = sack;
            myArmory = armory;
            currency = 0;
	}
	
	/*----------MESSAGES PASSED FROM COORDINATORS------------*/
	public Takeable removeItem(int location){
		return mySack.removeItem(location);
	}
			
	public void useItem(int location, Entity ent){
		if(location <= 9){
			mySack.addItem(myArmory.unequip(EquipSlot.values()[location]));
		}
		else{
			mySack.useItem(location-10,ent);
		}
	}    
	
	/*---------MESSAGES PASSED FROM ITEMS---------------*/
	public void addItem(Takeable item){
		mySack.addItem(item);
	}
	public boolean equipItem(Takeable item){
		if (mySack.isInSack(item) && item.getClassName().equals("Equipable")){
			myArmory.equip((Equipable)item);
			return true;
		}
		else
			return false;
	}
        
        public Equipable unequipItem(EquipSlot slot){
		return myArmory.unequip(slot);
	}
        
	public void removeItem(Takeable item){
		mySack.removeItem(item);
        }
	public boolean modCurrency(int change){
        if(currency + change >= 0){
        	currency += change;
        	return true;
        }
        return false;     
	}
	public boolean setCurrency(int newAmount){
            if(newAmount>=0){
                    currency = newAmount;
                return true;
            }
            else{
                    return false;
            }
	}
        
        /*---------------ACCESSORS-----------------*/
	public int getCurrency(){
		return currency;
        }	
        
        public HashMap<EquipSlot, Equipable> getArmoryHMap() {
            return myArmory.getHMap();
        }

        public Takeable[] getSack() {
            return mySack.getArray();
        }
        
    

    public String toXML(){
    	String str = "";
    	str += "<inventory>";
    	str += "\n";
    	if(mySack != null){
    		str += mySack.toXML();
        	str += "\n";
    	}
    	if(myArmory != null)
    		str += myArmory.toXML();
    	str += "\n";
    	str += "</inventory>";
    	return str;
    	
    }


	
}







