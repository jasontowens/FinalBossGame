package factories;

import item.Takeable;
import item.Equipable;
import stats.ItemStats;

public class TakeableFactory {
	
	public Takeable createTakeable(String name, int durability) {
		switch(name) {
			case "Health Potion":
				return createHealthPotion(durability);
			case "Bronze Sword":
				return createBronzeSword(durability);
			default:
				return null;
		}
	}

	public Takeable createHealthPotion(int durability) {
		ItemStats i = new ItemStats(0, 0, 0, 0, 0, 0, 0, 10, 0, durability, 10, 0, 0);
		Takeable t = new Takeable("Health Potion", "Health up.", "potionpath", i);
		return t;
	}

	public Takeable createBronzeSword(int durability) {
		ItemStats i = new ItemStats(10, 0, 0, 0, 0, 0, 0, 0, 0, durability, 0, 10, 0);
		Takeable t = new Equipable("Bronze Sword", "Swing it to kill things.", "bronzeswordpath", i, MAINHAND);
		return t;
	}
}