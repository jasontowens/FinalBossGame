package factories;

import item.Interactive;

public class InteractiveItemFactory extends PlaceableObjectFactory {
	
	public GameObject createObject(String object) {
		switch(object) {
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

	public GameObject createSmasherSetter() {
		GameObject i = new OccupationSetter("Smasher setter", "Makes you a smasher.", "ossmasherpath", "Smasher");
		return i;
	}

	public GameObject createSummonerSetter() {
		GameObject i = new OccupationSetter("Summoner setter", "Makes you a summoner.", "ossummonerpath", "Summoner");
		return i;
	}

	public GameObject createSneakSetter() {
		GameObject i = new OccupationSetter("Sneak setter", "Makes you a sneak.", "ossneakpath", "Sneak");
		return i;
	}

	public GameObject createObstacleClearer() {
		i = new ObstacleClearer("Obstacle clearer", "Clears obstacles", "osclearerpath");
		return i;
	}
}