package gameobject;

public abstract class GameObject {
	private int id;
	private String name;
	private String className;
	private String description;
	
	
	//This constructor should be called only after the subclass constructor is called
	protected GameObject(){
		IDGenerator idGen = new IDGenerator();
		id = idGen.generateID(className);
	}
	
	protected GameObject(String className, String objectName, String description){
		this.name = objectName;
		this.className = className;
		this.description = description;
		this();
	}
	
	public int getID(){ return id; }
	public String getClassName(){ return className; }
	public String getDescription(){ return description; }
	public String getName() { return name; }
}
