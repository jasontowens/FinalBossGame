package inventory;

import item.*;
import java.util.ArrayList;
import java.util.HashMap;


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
        
    //EQUIPABLES
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
	
        
        //CURRENCY
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

    public HashMap<EquipSlot, Equipable> getArmoryHMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Takeable> getSack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
