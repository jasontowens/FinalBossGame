package main;

import coordinators.GameCoordinator;
import coordinators.InventoryCoordinator;
import coordinators.MenuCoordinator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import scene.SceneManager;

/**
 *
 * @author ChrisMoscoso
 */
public class GamePanel extends JPanel implements Runnable {

    private final Thread animator;
    private boolean showFPS = false; //Shows the current FPS on screen
    private int currentFPS;
    private boolean gameOver = false;
    private SceneManager sm;
    private BufferedImage i;
    private long gameStartTime;
    private long prevStatsTime;

    private static final int MAX_FRAME_SKIPS = 5;
    /* Number of frames that can be skipped by the renderer to keep the 
     game updates per second close to the frames per second.
     */

    public GamePanel(int width, int height) {
        this.setSize(width, height);
        animator = new Thread((Runnable) this);
    }

    public GamePanel() {
        this(RunGame.WIDTH, RunGame.HEIGHT);
        //Create the scene manager
        sm = SceneManager.getInstance();
        //Start the animator thread
        animator.start();
    }

    /* Repeatedly: update, render, sleep so loop takes close
     to period milliseconds to run */
    @Override
    public void run() {
        long beforeTime, afterTime, timeDiff, sleepTime, period;
        long overSleepTime = 0L;
        int noDelays = 0;
        long excess = 0L;

        period = 1000 / RunGame.FPS;

        gameStartTime = System.currentTimeMillis();
        prevStatsTime = gameStartTime;
        beforeTime = gameStartTime;

        while (RunGame.RUNNING) {
            gameUpdate();// game state is updated
            gameRender();// render to a buffer
            paintScreen();// paint with the buffer

            afterTime = System.currentTimeMillis();
            timeDiff = afterTime - beforeTime;
            sleepTime = period - timeDiff - overSleepTime; // time left in this loop

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);  // sleep a bit
                } catch (InterruptedException ex) {
                }
                overSleepTime = (System.currentTimeMillis() - afterTime) - sleepTime;
            } else { //sleeptime <=0; frame took longer than a period
                excess -= sleepTime; //store excess time value
                overSleepTime = 0;
            }

            beforeTime = System.currentTimeMillis();

            /* If frame animation is taking too long, update the game state
             without rendering it, to get the updates/sec nearer to
             the required FPS. */
            int skips = 0;
            while ((excess > period) && (skips < MAX_FRAME_SKIPS)) {
                excess -= period;
                gameUpdate(); // update state but don't render 
                skips++;
            }

        }
        System.exit(0); // so enclosing JFrame/JApplet exits }
    }

    //This is when the model updates itself
    public void gameUpdate() {

    }

    //Render the game to buffer
    public void gameRender() {
        i = sm.getActiveScene().getImage();
    }

    //Draw the buffer to screen
    public void paintScreen() {
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(i, 0, 0, this);
        if (showFPS) {
            g.setColor(Color.black);
            g.drawString("FPS: ", 0, 20);
        }
    }

    public void gameOver() {
        this.gameOver = true;
    }
}
