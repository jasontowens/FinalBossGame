package viewport;

import java.awt.Graphics;
import scene.Scene;

/**
 *
 * @author ChrisMoscoso
 */
public abstract class ViewPort { 
    
    Scene scene; //A reference to the scene that the viewport os in
    
    public ViewPort(Scene s){
        scene = s;
    }
    
    private void queryModel(){}
    public void drawGraphics(Graphics g){} 
}
