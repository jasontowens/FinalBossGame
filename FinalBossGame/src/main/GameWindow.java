package main;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ChrisMoscoso
 */
public class GameWindow extends JFrame {
        
    public GameWindow(){
        GamePanel gp = new GamePanel();
        this.getContentPane().add(gp, BorderLayout.CENTER);
        
        int menuBarOffset = 20;
        this.setSize(RunGame.WIDTH, RunGame.HEIGHT + menuBarOffset);
        this.setTitle("FINAL BOSS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    
}
