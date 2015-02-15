//Last updated by Matthew Kroeze on 2015-02-12
package item;

import map.GameMap;
import gameobject.GameObject;
import stats.ItemStats;
import util.Saveable;
import item.Item;
import entity.Entity;

public class Takeable extends GameObject implements Item , Saveable {
	//fields
	protected ItemStats modifiers;   //TODO: add this to save XML
	protected GameMap current;
	
	//constructors
	protected Takeable(String className, String name, String description, int ID, ItemStats mods, GameMap active){
		super(className, name, description, ID); //TODO: change ID to how Hanif wants it set up 
		modifiers = mods;
		current = active;
	}
	public Takeable(String name, String description, ItemStats mods, GameMap active){
		//TODO:  fix this damn sprite file path
		super("Takeable", name, description, 4); //TODO: change ID to how Hanif wants it set up 
		modifiers = mods;
		current = active;
	}
	
	/*--------- ITEM INTERFACE OPERATIONS ----------*/
	public boolean activate(Entity entity){
                if(entity.addItem(this)){
                    current.removeItem(this);
                    return true;
                }
		else
                    return false;
		
	}
	
	//usage operations
	public void inventoryUse(Entity entity){	//performed when the item is used from an inventory
		entity.mergeStats(modifiers);
		entity.changeMoney(modifiers.getValue());
		modifiers.modDurability(-1); //decreases durability by 1 after use
		if(modifiers.getDurability() <= 0){
			entity.removeItem(this); //checks for used-up consumable to be removed
		}
	}
	
	public String toXML(){
		String str = "";
		
		//TODO: remember to add stat modifiers for Iteration2
		str +=  "<takeableItem> name=\"" + this.getName() + "\""  ;
		return str;
	}
}
