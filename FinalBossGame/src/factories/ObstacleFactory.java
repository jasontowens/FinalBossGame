package factories;

import item.Obstacle;

public class ObstacleFactory extends PlaceableObjectFactory {
	
	private static ObstacleFactory factory = null;
	public static ObstacleFactory getInstance() {
		if(factory == null) {
			factory = new ObstacleFactory();
		}
		return factory;
	}

	/*---------------------------------------------------*/

	public Obstacle createWall() {
		Obstacle o = new Obstacle("Obstacle", "Wall", "Can't walk through it.");
		return o;
	}
}