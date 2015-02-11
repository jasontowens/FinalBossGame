package model;

public abstract class GameObject {
	private int id;
	private String className;
	private String description;
	
	
	//This constructor should be called only after the subclass constructor is called
	public GameObject(){
		IDGenerator idGen = new IDGenerator();
		id = idGen.generateID(className);
	}
	
	public int getID(){ return id; }
	public String getClassName(){ return className; }
	public String getDescription(){ return description; }
}
