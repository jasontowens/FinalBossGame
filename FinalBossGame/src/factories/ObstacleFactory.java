package factories;

import item.Obstacle;

public class ObstacleFactory extends PlaceableObjectFactory {
	
	public Obstacle createWall() {
		Obstacle o = new Obstacle("Obstacle", "Wall", "Can't walk through it.");
		return o;
	}
}