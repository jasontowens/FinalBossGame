package factories;

import util.XMLReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import entity.*;
import item.*;
import map.GameMap;
import map.CoordinatePair;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ObjectFactory {
	private InputStream xmlfile;
	private GameMap map;
	private EntityFactory entityFactory;
	private InteractiveFactory interactiveFactory;
	private ObstacleFactory obstacleFactory;
	private OneShotFactory oneShotFactory;
	private TakeableFactory takeableFactory;
	private ElementValidator elementValidator;
	private XMLReader xmlreader;

	public ObjectFactory(InputStream file, GameMap currentmap) {
		xmlfile = file;
		map = currentmap;
		entityFactory = new EntityFactory();
		interactiveFactory = new InteractiveFactory();
		obstacleFactory = new ObstacleFactory();
		oneShotFactory = new OneShotFactory();
		takeableFactory = new TakeableFactory();
		elementValidator = new ElementValidator();
		xmlreader = XMLReader.getInstance(xmlfile);
	}

	public Entity ParseFile() throws ParserConfigurationException, SAXException, IOException{
		//Load document from xml file
		Document d = xmlreader.parseDocument();
		Element head = d.getDocumentElement();
		
		int counter;
		Entity player = null;
		
		//Entities
		
		List<Element> entityElements = xmlreader.getElements("entity", head);
		
		for(counter = 0; counter < entityElements.size(); counter++) {
			List<Element> sackElements = xmlreader.getElements("takeableItem", xmlreader.getElements("sack", entityElements.get(counter)).get(0));
			List<Element> armoryElements = xmlreader.getElements("takeableItem", xmlreader.getElements("armory", entityElements.get(counter)).get(0));
			ArrayList<Takeable> sack = new ArrayList<Takeable>();
			ArrayList<Takeable> armory = new ArrayList<Takeable>();
			
			for(int i = 0; i < sackElements.size(); i++) {
				if(elementValidator.ValidElement(sackElements.get(i), "takeableItem")) {
					Takeable t = takeableFactory.createTakeable(null, sackElements.get(i).getAttribute("name"), Integer.parseInt(sackElements.get(i).getAttribute("durability")));
					if(t != null) sack.add(t);
				}
			}
			
			for(int i = 0; i < armoryElements.size(); i++) {
				if(elementValidator.ValidElement(armoryElements.get(i), "takeableItem")) {
					Takeable t = takeableFactory.createTakeable(null, armoryElements.get(i).getAttribute("name"), Integer.parseInt(armoryElements.get(i).getAttribute("durability")));
					if(t != null) armory.add(t);
				}
			}
			
			if(elementValidator.ValidElement(entityElements.get(counter), "entity")) {
				Entity e = entityFactory.createEntity(map, entityElements.get(counter).getAttribute("occupation"), xmlreader.getElements("stats", entityElements.get(counter)).get(0), sack, armory);

				
				if(e != null){
					map.addEntity(e, new CoordinatePair(Integer.parseInt(entityElements.get(counter).getAttribute("x")), Integer.parseInt(entityElements.get(counter).getAttribute("y"))));
					player = e;
				}
			}
		}

		//One Shot items
		List<Element> oneShotElements = xmlreader.getElements("oneshot", head);

		for(counter = 0; counter < oneShotElements.size(); counter++) {
			
			if(elementValidator.ValidElement(oneShotElements.get(counter), "oneshot")) {
				OneShot o = oneShotFactory.createOneShot(oneShotElements.get(counter).getAttribute("name"));

				if(o != null) map.addItem(o, new CoordinatePair(Integer.parseInt(oneShotElements.get(counter).getAttribute("x")), Integer.parseInt(oneShotElements.get(counter).getAttribute("y"))));
			}
		}

		//Interactive items
		List<Element> interactiveElements = xmlreader.getElements("interactive", head);

		for(counter = 0; counter < interactiveElements.size(); counter++) {
			
			if(elementValidator.ValidElement(interactiveElements.get(counter), "interactive")) {
				Interactive i = interactiveFactory.createInteractive(map, interactiveElements.get(counter).getAttribute("name"));

				if(i != null) map.addItem(i, new CoordinatePair(Integer.parseInt(interactiveElements.get(counter).getAttribute("x")), Integer.parseInt(interactiveElements.get(counter).getAttribute("y"))));
			}
		}

		//Obstacles
		List<Element> obstacleElements = xmlreader.getElements("obstacle", head);

		for(counter = 0; counter < obstacleElements.size(); counter++) {
			
			if(elementValidator.ValidElement(obstacleElements.get(counter), "obstacle")) {
				Obstacle o = obstacleFactory.createObstacle(obstacleElements.get(counter).getAttribute("name"));

				if(o != null) map.addItem(o, new CoordinatePair(Integer.parseInt(obstacleElements.get(counter).getAttribute("x")), Integer.parseInt(obstacleElements.get(counter).getAttribute("y"))));
			}
		}

		//Takeable items
		List<Element> takeableElements = xmlreader.getElements("takeable", head);

		for(counter = 0; counter < takeableElements.size(); counter++) {
			
			if(elementValidator.ValidElement(takeableElements.get(counter), "takeable")) {
				Takeable t = takeableFactory.createTakeable(map, takeableElements.get(counter).getAttribute("name"), Integer.parseInt(takeableElements.get(counter).getAttribute("durability")));

				if(t != null) map.addItem(t, new CoordinatePair(Integer.parseInt(takeableElements.get(counter).getAttribute("x")), Integer.parseInt(takeableElements.get(counter).getAttribute("y"))));
			}
		}
		
		return player;
	}
}