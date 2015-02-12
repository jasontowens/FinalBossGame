package item;

import gameobject.GameObject;
import item.Item;
import entity.Entity;

public class Obstacle extends GameObject implements Item{
	
	public Obstacle(String className, String name, String description){
		super(className, name, description);
	}
	
	public boolean activate(Entity entity){
		return false;
	}
}
