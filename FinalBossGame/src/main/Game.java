package main;

/**
 *
 * @author moco
 */
public class Game {
    
    public static final int WIDTH = 720, HEIGHT=600; //The width and height of the game window
    public static final int FPS = 60;//The prefered FPS animation rate
    public static boolean RUNNING = true;
    
    public static void main(String[] args) {
        
    	//MODEL SETUP
    	
    	//TODO: CREATE MODEL, store avatar in myAvatar and active mao in myMap
    	
    	//CONTROLLER SETUP
    	InputParser myParser = new InputParser();
    	GameCoordinator myGameCoord = GameCoordiator.getInstance();
    	myGameCoord.setAvatar(myAvater);
    	myGameCoord.setActiveMap(myMap);
    	
    	
    	//
    	//TODO: add the view:
    	GameWindow window =	new GameWindow();
    	//window.setModel( para1, para2...)
    	
    	
    	//To end game:
    	//RUNNING = false;
    }
    
}
