//Last updated by Matthew Kroeze on 2015-02-12

package item;

import gameobject.GameObject;
import item.Item;
import entity.Entity;

public class Obstacle extends GameObject implements Item{
	//constructors
	protected Obstacle(String className, String name, String description, int ID){
		super(className, name, description, ID); //TODO: change ID to how Hanif wants it set up 
	}
	public Obstacle(String name, String description, int ID){
		super("Obstacle", name, description, ID); //TODO: change ID to how Hanif wants it set up 
	}
	
	//Item interface operations
	public boolean activate(Entity entity){
		return false;
	}

	public String toXML(){
		String str = "";
		
		//TODO: remember to add stat modifiers for Iteration2
		str +=  "<obstacle name=\"" + this.getName() + "\"" + "x=\"" + this.getLocation().getX() + "\" y=\"" + this.getLocation().getY() +"\" />" ;
		return str;
	}
}
