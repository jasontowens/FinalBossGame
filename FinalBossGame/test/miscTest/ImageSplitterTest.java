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
		BufferedImage [][] allTiles;
		BufferedImage spriteSheet = null;
		BufferedImage testImage = null;
		try {
			spriteSheet = ImageIO.read(ImageSplitterTest.class.getResource("/resources/spriteSheets/tiles-map.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(spriteSheet == null){
			System.out.println("Error with file path");
			System.exit(-1);
		}
		
		ImageSplitter splitter = ImageSplitter.getInstance(spriteSheet, 32, 32);
		
		String description;
		
		//System.out.println("NumTilesHorizontal: " + splitter.getNumTilesHorizontal());
		//System.out.println("NumTilsVertical : " + splitter.getNumTilesVertical());
		/*---------For testing getTile() method----------*/
		
			//testImage = splitter.getTile(1, 3);
			//description = "getTile() method test";
		
		
		/*---------For testing getTileArray() -----------*/
			//allTiles = splitter.getTileArray();
			//testImage = allTiles[1][6];
			//description = "getTileArray() method test";
		
		
		/*---------For testing getTileFromID() ----------*/
			testImage = splitter.getTileFromID(18);
			description = "getTileFromID() test";
		
		
		/*------------Drawing------------*/
		JFrame j = new JFrame(description);
		j.setSize(250, 200);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			

		
		JLabel tile = new JLabel(new ImageIcon(testImage));
		j.getContentPane().add(tile);
		j.setVisible(true);
	}
}

