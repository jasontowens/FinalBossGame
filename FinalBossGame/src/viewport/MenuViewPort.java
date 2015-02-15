package viewport;


import coordinators.MenuCoordinator;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import menu.Menu.MenuOption;
import scene.Scene;

/**
 *
 * @author ChrisMoscoso
 */
public class MenuViewPort extends ViewPort {

    MenuCoordinator mainMenu;
    MenuOption options;

    public MenuViewPort(Scene s) {
        super(s);
    }

    public void queryModel() {
        Object o = scene.getModelObject("menucoordinator");
        //menucoordinator = (MainMenuCoordinator) o;
        
    }

    @Override
    public void drawGraphics(Graphics g) {
        if (mainMenu != null && options != null) {
            
        }

    }
}
