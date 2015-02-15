/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;
import item.*;
import entity.*



/**
 *
 * @author Owner
 */
public class ItemTest{
	Obstacle obstacleSubject;
	Equipable equipableSubject;
	Takeable takeableSubject;
	MobilityEquipable mobilitySubject;
	ObstacleClearer clearerSubject;
	OccupationSetter occupationSubject;
	Entity dummy;
	Stats mods;
	
	@Before
	public void init(){
		dummy = new Entity("dummy", "a test dummy", GROUND)
		obstacleSubject = new Obstacle("test", "a test object");
		equipableSubject = new Equipable("test", "a test object");
		takeableSubject = new Takeable("test", "a test object");
		mobilitySubject = new MobilityEquipable("test," "a test object");
		clearerSubject = new ObstacleClearer("test", "a test object");
		occupationSubject = new OccupationSetter("test", "a test object");
		dummy = new Entity()
	}
	
	@Test
	public void traversalTest(){
		assertFalse(obstacleSubject.activate(dummy));
		assertTrue(equipableSubject.activate(dummy));
		assertTrue(takeableSubject.activate(dummy));
		assertTrue(mobilitySubject.activate(dummy));
		assertFalse(clearerSubject.activate(dummy));
		assertFalse(occupationSubject.activate(dummy));
	}
}
