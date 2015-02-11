package model;

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
	}
	public Equipable unequip(EquipSlot slot){
		int index = getIndex(slot);
		
		if(!usedSlots[index]){
			return null;			
		}
				
		Equipable itemAtSlot = equippedItems[index];
		usedSlots[index]=false;					//signifies that the equippedItems[index] is now "empty"
		
		return itemAtSlot;
	}
	
	//equip returns false IFF the designated slot is already being occupied
	//Inventory will use this information to unequip said Item and replace it
	public boolean equip(Equipable equipment){
		int index = getIndex(equipment.getEquipSlot());
		if(usedSlots[index])
			return false;
		else{
			usedSlots[index]=true;
			equippedItems[index]=equipment;	
			
			//update stats
			//
			//
			//or have inventory do it, not yet decided
			//
			return true;
		}
		
		
	}
	private int getIndex(EquipSlot slot){ //returns index value of specified EquipSlot
		int index=-1;
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
		}
		return index;
	}
}
