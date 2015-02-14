//Last updated by Matthew Kroeze on 2015-02-12
package item;

import map.GameMap;
import gameobject.GameObject;
import stats.ItemStats;
import item.Item;
import entity.Entity;

public class Takeable extends GameObject implements Item {
	//fields
	protected ItemStats modifiers;
	protected GameMap current;
	
	//constructors
	protected Takeable(String className, String name, String description, ItemStats mods, GameMap active){
		super(className, name, description);
		modifiers = mods;
		current = active;
	}
	public Takeable(String name, String description, ItemStats mods, GameMap active){
		super("Takeable", name, description);
		modifiers = mods;
		current = active;
	}
	
	//Item interface operations
	public boolean activate(Entity entity){
		current.removeItem(this);
		entity.addItem(this);
		return true;
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
}
