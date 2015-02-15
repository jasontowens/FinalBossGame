package factories;

import map.GameMap;
import item.Interactive;
import item.OccupationSetter;
import item.ObstacleClearer;

public class InteractiveFactory {
	
	public Interactive createInteractive(GameMap map, String name) {
		switch(name) {
			case "Smasher setter":
				return createSmasherSetter();
			case "Summoner setter":
				return createSummonerSetter();
			case "Sneak setter":
				return createSneakSetter();
			case "Obstacle clearer":
				return createObstacleClearer(map);
			default:
				return null;
		}
	}

	private Interactive createSmasherSetter() {
		Interactive i = new OccupationSetter("Smasher setter", "Makes you a smasher.", 2, "Smasher");
		return i;
	}

	private Interactive createSummonerSetter() {
		Interactive i = new OccupationSetter("Summoner setter", "Makes you a summoner.", 2, "Summoner");
		return i;
	}

	private Interactive createSneakSetter() {
		Interactive i = new OccupationSetter("Sneak setter", "Makes you a sneak.", 2, "Sneak");
		return i;
	}

	private Interactive createObstacleClearer(GameMap map) {
		Interactive i = new ObstacleClearer("Obstacle clearer", "Clears obstacles", 2, map);
		return i;
	}
}