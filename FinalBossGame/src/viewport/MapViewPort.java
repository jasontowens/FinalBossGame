package viewport;

import coordinators.GameCoordinator;
import entity.Entity;
import item.Item;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.RunGame;
import map.CoordinatePair;
import map.GameMap;
import map.Pair;
import scene.Scene;
import util.ImageSplitter;
import util.MapLoader;

/**
 *
 * @author ChrisMoscoso
 */
public class MapViewPort extends ViewPort {

    private GameMap map;

    public MapViewPort(Scene s) {
        super(s);
    }

    private void queryModel() {
       Object o = scene.getModelObject("game");
       GameCoordinator gc = (GameCoordinator) o;
       //this.map = gc.getActiveMap();
    }

    public void drawGraphics(Graphics g) {
        queryModel();
        //g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        //g.drawString("MAP VIEWPORT", RunGame.WIDTH/2 - 85, RunGame.HEIGHT/2);
        
        BufferedImage[][] images = RunGame.ml.getMap();
        for(int i = 0; i < RunGame.ml.getMapWidth(); i++){
            for(int j = 0; j < RunGame.ml.getMapHeight(); j++){
                g.drawImage(images[j][i], i*RunGame.TILE_WIDTH, j*RunGame.TILE_HEIGHT, null);
            }
        }
        
        
        GameMap map = GameMap.getInstance();
        
        //Draw Entities
        for (Pair p : map.getAllEntities()){
            Entity e = (Entity) p.getLeft();
            CoordinatePair c = (CoordinatePair) p.getRight();            
            ImageSplitter splitter = ImageSplitter.getInstance();
            BufferedImage i = splitter.getTileFromID(e.getID());
            //g.setColor(Color.pink);
            //g.fillRect(c.getX() * RunGame.TILE_WIDTH , c.getY() * RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
              g.drawImage(i, c.getX()*RunGame.TILE_WIDTH, c.getY()*RunGame.TILE_HEIGHT, null); 
        }
        
        //Draw Items
        for(Pair p: map.getAllItems()){
            Item item = (Item) p.getLeft();
            CoordinatePair c = (CoordinatePair) p.getRight();
            
            ImageSplitter splitter = ImageSplitter.getInstance();
            BufferedImage image = splitter.getTileFromID(item.getID());
            
            g.drawImage(image, c.getX()*RunGame.TILE_WIDTH, c.getY()*RunGame.TILE_HEIGHT, null);
               
        }
        
        
    }
}
