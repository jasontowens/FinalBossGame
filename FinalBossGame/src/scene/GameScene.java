package scene;

import viewport.MapViewPort;
import viewport.StatusViewPort;
import viewport.ViewPort;

/**
 *
 * @author ChrisMoscoso
 */
public class GameScene extends Scene {
    
    ViewPort mvp, statusViewPort;  
    public GameScene(){
        mvp = new MapViewPort();
        statusViewPort = new StatusViewPort();
        viewports.add(mvp);
        viewports.add(statusViewPort);
    }    
}
