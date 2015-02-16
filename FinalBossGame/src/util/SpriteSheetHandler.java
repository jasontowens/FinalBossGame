package util;

import gameobject.GameObject;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheetHandler {
	private BufferedImage SpriteSheet;
	private BufferedImage[][] Sprites;
	private static SpriteSheetHandler spriteSheetHandler = null;
	
	SpriteSheetHandler()
	{
		SpriteSheet = null;
		Sprites = null;
	}
	
	public void SetupSheet(String path, int width, int height, int rows, int cols){
        try {
			SpriteSheet = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
        
        Sprites = new BufferedImage[cols][rows];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                Sprites[j][i] = SpriteSheet.getSubimage(
                    j * width,
                    i * height,
                    width,
                    height
                );
            }
        }
	}
	
	public BufferedImage getSprite(int id)
	{
    	if(Sprites == null) return null;
    	int x = (id - 1) / 11;
    	int y = (id - 1) % 11;
    	
    	return Sprites[y][x];
	}
	
	public static SpriteSheetHandler getInstance()
	{
		if(spriteSheetHandler == null)
		{
			spriteSheetHandler = new SpriteSheetHandler();
			return spriteSheetHandler;
		}
		
		return spriteSheetHandler;
	}
}
