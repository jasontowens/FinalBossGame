package inventory;

import item.*;


public class Inventory {
	int currency;
	Sack mySack;
	Armory myArmory;
	
	public Inventory(Sack sack, Armory armory){
		mySack = sack;
		myArmory = armory;
                currency = 0;
	}
	public void addItem(Takeable item){
		mySack.addItem(item);
	}
	public Takeable removeItem(int location){
		return mySack.removeItem(location);
	}
        public Takeable removeItem(Takeable item){
                return mySack.removeItem(item);
        }
	public Takeable useItem(int location){
		return mySack.useItem(location);
	}
	public boolean equipItem(int location){
		if(mySack.itemAt(location).getClassName().equals("Equipable")){
			myArmory.equip((Equipable)mySack.removeItem(location));
			return true;
		}
		else
			return false;
	}
	public Equipable unequipItem(EquipSlot slot){
		return myArmory.unequip(slot);
	}
	
	public int getCurrency(){
            return currency;
        }
        public int modCurrency(int change){
            currency += change;
            return currency;
        }
        public void setCurrency(int newAmount){
            currency = newAmount;
        }
	
}
