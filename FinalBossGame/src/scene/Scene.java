package scene;

import viewport.ViewPort;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import main.Game;

/**
 *
 * @author ChrisMoscoso
 */
public abstract class Scene {
    
    ArrayList<ViewPort> viewports = new ArrayList<ViewPort>();
    
    
    public BufferedImage getImage(){
        BufferedImage i = new BufferedImage(Game.WIDTH , Game.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        for(ViewPort v : viewports){
            v.drawGraphics(i.getGraphics());
        }
        return i;
    }
}
