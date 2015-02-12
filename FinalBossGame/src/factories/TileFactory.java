package factories;

import map.Tile;

public class TileFactory extends PlaceableObjectFactory {
	
	public Tile createTile() {
		Tile t = new Tile();
		return t;
	}
}