package model;

public class Sack {
	private int sizeOfSack;	
	private Takeable[] itemsInSack; 
	private boolean[] slotsInUse;
	
	public Sack(){
		sizeOfSack = 10; //default initial value for now
		itemsInSack = new Takeable[sizeOfSack];
		slotsInUse = new boolean[10];
	}
	
	
	//<<Usage>>
	public Takeable useItem(int location){
		if(slotsInUse[location]){	
			//use item
			//
			//may do this in inventory, waiting for item class
			//
			return itemsInSack[location];
		}
		else{
			return null;
		}
	}
	public Takeable removeItem(Takeable item){
		//waiting on object ID format
		//				
	}
	addItem(item : Takeable){
		
	
	}

}
