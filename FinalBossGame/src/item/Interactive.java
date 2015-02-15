//Last edited by Matthew Kroeze on 2015-02-12

package item;

import gameobject.GameObject;
import item.Item;

public abstract class Interactive extends GameObject implements Item{
	//fields
	protected boolean hasActivated;
	
	//constructors
	protected Interactive(String className, String name, String description, int ID){
		super(className, name, description, ID); //TODO: change ID to how Hanif wants it set up 
		hasActivated = false;
	}
	protected Interactive(String name, String description, int ID){
		super("Interactive", name, description, ID); //TODO: change ID to how Hanif wants it set up 
		hasActivated = false;
	}
	protected Interactive(String className, String name, String description, int ID, boolean activation){
		super(className, name, description, ID); //TODO: change ID to how Hanif wants it set up 
		hasActivated = activation;
	}
	protected Interactive(String name, String description, int ID, boolean activation){
		super("Interactive", name, description, ID);
		hasActivated = activation;
	}
	public String toXML(){
		String str = "";
		
		//TODO: remember to add stat modifiers for Iteration2
		str +=  "<interactive name=\"" + this.getName() + "\"" + "x=\"" + this.getLocation().getX() + "\" y=\"" + this.getLocation().getY() +"\" />" ;
		return str;
	}
}
