package map;

import entity.Entity;
import entity.MotionType;
import gameobject.GameObject;

public class Terrain extends GameObject {
	private MotionType motiontype;

	public Terrain(String name, String description, int ID, MotionType motiontype) {
		//Super must be first call in constructor
		super("Terrain", name, description, ID); //TODO: change ID to how Hanif wants it set up 
		this.motiontype = motiontype;
		
	}
	
	//name should probably be based on MotionType, 
	public Terrain(MotionType motiontype){
		//super("Terrain" , "a terrain" , "unncessary description");
		this.motiontype = motiontype;
	}

	public boolean verifyMovement(Entity entity) {
		return MotionValidator.getInstance().canTraverse(entity.getMotionType(), motiontype);
	}
}