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
                case "Heal": this.name = name; setID(1); break;
                case "Level Up": this.name = name; setID(76); break;
                case "Take Damage": this.name = name; setID(93); break;
                case "Die": this.name = name; setID(71); break;                
            }
	}
	
	/*--------------------- USAGE ---------------------*/
	public void affect(Entity entity){
            System.out.println("areaaffect!!!");
            switch(name){
                case "Heal": entity.getStats().modhpCurrent(1); break;
                case "Level Up": entity.getStats().modLevel(1); break;
                case "Take Damage": entity.getStats().modhpCurrent(-3); break;
                case "Die": entity.getStats().modhpCurrent(-1000); break;
            }
		if(entity.getStats().gethpCurrent() <= 0) entity.die();
	}	
	
}
