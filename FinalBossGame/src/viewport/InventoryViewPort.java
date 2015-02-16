package viewport;

import coordinators.GameCoordinator;
import coordinators.InventoryCoordinator;
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
import util.ImageSplitter;

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

            g.setColor(new Color(0, 0, 0, 100));
            g.fillRect(0, RunGame.HEIGHT - 200, 160, RunGame.HEIGHT);

            g.setColor(Color.WHITE);
            g.fillRect(0, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.fillRect(32, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.fillRect(64, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.fillRect(96, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
            g.fillRect(128, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);

            /*SACK ITEMS*/
            for (int i = 5; i < 10; i++) {
                Takeable t = InventoryCoordinator.getInstance().getItem(i);
                BufferedImage img = null;
                if (t != null) {
                    img = ImageSplitter.getInstance().getTileFromID(t.getID());
                }
                g.drawImage(img, (i - 5) * RunGame.TILE_WIDTH, RunGame.HEIGHT - RunGame.TILE_HEIGHT, null);

            }

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
                BufferedImage pants = ImageIO.read(getClass().getResource("/resources/singleSprites/pants.jpg"));
                BufferedImage boots = ImageIO.read(getClass().getResource("/resources/singleSprites/boots.jpg"));

                BufferedImage[] slots = {head, weapon, torso, pants, boots};

                /*Armory Items*/
                for (int i = 0; i < 5; i++) {
                    Takeable t = InventoryCoordinator.getInstance().getItem(i);
                    BufferedImage img;
                    if (t != null) {
                        img = ImageSplitter.getInstance().getTileFromID(t.getID());
                    } else {
                        img = slots[i];
                    }
                    g.setColor(Color.yellow);
                    //Draw the slots in a straight line. Except for the weapon
                    if (i == 0) {
                        if (InventoryCoordinator.getInstance().getSelectedItemIndex() == i) {
                            g.drawRect(64, RunGame.HEIGHT - 200 + (i * 35), RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
                        }
                        g.drawImage(img, 64, RunGame.HEIGHT - 200 + (i * 35), null);
                    } else if (i == 1) {
                        if (InventoryCoordinator.getInstance().getSelectedItemIndex() == i) {
                            g.drawRect(32, RunGame.HEIGHT - 165, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
                        }
                        g.drawImage(img, 32, RunGame.HEIGHT - 165, null);
                    } else {
                        if (InventoryCoordinator.getInstance().getSelectedItemIndex() == i) {
                            g.drawRect(64, RunGame.HEIGHT - 200 + ((i - 1) * 35), RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
                        }
                        g.drawImage(img, 64, RunGame.HEIGHT - 200 + ((i - 1) * 35), null);
                    }

                }

                g.setColor(Color.yellow);
                /*Check at the end for selected item*/
                for (int i = 0; i < 10; i++) {
                    if (i == 0) {
                        if (InventoryCoordinator.getInstance().getSelectedItemIndex() == i) {
                            g.drawRect(64, RunGame.HEIGHT - 200 + (i * 35), RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
                        }
                    }
                    if (i == 1) {
                        if (InventoryCoordinator.getInstance().getSelectedItemIndex() == i) {
                            g.drawRect(32, RunGame.HEIGHT - 165, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
                        }
                    }
                    if (i > 1 && i < 5) {
                        if (InventoryCoordinator.getInstance().getSelectedItemIndex() == i) {
                            g.drawRect(64, RunGame.HEIGHT - 200 + ((i - 1) * 35), RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
                        }
                    }
                    if (i >= 5) {
                        if (InventoryCoordinator.getInstance().getSelectedItemIndex() == i) {
                            g.drawRect((i - 5) * RunGame.TILE_WIDTH, RunGame.HEIGHT - RunGame.TILE_HEIGHT, RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
                        }
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(InventoryViewPort.class.getName()).log(Level.INFO, null, ex);
            }
        }
    }
}
