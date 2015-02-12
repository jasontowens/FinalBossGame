package model;

import java.util.ArrayList;

public class ObstacleClearer extends Interactive {
	private ArrayList<Obstacle> targetObstacles;
	private GameMap current;
	
	public ObstacleClearer(String className, String description, ArrayList<Obstacle> targets, GameMap active){
		super(className, description);
		targetObstacles = targets;
	}
	
	public boolean activate(Entity entity){
		for(Obstacle o : targetObstacles){
			current.removeItem(o);
		}
		return false;
	}
	
}
