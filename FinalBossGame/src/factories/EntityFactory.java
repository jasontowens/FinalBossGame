package factories;

import inventory.Armory;
import inventory.Inventory;
import inventory.Sack;
import item.Equipable;
import item.Takeable;

import java.util.ArrayList;

import entity.Entity;
import entity.Occupation;
import stats.PlayerStats;
import entity.MotionType;
import map.GameMap;

import org.w3c.dom.Element;

public class EntityFactory {

	public Entity createEntity(GameMap map, String name, Element statsElement, ArrayList<Takeable> sack, ArrayList<Takeable> armory) {
		
		Inventory i = new Inventory(new Sack(), new Armory());

		PlayerStats s = new PlayerStats(
			Integer.parseInt(statsElement.getAttribute("livesleft")),
			Integer.parseInt(statsElement.getAttribute("strength")),
			Integer.parseInt(statsElement.getAttribute("agility")),
			Integer.parseInt(statsElement.getAttribute("intellect")),
			Integer.parseInt(statsElement.getAttribute("hardiness")),
			Integer.parseInt(statsElement.getAttribute("experience")),
			Integer.parseInt(statsElement.getAttribute("movement")),
			Integer.parseInt(statsElement.getAttribute("hpcurrent")),
			Integer.parseInt(statsElement.getAttribute("mpcurrent")),
			Integer.parseInt(statsElement.getAttribute("defense")),
			Integer.parseInt(statsElement.getAttribute("offense")));
			
		Entity e;
		switch(name) {
			case "Smasher":
				e = createSmasher(i, s, map);
				for(Takeable t : sack) {
					e.addItem(t);
				}
				
				for(Takeable t : armory) {
					e.addItem(t);
					e.equipItem((Equipable) t);
				}
				return e;
			case "Summoner":
				e = createSummoner(i, s, map);
				for(Takeable t : sack) {
					e.addItem(t);
				}
				
				for(Takeable t : armory) {
					e.addItem(t);
					e.equipItem((Equipable) t);
				}
				return e;
			case "Sneak":
				e = createSneak(i, s, map);
				for(Takeable t : sack) {
					e.addItem(t);
				}
				
				for(Takeable t : armory) {
					e.addItem(t);
					e.equipItem((Equipable) t);
				}
				return e;
			default:
				return null;
		}
	}
				
	
	private Entity createSmasher(Inventory i, PlayerStats s, GameMap map) {
		Occupation o = new Occupation("Smasher", "Brawls heavily.");
		Entity e = new Entity("Smasher", "Brawls heavily", 85, MotionType.GROUND, i, o, s, map);
		return e;
	}

	private Entity createSummoner(Inventory i, PlayerStats s, GameMap map) {
		Occupation o = new Occupation("Summoner", "Summons stuff.");
		Entity e = new Entity("Summoner", "Summons stuff.", 85, MotionType.GROUND, i, o, s, map);
		return e;
	}

	private Entity createSneak(Inventory i, PlayerStats s, GameMap map) {
		Occupation o = new Occupation("Sneak", "Sneaks around.");
		Entity e = new Entity("Sneak", "Sneaks around.", 85, MotionType.GROUND, i, o, s, map);
		return e;
	}
}