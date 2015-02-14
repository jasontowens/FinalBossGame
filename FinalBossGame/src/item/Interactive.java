//Last edited by Matthew Kroeze on 2015-02-12

package item;

import gameobject.GameObject;
import item.Item;

public abstract class Interactive extends GameObject implements Item{
	//fields
	protected boolean hasActivated;
	
	//constructors
	protected Interactive(String className, String name, String description, String spriteFilePath){
		super(className, name, description, spriteFilePath);
		hasActivated = false;
	}
	protected Interactive(String name, String description, String spriteFilePath){
		super("Interactive", name, description, spriteFilePath);
		hasActivated = false;
	}
	protected Interactive(String className, String name, String description, String spriteFilePath, bool activation){
		super(className, name, description, spriteFilePath);
		hasActivated = activation;
	}
	protected Interactive(String name, String description, String spriteFilePath, bool activation){
		super("Interactive", name, description, spriteFilePath);
		hasActivated = activation;
	}
}
