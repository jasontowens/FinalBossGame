package factories;

import item.Obstacle;
import gameobject.GameObject;

public class ObstacleFactory extends PlaceableObjectFactory {
	
	public GameObject createObject(String object) {
		switch(object) {
			case "Wall":
				return createWall();
			default:
				return null;
		}
	}

	public GameObject createWall() {
		GameObject o = new Obstacle("Obstacle", "Wall", "wallpath", "Can't walk through it.");
		return o;
	}
}