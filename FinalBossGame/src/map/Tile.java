package map;

import java.util.ArrayList;

import entity.Entity;


public class Tile {
	
	private Terrain terrain;
	private AreaEffect effect;
	
	public Tile(){
		terrain = null;
		effect = null;
	}
        
    public Terrain getTerrain(){
            return terrain;        
    }

    public AreaEffect getAreaEffect(){
    	return effect;
    }
    
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public void setAreaEffect(AreaEffect effect){
		this.effect = effect;
	}
	
}



















