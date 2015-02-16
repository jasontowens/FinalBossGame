package statsTest;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import stats.Stats;


public class StatsTest {
	
	private Stats stats;

	@Before
	public void setUp() throws Exception {
		stats = new Stats(1,2,3,4,5,6,7,8,9,10,11,12);
	}

	@Test
	public void testSettingLevel() {
		stats.setLevelUps(12);
		assertEquals(12, stats.getLevels());
	}
	
	@Test
	public void testSettingLevelNegative() {
		stats.setLevelUps(-5);
		assertEquals(1,stats.getLevels());
	}
	
	@Test
	public void testSettingLivesLeft() {
		stats.setLivesLeft(12);
		assertEquals(12, stats.getLivesLeft());
	}
	
	@Test
	public void testSettingLivesLeftNegative() {
		stats.setLivesLeft(-5);
		assertEquals(2,stats.getLivesLeft());
	}
	
	@Test
	public void testSettingStrength() {
		stats.setStrength(12);
		assertEquals(12, stats.getStrength());
	}
	
	@Test
	public void testSettingStrengthNegative() {
		stats.setLivesLeft(-5);
		assertEquals(3,stats.getStrength());
	}
	
	@Test
	public void testSettingAgility() {
		stats.setAgility(12);
		assertEquals(12,stats.getAgility());
	}
	
	@Test
	public void testSettingAgilityNegative() {
		stats.setAgility(-5);
		assertEquals(4,stats.getAgility());
	}
	
	@Test
	public void testSettingIntellect() {
		stats.setIntellect(12);
		assertEquals(12,stats.getIntellect());
	}
	
	@Test
	public void testSettingIntellectNegative() {
		stats.setIntellect(-5);
		assertEquals(5,stats.getIntellect());
	}
	
	@Test
	public void testSettingHardiness() {
		stats.setHardiness(12);
		assertEquals(12,stats.getHardiness());
	}
	
	@Test
	public void testSettingHardinessNegative() {
		stats.setHardiness(-5);
		assertEquals(6,stats.getHardiness());
	}
	
	@Test
	public void testSettingExperience() {
		stats.setExperience(12);
		assertEquals(12,stats.getExperience());
	}
	
	@Test
	public void testSettingExperienceNegative() {
		stats.setExperience(-5);
		assertEquals(7,stats.getExperience());
	}
	
	@Test
	public void testSettingMovement() {
		stats.setMovement(12);
		assertEquals(12,stats.getMovement());
	}
	
	@Test
	public void testSettingMovementNegative() {
		stats.setMovement(-5);
		assertEquals(8,stats.getMovement());
	}
	
	@Test
	public void testSettingMP() {
		stats.setmpCurrent(12);
		assertEquals(12,stats.getmpCurrent());
	}
	
	@Test
	public void testSettingMPNegative() {
		stats.setmpCurrent(-5);
		assertEquals(10,stats.getmpCurrent());
	}
	
	@Test
	public void testSettingDefense() {
		stats.setDefense(12);
		assertEquals(12,stats.getDefense());
	}
	
	@Test
	public void testSettingDefenseNegatie() {
		stats.setDefense(-5);
		assertEquals(11,stats.getDefense());
	}
	
	@Test
	public void testSettingHP() {
		stats.sethpCurrent(12);
		assertEquals(12,stats.gethpCurrent());
	}
	
	@Test
	public void testSettingHPNegative() {
		stats.sethpCurrent(-5);
		assertEquals(9,stats.gethpCurrent());
	}
	
	@Test
	public void testSettingOffense() {
		stats.setOffense(13);
		assertEquals(13,stats.getOffense());
	}
	
	@Test
	public void testSettingOffenseNegative() {
		stats.setOffense(-5);
		assertEquals(12,stats.getOffense());
	}
	
	@Test
	public void testModLivesLeft() {
		stats.modLivesLeft(12);
		assertEquals(14, stats.getLivesLeft());
	}
	
	@Test
	public void testModLivesLeftNegative() {
		stats.modLivesLeft(-50);
		assertEquals(0,stats.getLivesLeft());
	}
	
	@Test
	public void testModStrength() {
		stats.modStrength(12);
		assertEquals(15, stats.getStrength());
	}
	
	@Test
	public void testModStrengthNegative() {
		stats.modStrength(-5);
		assertEquals(0,stats.getStrength());
	}
	
	@Test
	public void testModAgility() {
		stats.modAgility(12);
		assertEquals(16,stats.getAgility());
	}
	
	@Test
	public void testModAgilityNegative() {
		stats.modAgility(-5);
		assertEquals(0,stats.getAgility());
	}
	
	@Test
	public void testModIntellect() {
		stats.modIntellect(12);
		assertEquals(17,stats.getIntellect());
	}
	
	@Test
	public void testModIntellectNegative() {
		stats.modIntellect(-7);
		assertEquals(0,stats.getIntellect());
	}
	
	@Test
	public void testModHardiness() {
		stats.modHardiness(12);
		assertEquals(18,stats.getHardiness());
	}
	
	@Test
	public void testModHardinessNegative() {
		stats.modHardiness(-50);
		assertEquals(0,stats.getHardiness());
	}
	
	@Test
	public void testModExperience() {
		stats.modExperience(12);
		assertEquals(19,stats.getExperience());
	}
	
	@Test
	public void testModExperienceNegative() {
		stats.modExperience(-50);
		assertEquals(0,stats.getExperience());
	}
	
	@Test
	public void testModMovement() {
		stats.modMovement(12);
		assertEquals(20,stats.getMovement());
	}
	
	@Test
	public void testModMovementNegative() {
		stats.modMovement(-50);
		assertEquals(0,stats.getMovement());
	}
	
	@Test
	public void testModMP() {
		stats.modmpCurrent(12);
		assertEquals(22,stats.getmpCurrent());
	}
	
	@Test
	public void testModMPNegative() {
		stats.modmpCurrent(-50);
		assertEquals(0,stats.getmpCurrent());
	}
	
	@Test
	public void testModDefense() {
		stats.modDefense(12);
		assertEquals(23,stats.getDefense());
	}
	
	@Test
	public void testModDefenseNegatie() {
		stats.modDefense(-50);
		assertEquals(0,stats.getDefense());
	}
	
	@Test
	public void testModHP() {
		stats.modhpCurrent(12);
		assertEquals(21,stats.gethpCurrent());
	}
	
	@Test
	public void testModHPNegative() {
		stats.modhpCurrent(-50);
		assertEquals(0,stats.gethpCurrent());
	}
	
	@Test
	public void testModOffense() {
		stats.modOffense(13);
		assertEquals(25,stats.getOffense());
	}
	
	@Test
	public void testModOffenseNegative() {
		stats.modOffense(-50);
		assertEquals(0,stats.getOffense());
	}

}
