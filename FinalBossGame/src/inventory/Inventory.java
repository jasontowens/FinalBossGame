package inventory;

import item.*;


public class Inventory {
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
	public void useItem(int location){
		if(location <= 9){
			mySack.addItem(myArmory.unequip(location));
		}
		else{
			mySack.useItem(location-10);
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
	public void removeItem(Takeable item){
		mySack.removeItem(item);
    }
	public boolean modCurrency(int change){
		currency += change;
		return currency;
	}
	public boolean setCurrency(int newAmount){
		currency = newAmount;
	}
        
    /*---------------ACCESSORS-----------------*/
	public int getCurrency(){
		return currency;
    }
	
	/*---------PRIVATE UTILITY FUNCTIONS-------*/
	private Equipable unequipItem(EquipSlot slot){
		return myArmory.unequip(slot);
	}
}
