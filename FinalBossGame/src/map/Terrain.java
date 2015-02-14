package map;

import entity.Entity;
import entity.MotionType;
import gameobject.GameObject;

public class Terrain extends GameObject {
	private MotionType motiontype;

	public Terrain(String sprite, String name, String description, String spriteFilePath, MotionType motiontype) {
		//Super must be first call in constructor
		super(sprite, name, description, spriteFilePath);
		this.motiontype = motiontype;
		
	}

	public boolean verifyMovement(Entity entity) {
		return MotionValidator.getInstance().canTraverse(entity.getMotionType(), motiontype);
	}
}