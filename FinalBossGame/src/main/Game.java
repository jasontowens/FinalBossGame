package main;

/**
 *
 * @author moco
 */
public class Game {
    
    public static final int WIDTH = 720, HEIGHT=600; //The width and height of the game window
    public static final int FPS = 60;//The prefered FPS animation rate
    public static boolean RUNNING = true;
    
    public static void main(String[] args) {
        new GameWindow();
    }
    
}
