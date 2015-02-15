package factories;

import entity.Entity;
import entity.Occupation;
import stats.Stats;
import stats.PlayerStats;
import entity.MotionType;

import org.w3c.dom.Element;

public class EntityFactory {

	public Entity createEntity(String name, Element statsElement, ArrayList<Takeable> inv) {
		
		Inventory i = new Inventory(new Sack(), new Armory());
		
		for(Takeable t : inv) {
			i.addItem(t);
		}

		PlayerStats s = new PlayerStats(
			statsElement.getAttribute("livesleft"),
			statsElement.getAttribute("strength"),
			statsElement.getAttribute("agility"),
			statsElement.getAttribute("intellect"),
			statsElement.getAttribute("hardiness"),
			statsElement.getAttribute("experience"),
			statsElement.getAttribute("movement"),
			statsElement.getAttribute("hpcurrent"),
			statsElement.getAttribute("mpcurrent"),
			statsElement.getAttribute("defense"),
			statsElement.getAttribute("offense"));
			
		
		switch(name) {
			case "Smasher":
				return createSmasher(i, s);
			case "Summoner":
				return createSummoner(i, s);
			case "Sneak":
				return createSneak(i, s);
			default:
				return null;
		}
	}
				
	
	public Entity createSmasher(Inventory i, PlayerStats s) {
		Occupation o = new Occupation("Smasher", "Brawls heavily.");
		Entity e = new Entity("Smasher", "Brawls heavily", "smashersprite", GROUND, i, o, s);
		return e;
	}

	public Entity createSummoner(Inventory i, PlayerStats s) {
		Occupation o = new Occupation("Summoner", "Summons stuff.");
		Entity e = new Entity("Summoner", "Summons stuff.", "summonersprite", GROUND, i, o, s);
		return e;
	}

	public Entity createSneak(Inventory i, PlayerStats s) {
		Occupation o = new Occupation("Sneak", "Sneaks around.");
		Entity e = new Entity("Sneak", "Sneaks around.", "sneaksprite", GROUND, i, o, s);
		return e;
	}
}