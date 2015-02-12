package factories;

import item.Interactive;

public class InteractiveItemFactory extends PlaceableObjectFactory {
	
	public InteractiveItem createSwitch() {
		InteractiveItem i = new InteractiveItem("InteractiveItem", "Switch", "Opens something probably.");
		return i;
	}
}