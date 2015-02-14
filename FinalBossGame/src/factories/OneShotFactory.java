package factories;

import item.OneShot;
import stats.ItemStats;

public class OneShotFactory extends PlaceableObjectFactory {
	
	public GameObject createObject(String object) {
		switch(object) {
			case "Heart Container":
				return createHeartContainer();
			default:
				return null;
		}
	}

	public GameObject createHeartContainer() {
		ItemStats i = new ItemStats(0, 0, 0, 0, 0, 0, 0, 10, 0, 1, 0, 0, 0);
		GameObject o = new OneShot("Heart Container", "Raises health.", "hearthpath", i);
		return o;
	}
}