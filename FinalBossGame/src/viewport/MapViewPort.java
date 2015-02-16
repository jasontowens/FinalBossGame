package viewport;

import coordinators.GameCoordinator;
import gameobject.GameObject;
import item.Item;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.RunGame;
import map.CoordinatePair;
import map.GameMap;
import scene.Scene;

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
       this.map = gc.getActiveMap();
    }

    public void drawGraphics(Graphics g) {
        
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("MAP VIEWPORT", RunGame.WIDTH/2 - 85, RunGame.HEIGHT/2);
        
        GameMap cmap = GameMap.getInstance();
        BufferedImage[][] images = RunGame.ml.getMap();
        for(int i = 0; i < RunGame.ml.getMapWidth(); i++){
            for(int j = 0; j < RunGame.ml.getMapHeight(); j++){
                g.drawImage(images[j][i], i*RunGame.TILE_WIDTH, j*RunGame.TILE_HEIGHT, null);
         
                Item itemat = cmap.getItemAt(new CoordinatePair(i,j));
                if(itemat != null)
                {
                	g.drawImage(RunGame.ssh.getSprite(((GameObject) itemat).getID()), i*RunGame.TILE_WIDTH, j*RunGame.TILE_HEIGHT, null);
                }
                
                Entity entat = cmap.getEntityAt(new CoordinatePair(i,j));
                if(entat != null)
                {
                	g.drawImage(RunGame.ssh.getSprite(entat.getID()), i*RunGame.TILE_WIDTH, j*RunGame.TILE_HEIGHT, null);
                }
            }
        }     
    }
}
