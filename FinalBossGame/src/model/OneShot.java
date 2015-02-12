package model;

public class OneShot extends GameObject implements Item{
	protected ItemStats modifier;
	
	public OneShot(String className, String name, String description, ItemStats mods){
		super(className, name, description);
		modifier = mods;
	}
	
	public boolean activate(Entity entity){
		entity.mergeStats(modifier);
		entity.changeMoney(modifier.getValue());
		return true;
	}
}
