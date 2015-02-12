package factories;

import map.Tile;

public class TileFactory extends PlaceableObjectFactory {
	
	private static TileFactory factory = null;
	public static TileFactory getInstance() {
		if(factory == null) {
			factory = new TileFactory();
		}
		return factory;
	}

	/*---------------------------------------------------*/

	public Tile createTile() {
		Tile t = new Tile();
		return t;
	}
}