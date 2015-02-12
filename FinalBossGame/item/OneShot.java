package item;

import gameobject.GameObject;
import stats.ItemStats;
import item.Item;
import entity.Entity;

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
