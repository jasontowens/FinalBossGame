package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

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
	
	int[][] idTable;
	BufferedImage[][] map;
	
	
	/*
	 * Making it a singleton for now
	 */
	private static MapLoader thisMapLoader = null;
	
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
			spriteSheet = ImageIO.read(getClass().getResource("/resources/spriteSheets/tiles-map.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		levelXML = reader.parseDocument();
		
		NodeList mapNodeList = levelXML.getElementsByTagName("map");
		Element mapElement = (Element)mapNodeList.item(0);
		mapWidth = Integer.parseInt(mapElement.getAttribute("width"));
		mapHeight = Integer.parseInt(mapElement.getAttribute("height"));
		
		
		
		if(mapWidth == 0 || mapHeight == 0){
			System.out.println("Something went wrong, check map dimensions");
		}
		
		splitter = splitter.getInstance(spriteSheet, mapWidth, mapHeight);
		idTable = new int[mapHeight][mapWidth];
		map = new BufferedImage[mapHeight][mapWidth];
		fillIDTable();
		fillMap();
		
	}
	
	
	public static MapLoader getIntance(InputStream in){
		if(thisMapLoader == null){
			thisMapLoader = new MapLoader(in);
		}
		
		return thisMapLoader;
	}
	
	private void fillMap(){
		
		for(int i = 0; i < mapHeight; ++i){
			for(int j = 0; j < mapWidth; ++j){
				map[i][j] = splitter.getTileFromID(idTable[i][j]);
			}
		}
	}
	
	private void fillIDTable(){
		Element head = levelXML.getDocumentElement();
		List<Element> tiles = reader.getElements("tile" , head);
		int i = 0;
		int j = 0;
		int id;
		for(int counter = 0; counter < tiles.size(); ++counter){
			id = Integer.parseInt(tiles.get(counter).getAttribute("gid"));
			i  = counter / mapWidth;
			j  = counter % mapWidth;
			idTable[i][j] = id;
		}
		
		
	}
	
	public BufferedImage[][] getMap(){
		return map;
	}
	
	public int[][]  getIdTable(){
		return idTable;
	}
	
	
	public int getMapHeight(){
		return mapHeight;
	}
	
	public int getMapWidth(){
		return mapWidth;
	}
	
}




















