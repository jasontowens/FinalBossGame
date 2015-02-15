package scene;

import viewport.MapViewPort;
import viewport.StatusViewPort;
import viewport.ViewPort;

/**
 *
 * @author ChrisMoscoso
 */
public class GameScene extends Scene {
    
    ViewPort map, status;  
    public GameScene(){
        map = new MapViewPort(this);
        status = new StatusViewPort(this);
        viewports.add(map);
        viewports.add(status);
    }    
}
