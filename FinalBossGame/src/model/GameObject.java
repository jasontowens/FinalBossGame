package model;

public abstract class GameObject {
	private int id;
	private String name;
	private String description;
	
	public int getID(){ return id; }
	public String getName(){ return name; }
	public String getDescription(){ return description; }
}
