package viewport;

import coordinators.GameCoordinator;
import coordinators.MenuCoordinator;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import main.RunGame;
import scene.Scene;

/**
 *
 * @author ChrisMoscoso
 */
public class PauseViewPort extends ViewPort {

    GameCoordinator gc;
    MenuCoordinator mc;

    public PauseViewPort(Scene s) {
        super(s);
        queryModel();
    }

    public void queryModel() {
        gc = GameCoordinator.getInstance();
        mc = MenuCoordinator.getInstance();
    }

    @Override
    public void drawGraphics(Graphics g) {
        if (gc.showPauseMenu()) {
            g.setFont(new Font(g.getFont().getFamily(), Font.PLAIN, 30));

            g.setColor(new Color(255, 255, 255, 100));
            g.fillRect(0, 0, RunGame.WIDTH, RunGame.HEIGHT);
            for (int i = 0; i < mc.getCurrentMenu().getOptions().length; i++) {
                if (mc.getCurrentMenu().getCurrentSelection() == mc.getCurrentMenu().getOptions()[i]) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.black);
                }
                String s;
                switch (mc.getCurrentMenu().getOptions()[i].toString()) {
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
                i = ImageIO.read(getClass().getResource("/resources/spriteSheets/finalBoss.png"));
            } catch (IOException ex) {
                Logger.getLogger(MenuViewPort.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.drawImage(i, RunGame.WIDTH / 2 - i.getWidth() / 2, 100, null);
        }
    }

}
