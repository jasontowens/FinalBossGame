package factories;

import item.OneShot;
import stats.ItemStats;

public class OneShotFactory extends PlaceableObjectFactory {
	
	private static OneShotFactory factory = null;
	public static OneShotFactory getInstance() {
		if(factory == null) {
			factory = new OneShotFactory();
		}
		return factory;
	}

	/*---------------------------------------------------*/

	public OneShot createHeartContainer() {
		ItemStats i = new ItemStats(0, 0, 0, 0, 0, 0, 0, 10, 0, 1, 0, 0, 0);
		OneShot o = new OneShot("OneShot", "Heart Container", "Raises health.", i);
		return o;
	}
}