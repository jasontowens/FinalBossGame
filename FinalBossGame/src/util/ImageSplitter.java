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
 * Fixed indexing bug 2/15/15 - Hanif
 * 
 * @author: Hanif 
 */
public class ImageSplitter {

	private static ImageSplitter splitter = null;
    private BufferedImage img;
    private int sheetHeight;
    private int sheetWidth;
    private int tileWidth;
    private int tileHeight;

    private int numTilesHorizontal; //Number of tiles horizontal
    private int numTilesVertical; //Number of tiles vertical

    BufferedImage[][] tiles;

    private ImageSplitter(BufferedImage i,
            int tWidth, int tHeight) {
        img = i;
        sheetWidth = i.getWidth();
        sheetHeight = i.getHeight();
        tileHeight = tHeight;
        tileWidth = tWidth;

        numTilesHorizontal = sheetWidth / tileWidth;
        numTilesVertical = sheetHeight / tileHeight;

        tiles = makeTiles();

    }

    
    public static ImageSplitter getInstance(BufferedImage i , int tWidth, int tHeight){
    	if(splitter == null){
    		splitter = new ImageSplitter(i , tWidth , tHeight);
    	}
    	
    	return splitter;
    }
    private BufferedImage[][] makeTiles() {
        BufferedImage[][] image = new BufferedImage[numTilesVertical][numTilesHorizontal];
        int xPos = 0;
        int yPos = 0;
    
        for(int i = 0; i < numTilesVertical; ++i){
        	for(int j = 0; j < numTilesHorizontal; ++j){
        		image[i][j] = img.getSubimage(xPos, yPos, tileWidth, tileHeight);
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
     * getTile(0 , 1) is the tile on the 0th row, 1st column, 
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
        return tiles[i][j];
    }

    //The number of tiles horizontal
    public int getNumTilesHorizontal() {
        return numTilesHorizontal;
    }

    //The number of tiles vertically
    public int getNumTilesVertical() {
        return numTilesVertical;
    }

   
    public BufferedImage[][] getTileArray() {
    	return tiles;
    }
    
    
    /*
     * Tested
     */
    public BufferedImage getTileFromID(int id){
    	
    	//TODO: make it throw invalid argument
    	if(id < 1){
    		System.out.println("Invalid argument");
    	}
    	
    	int i = (id - 1) / numTilesHorizontal;
    	int j = (id - 1) % numTilesHorizontal;
    	
    	return getTile(i , j);
    }
}






















