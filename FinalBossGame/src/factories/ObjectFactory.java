package factories;

import util.XMLReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import entity.*;
import item.*;
import map.GameMap;
import map.CoordinatePair;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ObjectFactory {
	private String xmlfile;
	private GameMap map;
	private EntityFactory entityFactory;
	private InteractiveFactory interactiveFactory;
	private ObstacleFactory obstacleFactory;
	private OneShotFactory oneShotFactory;
	private TakeableFactory takeableFactory;

	public ObjectFactory(String file, GameMap currentmap) {
		xmlfile = file;
		map = currentmap;
		entityFactory = new EntityFactory();
		interactiveFactory = new InteractiveFactory();
		obstacleFactory = new ObstacleFactory();
		oneShotFactory = new OneShotFactory();
		takeableFactory = new TakeableFactory();
	}

	public void ParseFile()
	{
		//Load document from xml file
		InputStream f = getClass().getResourceAsStream(xmlfile);
		Document d = XMLReader.parseDocument(f);
		Element head = d.getDocumentElement();
		
		int counter;
		
		//Entities
		List<Element> entityElements = XMLReader.getElements("entity", head);
		
		for(counter = 0; counter < entityElements.size(); counter++) {
			
			List<Element> invElements = XMLReader.getElements("inventory", entityElements.get(counter));
			ArrayList<Takeable> inv = new ArrayList<Takeable>();
			
			for(int i = 0; i < invElements.size(); i++) {
				inv.add(takeableFactory.createTakeable(map, invElements.get(i).getAttribute("name"), Integer.parseInt(invElements.get(i).getAttribute("durability"))));
			}
			
			Entity e = entityFactory.createEntity(map, entityElements.get(counter).getAttribute("name"), XMLReader.getElements("stats", entityElements.get(counter)).get(0), inv);

			map.addEntity(e, new CoordinatePair(Integer.parseInt(entityElements.get(counter).getAttribute("x")), Integer.parseInt(entityElements.get(counter).getAttribute("y"))));
		}

		//One Shot items
		List<Element> oneShotElements = XMLReader.getElements("oneshot", head);

		for(counter = 0; counter < oneShotElements.size(); counter++) {
			
			OneShot o = oneShotFactory.createOneShot(oneShotElements.get(counter).getAttribute("name"));

			map.addItem(o, new CoordinatePair(Integer.parseInt(oneShotElements.get(counter).getAttribute("x")), Integer.parseInt(oneShotElements.get(counter).getAttribute("y"))));
		}

		//Interactive items
		List<Element> interactiveElements = XMLReader.getElements("interactive", head);

		for(counter = 0; counter < interactiveElements.size(); counter++) {
			
			Interactive i = interactiveFactory.createInteractive(map, interactiveElements.get(counter).getAttribute("name"));

			map.addItem(i, new CoordinatePair(Integer.parseInt(interactiveElements.get(counter).getAttribute("x")), Integer.parseInt(interactiveElements.get(counter).getAttribute("y"))));
		}

		//Obstacles
		List<Element> obstacleElements = XMLReader.getElements("obstacle", head);

		for(counter = 0; counter < obstacleElements.size(); counter++) {
			
			Obstacle o = obstacleFactory.createObstacle(obstacleElements.get(counter).getAttribute("name"));

			map.addItem(o, new CoordinatePair(Integer.parseInt(obstacleElements.get(counter).getAttribute("x")), Integer.parseInt(obstacleElements.get(counter).getAttribute("y"))));
		}

		//Takeable items
		List<Element> takeableElements = XMLReader.getElements("takeable", head);

		for(counter = 0; counter < takeableElements.size(); counter++) {
			
			Takeable t = takeableFactory.createTakeable(map, takeableElements.get(counter).getAttribute("name"), Integer.parseInt(takeableElements.get(counter).getAttribute("durability")));

			map.addItem(t, new CoordinatePair(Integer.parseInt(takeableElements.get(counter).getAttribute("x")), Integer.parseInt(takeableElements.get(counter).getAttribute("y"))));
		}
			
	}
}