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
        map = new MapViewPort();
        status = new StatusViewPort();
        viewports.add(map);
        viewports.add(status);
    }    
}
