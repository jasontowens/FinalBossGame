package factories;

import entity.Entity;
import stats.PlayerStats;
import entity.MotionType;

public class EntityFactory extends PlaceableObjectFactory {

	public GameObject createObject(String object) {
		switch(object) {
			case "SmasherEntity":
				return createSmasher();
			case "SummonerEntity":
				return createSummoner();
			case "SneakEntity":
				return createSneak();
			default:
				return null;
		}
	}
				
	
	public GameObject createSmasher() {
		Inventory i = new Inventory(new Sack(), new Armory());
		Occupation o = new Smasher();
		Stats s = new PlayerStats(1, 10, 2, 4, 10, 0, 1, 40, 5, 20, 30);
		GameObject e = new Entity("SmasherEntity", "Heavy brawler", "smashersprite", GROUND, i, o, s);
		return e;
	}

	public GameObject createSummoner() {
		Inventory i = new Inventory(new Sack(), new Armory());
		Occupation o = new Summoner();
		Stats s = new PlayerStats(1, 2, 10, 20, 5, 1, 20, 30, 10, 15);
		GameObject e = new Entity("SummonerEntity" "Magical man", "summonersprite", GROUND, i, o, s);
		return e;
	}

	public GameObject createSneak() {
		Inventory i = new Inventory(new Sack(), new Armory());
		Occupation o = new Sneak();
		Stats s = new PlayerStats(1, 5, 20, 10, 5, 1, 20, 10, 5, 40);
		GameObject e = new Entity("SneakEntity", "Sneaky dude", "sneaksprite", GROUND, i, o, s);
		return e;
	}
}