package model;

public class Obstacle extends GameObject implements Item{
	
	public Obstacle(String className, String name, String description){
		super(className, name, description);
	}
	
	public boolean activate(Entity entity){
		return false;
	}
}