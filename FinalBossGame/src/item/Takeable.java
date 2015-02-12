package item;

import gameobject.GameObject;
import stats.ItemStats;
import item.Item;
import entity.Entity;

public class Takeable extends GameObject implements Item {
	protected ItemStats modifiers;
	protected GameMap current;
	
	public Takeable(String className, String name, String description, ItemStats mods, GameMap active){
		super(className, name, description);
		modifiers = mods;
		current = active;
	}
	
	public boolean activate(Entity entity){
		current.removeItem(this);
		entity.addItem(this);
		return true;
	}
	
	public void inventoryUse(Entity entity){
		entity.mergeStats(modifiers);
		entity.changeMoney(modifiers.getValue());
		modifiers.modDurability(-1); //decreases durability by 1 after use
		if(modifiers.getDurability() <= 0){
			entity.removeItem(this); //checks for used-up consumable to be removed
		}
	}
}
