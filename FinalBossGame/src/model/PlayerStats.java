//PlayerStats last modified by Matthew Kroeze on 2015-12-02

package model;

public class PlayerStats extends Stats {
	private int level;
	private int hpMax;
	private int mpMax;
	private int defensiveRating;
	private int offensiveRating;
	private int armorRating;
	final static private int expPerLevel = 1000;
	
	//Updaters
	private void updateLevel(){
		level = experience / expPerLevel;
	}
	private void updatehpMax(){
		hpMax = hardiness * 10 + level * 100;
	}
	private void updatempMax(){
		mpMax = intellect * 10 + level * 100;
	}
	private void updateDefensiveRating(){
		defensiveRating = agility * 10 + level * 100;
	}
	private void updateOffensiveRating(){
		offensiveRating = strength * 10 + level * 100 + offense * 10;
	}
	private void updateArmorRating(){
		armorRating = hardiness * 10 + defense * 100;
	}
	private void updateStats(){
		updateLevel();
		updatehpMax();
		updatempMax();
		updateDefensiveRating();
		updateOffensiveRating();
		updateArmorRating();
	}
	
	//Constructor
	public PlayerStats(int livesLeft,
					   int strength,
					   int agility,
					   int intellect,
					   int hardiness,
					   int experience,
					   int movement,
					   int hpCurrent,
					   int mpCurrent,
					   int defense,
					   int offense){
		super(livesLeft, strength, agility, intellect, hardiness, experience, movement, hpCurrent, mpCurrent, defense, offense);
		updateStats();
	}
	
	//Accessors
	public int getLevel(){
		return level;
	}
	public int gethpMax(){
		return hpMax;
	}
	public int getmpMax(){
		return mpMax;
	}
	public int getDefensiveRating(){
		return defensiveRating;
	}
	public int getOffensiveRating(){
		return offensiveRating;
	}
	public int getArmorRating(){
		return armorRating;
	}
	
	//Usage
	public void levelUp(){
		modExperience(expPerLevel - (experience % expPerLevel));
	}
}
