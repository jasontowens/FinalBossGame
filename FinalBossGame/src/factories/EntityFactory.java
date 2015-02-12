package factories;

import entity.Entity
import stats.PlayerStats;
import entity.MotionType;

public class EntityFactory extends PlaceableObjectFactory {

	private static EntityFactory factory = null;
	public static EntityFactory getInstance() {
		if(factory == null) {
			factory = new EntityFactory();
		}
		return factory;
	}

	/*---------------------------------------------------*/

	
	public Entity createSmasher() {
		Inventory i = new Inventory(new Sack(), new Armory());
		Occupation o = new Smasher();
		Stats s = new PlayerStats(1, 10, 2, 4, 10, 0, 1, 40, 5, 20, 30);
		Entity e = new Entity("SmasherEntity", "Heavy brawler", GROUND, i, o, s);
		return e;
	}

	public Entity createSummoner() {
		Inventory i = new Inventory(new Sack(), new Armory());
		Occupation o = new Summoner();
		Stats s = new PlayerStats(1, 2, 10, 20, 5, 1, 20, 30, 10, 15);
		Entity e = new Entity("SummonerEntity", GROUND, i, o, s);
		return e;
	}

	public Entity createSneak() {
		Inventory i = new Inventory(new Sack(), new Armory());
		Occupation o = new Sneak();
		Stats s = new PlayerStats(1, 5, 20, 10, 5, 1, 20, 10, 5, 40);
		Entity e = new Entity("SneakEntity", GROUND, i, o, s);
		return e;
	}
}