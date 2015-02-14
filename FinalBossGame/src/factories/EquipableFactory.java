package factories;

import gameobject.GameObject;
import item.Equipable;
import stats.ItemStats;
import stats.Stats;
import inventory.EquipSlot;

public class EquipableFactory extends PlaceableObjectFactory {
	
	public GameObject createObject(String object) {
		switch(object) {
			case "Bronze Sword":
				return createBronzeSword();
			default:
				return null;
		}
	}

	public GameObject createBronzeSword() {
		ItemStats i = new ItemStats(10, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 10, 0);
		GameObject e = new Equipable("Bronze Sword", "Swing it to kill things.", "bronzeswordpath", i, MAINHAND);
		return e;
	}
}