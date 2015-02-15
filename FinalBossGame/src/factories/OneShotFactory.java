package factories;

import item.OneShot;
import stats.ItemStats;

public class OneShotFactory {
	
	public OneShot createOneShot(String name) {
		switch(name) {
			case "Heart Container":
				return createHeartContainer();
			default:
				return null;
		}
	}

	private OneShot createHeartContainer() {
		ItemStats i = new ItemStats(0, 0, 0, 0, 0, 0, 0, 10, 0, 1, 0, 0, 0);
		OneShot o = new OneShot("Heart Container", "Raises health.", "gameobject.png", i);
		return o;
	}
}