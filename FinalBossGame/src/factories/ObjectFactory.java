package factories;

import gameobject.GameObject;
import main.XMLReader;
import java.io.*;
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
	private TileFactory tileFactory;

	public ObjectFactory(String file, GameMap currentmap) {
		xmlfile = file;
		map = currentmap;
		entityFactory = new EntityFactory());
		interactiveFactory = new InteractiveFactory());
		obstacleFactory = new ObstacleFactory());
		oneShotFactory = new OneShotFactory());
		takeableFactory = new TakeableFactory());
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
		
		for(counter = 0; counter < entityElements.getSize(); counter++) {
			
			List<Element> invElements = XMLReader.getElements("inventory", entityElements.get(counter));
			ArrayList<TakeableItem> inv = new ArrayList<TakeableItem>();
			
			for(int i = 0; i < invElements.getSize(); i++) {
				inv.add(takeableFactory.createTakeable(invElements.get(i).getAttribute("name"), Integer.parseInt(invElements.get(i).getAttribute("durability"))));
			}
			
			Entity e = entityFactory.createEntity(entityElements.get(counter).getAttribute("name"), XMLReader.getElements("stats", entityElements.get(counter)).get(0), inv);

			map.addEntity(e, new CoordinatePair(entityElements.get(counter).getAttribute("x"), entityElements.get(counter).getAttribute("y")));
		}

		//One Shot items
		List<Element> oneShotElements = XMLReader.getElements("oneshot", head);

		for(counter = 0; counter < oneShotElements.getSize(); counter++) {
			
			OneShot o = oneShotFactory.createOneShot(oneShotElements.get(counter).getAttribute("name"));

			map.addItem(o, new CoordinatePair(oneShotElements.get(counter).getAttribute("x"), oneShotElements.get(counter).getAttribute("y")));
		}

		//Interactive items
		List<Element> interactiveElements = XMLReader.getElements("interactive", head);

		for(counter = 0; counter < interactiveElements.getSize(); counter++) {
			
			Interactive i = interactiveFactory.createInteractive(interactiveElements.get(counter).getAttribute("name"));

			map.addItem(i, new CoordinatePair(interactiveElements.get(counter).getAttribute("x"), interactiveElements.get(counter).getAttribute("y")));
		}

		//Obstacles
		List<Element> obstacleElements = XMLReader.getElements("obstacle", head);

		for(counter = 0; counter < obstacleElements.getSize(); counter++) {
			
			Obstacle o = obstacleFactory.createObstacle(obstacleElements.get(counter).getAttribute("name"));

			map.addItem(o, new CoordinatePair(obstacleElements.get(counter).getAttribute("x"), obstacleElements.get(counter).getAttribute("y")));
		}

		//Takeable items
		List<Element> takeableElements = XMLReader.getElements("takeable", head);

		for(counter = 0; counter < takeableElements.getSize(); counter++) {
			
			Takeable t = takeableFactory.createTakeable(takeableElements.get(counter).getAttribute("name"), Integer.parseInt(takeableElements.get(counter).getAttribute("durability")));

			map.addItem(t, new CoordinatePair(takeableElements.get(counter).getAttribute("x"), takeableElements.get(counter).getAttribute("y")));
		}
			
	}
}