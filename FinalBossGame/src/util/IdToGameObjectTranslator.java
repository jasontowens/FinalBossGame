package util;



/*
 * Note: This is a temporary solution for Iteration1.  Once we 
 * get the FinalBossMapEditor working at full speed, this class should probably 
 * be deprecated, and a new way that doesn't involve hard-coding tile
 * meta data should be used.  
 * 
 * The only possible advantage of this method is efficiency. 
 * 
 * Class responsibilities: Given an Id, this knows the corresponding TileObject.
 * It returns the appropriate Tile.
 * 
 * Since the enums in this class are the 
 *
 * 
 * @author: Hanif
 */
import main.RunGame;
import map.Tile;

public class IdToGameObjectTranslator {
	
	//this REQUIRES that RunGame has been initialized BEFORE this class
	private static int SIZE = 31 * 22;
	
	private static IdToGameObjectTranslator thisTranslator = null;
	
	//might not be needed
	private enum Item{
		ITEM1, ITEM2,ITEM3, ITEM4;
	}
	
	/*
	 * Watch for off-by-1 errors!
	 */
	private static util.Terrain[] terrain = new util.Terrain[SIZE];
	private static util.AreaEffect[] areaEffects = new util.AreaEffect[SIZE];
	
	
	private IdToGameObjectTranslator(){
		
		//set everything to default values
		for(int i = 0; i < SIZE; ++i){
			terrain[i] = Terrain.DEFAULT;
			areaEffects[i] = AreaEffect.DEFAULT;	
		}		
		
		/*
		 * Hard coding this shit...refactor in It2.
		 */
		
		System.out.println(SIZE);
		
		terrain[11] = util.Terrain.GRASS;
		terrain[12] = util.Terrain.GRASS;
		terrain[21] = util.Terrain.GRASS;
		terrain[31] = util.Terrain.GRASS;
		terrain[32] = util.Terrain.GRASS;
		terrain[41] = util.Terrain.GRASS;
		terrain[42] = util.Terrain.GRASS;
		terrain[43] = util.Terrain.GRASS;
		terrain[44] = util.Terrain.GRASS;
		terrain[47] = util.Terrain.GRASS;
		terrain[48] = util.Terrain.GRASS;
		terrain[49] = util.Terrain.GRASS;
		terrain[57] = util.Terrain.GRASS;
		terrain[58] = util.Terrain.GRASS;
		terrain[59] = util.Terrain.GRASS;
		terrain[60] = util.Terrain.GRASS;
		terrain[76] = util.Terrain.GRASS;
		terrain[77] = util.Terrain.GRASS;
		terrain[66] = util.Terrain.WATER;
		terrain[61] = util.Terrain.MOUNTAIN;
		terrain[60] = util.Terrain.MOUNTAIN;
		terrain[61] = util.Terrain.MOUNTAIN;
		terrain[62] = util.Terrain.MOUNTAIN;
		terrain[63] = util.Terrain.MOUNTAIN;
		terrain[64] = util.Terrain.WATER;
		terrain[65] = util.Terrain.WATER;
		terrain[71] = util.Terrain.MOUNTAIN;
		terrain[72] = util.Terrain.MOUNTAIN;
		terrain[73] = util.Terrain.MOUNTAIN;
		terrain[72] = util.Terrain.WATER;
		terrain[73] = util.Terrain.WATER;
		
		
		
	}
	
	public static IdToGameObjectTranslator getInstance(){
		if(thisTranslator == null){
			thisTranslator = new IdToGameObjectTranslator();
		}
		
		return thisTranslator;
	}
	
	public Tile getTileFromId(int id){
		if(id <= 0 || id > SIZE){
			System.out.println("Bad ID given to Translator");
		}
		
		//to avoid off-by-one errors
		--id;
		Tile tile = new Tile();
		util.Terrain tileTerrain = terrain[id];
		util.AreaEffect tileEffect = areaEffects[id];
		
		
		if(tileTerrain == util.Terrain.GRASS)
			tile.setTerrain(new map.Terrain(entity.MotionType.GROUND));
		
		else if(tileTerrain == util.Terrain.MOUNTAIN)
			tile.setTerrain(new map.Terrain(entity.MotionType.UNATTAINABLE));
		
		else if(tileTerrain == util.Terrain.WATER)
			tile.setTerrain(new map.Terrain(entity.MotionType.WATER));
		
		
		if(tileEffect == util.AreaEffect.HEAL)
			tile.setAreaEffect(new map.AreaEffect("Heal"));
			
		if(tileEffect == util.AreaEffect.INSTANTDEATH)
			tile.setAreaEffect(new map.AreaEffect("Instant Death"));
		
		if(tileEffect == util.AreaEffect.LEVELUP)
			tile.setAreaEffect(new map.AreaEffect("Level Up"));
		
		if(tileEffect == util.AreaEffect.TAKEDAMAGE)
			tile.setAreaEffect(new map.AreaEffect("Take Damage"));
		
		
		
		return tile;
	}
	
}










