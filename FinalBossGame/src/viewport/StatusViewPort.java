package viewport;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import main.Game;

/**
 *
 * @author ChrisMoscoso
 */
public class StatusViewPort extends ViewPort {

    public void queryModel() {
    }

    @Override
    public void drawGraphics(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0, Game.HEIGHT - 100, Game.WIDTH, 100);
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("STATUS VIEWPORT", Game.WIDTH/2 - 85, Game.HEIGHT - 50);
    }
}
