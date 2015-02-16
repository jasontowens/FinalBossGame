package item;



import entity.Entity;

import java.util.ArrayList;

import map.GameMap;

public class ObstacleClearer extends Interactive {
	private ArrayList<String> targetObstacles;
	private GameMap current;
	
	protected ObstacleClearer(String className, String name, String description, int ID, GameMap currentmap, ArrayList<String> targets){
		super(className, name, description, ID); //TODO: change ID to how Hanif wants it set up 
		targetObstacles = targets;
		current = currentmap;
	}
	public ObstacleClearer(String name, String description, int ID, GameMap currentmap, ArrayList<String> targets){
		super("ObstacleClearer", name, description, ID); //TODO: change ID to how Hanif wants it set up 
		targetObstacles = targets;
		current = currentmap;
	}
	
	public boolean activate(Entity entity){
		for(String t : targetObstacles){
			ArrayList<Item> targets = current.findItemsByName(t);
			
			for(Item o : targets){
				current.removeItem(o);
			}
		}
		return false;
	}
	
}
