//ItemStats last edited by Matthew Kroeze on 2015-12-02

package model;

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
	super(livesLeft, strength, agility, intellect, hardiness, experience, movement, hpCurrent, mpCurrent,defense,offense);
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
		durability = nextDur;
	}
	public void setValue(int nextVal){
		value = nextVal;
	}
	//Modifiers
	public void modDurability(int durAdded){
		durability += durAdded;
	}
	public void modValue(int valAdded){
		value += valAdded;
	}
}
