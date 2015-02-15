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

	public Interactive createSmasherSetter() {
		Interactive i = new OccupationSetter("Smasher setter", "Makes you a smasher.", "ossmasherpath", "Smasher");
		return i;
	}

	public Interactive createSummonerSetter() {
		Interactive i = new OccupationSetter("Summoner setter", "Makes you a summoner.", "ossummonerpath", "Summoner");
		return i;
	}

	public Interactive createSneakSetter() {
		Interactive i = new OccupationSetter("Sneak setter", "Makes you a sneak.", "ossneakpath", "Sneak");
		return i;
	}

	public Interactive createObstacleClearer(GameMap map) {
		Interactive i = new ObstacleClearer("Obstacle clearer", "Clears obstacles", "osclearerpath", map);
		return i;
	}
}