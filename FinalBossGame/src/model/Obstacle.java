package model;

public class Obstacle extends GameObject implements Item{
	
	public Obstacle(String className, String description){
		super(className, description);
	}
	
	public boolean activate(Entity entity){
		return false;
	}
}
