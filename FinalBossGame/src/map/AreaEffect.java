package map;

import entity.Entity;
import stats.Stats;
import gameobject.GameObject;

public class AreaEffect extends GameObject {
	
	/*--------------------- DATA MEMBERS ---------------------*/
	private Stats modifiers;
	private String name ; // corresponds to Type (should be deprecated in It2)
	/*--------------------- CONSTRUCTORS ---------------------*/
	public AreaEffect(String name, int ID, Stats mods){
            super(name, name, ID); //TODO: change ID to how Hanif wants it set up 
            this.modifiers = mods;
	}
        
        
        
	
	public AreaEffect(String name){
            Stats s = new Stats(0,0,0,0,0,0,0,0,0,0,0,0);
            switch(name){
                case "Heal": s.modhpCurrent(100);
                case "Level Up": s.setLevelUps(1);
                case "Take Dameage": s.modhpCurrent(-10);
                case "Instant Death": s.modhpCurrent(-1000);                                
            }
	}
	
	/*--------------------- USAGE ---------------------*/
	public void affect(Entity entity){
		entity.mergeStats(modifiers);
	}	
	
}
