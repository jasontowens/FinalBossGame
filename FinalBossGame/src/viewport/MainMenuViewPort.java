package viewport;

import coordinators.MainMenuCoordinator;
import coordinators.MainOption;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import scene.Scene;

/**
 *
 * @author ChrisMoscoso
 */
public class MainMenuViewPort extends ViewPort {

    MainMenuCoordinator mainMenu;
    MainOption options;

    public MainMenuViewPort(Scene s) {
        super(s);
    }

    public void queryModel() {
        Object o = scene.getModelObject("mainmenu");
        mainMenu = (MainMenuCoordinator) o;
        o = scene.getModelObject("options");
        options = (MainOption) o;
    }

    @Override
    public void drawGraphics(Graphics g) {
        if (mainMenu != null && options != null) {
            g.setFont(new Font(g.getFont().getFamily(), Font.PLAIN, 20));
            g.setColor(Color.black);
            if (mainMenu.getCurrentSelection() == options.Start) {
                g.setColor(Color.red);
            }
            g.drawString("Start Game", 10, 10);
            g.setColor(Color.BLACK);

            if (mainMenu.getCurrentSelection() == options.Load) {
                g.setColor(Color.red);

            }
            g.drawString("Load Game", 10, 30);
            g.setColor(Color.BLACK);
            if (mainMenu.getCurrentSelection() == options.Exit) {
                g.setColor(Color.red);
            }
            g.drawString("Exit Game", 10, 50);
            g.setColor(Color.BLACK);

        }

    }
}
