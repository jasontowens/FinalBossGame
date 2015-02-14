//Last updated by Matthew Kroeze on 2015-02-12

package item;

import map.GameMap;
import inventory.EquipSlot;
import stats.ItemStats;
import item.Item;
import entity.Entity;

public class Equipable extends Takeable implements Item {
	//fields
	private EquipSlot slot;
	
	//constructors
	public Equipable(String className, String name, String description, ItemStats mods, GameMap active, EquipSlot equipSlot){
		super(className, name, description, mods, active);
		slot = equipSlot;
	}
	
	//accessors
	public EquipSlot getSlot(){
		return slot;
	}
	
	//Takeable overriden operations
	public void inventoryUse(Entity entity){
		entity.equipItem(this);
	}
	
	//usage operations
	public void onEquip(Entity entity){
		entity.mergeStats(modifiers);
	}
	public void onUnequip(Entity entity){
		entity.mergeStats(modifiers.inverted());
	}
}
