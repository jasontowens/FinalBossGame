package main;
import controllers.InputParser;
import coordinators.GameCoordinator;
import coordinators.InventoryCoordinator;
import coordinators.MenuCoordinator;
import factories.EntityFactory;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import map.GameMap;

import org.xml.sax.SAXException;

import static sun.audio.AudioPlayer.player;
import util.MapLoader;
import util.SpriteSheetHandler;

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
    public static SpriteSheetHandler ssh;
    
    GameCoordinator gc;
    MenuCoordinator mc;
    InventoryCoordinator ic;
    
    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
    	
        
        InputStream is = RunGame.class.getResourceAsStream("/resources/levels/level 1.xml");
        ml = MapLoader.getInstance(is);
        ssh = SpriteSheetHandler.getInstance();
        ssh.SetupSheet("/resources/spriteSheets/spritesheetv1.png", 32, 32, 9, 11);
        

        NUM_OF_TILES_WIDE = ml.getMapWidth();
        NUM_OF_TILES_HIGH = ml.getMapHeight();
        WIDTH = NUM_OF_TILES_WIDE * TILE_WIDTH;
        HEIGHT = NUM_OF_TILES_HIGH * TILE_HEIGHT;
        
        System.out.println("Game Window Size: " + WIDTH + "x" + HEIGHT); //initial message

        EntityFactory e = new EntityFactory();
            	
    	GameWindow window = new GameWindow();
        window.addKeyListener(new InputParser());
    }
    
}
