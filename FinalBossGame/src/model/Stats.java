package model;

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
	
	public Stats(int livesLeft,
		  		 int strength,
		  		 int agility,
		  		 int intellect,
		  		 int hardiness,
		  		 int experience,
		  		 int movement,
		  		 int hpCurrent,
		  		 int mpCurrent){
		this.livesLeft =livesLeft;
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.hardiness = hardiness;
		this.experience = experience;
		this.movement = movement;
		this.hpCurrent = hpCurrent;
		this.mpCurrent = mpCurrent;
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
	}
	
	
}
