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
        this.setSize(RunGame.WIDTH, RunGame.HEIGHT);
        this.setTitle("FINAL BOSS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        GamePanel gp = new GamePanel(this.getWidth(), this.getHeight());
        this.getContentPane().add(gp, BorderLayout.CENTER);
    }
    
}
