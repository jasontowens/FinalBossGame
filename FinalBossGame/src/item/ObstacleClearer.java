package item;



import entity.Entity;

import java.util.ArrayList;

import map.GameMap;

public class ObstacleClearer extends Interactive {
	private ArrayList<Obstacle> targetObstacles;
	private static GameMap current;
	
	protected ObstacleClearer(String className, String name, String description, String spriteFilePath){
		super(className, name, description, spriteFilePath);
		targetObstacles = new ArrayList<Obstacle>();
	}
	public ObstacleClearer(String name, String description, String spriteFilePath){
		super("ObstacleClearer", name, description, spriteFilePath);
		targetObstacles = new ArrayList<Obstacle>();
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

	public static void SetGameMap(GameMap current) {
		this.current = current;
	}

	private static GameMap GetGameMap() {
		return current;
	}
	
}
