package factories;

import inventory.Armory;
import inventory.Inventory;
import inventory.Sack;
import item.Takeable;

import java.util.ArrayList;

import entity.Entity;
import entity.Occupation;
import stats.PlayerStats;
import entity.MotionType;
import map.GameMap;

import org.w3c.dom.Element;

public class EntityFactory {

	public Entity createEntity(GameMap map, String name, Element statsElement, ArrayList<Takeable> inv) {
		
		Inventory i = new Inventory(new Sack(), new Armory());
		
		for(Takeable t : inv) {
			i.addItem(t);
		}

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
			
		
		switch(name) {
			case "Smasher":
				return createSmasher(i, s, map);
			case "Summoner":
				return createSummoner(i, s, map);
			case "Sneak":
				return createSneak(i, s, map);
			default:
				return null;
		}
	}
				
	
	public Entity createSmasher(Inventory i, PlayerStats s, GameMap map) {
		Occupation o = new Occupation("Smasher", "Brawls heavily.");
		Entity e = new Entity("Smasher", "Brawls heavily", "smashersprite", MotionType.GROUND, i, o, s, map);
		return e;
	}

	public Entity createSummoner(Inventory i, PlayerStats s, GameMap map) {
		Occupation o = new Occupation("Summoner", "Summons stuff.");
		Entity e = new Entity("Summoner", "Summons stuff.", "summonersprite", MotionType.GROUND, i, o, s, map);
		return e;
	}

	public Entity createSneak(Inventory i, PlayerStats s, GameMap map) {
		Occupation o = new Occupation("Sneak", "Sneaks around.");
		Entity e = new Entity("Sneak", "Sneaks around.", "sneaksprite", MotionType.GROUND, i, o, s, map);
		return e;
	}
}