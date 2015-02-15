//Last updated by Matthew Kroeze on 2015-02-12

package item;

import map.GameMap;
import inventory.EquipSlot;
import stats.ItemStats;
import util.Saveable;
import item.Item;
import entity.Entity;

public class Equipable extends Takeable implements Item {
	//fields
	protected EquipSlot slot;
	
	//constructors
	protected Equipable(String className, String name, String description, ItemStats mods, GameMap active, EquipSlot equipSlot){
		//TODO: change ID to how Hanif wants it set up 
		super(className, name, description, 69, mods, active);
		slot = equipSlot;
	}
	public Equipable(String name, String description, ItemStats mods, GameMap active, EquipSlot equipSlot){
		//TODO: change ID to how Hanif wants it set up 
		super("Equipable", name, description, 69, mods, active);
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
	
	public String toXML(){
		String str = "";
		
		str += "<equipableItem name=\"" + this.getName() + "\"" + " />";
		
		
		return str;
		
	}
}
