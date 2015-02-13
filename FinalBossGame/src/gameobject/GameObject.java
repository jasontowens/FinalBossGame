package gameobject;

import java.io.File;

public abstract class GameObject {
	private String spriteFilePath;
	private String name;
	private String className;
	private String description;
	
	
	//This constructor should be called only after the subclass constructor is called
	protected GameObject(){
		spriteFilePath = "art" + File.separator;
		name = "Generic Object";
		className = "GameObject";
		description = "Generic description";
		
	}
	
	protected GameObject(String className, String objectName, String description){
		this.name = objectName;
		this.className = className;
		this.description = description;
	}
	
	private String getSpriteFilePath(){ return spriteFilePath; }
	public String getClassName(){ return className; }
	public String getDescription(){ return description; }
	public String getName() { return name; }
}
