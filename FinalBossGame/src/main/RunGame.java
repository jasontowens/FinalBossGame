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
        System.out.println("Game Window Size: " + WIDTH + "x" + HEIGHT);
    	GameMap myMap = new GameMap();
    	for(int i = 0; i != 25; ++i){
    		GameMap.addTile(new Tile(new Terrain("grass","a grassy tile","grass.png", GROUND)));
    	}
    	InputStream stream = new FileInputStream("./resources/saves/save1.xml");
    	ObjectFactory f = new ObjectFactory(stream, myMap);
    	Entity myAvatar = f.parseFile();
    	InputParser myParser = new InputParser();
    	GameCoordinator myGameCoord = GameCoordiator.getInstance();
    	myGameCoord.setAvatar(myAvater);
    	GameWindow window =	new GameWindow();
    	window.setModel(myGameCoord, )
    	//MODEL SETUP
    	
    	//TODO: CREATE MODEL, store avatar in myAvatar and active mao in myMap
    	
    	//CONTROLLER SETUP
    	InputParser myParser = new InputParser();
    	GameCoordinator myGameCoord = GameCoordinator.getInstance();
    	//myGameCoord.setAvatar(myAvater);
    	//myGameCoord.setActiveMap(myMap);
    	
    	
    	//
    	//TODO: add the view:
    	GameWindow window =	new GameWindow();
        window.addKeyListener(myParser);
    	//window.setModel( para1, para2...)
    	
    	
    	//To end game:
    	//RUNNING = false;
    }
    
}
