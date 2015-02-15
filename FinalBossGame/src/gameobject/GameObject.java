package gameobject;

import java.io.File;

import map.CoordinatePair;

public abstract class GameObject {
	private String spriteFilePath;
	private String name;
	private String className;
	private String description;
	
	
	//Added this, necessary to save game state. 
	private CoordinatePair location;
	
	
	//This constructor should be called only after the subclass constructor is called
	protected GameObject(){
		spriteFilePath = "art" + File.separator;
		name = "Generic Object";
		className = "GameObject";
		description = "Generic description";
		location = new CoordinatePair(); // default constructor, (0 , 0)
		
	}
	
	protected GameObject(String className, String objectName, String description, String spriteFilePath){
		this.spriteFilePath = spriteFilePath;
		this.name = objectName;
		this.className = className;
		this.description = description;
		location = new CoordinatePair(); // default constructor, (0 , 0)
		
	}
	
	private String getSpriteFilePath(){ return spriteFilePath; }
	public String getClassName(){ return className; }
	public String getDescription(){ return description; }
	public String getName() { return name; }
	public CoordinatePair getLocation() { return location; };
}
