package factories;

import item.Equipable;
import stats.ItemStats;
import inventory.EquipSlot;

public class EquipableFactory extends PlaceableObjectFactory {
	
	public Equipable createBronzeSword() {
		ItemStats i = new ItemStats(10, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 10, 0);
		Equipable e = new Equipable("Equipable", "Bronze Sword", "Swing it to kill things.", i, MAINHAND);
		return e;
	}
}