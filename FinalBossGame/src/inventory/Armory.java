package inventory;

import item.Equipable;

public class Armory {
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
	public Armory(){
		numOfSlots = 10;
		equippedItems = new Equipable[numOfSlots];
		usedSlots = new boolean[numOfSlots];
	}
	public Armory(int numberOfSlots){
		numOfSlots = numberOfSlots;
		equippedItems = new Equipable[numOfSlots];
		usedSlots = new boolean[numOfSlots];
	}
	
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
	
	//should always return true for now, maybe false later if entity doesn't meet requirements 
	public Equipable equip(Equipable equipment){
		Equipable returnEquipable = equipment;
		
		int index = getIndex(equipment.getSlot());
		if(index < 0 || index > equippedItems.length) {
			return null;
		} 
		
		if(usedSlots[index]) //if there is already an item in the given slot, unequip it

			returnEquipable = unequip(equipment.getSlot());
		
		usedSlots[index]=true;
		equippedItems[index]=equipment;
		
		return returnEquipable;
	}
	private int getIndex(EquipSlot slot){ //returns index value of specified EquipSlot
		int index;
		switch(slot){
		case HEAD: index = 0; break;
		case SHOULDERS: index = 1; break;
		case NECKLACE: index = 2; break;
		case WHISTLE: index = 3; break;
		case CHEST: index = 4; break;
		case LEGS: index = 5; break;
		case BOOTS: index = 6; break;
		case MAINHAND: index = 7; break;
		case OFFHAND: index = 8; break;
		case TWOHAND: index = 9; break;
		default: index = -1; break;
		}
                
		return index;
	}
	
	/* TEST METHODS */
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
	
	
}
