package controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import controllers.LoadMenuController;
import controllers.PauseMenuController;

public class PauseMenuControllerTest {

	@Test
	public void testMultipleCallsYieldsSameController() {
		assertEquals(PauseMenuController.getInstance(), PauseMenuController.getInstance());
	}
	
	@Test
	public void testSingletonDoesNotReferToDifferentSceneController() {
		assertNotEquals(PauseMenuController.getInstance(), LoadMenuController.getInstance());
	}

}
