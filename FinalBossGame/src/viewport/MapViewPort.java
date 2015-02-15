package viewport;

import viewport.ViewPort;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import main.RunGame;
import scene.Scene;

/**
 *
 * @author ChrisMoscoso
 */
public class MapViewPort extends ViewPort {

    int r = 0, g = 0, b = 0;

    public MapViewPort(Scene s) {
        super(s);
    }

    private void queryModel() {
        r = 0;//(int) (Math.random() * 255);
        g = 255;//(int) (Math.random() * 255);
        b = 0;//(int) (Math.random() * 255);
        //System.out.println("r:" + r + " g:" + g + "b:" + b);
    }

    public void drawGraphics(Graphics g) {
        queryModel();
        g.setColor(new Color(r, this.g, b));
        g.fillRect(0, 0, RunGame.WIDTH, RunGame.HEIGHT);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("MAP VIEWPORT", RunGame.WIDTH/2 - 85, RunGame.HEIGHT/2);
    }
}
