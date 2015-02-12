package model;

public class Equipable extends Takeable implements Item {
	private EquipSlot slot;
	
	public Equipable(String className, String name, String description, ItemStats mods, GameMap active, EquipSlot equipSlot){
		super(className, name, description, mods, active);
		slot = equipSlot;
	}
	public EquipSlot getSlot(){
		return slot;
	}
	public void inventoryUse(Entity entity){
		entity.equipItem(this);
	}
	public void onEquip(Entity entity){
		entity.mergeStats(modifiers);
	}
	public void onUnequip(Entity entity){
		entity.mergeStats(modifiers.inverted());
	}
}
