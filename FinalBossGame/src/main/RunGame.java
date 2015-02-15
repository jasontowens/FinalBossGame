package main;
import controllers.InputParser;
import coordinators.GameCoordinator;
import coordinators.InventoryCoordinator;
import coordinators.MenuCoordinator;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import util.MapLoader;

/**
 *
 * @author moco
 */
public class RunGame {
    
    public static int NUM_OF_TILES_WIDE, NUM_OF_TILES_HIGH;
    public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32; 
    public static int WIDTH = NUM_OF_TILES_WIDE * TILE_WIDTH, HEIGHT= NUM_OF_TILES_HIGH * TILE_HEIGHT; //The width and height of the game window
    public static final int FPS = 60;//The prefered FPS animation rate
    public static boolean RUNNING = true;
    public static MapLoader ml;
    
    GameCoordinator gc;
    MenuCoordinator mc;
    InventoryCoordinator ic;
    
    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
    	
        
        InputStream is = RunGame.class.getResourceAsStream("/resources/levels/10x10.xml");
        ml = MapLoader.getIntance(is);
        
        BufferedImage[][] map = ml.getMap();
        NUM_OF_TILES_WIDE = ml.getMapWidth();
        NUM_OF_TILES_HIGH = ml.getMapHeight();
        WIDTH = NUM_OF_TILES_WIDE * TILE_WIDTH;
        HEIGHT = NUM_OF_TILES_HIGH * TILE_HEIGHT;
        
        System.out.println("Game Window Size: " + WIDTH + "x" + HEIGHT); //initial message

        

        GameCoordinator gc = GameCoordinator.getInstance();
        MenuCoordinator mc = MenuCoordinator.getInstance();
        InventoryCoordinator ic = InventoryCoordinator.getInstance();
    	
        //set up view

    	GameWindow window = new GameWindow();
        GamePanel gp = new GamePanel( gc, mc, ic );
        window.getContentPane().add(gp, BorderLayout.CENTER);
        window.addKeyListener(new InputParser());
    }
    
}
