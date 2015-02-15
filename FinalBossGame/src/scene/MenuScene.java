package scene;

import viewport.MainMenuViewPort;
import viewport.ViewPort;

/**
 *
 * @author ChrisMoscoso
 */
public class MenuScene extends Scene {
    
    ViewPort mainMenu;  
    public MenuScene(){
        mainMenu = new MainMenuViewPort(this);
        viewports.add(mainMenu);
        
    }    
    
}
