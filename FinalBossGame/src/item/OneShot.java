//Last updated by Matthew Kroeze on 2015-02-12
package item;

import gameobject.GameObject;
import stats.ItemStats;
import item.Item;
import entity.Entity;

public class OneShot extends GameObject implements Item{
	//fields
	protected ItemStats modifier;
	
	//constructors
	protected OneShot(String className, String name, String description, String spriteFilePath, ItemStats mods){
		super(className, name, description, spriteFilePath);
		modifier = mods;
	}
	public OneShot(String name, String description, String spriteFilePath, ItemStats mods){
		super("OneShot", name, description, spriteFilePath);
		modifier = mods;
	}
	
	//Item interface operations
	public boolean activate(Entity entity){
		entity.mergeStats(modifier);
		entity.changeMoney(modifier.getValue());
		return true;
	}
}
