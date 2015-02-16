package map;

import entity.Entity;
import stats.Stats;
import gameobject.GameObject;

public class AreaEffect extends GameObject {
	
	/*--------------------- DATA MEMBERS ---------------------*/
	private Stats modifiers;
	private String name ; // corresponds to Type (should be deprecated in It2)
	
	/*--------------------- CONSTRUCTORS ---------------------*/
	public AreaEffect(String name, Stats mods){
            super(name, name, name , -1); //TODO: change ID to how Hanif wants it set up 

            this.modifiers = mods;
	}
        
        
        
	
	public AreaEffect(String name){
            Stats s = new Stats(0,0,0,0,0,0,0,0,0,0,0,0);
            switch(name){
                case "Heal": s.modhpCurrent(100); setID(1); break;
                case "Level Up": s.setLevelUps(1); setID(76); break;
                case "Take Dameage": s.modhpCurrent(-10); setID(93); break;
                case "Instant Death": s.modhpCurrent(-1000); break;
                
            }
            
            this.modifiers = s;
	}
	
	/*--------------------- USAGE ---------------------*/
	public void affect(Entity entity){
		System.out.println("areaaffect!!!");
		entity.mergeStats(modifiers);
	}	
	
}
