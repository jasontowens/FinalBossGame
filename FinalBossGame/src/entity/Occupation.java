
package entity;

/**
 *
 * @author Jason Owens
 */
public class Occupation {
    
	/*
	 * If an access modifier is added to the attributes below (i.e. name becomes private), 
	 * see my note in Entity's toXML() method.
	 * 
	 * You'll need to add a getter for name for everything to still work. 
	 *
	 * -Hanif
	 */
	
	 String name;
     String description;
    
    //string name needs to be one of the three types
    public Occupation(String name, String description){
        this.name = name;
        this.description = description;
        
        if(name.equals("Smasher")){
            //stuff that Smashers do
        }
        else if(name.equals("Sneak")){
            //stuff that Sneaks do
        }
        else if(name.equals("Summoner")){
            //stuff that Summoners do
        }
        else{
            throw new IllegalArgumentException("Occupation name doesn't match any of the current types.");
        }
    }


    
}
