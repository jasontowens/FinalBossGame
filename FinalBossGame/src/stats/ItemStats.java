//ItemStats last edited by Matthew Kroeze on 2015-12-02

package stats;

import stats.Stats;

public class ItemStats extends Stats {
	private int durability;
	private int value;
	
	//Constructors
	public ItemStats(int livesLeft,
	  		 int strength,
	  		 int agility,
	  		 int intellect,
	  		 int hardiness,
	  		 int experience,
	  		 int movement,
	  		 int hpCurrent,
	  		 int mpCurrent,
	  		 int durability,
	  		 int value,
	  		 int defense,
	  		 int offense){
		//TODO currently implementing so that Items can't give levels
	super(0,livesLeft, strength, agility, intellect, hardiness, experience, movement, hpCurrent, mpCurrent,defense,offense);
	this.durability = durability;
	this.value = value;
	}
	
	//Accessors
	public int getDurability(){
		return durability;
	}
	public int getValue(){
		return value;
	}
	//Setters
	public void setDurability(int nextDur){
		durability = verifyBounds(nextDur) ? nextDur : durability;
	}
	public void setValue(int nextVal){
		value = verifyBounds(nextVal) ? nextVal : value;
	}
	//Modifiers
	public void modDurability(int durAdded){
		durability = verifyBounds(durAdded + durability) ? (durAdded + durability) : 0;
	}
	public void modValue(int valAdded){
		value = verifyBounds(value + valAdded) ? (value + valAdded) : 0;
	}
	
	//TODO: override toXML() to  durability.
	
}
