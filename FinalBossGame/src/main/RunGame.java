package main;

/**
 *
 * @author moco
 */
public class RunGame {
    
    public static final int NUM_OF_TILES_WIDE = 21, NUM_OF_TILES_HIGH = 17;
    public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32; 
    public static final int WIDTH = NUM_OF_TILES_WIDE * TILE_WIDTH, HEIGHT= NUM_OF_TILES_HIGH * TILE_HEIGHT; //The width and height of the game window
    public static final int FPS = 60;//The prefered FPS animation rate
    public static boolean RUNNING = true;
    
    public static void main(String[] args) {
        System.out.println("Game Window Size: " + WIDTH + "x" + HEIGHT);
    	//MODEL SETUP
    	
    	//TODO: CREATE MODEL, store avatar in myAvatar and active mao in myMap
    	
    	//CONTROLLER SETUP
    	/*InputParser myParser = new InputParser();
    	GameCoordinator myGameCoord = GameCoordiator.getInstance();
    	myGameCoord.setAvatar(myAvater);
    	myGameCoord.setActiveMap(myMap);*/
    	
    	
    	//
    	//TODO: add the view:
    	GameWindow window =	new GameWindow();
    	//window.setModel( para1, para2...)
    	
    	
    	//To end game:
    	//RUNNING = false;
    }
    
}
