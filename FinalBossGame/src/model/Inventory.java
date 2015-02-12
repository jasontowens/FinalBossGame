package model;


public class Inventory {
	int currency;
	Sack mySack;
	Armory myArmory;
	
	public Inventory(Sack sack, Armory armory){
		mySack = sack;
		myArmory = armory;
	}
	public void addItem(Takeable Item){
		mySack.addItem(Item);
	}
	public Takeable removeItem(int location){
		return mySack.removeItem(location);
	}
	public Takeable useItem(int location){
		return mySack.useItem(location);
	}
	public boolean equipItem(int location){
		if(mySack.itemAt(location).getClassName() == "Equipable"){
			myArmory.equip(mySack.removeItem(location));
			return true;
		}
		else
			return false;
	}
	public Equipable unequipItem(EquipSlot slot){
		return myArmory.unequip(slot);
	}
	
	
	
}
