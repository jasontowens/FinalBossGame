package factories;

import item.Takeable;
import stats.ItemStats;

public class TakeableFactory extends PlaceableObjectFactory {
	
	public Takeable createHealthPotion() {
		ItemStats i = new ItemStats(0, 0, 0, 0, 0, 0, 0, 10, 0, 1, 10, 0, 0);
		Takeable t = new Takeable("Takeable", "Health Potion", "Health up.", i);
		return t;
	}
}