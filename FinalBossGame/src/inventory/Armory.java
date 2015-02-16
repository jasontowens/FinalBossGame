package inventory;

import util.Saveable;
import item.Equipable;
import java.util.HashMap;

public class Armory implements Saveable {
	int numOfSlots;
	Equipable[] equippedItems;
	boolean[] usedSlots; // true if slot is used, false otherwise
	/*
	  
	0:	head 
	1:	shoulders 
	2:	necklace 
	3:	whistle 
	4:	chest 
	5:	legs 
	6:	boots 
	7:	mainHand 
	8:	offHand 
	9:	twoHand 
	  
	 */
	
	/*-------------CONSTRUCTORS--------------*/
	public Armory(){
		numOfSlots = 5;
		equippedItems = new Equipable[numOfSlots];
		usedSlots = new boolean[numOfSlots];
	}
	public Armory(int numberOfSlots){
		numOfSlots = numberOfSlots;
		equippedItems = new Equipable[numOfSlots];
		usedSlots = new boolean[numOfSlots];
	}
	
	/*----------MESSAGES PASSED FROM ENTITY-------------*/
	public Equipable unequip(EquipSlot slot){
		int index = getIndex(slot);
		if(index < 0 || index > equippedItems.length) {
			return null;
		} 
		if(!usedSlots[index]){
			return null;			
		}
				
		Equipable itemAtSlot = equippedItems[index];
		equippedItems[index] = null;
		usedSlots[index]=false;					//signifies that the equippedItems[index] is now "empty"
		
		return itemAtSlot;
	}
        public Equipable unequip(int position){
		int index = position;
		if(index < 0 || index > equippedItems.length) {
			return null;
		} 
		if(!usedSlots[index]){
			return null;			
		}
				
		Equipable itemAtSlot = equippedItems[index];
		equippedItems[index] = null;
		usedSlots[index]=false;					//signifies that the equippedItems[index] is now "empty"
		
		return itemAtSlot;
	}
	
	//should always return true for now, maybe false later if entity doesn't meet requirements 
	public Equipable equip(Equipable equipment)
{
	Equipable returnEquipable = equipment;
	int index = getIndex(equipment.getSlot());

	// invalid index
	if(index < 0 || index > equippedItems.length)
		return null;
	/*
	// equipping mainHand or offHand, must unequip twoHand
	else if((index == 7 || index == 8) && usedSlots[9])
		returnEquipable = unequip(9);

	// equipping twoHand, must unequip mainHand and/or offHand
	else if(index == 9 && (usedSlots[7] || usedSlots[8]))
	{
		// flawed function return, because we can potentially 
		// unequip both mainHand and offHand. however, inevitable
		// given return type
		if(usedSlots[7])
			returnEquipable = unequip(7);
		if(usedSlots[8])
			returnEquipable = unequip(8);
	}*/

	// if there is already an item in a slot that is not 7, 8, or 9,
	// unequip it
	else 
	{
		if(usedSlots[index])
			returnEquipable = unequip(equipment.getSlot());
	}

	usedSlots[index] = true;
	equippedItems[index] = equipment;

	return returnEquipable;
        }
        
	private int getIndex(EquipSlot slot){ //returns index value of specified EquipSlot
		int index;
		switch(slot){
		case HEAD: index = 0; break;
		case MAINHAND: index =1; break;
		case CHEST: index = 2; break;
		case LEGS: index = 3; break;
		case BOOTS: index = 4; break;
		/*
		case SHOULDERS: index = 1; break;
		case NECKLACE: index = 2; break;
		case WHISTLE: index = 3; break;
		case CHEST: index = 4; break;
		case LEGS: index = 5; break;
		case BOOTS: index = 6; break;
		case MAINHAND: index = 7; break;
		case OFFHAND: index = 8; break;
		case TWOHAND: index = 9; break;
		*/
		default: index = -1; break;
		}
                
		return index;
	}
	
	/* TEST METHODS */
	//Saving also relies on some of these methods, so looks like they might have to stay.
	public int getNumOfSlots() {
		return numOfSlots;
	}
	public void setNumOfSlots(int numOfSlots) {
		this.numOfSlots = numOfSlots;
	}
	public Equipable[] getEquippedItems() {
		return equippedItems;
	}
	public void setEquippedItems(Equipable[] equippedItems) {
		this.equippedItems = equippedItems;
	}
	public boolean[] getUsedSlots() {
		return usedSlots;
	}
	public void setUsedSlots(boolean[] usedSlots) {
		this.usedSlots = usedSlots;
	}
	
	
	public String toXML(){
		String str = "";
		str += "<armory>";
		str += "\n";
		if(equippedItems != null){
			for(int i = 0; i < numOfSlots; ++i){
				if(equippedItems[i] != null){
					str += equippedItems[i].toXML(true);
					str += "\n";
				}			
			}
		}
		
		str += "</armory>";
		
		
		return str;
		
	}

    public HashMap<EquipSlot, Equipable> getHMap() {
        HashMap<EquipSlot, Equipable> hMap = new HashMap<EquipSlot, Equipable>();
        for(Equipable e: equippedItems){
            if(e != null){
                hMap.put(e.getSlot(), e);
            }
        }
        return hMap;
    }
	
}
