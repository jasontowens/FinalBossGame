package controllerTest;

import static org.easymock.EasyMock.createNiceMock;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllers.LoadMenuController;
import controllers.MenuController;
import coordinators.LoadMenuCoordinator;
import coordinators.MainMenuCoordinator;

public class LoadMenuControllerTest {
	
	private LoadMenuCoordinator loadMenuCoordinator;
	private LoadMenuController menuController;

	@Before
	public void init() throws InterruptedException {
		//mainMenuCoordinator = createNiceMock(MainMenuCoordinator.class);
		//menuController = MenuController.getInstance();
	}

	@Test
	public void testMultipleCallsYieldsSameController() {
		assertEquals(LoadMenuController.getInstance(), LoadMenuController.getInstance());
	}
	
	@Test
	public void testSingletonDoesNotReferToDifferentSceneController() {
		assertNotSame(LoadMenuController.getInstance(), MenuController.getInstance());
	}
	
	

}
