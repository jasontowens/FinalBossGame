package factories;

import entity.MotionType;
import map.GameMap;
import item.MobilityEquipable;
import item.Takeable;
import item.Equipable;
import stats.ItemStats;
import inventory.EquipSlot;

public class TakeableFactory {
	
	public Takeable createTakeable(GameMap map, String name, int durability) {
		switch(name) {
			case "Health Potion":
				return createHealthPotion(map, durability);
			case "Sword of 1000 Truths":
				return createTruthSword(map, durability);
			case "Sloth Helmet":
				return createSlothHelmet(map, durability);
			case "Jesus Boots":
				return createJesusBoots(map, durability);
			case "Whistle":
				return createWhistle(map, durability);
			default:
				return null;
		}
	}

	private Takeable createHealthPotion(GameMap map, int durability) {
		ItemStats i = new ItemStats(0, 0, 0, 0, 0, 0, 0, 10, 0, durability, 10, 0, 0);
		Takeable t = new Takeable("Health Potion", "Health up.", 83, i, map);
		return t;
	}
	
	private Takeable createWhistle(GameMap map, int durability) {
		ItemStats i = new ItemStats(0, 0, 0, 100, 0, 0, 0, 0, 0, durability, 0, 0, 0);
		Takeable t = new Takeable("Whistle", "Does literally nothing.", 70, i, map);
		return t;
	}

	private Takeable createTruthSword(GameMap map, int durability) {
		ItemStats i = new ItemStats(10, 0, 0, 0, 0, 0, 0, 0, 0, durability, 0, 0, 10);
		Takeable t = new Equipable("Sword of 1000 Truths", "Swing it to kill things.", 95, i, map, EquipSlot.MAINHAND);
		return t;
	}
	
	private Takeable createSlothHelmet(GameMap map, int durability) {
		ItemStats i = new ItemStats(10, 0, 0, 0, 0, 0, 0, 0, 0, durability, 0, 10, 0);
		Takeable t = new Equipable("Sloth Helmet", "Wear it on your head to be slow.", 84, i, map, EquipSlot.HEAD);
		return t;
	}
	
	private Takeable createJesusBoots(GameMap map, int durability) {
		ItemStats i = new ItemStats(0, 0, 0, 0, 0, 0, 0, 0, 0, durability, 0, 0, 0);
		Takeable t = new MobilityEquipable("Jesus Boots", "Walk on water!", 94, i, map, EquipSlot.BOOTS, MotionType.WATER);
		return t;
	}
}