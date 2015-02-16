//Stats last modified by Matthew Kroeze on 2015-12-02

package stats;

import util.Saveable;

public class Stats implements Saveable{
	
    protected int level; //only for levelUp 
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
	
	public Stats(int levels,
                 int livesLeft,
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
        this.level = levels;
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
	public int getLevels() {
		return this.level;
	}
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
    public void setLevelUps(int levels){ //this should only be used for level up AEs or other (possibly item) effects
		level = verifyBounds(levels) ? levels : level;
	}
	public void setLivesLeft(int nextLives){
		livesLeft = verifyBounds(nextLives) ? nextLives : livesLeft;
	}
	public void setStrength(int nextStr){
		strength = verifyBounds(nextStr) ? nextStr : strength;
	}
	public void setAgility(int nextAgi){
		agility = verifyBounds(nextAgi) ? nextAgi : agility;
	}
	public void setIntellect(int nextInt){
		intellect = verifyBounds(nextInt) ? nextInt : intellect;
	}
	public void setHardiness(int nextHard){
		hardiness = verifyBounds(nextHard) ? nextHard : hardiness;
	}
	public void setExperience(int nextExp){
		experience = verifyBounds(nextExp) ? nextExp : experience;
	}
	public void setMovement(int nextMove){
		movement = verifyBounds(nextMove) ? nextMove : movement;
	}
	public void sethpCurrent(int nextHP){
		hpCurrent = verifyBounds(nextHP) ? nextHP : hpCurrent;
	}
	public void setmpCurrent(int nextMP){
		mpCurrent = verifyBounds(nextMP) ? nextMP : mpCurrent;
	}
	public void setDefense(int nextDef){
		defense = verifyBounds(nextDef) ? nextDef : defense;
	}
	public void setOffense(int nextOff){
		offense = verifyBounds(nextOff) ? nextOff : offense;
	}
	//Modifiers
	public void modLivesLeft(int livesAdded){
		livesLeft = verifyBounds(livesLeft+livesAdded) ? (livesLeft + livesAdded) : 0;
	}
	public void modStrength(int strAdded){
		strength = verifyBounds(strength+strAdded) ? (strength+strAdded) : 0;
	}
	public void modAgility(int agiAdded){
		agility = verifyBounds(agility + agiAdded) ? (agility + agiAdded) : 0;
	}
	public void modIntellect(int intAdded){
		intellect = verifyBounds(intellect + intAdded) ? (intellect+intAdded) : 0;
	}
	public void modHardiness(int hardAdded){
		hardiness = verifyBounds(hardiness + hardAdded) ? (hardiness + hardAdded) : 0;
	}
	public void modExperience(int expAdded){
		experience = verifyBounds(experience + expAdded) ? (experience + expAdded) : 0;
	}
	public void modMovement(int moveAdded){
		movement = verifyBounds(movement + moveAdded) ? (movement + moveAdded) : 0;
	}
	public void modhpCurrent(int hpAdded){
		hpCurrent = verifyBounds(hpCurrent + hpAdded) ? (hpCurrent + hpAdded) : 0;
	}
	public void modmpCurrent(int mpAdded){
		mpCurrent = verifyBounds(mpCurrent + mpAdded) ? (mpCurrent + mpAdded) : 0;
	}
	public void modOffense(int offAdded){
		offense = verifyBounds(offense + offAdded) ? (offense + offAdded) : 0;
	}
	public void modDefense(int defAdded){
		defense = verifyBounds(defense + defAdded) ? (defense + defAdded) : 0;
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
		return new Stats(level*-1,livesLeft*-1,strength*-1,agility*-1,intellect*-1,hardiness*-1,experience*-1,movement*-1,hpCurrent*-1,mpCurrent*-1,offense*-1,defense*-1);
	}
	
	protected boolean verifyBounds(int value) {
		return (value < 0) ? false : true;
	}
	
	public String toXML(){
		//all Stat data stored as tag attributes for now, might be better to make
		//them separate child tags
		
		String str = "";
		str += "<stat livesLeft=\"" + livesLeft + "\"" 
				+ " strength=\"" + strength + "\""
				+ " agility=\"" + agility + "\""
				+ " intellect=\"" + intellect + "\""
				+ " hardiness=\"" + hardiness + "\""
				+ " experience=\"" + experience + "\""
				+ " movement=\"" + movement + "\""
				+ " hpCurrent=\"" + hpCurrent + "\""
				+ " mpCurrent=\"" + mpCurrent + "\""
				+ " defense=\"" + defense + "\""
				+ " offense=\"" + offense + "\""
				;
		str += " />";
		return str;
	}
}




















