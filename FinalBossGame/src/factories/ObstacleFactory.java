package factories;

import item.Obstacle;

public class ObstacleFactory {
	
	public Obstacle createObstacle(String name) {
		switch(name) {
			case "Wall":
				return createWall();
			default:
				return null;
		}
	}

	private Obstacle createWall() {
		Obstacle o = new Obstacle("Wall", "Can't walk through it.", "gameobject.png");
		return o;
	}
}