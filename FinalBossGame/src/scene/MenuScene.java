package scene;

import viewport.MenuViewPort;
import viewport.ViewPort;

/**
 *
 * @author ChrisMoscoso
 */
public class MenuScene extends Scene {
    
    ViewPort mainMenu;  
    public MenuScene(){
        mainMenu = new MenuViewPort(this);
        viewports.add(mainMenu);
        
    }    
    
}
