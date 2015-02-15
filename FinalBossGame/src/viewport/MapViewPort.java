package viewport;

import coordinators.GameCoordinator;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.RunGame;
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
        
        BufferedImage[][] images = RunGame.ml.getMap();
        for(int i = 0; i < RunGame.NUM_OF_TILES_HIGH; i++){
            for(int j = 0; j < RunGame.NUM_OF_TILES_WIDE; j++){
                g.drawImage(images[j][i], i*RunGame.TILE_WIDTH, j*RunGame.TILE_HEIGHT, null);
            }
        }
        
        
    }
}
