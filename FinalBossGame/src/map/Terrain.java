package map;

import entity.Entity;
import gameobject.GameObject;

public class Terrain extends GameObject {
	private MotionType motiontype;

	public Terrain(String sprite, String name, String description, MotionType motiontype) {
		this.motiontype = motiontype;
		super(sprite, name, description);
	}

	public boolean verifyMovement(Entity entity) {
		return MotionValidator.getInstance().canTraverse(entity.getMotionType(), motiontype);
	}
}