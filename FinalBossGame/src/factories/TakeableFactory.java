package factories;

import map.GameMap;
import item.Takeable;
import item.Equipable;
import stats.ItemStats;
import inventory.EquipSlot;

public class TakeableFactory {
	
	public Takeable createTakeable(GameMap map, String name, int durability) {
		switch(name) {
			case "Health Potion":
				return createHealthPotion(map, durability);
			case "Bronze Sword":
				return createBronzeSword(map, durability);
			default:
				return null;
		}
	}

	public Takeable createHealthPotion(GameMap map, int durability) {
		ItemStats i = new ItemStats(0, 0, 0, 0, 0, 0, 0, 10, 0, durability, 10, 0, 0);
		Takeable t = new Takeable("Health Potion", "Health up.", i, map);
		return t;
	}

	public Takeable createBronzeSword(GameMap map, int durability) {
		ItemStats i = new ItemStats(10, 0, 0, 0, 0, 0, 0, 0, 0, durability, 0, 10, 0);
		Takeable t = new Equipable("Bronze Sword", "Swing it to kill things.", i, map, EquipSlot.MAINHAND);
		return t;
	}
}