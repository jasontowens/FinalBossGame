package model;

public abstract class GameObject {
	private int id;
	private String className;
	private String description;
	
	
	
	public int getID(){ return id; }
	public String getClassName(){ return className; }
	public String getDescription(){ return description; }
}
