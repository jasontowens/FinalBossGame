//Stats last modified by Matthew Kroeze on 2015-12-02

package stats;

public class Stats {
	protected int livesLeft;
	protected int strength;
	protected int agility;
	protected int intellect;
	protected int hardiness;
	protected int experience;
	protected int movement;
	protected int hpCurrent;
	protected int mpCurrent;
	protected int defense;	//used in defensiveRating
	protected int offense;  //used in offensiveRating
	
	public Stats(int livesLeft,
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
		this.livesLeft =livesLeft;
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.hardiness = hardiness;
		this.experience = experience;
		this.movement = movement;
		this.hpCurrent = hpCurrent;
		this.mpCurrent = mpCurrent;
		this.defense = defense;
		this.offense = offense;
	}
	//Accessors
	public int getLivesLeft(){
		return livesLeft;
	}
	public int getStrength(){
		return strength;
	}
	public int getAgility(){
		return agility;
	}
	public int getIntellect(){
		return intellect;
	}
	public int getHardiness(){
		return hardiness;
	}
	public int getExperience(){
		return experience;
	}
	public int getMovement(){
		return movement;
	}
	public int gethpCurrent(){
		return hpCurrent;
	}
	public int getmpCurrent(){
		return mpCurrent;
	}
	public int getOffense(){
		return offense;
	}
	public int getDefense(){
		return defense;
	}
	//Setters
	public void setLivesLeft(int nextLives){
		livesLeft = nextLives;
	}
	public void setStrength(int nextStr){
		strength = nextStr;
	}
	public void setAgility(int nextAgi){
		agility = nextAgi;
	}
	public void setIntellect(int nextInt){
		intellect = nextInt;
	}
	public void setHardiness(int nextHard){
		hardiness = nextHard;
	}
	public void setExperience(int nextExp){
		experience = nextExp;
	}
	public void setMovement(int nextMove){
		movement = nextMove;
	}
	public void sethpCurrent(int nextHP){
		hpCurrent = nextHP;
	}
	public void setmpCurrent(int nextMP){
		mpCurrent = nextMP;
	}
	public void setDefense(int nextDef){
		defense = nextDef;
	}
	public void setOffense(int nextOff){
		offense = nextOff;
	}
	//Modifiers
	public void modLivesLeft(int livesAdded){
		livesLeft += livesAdded;
	}
	public void modStrength(int strAdded){
		strength += strAdded;
	}
	public void modAgility(int agiAdded){
		agility += agiAdded;
	}
	public void modIntellect(int intAdded){
		intellect += intAdded;
	}
	public void modHardiness(int hardAdded){
		hardiness += hardAdded;
	}
	public void modExperience(int expAdded){
		experience += expAdded;
	}
	public void modMovement(int moveAdded){
		movement += moveAdded;
	}
	public void modhpCurrent(int hpAdded){
		hpCurrent += hpAdded;
	}
	public void modmpCurrent(int mpAdded){
		mpCurrent += mpAdded;
	}
	public void modOffense(int offAdded){
		offense += offAdded;
	}
	public void modDefense(int defAdded){
		defense += defAdded;
	}
	//Merge
	public void mergeStats(Stats modifier){
		modLivesLeft(modifier.getLivesLeft());
		modStrength(modifier.getStrength());
		modAgility(modifier.getAgility());
		modIntellect(modifier.getIntellect());
		modHardiness(modifier.getHardiness());
		modExperience(modifier.getExperience());
		modMovement(modifier.getMovement());
		modhpCurrent(modifier.gethpCurrent());
		modmpCurrent(modifier.getmpCurrent());
		modOffense(modifier.getOffense());
		modDefense(modifier.getDefense());
	}
	
	public Stats inverted(){
		return new Stats(livesLeft*-1,strength*-1,agility*-1,intellect*-1,hardiness*-1,experience*-1,movement*-1,hpCurrent*-1,mpCurrent*-1,offense*-1,defense*-1);
	}
	
	
}
