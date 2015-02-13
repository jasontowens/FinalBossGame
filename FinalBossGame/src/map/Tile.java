package map;

import entity.Entity;

/**
 *
 * @author ChrisMoscoso & Aidan
 */
public class Tile {
	private Decal decal;
	private Terrain terrain;
	private ArrayList<AreaEffect> effects;

	public Tile(Terrain terrain) {
		this.terrain = terrain;
		decal = null;
		effects = new ArrayList<AreaEffect>;
	}

	public Tile(Terrain terrain, Decal decal) {
		this.terrain = terrain;
		this.decal = decal;
    		effects = new ArrayList<AreaEffect>;
	}

	public Tile(Terrain terrain, Decal decal, ArrayList<AreaEffect> effects) {
		this.terrain = terrain;
		this.decal = decal;
		this.effects = effects;
	}

	public Tile(Terrain terrain, ArrayList<AreaEffect> effects) {
		this.terrain = terrain;
		decal = null;
		this.effects = effects;
	}

	public boolean AddDecal(Decal decal) {
		if(this.decal == null) return false;
		this.decal = decal;
		return true;
	}

	public boolean AddAreaEffect(AreaEffect effect) {
		if(effects.contains(effect)) return false;
		effects.add(effect);
		return true;
	}

	public void RemoveAreaEffect(AreaEffect effect) {
		if(!effects.contains(effect)) return;
		effects.remove(effect);
		return;
	}

	public void ChangeTerrain(Terrain terrain) {
		this.terrain = terrain;
		return;
	}

	public boolean verifyMovement(Entity entity) {
		return verifyMovement(entity);
	}
}
