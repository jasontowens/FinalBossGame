package factories;

import item.Obstacle;

public class ObstacleFactory {
	
	public Obstacle createObstacle(String name) {
		switch(name) {
			case "Wall":
				return createWall();
			case "Door":
				return createDoor();
			default:
				return null;
		}
	}

	private Obstacle createWall() {
		Obstacle o = new Obstacle("Wall", "Can't walk through it.", 2);
		return o;
	}
	
	private Obstacle createDoor() {
		Obstacle o = new Obstacle("Door", "Can open maybe", 2);
		return o;
	}
}