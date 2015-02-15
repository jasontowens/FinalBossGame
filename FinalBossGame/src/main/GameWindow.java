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
        int menuBarOffset = 20;
        this.setSize(RunGame.WIDTH, RunGame.HEIGHT + menuBarOffset);
        this.setTitle("FINAL BOSS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        GamePanel gp = new GamePanel(this.getWidth(), this.getHeight());
        this.getContentPane().add(gp, BorderLayout.CENTER);
    }
    
}
