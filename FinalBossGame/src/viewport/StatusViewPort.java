package viewport;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import main.RunGame;
import scene.Scene;
import stats.PlayerStats;

/**
 *
 * @author ChrisMoscoso
 */
public class StatusViewPort extends ViewPort {

    private PlayerStats p;
   
    public StatusViewPort(Scene s) {
        super(s); 
    }

    public void queryModel() {
       Object o = scene.getModelObject("stats");
       p = (PlayerStats) o;
    }

    @Override
    public void drawGraphics(Graphics g) {
        /*g.setColor(Color.blue);
        g.fillRect(0, RunGame.HEIGHT - 100, RunGame.WIDTH, 100);
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.setColor(Color.black);
        g.drawString("STATUS VIEWPORT", RunGame.WIDTH/2 - 85, RunGame.HEIGHT - 50);*/
        
        queryModel();
        if(p != null){
            g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
            g.drawString("Agility: " + p.getAgility(), 0, RunGame.HEIGHT - 170);
            g.drawString("Armor Rating: " + p.getArmorRating(), 0, RunGame.HEIGHT - 160);
            g.drawString("Defense: " + p.getDefense(), 0, RunGame.HEIGHT - 150);
            g.drawString("Defensive Rating: " + p.getDefensiveRating(), 0, RunGame.HEIGHT - 140);            
            g.drawString("Experience: " + p.getExperience(), 0, RunGame.HEIGHT - 130);
            g.drawString("Hardiness: " + p.getHardiness(), 0, RunGame.HEIGHT - 120);
            g.drawString("Intellect: " + p.getIntellect(), 0, RunGame.HEIGHT - 110);
            g.drawString("HP Current: " + p.gethpMax(), 0, RunGame.HEIGHT - 100);
            g.drawString("HP Max: " + p.gethpMax(), 0, RunGame.HEIGHT - 90);
            g.drawString("Level: " + p.getLevel(), 0, RunGame.HEIGHT - 80);
            g.drawString("Lives: " + p.getLivesLeft(), 0, RunGame.HEIGHT - 70);
            g.drawString("MP Current: " + p.getmpCurrent(), 0, RunGame.HEIGHT - 60);
            g.drawString("MP Max: " + p.getmpMax(), 0, RunGame.HEIGHT - 50);
            g.drawString("Movement: " + p.getMovement(), 0, RunGame.HEIGHT - 40);
            g.drawString("Lives: " + p.getLivesLeft(), 0, RunGame.HEIGHT - 30);
            g.drawString("Offense: " + p.getOffense(), 0, RunGame.HEIGHT - 20);
            g.drawString("Strength: " + p.getStrength(), 0, RunGame.HEIGHT - 10);
            
        }
        
    }
}
