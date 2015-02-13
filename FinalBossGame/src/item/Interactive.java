//Last edited by Matthew Kroeze on 2015-02-12

package item;

import gameobject.GameObject;
import item.Item;

public abstract class Interactive extends GameObject implements Item{
	//fields
	protected boolean hasActivated;
	
	//constructors
	protected Interactive(String className, String name, String description){
		super(className, name, description);
		hasActivated = false;
	}
	protected Interactive(String className, String name, String description, bool activation){
		super(className, name, description);
		hasActivated = activation;
	}
}
