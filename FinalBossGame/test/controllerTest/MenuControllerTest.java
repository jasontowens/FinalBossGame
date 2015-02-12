package controllerTest;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.LoadMenuController;
import controllers.MenuController;

public class MenuControllerTest {

	@Test
	public void testMultipleCallsYieldsSameController() {
		assertEquals(MenuController.getInstance(), MenuController.getInstance());
	}
	
	@Test
	public void testSingletonDoesNotReferToDifferentSceneController() {
		assertNotEquals(MenuController.getInstance(), LoadMenuController.getInstance());
	}

}
