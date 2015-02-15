package factories;

import item.Interactive;
import item.OccupationSetter;
import item.ObstacleClearer;

public class InteractiveFactory {
	
	public Interactive createInteractive(String name) {
		switch(name) {
			case "Smasher setter":
				return createSmasherSetter();
			case "Summoner setter":
				return createSummonerSetter();
			case "Sneak setter":
				return createSneakSetter();
			case "Obstacle clearer":
				return createObstacleClearer();
			default:
				return null;
		}
	}

	public Interactive createSmasherSetter() {
		Interactive i = new OccupationSetter("Smasher setter", "Makes you a smasher.", "ossmasherpath", "Smasher");
		return i;
	}

	public Interactive createSummonerSetter() {
		InteractiveItem i = new OccupationSetter("Summoner setter", "Makes you a summoner.", "ossummonerpath", "Summoner");
		return i;
	}

	public Interactive createSneakSetter() {
		Interactive i = new OccupationSetter("Sneak setter", "Makes you a sneak.", "ossneakpath", "Sneak");
		return i;
	}

	public Interactive createObstacleClearer() {
		Interactive i = new ObstacleClearer("Obstacle clearer", "Clears obstacles", "osclearerpath");
		return i;
	}
}