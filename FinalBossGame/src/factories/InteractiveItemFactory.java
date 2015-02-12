package factories;

import item.Interactive;

public class InteractiveItemFactory extends PlaceableObjectFactory {
	
	private static InteractiveItemFactory factory = null;
	public static InteractiveItemFactory getInstance() {
		if(factory == null) {
			factory = new InteractiveItemFactory();
		}
		return factory;
	}

	/*---------------------------------------------------*/

	public InteractiveItem createSwitch() {
		InteractiveItem i = new InteractiveItem("InteractiveItem", "Switch", "Opens something probably.");
		return i;
	}
}