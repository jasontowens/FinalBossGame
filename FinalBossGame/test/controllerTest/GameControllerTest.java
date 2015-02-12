package controllerTest;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.GameController;
import controllers.MenuController;

public class GameControllerTest {

	@Test
	public void testMultipleCallsYieldsSameController() {
		assertEquals(GameController.getInstance(), GameController.getInstance());
	}
	
	@Test
	public void testSingletonDoesNotReferToDifferentSceneController() {
		assertNotEquals(GameController.getInstance(), MenuController.getInstance());
	}

}
