package viewport;

import coordinators.CoordinatorType;
import coordinators.MenuCoordinator;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import main.RunGame;
import menu.Menu.MenuOption;
import scene.Scene;

/**
 *
 * @author ChrisMoscoso
 */
public class MenuViewPort extends ViewPort {

    MenuCoordinator menuCoordinator;
    //GameCoordinator gameCoordinator;
    MenuOption options;

    public MenuViewPort(Scene s) {
        super(s);
    }

    public void queryModel() {
        menuCoordinator = MenuCoordinator.getInstance();
    }

    @Override
    public void drawGraphics(Graphics g) {

        queryModel();
        Graphics2D g2D = (Graphics2D) g.create();

        ImageIcon imageIcon = new ImageIcon("src/resources/background/bg.gif");
        if (imageIcon != null) {
            g2D.drawImage(imageIcon.getImage(), 0, 0, null);
            g.setFont(new Font(g.getFont().getFamily(), Font.PLAIN, 30));
        } else {
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, RunGame.WIDTH, RunGame.HEIGHT);
        }

        for (int i = 0; i < menuCoordinator.getCurrentMenu().getOptions().length; i++) {
            if (menuCoordinator.getCurrentMenu().getCurrentSelection() == menuCoordinator.getCurrentMenu().getOptions()[i]) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.black);
            }
            String s;
            switch (menuCoordinator.getCurrentMenu().getOptions()[i].toString()) {
                case "NEW_GAME":
                    s = "New Game";
                    break;
                case "SWITCH_TO_LOAD_MENU":
                    s = "Load Game";
                    break;
                case "SAVE_FILE":
                    s = "Save Game";
                    break;
                case "RESUME_GAME":
                    s = "Resume Game";
                    break;
                case "OPEN_SAVE_FILE":
                    s = "Open Game From File...";
                    break;
                case "RETURN_TO_MAIN_MENU":
                    s = "Return to Main Menu";
                    break;
                case "EXIT":
                default:
                    s = "Exit Game";

            }

            g.drawString(s, RunGame.WIDTH / 2 - 85, 400 + i * 50);
        }

        BufferedImage i = null;
        try {
            i = ImageIO.read(getClass().getResource("/resources/spriteSheets/FinalBoss.png"));
        } catch (IOException ex) {
            Logger.getLogger(MenuViewPort.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(i, RunGame.WIDTH / 2 - i.getWidth() / 2, 100, null);

    }
}
