package viewport;

import coordinators.GameCoordinator;
import entity.Entity;
import inventory.Armory;
import inventory.Inventory;
import inventory.Sack;
import item.Takeable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import main.RunGame;
import map.GameMap;
import map.Pair;
import scene.Scene;

/**
 *
 * @author ChrisMoscoso
 */
public class InventoryViewPort extends ViewPort {

    HashMap armory;
    Takeable[] sack;

    public InventoryViewPort(Scene s) {
        super(s);
    }

    public void queryModel() {
        GameMap map = GameMap.getInstance();
        map.getAllEntities();
        for (Pair p : map.getAllEntities()) {
            Entity e = (Entity) p.getLeft();
            if (e != null) {
                armory = e.getArmory();
                sack = e.getSack();

            }
        }
    }

    @Override
    public void drawGraphics(Graphics g) {
        queryModel();

        GameCoordinator gc = GameCoordinator.getInstance();
        if (gc.showInventory()) {
            g.setColor(Color.WHITE);
            g.fillRect(0, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.fillRect(32, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.fillRect(64, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.fillRect(96, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.fillRect(128, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);

            g.setColor(Color.BLUE);
            g.drawRect(0, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.drawRect(32, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.drawRect(64, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.drawRect(96, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.drawRect(128, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            try {
                BufferedImage head = ImageIO.read(getClass().getResource("/resources/singleSprites/head.jpg"));
                BufferedImage weapon = ImageIO.read(getClass().getResource("/resources/singleSprites/weapon.jpg"));
                BufferedImage torso = ImageIO.read(getClass().getResource("/resources/singleSprites/torso.jpg"));
                BufferedImage shield = ImageIO.read(getClass().getResource("/resources/singleSprites/shield.jpg"));
                BufferedImage pants = ImageIO.read(getClass().getResource("/resources/singleSprites/pants.jpg"));
                BufferedImage boots = ImageIO.read(getClass().getResource("/resources/singleSprites/boots.jpg"));
                
                g.drawImage(head, 64, RunGame.HEIGHT - 200, null);
                g.drawImage(torso, 64, RunGame.HEIGHT - 165, null);
                g.drawImage(pants, 64, RunGame.HEIGHT - 130, null);
                g.drawImage(boots, 64, RunGame.HEIGHT - 95, null);
                g.drawImage(weapon, 32, RunGame.HEIGHT - 165, null);
            } catch (IOException ex) {
                Logger.getLogger(InventoryViewPort.class.getName()).log(Level.INFO, null, ex);
            }
        }
    }
}
