package model;

public abstract class Interactive extends GameObject implements Item{
	protected boolean hasActivated;
	
	protected Interactive(String className, String name, String description){
		super(className, name, description);
		hasActivated = false;
	}
}
