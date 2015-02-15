package miscTest;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import util.ImageSplitter;

/*
 * A test for ImageSplitter, uses a small JFrame. Pay special attention to the order
 * of arguments for ImageSplitter's getTile() method.
 * 
 * -Hanif
 * 
 */
public class ImageSplitterTest {
	public static void main(String [] args){
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(ImageSplitterTest.class.getResource("/resources/spriteSheets/tiles-map.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(img == null){
			System.out.println("Error with file path");
			System.exit(-1);
		}
		ImageSplitter splitter = new ImageSplitter(img , 32, 32);
		
		BufferedImage subImage = splitter.getTile(5, 0);
		
		JFrame j = new JFrame("Test");
		j.setSize(100, 100);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			

		
		JLabel tile = new JLabel(new ImageIcon(subImage));
		j.getContentPane().add(tile);
		j.setVisible(true);
	}
}

