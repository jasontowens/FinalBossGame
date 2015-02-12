package model;

public abstract class Interactive extends GameObject implements Item{
	protected boolean hasActivated;
	
	protected Interactive(String className, String description){
		super(className, description);
		hasActivated = false;
	}
}
