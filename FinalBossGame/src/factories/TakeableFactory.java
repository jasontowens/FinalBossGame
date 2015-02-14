package factories;

import item.Takeable;
import stats.ItemStats;

public class TakeableFactory extends PlaceableObjectFactory {
	
	public GameObject createObject(String object) {
		switch(object) {
			case "Health Potion":
				return createHealthPotion();
			default:
				return null;
		}
	}

	public GameObject createHealthPotion() {
		ItemStats i = new ItemStats(0, 0, 0, 0, 0, 0, 0, 10, 0, 1, 10, 0, 0);
		GameObject t = new Takeable("Health Potion", "Health up.", "potionpath", i);
		return t;
	}
}