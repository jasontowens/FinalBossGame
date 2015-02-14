//Last updated by Matthew Kroeze on 2015-02-12

package item;

import gameobject.GameObject;
import item.Item;
import entity.Entity;

public class Obstacle extends GameObject implements Item{
	//constructors
	protected Obstacle(String className, String name, String description){
		super(className, name, description);
	}
	public Obstacle(String name, String description){
		super("Obstacle", name, description);
	}
	
	//Item interface operations
	public boolean activate(Entity entity){
		return false;
	}
}
