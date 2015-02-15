package item;



import entity.Entity;

import java.util.ArrayList;

import map.GameMap;

public class ObstacleClearer extends Interactive {
	private ArrayList<Obstacle> targetObstacles;
	private GameMap current;
	
	protected ObstacleClearer(String className, String name, String description, int ID, GameMap currentmap){
		super(className, name, description, ID); //TODO: change ID to how Hanif wants it set up 
		targetObstacles = new ArrayList<Obstacle>();
		current = currentmap;
	}
	public ObstacleClearer(String name, String description, int ID, GameMap currentmap){
		super("ObstacleClearer", name, description, ID); //TODO: change ID to how Hanif wants it set up 
		targetObstacles = new ArrayList<Obstacle>();
		current = currentmap;
	}
	
	public boolean activate(Entity entity){
		for(Obstacle o : targetObstacles){
			current.removeItem(o);
		}
		return false;
	}

	public void addTarget(Obstacle target) {
		if(!targetObstacles.contains(target)) {
			targetObstacles.add(target);
		}
	}
	
}
