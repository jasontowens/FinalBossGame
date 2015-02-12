package model;

/*
 * Helper class for MapLoader.
 * Abstraction for a tile sheet.
 * MapLoader is responsible for constructing this class.
 * 
 * API:
 * +getX() - the number of tiles in the horizontal direction
 * +getY() - the number of tiles in the vertical direction
 * +getTile(int) - given an int, it returns the corresponding tile from the tile sheet
 * 
 */


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TileSheet {
	int sheetWidth;
	int sheetHeight;
	String path;
	int firstId;
	int tileWidth;
	int tileHeight;
	BufferedImage spriteSheet;
	TileSheet(String path ,int sheetWidth,int sheetHeight, int firstId, int tileWidth, 
			int tileHeight){
		this.path = path;
		this.sheetHeight = sheetWidth;
		this.sheetHeight = sheetHeight;
		this.firstId = firstId;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		read();
	}
	
	public double getX(){
		return sheetWidth / tileWidth;
	}
	
	public double getY(){
		return sheetHeight / tileHeight;
	}
	
	
	public BufferedImage getTile(int i){
		int yPos = ((i - 1) / sheetWidth) * tileHeight;
		int xPos = ((i-1) % sheetWidth) * tileWidth;
		
		return spriteSheet.getSubimage(xPos, yPos, tileWidth, tileHeight);
	}

	private void read(){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		spriteSheet = img;
		
	}
	
}