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
            this.modifiers = s;
            switch(name){
                case "Heal": modifiers.sethpCurrent(100); setID(1); break;
                case "Level Up": modifiers.setLevelUps(1); setID(76); break;
                case "Take Damage": modifiers.sethpCurrent(-10); setID(93); break;
                case "Die": modifiers.sethpCurrent(-1000); setID(71); break;
                
            }
	}
	
	/*--------------------- USAGE ---------------------*/
	public void affect(Entity entity){
		System.out.println("areaaffect!!!");
	}	
	
}
