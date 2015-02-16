package viewport;

import java.awt.Font;
import java.awt.Graphics;
import main.RunGame;
import scene.Scene;
import stats.PlayerStats;
import coordinators.GameCoordinator;
import entity.Entity;
import java.awt.Color;
import java.awt.image.BufferedImage;
import map.CoordinatePair;
import map.GameMap;
import map.Pair;
import util.ImageSplitter;

/**
 *
 * @author ChrisMoscoso
 */
public class StatusViewPort extends ViewPort {

    private PlayerStats stats;
   
    public StatusViewPort(Scene s) {
        super(s); 
        queryModel();
    }

    public void queryModel() {
       
       GameCoordinator gc = GameCoordinator.getInstance();
       GameMap map = GameMap.getInstance();
        
        for (Pair p : map.getAllEntities()){
            Entity e = (Entity) p.getLeft();
            stats = e.getStats();
        }
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
        if(stats != null){
            g.setFont(new Font("TimesRoman", Font.PLAIN, 16));
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(RunGame.WIDTH - 160, RunGame.HEIGHT - 380, RunGame.WIDTH, RunGame.HEIGHT);
            g.setColor(new Color(255, 255, 0, 255));
            g.drawString("Occupation: " + GameCoordinator.getInstance().getAvatar().getOccupationName(), RunGame.WIDTH - 150, RunGame.HEIGHT - 360);
            g.drawString("Agility: " + stats.getAgility(), RunGame.WIDTH - 150, RunGame.HEIGHT - 340);
            g.drawString("Armor Rating: " + stats.getArmorRating(), RunGame.WIDTH - 150, RunGame.HEIGHT - 320);
            g.drawString("Defense: " + stats.getDefense(), RunGame.WIDTH - 150, RunGame.HEIGHT - 300);
            g.drawString("Defensive Rating: " + stats.getDefensiveRating(), RunGame.WIDTH - 150, RunGame.HEIGHT - 280);            
            g.drawString("Experience: " + stats.getExperience(), RunGame.WIDTH - 150, RunGame.HEIGHT - 260);
            g.drawString("Hardiness: " + stats.getHardiness(), RunGame.WIDTH - 150, RunGame.HEIGHT - 240);
            g.drawString("Intellect: " + stats.getIntellect(), RunGame.WIDTH - 150, RunGame.HEIGHT - 220);
            g.drawString("HP Current: " + stats.gethpMax(), RunGame.WIDTH - 150, RunGame.HEIGHT - 200);
            g.drawString("HP Max: " + stats.gethpMax(), RunGame.WIDTH - 150, RunGame.HEIGHT - 180);
            g.drawString("Level: " + stats.getLevel(), RunGame.WIDTH - 150, RunGame.HEIGHT - 160);
            g.drawString("Lives: " + stats.getLivesLeft(), RunGame.WIDTH - 150, RunGame.HEIGHT - 140);
            g.drawString("MP Current: " + stats.getmpCurrent(), RunGame.WIDTH - 150, RunGame.HEIGHT - 120);
            g.drawString("MP Max: " + stats.getmpMax(), RunGame.WIDTH - 150, RunGame.HEIGHT - 100);
            g.drawString("Movement: " + stats.getMovement(), RunGame.WIDTH - 150, RunGame.HEIGHT - 80);
            g.drawString("Lives: " + stats.getLivesLeft(), RunGame.WIDTH - 150, RunGame.HEIGHT - 60);
            g.drawString("Offense: " + stats.getOffense(), RunGame.WIDTH - 150, RunGame.HEIGHT - 40);
            g.drawString("Strength: " + stats.getStrength(), RunGame.WIDTH - 150, RunGame.HEIGHT - 20);
            
        }
        
    }
}
