package item;



import entity.Entity;

import java.util.ArrayList;

import map.GameMap;

public class ObstacleClearer extends Interactive {
	private ArrayList<Obstacle> targetObstacles;
	private GameMap current;
	
	protected ObstacleClearer(String className, String name, String description, String spriteFilePath, ArrayList<Obstacle> targets, GameMap active){
		super(className, name, description, spriteFilePath);
		targetObstacles = targets;
	}
	public ObstacleClearer(String name, String description, String spriteFilePath, ArrayList<Obstacle> targets, GameMap active){
		super("ObstacleClearer", name, description, spriteFilePath);
		targetObstacles = targets;
	}
	
	public boolean activate(Entity entity){
		for(Obstacle o : targetObstacles){
			current.removeItem(o);
		}
		return false;
	}
	
}
