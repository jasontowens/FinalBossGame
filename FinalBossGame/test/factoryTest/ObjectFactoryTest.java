package factoryTest;

import item.Item;
import item.Takeable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import entity.Entity;
import factories.*;
import gameobject.GameObject;
import map.*;

public class ObjectFactoryTest {
	

	public static void main(String[] args) {
		GameMap m = new GameMap();
		InputStream stream;
		stream = ObjectFactoryTest.class.getResourceAsStream("/resources/saves/largesave.xml");
		/*try {
			//stream = new FileInputStream("./resources/saves/save1.xml");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}*/
		ObjectFactory f = new ObjectFactory(stream, m);
		
		printMap(m);
		
		try {
			f.ParseFile();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		printMap(m);
		
	}
	
	public static void printMap(GameMap m) {
		ArrayList<Pair<Entity, CoordinatePair>> entities = m.getAllEntities();
		ArrayList<Pair<Item, CoordinatePair>> items = m.getAllItems();
		
		System.out.println("\nPrinting map...\n");
		
		for(Pair p : entities) {
			System.out.println(((Entity) p.getLeft()).getName() + " @ " + ((CoordinatePair) p.getRight()).getX() + ", " + ((CoordinatePair) p.getRight()).getY() + "\n");
			System.out.println("    contains...\n");
			Takeable[] t = ((Entity) p.getLeft()).getSack();
			
			for(int i = 0; i < t.length; i++) {
			 
				if(t[i] != null) {
					System.out.println("    " + t[i].getName() + "\n");
				}
			}
		}
		
		for(Pair p : items) {
			System.out.println(((GameObject) p.getLeft()).getName() + " @ " + ((CoordinatePair) p.getRight()).getX() + ", " + ((CoordinatePair) p.getRight()).getY() + "\n");
		}
	}
}