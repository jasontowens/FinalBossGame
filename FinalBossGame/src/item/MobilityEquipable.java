//Last updated by Matthew Kroeze on 2015-02-12

package item;

import inventory.EquipSlot;
import map.GameMap;
import stats.ItemStats;
import entity.Entity;
import entity.MotionType;

public class MobilityEquipable extends Equipable{
	//fields
	private MotionType myMotion;
	private MotionType originalMotion;
	
	//constructors
	protected MobilityEquipable(String className, String name, String description, int ID, ItemStats mods, GameMap active, EquipSlot equipSlot, MotionType nextMotion){
		super(className, name, description, ID, mods, active, equipSlot);
		myMotion = nextMotion;
		
	}
	public MobilityEquipable(String name, String description, int ID, ItemStats mods, GameMap active, EquipSlot equipSlot, MotionType nextMotion){
		super("MobilityEquipable", name, description, ID, mods, active, equipSlot);
		myMotion = nextMotion;
	}
	
	//Equipable overriden operations
	public void onEquip(Entity entity){
		entity.mergeStats(modifiers);
		originalMotion = entity.getMotionType();
		entity.setMotionType(myMotion);
	}
	public void onUnequip(Entity entity){
		entity.mergeStats(modifiers.inverted());
		entity.setMotionType(originalMotion);
	}
}
