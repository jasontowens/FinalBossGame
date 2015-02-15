package util;

import java.awt.image.BufferedImage;

/*
 * Takes a BufferedImage (the sprite sheet), the sheet/tile height/width, and returns
 * a 2D array of the individual tiles.
 * 
 * 
 * IMPORTANT: Save yourself a lot of trouble and be sure to see the note above the 
 * getTile() method. 
 * 
 * @author: Hanif 
 */
public class ImageSplitter {

    private BufferedImage img;
    private int sheetHeight;
    private int sheetWidth;
    private int tileWidth;
    private int tileHeight;

    private int x; //Number of tiles horizontal
    private int y; //Number of tiles vertical

    BufferedImage[][] tiles;

    public ImageSplitter(BufferedImage i,
            int tWidth, int tHeight) {
        img = i;
        sheetWidth = i.getWidth();
        sheetHeight = i.getHeight();
        tileHeight = tHeight;
        tileWidth = tWidth;

        x = sheetWidth / tileWidth;
        y = sheetHeight / tileHeight;

        tiles = makeTiles();

    }

    private BufferedImage[][] makeTiles() {
        BufferedImage[][] image = new BufferedImage[x][y];
        int xPos = 0;
        int yPos = 0;
    
        for(int i = 0; i < y; ++i){
        	for(int j = 0; j < x; ++j){
        		image[j][i] = img.getSubimage(xPos, yPos, tileWidth, tileHeight);
        		//System.out.println("i=" + i + " j=" + j + " " + xPos + " , " +  yPos);
        		xPos += tileWidth;
        	}
        	
        	xPos = 0;
            yPos += tileHeight;
        }

        return image;
    }

    public int getSheetHeight() {
        return sheetHeight;
    }

    public int getSheetWidth() {
        return sheetWidth;
    }

    
    /*
     * WARNING: Here be Dragons!
     * 
     * Notice how i and j appear to be flipped? That's because 
     * the natural way to query this method should be the same as how
     * 2D arrays are indexed.  getTile(0 , 1) is the tile on the 0th row, 1st column, 
     * right where the @ symbol is.
     * 
     *  	* @ * * * ....
     *  	* * * * * ....
     *  	* * * * * ....
     *  
     *  On the other hand, getTile(1 , 0) is the following tile: 
     *  	
     *  	* * * * * ....
     *  	@ * * * * ....
     *  	* * * * * ....
     *  
     *  -Hanif
     *
     */
    public BufferedImage getTile(int i, int j) {
        return tiles[j][i];
    }

    //The number of tiles horizontal
    public int getX() {
        return x;
    }

    //The number of tiles vertically
    public int getY() {
        return y;
    }

    public BufferedImage[][] getTileArray() {
        return tiles;
    }

}
