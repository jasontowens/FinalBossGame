package viewport;

import java.awt.Graphics;
import scene.Scene;

/**
 *
 * @author ChrisMoscoso
 */
public class PauseViewPort extends ViewPort {

    public PauseViewPort(Scene s) {
        super(s);
    }
    
    public void queryModel() {
       Object o = scene.getModelObject("stats");
    }

    @Override
    public void drawGraphics(Graphics g) {
    }
    
}
