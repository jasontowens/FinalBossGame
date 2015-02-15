package viewport;

import viewport.ViewPort;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import main.RunGame;
import map.GameMap;
import map.Tile;
import scene.Scene;
import stats.PlayerStats;

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
       Object o = scene.getModelObject("map");
       this.map = (GameMap) o;
    }

    public void drawGraphics(Graphics g) {
        Tile[][] tiles = null;
        if(map == null){
           queryModel();
        }else{
            tiles = map.getTilesForScreen();
        }
        if(tiles != null){
            for(int i= 0; i <tiles.length; i++){
                for(int j = 0; j < tiles[0].length; j++){
                    tiles[i][j].getTerrain().getSpriteFilePath();
                }
            }
        }
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("MAP VIEWPORT", RunGame.WIDTH/2 - 85, RunGame.HEIGHT/2);
    }
}
