//Last updated by Matthew Kroeze on 2015-02-12

package item;

import gameobject.GameObject;
import item.Item;
import entity.Entity;

public class Obstacle extends GameObject implements Item{
	//constructors
	protected Obstacle(String className, String name, String description, String spriteFilePath){
		super(className, name, description, spriteFilePath);
	}
	public Obstacle(String name, String description, String spriteFilePath){
		super("Obstacle", name, description, spriteFilePath);
	}
	
	//Item interface operations
	public boolean activate(Entity entity){
		return false;
	}
}
