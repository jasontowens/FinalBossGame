package scene;

import viewport.InventoryViewPort;
import viewport.PauseViewPort;
import viewport.MapViewPort;
import viewport.StatusViewPort;
import viewport.ViewPort;

/**
 *
 * @author ChrisMoscoso
 */
public class GameScene extends Scene {
    
    ViewPort map, status,inventory, pause;  
    public GameScene(){
        map = new MapViewPort(this);
        status = new StatusViewPort(this);
        inventory = new InventoryViewPort(this);
        pause = new PauseViewPort(this);
        viewports.add(map);
        viewports.add(status);
        viewports.add(inventory);
        viewports.add(pause);
    }    
}
