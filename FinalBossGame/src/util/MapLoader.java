package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import miscTest.ImageSplitterTest;

/*
 * Responsible for reading the map XML file, and storing a 2D array of tiles corresponding 
 * to the map, so that View classes can query for rendering. 
 * 
 * @author: Hanif
 */
public class MapLoader {
	ImageSplitter splitter;
	private static MapLoader loader =  null;
	private int mapWidth = 0 , mapHeight = 0;
	XMLReader reader;
	BufferedImage spriteSheet;
	Document levelXML;
	
	
	/*
	 * Making it a singleton for now
	 */
	
	
	/*
	 * TODO: refactor so that map XML files have path or name of 
	 * the corresponding tile sheet which they read from.
	 * 
	 * OR:leave it as we have it now, one master sprite sheet for the 
	 * level.
	 */
	private MapLoader(InputStream in){
		reader = XMLReader.getInstance(in);
		try {
			spriteSheet = ImageIO.read(ImageSplitterTest.class.getResource("/resources/spriteSheets/tiles-map.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		levelXML = reader.parseDocument();
		Element mapElement = (Element) levelXML.getElementsByTagName("map");
		mapWidth = Integer.parseInt(mapElement.getAttribute("width"));
		mapHeight = Integer.parseInt(mapElement.getAttribute("height"));
		
		if(mapWidth == 0 || mapHeight == 0){
			System.out.println("Something went wrong, check map dimensions");
		}
	}
}




















