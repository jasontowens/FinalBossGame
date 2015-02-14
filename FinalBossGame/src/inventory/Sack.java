package inventory;
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
		for(int i = 0; i != sizeOfSack; ++i){
			if(itemsInSack[i] == item){
				slotsInUse[i] = false;
				return itemsInSack[i];
             }
        }	
        return null;//not found
	}
        
    public Takeable removeItem(int location){
    	slotsInUse[location] = false;
        return itemsInSack[location];
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
            if(slotsInUse[location])
                return itemsInSack[location];
            else
                return null;            
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
