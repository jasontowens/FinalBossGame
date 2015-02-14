/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;
import item.obstacle;



/**
 *
 * @author Owner
 */
public class ObstacleTest{
	Obstacle testSubject;
	
	@Before
	public void init(){
		testSubject = new Obstacle("test", "a test object");
	}
	
	@Test
	public void activationTest(){
		assertFalse(testSubject.activate());
	}
}
