package controllerTest;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.LoadMenuController;
import controllers.MenuController;

public class LoadMenuControllerTest {

	@Test
	public void testMultipleCallsYieldsSameController() {
		assertEquals(LoadMenuController.getInstance(), LoadMenuController.getInstance());
	}
	
	@Test
	public void testSingletonDoesNotReferToDifferentSceneController() {
		assertNotEquals(LoadMenuController.getInstance(), MenuController.getInstance());
	}

}
