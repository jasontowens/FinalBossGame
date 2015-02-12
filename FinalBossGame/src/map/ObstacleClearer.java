package map;

import item.Obstacle;
import item.Interactive;
import entity.Entity;
import java.util.ArrayList;

public class ObstacleClearer extends Interactive {
	private ArrayList<Obstacle> targetObstacles;
	private GameMap current;
	
	public ObstacleClearer(String className, String name, String description, ArrayList<Obstacle> targets, GameMap active){
		super(className, name, description);
		targetObstacles = targets;
	}
	
	public boolean activate(Entity entity){
		for(Obstacle o : targetObstacles){
			current.removeItem(o);
		}
		return false;
	}
	
}
