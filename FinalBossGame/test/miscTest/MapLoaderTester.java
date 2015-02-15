package miscTest;
import java.io.InputStream;

import util.MapLoader;
public class MapLoaderTester {
	public static void main(String [] args){
		InputStream in = MapLoaderTester.class.getResourceAsStream("/resources/levels/level 1.xml");
		
		MapLoader testMapLoader = MapLoader.getIntance(in);
		
		int [][] idTable = testMapLoader.getIdTable();
		
		for(int i = 0; i < testMapLoader.getMapHeight(); ++i){
			for(int j = 0; j < testMapLoader.getMapWidth(); ++j){
				System.out.print(idTable[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
}
