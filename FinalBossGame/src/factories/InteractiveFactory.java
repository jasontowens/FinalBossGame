package factories;

import java.util.ArrayList;

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
			case "Door Buster":
				return createDoorBuster(map);
			default:
				return null;
		}
	}

	private Interactive createSmasherSetter() {
		Interactive i = new OccupationSetter("Smasher setter", "Makes you a smasher.", 81, "Smasher");
		return i;
	}

	private Interactive createSummonerSetter() {
		Interactive i = new OccupationSetter("Summoner setter", "Makes you a summoner.", 82, "Summoner");
		return i;
	}

	private Interactive createSneakSetter() {
		Interactive i = new OccupationSetter("Sneak setter", "Makes you a sneak.", 92, "Sneak");
		return i;
	}

	private Interactive createDoorBuster(GameMap map) {
		ArrayList<String> targets = new ArrayList<String>();
		targets.add("Door");
		
		Interactive i = new ObstacleClearer("Door Buster", "Clears doors", 77, map, targets);
		return i;
	}
}