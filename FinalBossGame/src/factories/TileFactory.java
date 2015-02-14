package factories;

import map.Tile;
import map.Terrain;
import entity.MotionType;

public class TileFactory extends PlaceableObjectFactory {
	
	public GameObject createObject(String object) {
		switch(object) {
			case "Grass":
				return createGrass();
			case "Water":
				return createWater();
			case "Mountain":
				return createMountain();
			default:
				return null;
		}
	}

	public GameObject createGrass() {
		Terrain te = new Terrain("Grass", "A grassy field.", "grasspath", GROUND);
		GameObject t = new Tile(te);
		return t;
	}

	public GameObject createWater() {
		Terrain te = new Terrain("Water", "Some water.", "waterpath", WATER);
		GameObject t = new Tile(te);
		return t;
	}

	public GameObject createMountain() {
		Terrain te = new Terrain("Mountain", "Tall mountain.", "mountainpath", UNATTAINABLE);
		GameObject t = new Tile(te);
		return t;
	}
}