package viewport;

import java.awt.Graphics;
import scene.Scene;

/**
 *
 * @author ChrisMoscoso
 */
public class InventoryViewPort extends ViewPort {
    public InventoryViewPort(Scene s){
        super(s);
    }
    
    public void queryModel() {
       Object o = scene.getModelObject("inventory");
    }

    @Override
    public void drawGraphics(Graphics g) {
    }
}
