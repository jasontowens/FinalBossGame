package factories;

import gameobject.GameObject;

public abstract class PlaceableObjectFactory{

	public GameObject createObject(String object);
}