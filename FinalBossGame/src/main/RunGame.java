package main;

import entity.*;
import map.*;
import controllers.InputParser;
import coordinators.GameCoordinator;

/**
 *
 * @author moco
 */
public class RunGame {
    
    public static final int NUM_OF_TILES_WIDE = 5, NUM_OF_TILES_HIGH = 5;
    public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32; 
    public static final int WIDTH = NUM_OF_TILES_WIDE * TILE_WIDTH, HEIGHT= NUM_OF_TILES_HIGH * TILE_HEIGHT; //The width and height of the game window
    public static final int FPS = 60;//The prefered FPS animation rate
    public static boolean RUNNING = true;
    
    public static void main(String[] args) {
        System.out.println("Game Window Size: " + WIDTH + "x" + HEIGHT); //initial message
    	GameMap myMap = new GameMap();	//create empty game map
    	for(int i = 0; i != 25; ++i){	//add tiles to game map
    		GameMap.addTile(new Tile(new Terrain("grass","a grassy tile","grass.png", GROUND)));
    	}
    	InputStream stream = new FileInputStream("./resources/saves/save1.xml"); //create stream with file to be loaded
    	//initialize items and entities in the map
    	ObjectFactory f = new ObjectFactory(stream, myMap);	
    	Entity myAvatar = f.parseFile();
    	//set up controllers and coordinators
    	InputParser myParser = new InputParser();
    	GameCoordinator myGameCoord = GameCoordiator.getInstance();
    	myGameCoord.setAvatar(myAvater);
    	myGameCoord.setActiveMap(myMap);
    	//set up view
    	GameWindow window =	new GameWindow();
    	window.setModel(myGameCoord, MenuCoordinator.getInstance(), InventoryCoordinator.getInstance());
        window.addKeyListener(myParser);
    }
    
}
