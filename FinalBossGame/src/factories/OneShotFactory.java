package factories;

import map.GameMap;
import item.OneShot;
import stats.ItemStats;

public class OneShotFactory {
	
	public OneShot createOneShot(GameMap map, String name) {
		switch(name) {
			case "Heart Container":
				return createHeartContainer(map);
			default:
				return null;
		}
	}

	private OneShot createHeartContainer(GameMap map) {
		ItemStats i = new ItemStats(0, 0, 0, 0, 0, 0, 0, 10, 0, 1, 0, 0, 0);
		OneShot o = new OneShot("Heart Container", "Raises health.", 74, i, map);
		return o;
	}
}