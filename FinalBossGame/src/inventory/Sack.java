package inventory;
import entity.Entity;
import item.*;

public class Sack {
	private int sizeOfSack;	
	private Takeable[] itemsInSack; 
	private boolean[] slotsInUse;
	
	public Sack(){
		sizeOfSack = 10; //default initial value for now
		itemsInSack = new Takeable[sizeOfSack];
		slotsInUse = new boolean[sizeOfSack];
	}
	
	
	//<<Usage>>
	public Takeable useItem(int location, Entity ent){
		if(slotsInUse[location]){	
			Takeable item = itemsInSack[location];
                        item.inventoryUse(ent);
			return itemsInSack[location];
		}
		else{
			return null;
		}
	}
	public Takeable removeItem(Takeable item){
		for(int i = 0; i != sizeOfSack; ++i){

			if(itemsInSack[i] == item){
				slotsInUse[i] = false;
				return itemsInSack[i];
             }
        }	
        return null;//not found
	}

	public Takeable removeItem(int location){
		if(location >= 0 && location < sizeOfSack) {
			slotsInUse[location] = false;
			return itemsInSack[location];
		}
		return null;
	}
        
	//returns false if sack full
	public boolean addItem(Takeable item){
	        for(int i = 0; i != sizeOfSack; ++i){
	            if(!slotsInUse[i]){
	                slotsInUse[i] = true;
	                itemsInSack[i] = item;
	                return true;
	            }
	        }
	        return false; //sack is full
	}
        
	public Takeable itemAt(int location){
		if(location >= 0 && location < sizeOfSack) {
			if(slotsInUse[location])
				return itemsInSack[location];
		}
	    return null;            
	}
        
	public boolean isInSack(Takeable item){
		 for (int i = 0; i != sizeOfSack; ++i){
			 if (itemsInSack[i] == (item))
				 return true;
		 }
		 
		 return false;
	}

        /* TEST METHODS */
		public int getSizeOfSack() {
			return sizeOfSack;
		}


		public Takeable[] getItemsInSack() {
			return itemsInSack;
		}


		public boolean[] getSlotsInUse() {
			return slotsInUse;
		}

}
