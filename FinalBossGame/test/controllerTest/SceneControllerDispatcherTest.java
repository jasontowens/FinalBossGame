package controllerTest;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.MenuController;
import controllers.PauseMenuController;
import controllers.SceneController;
import controllers.SceneControllerDispatcher;

public class SceneControllerDispatcherTest {

	private SceneControllerDispatcher controllerDispatcher = new SceneControllerDispatcher();
	private final int numberOfControllers = 4;
	
	@Test
	public void testTotalNumberOfControllers() {
		assertEquals(numberOfControllers, controllerDispatcher.getSceneControllers().size());
	}
	
	@Test
	public void testStartingActiveController() {
		assertEquals(MenuController.getInstance(), controllerDispatcher.getSceneControllers().get(0));
	}
	
	@Test
	public void testSetActiveController() {
		//Currently this is PauseMenu
		SceneController sceneController = controllerDispatcher.getSceneControllers().get(2);
		controllerDispatcher.setActiveController(sceneController);
		assertEquals(PauseMenuController.getInstance(), controllerDispatcher.getActiveController());
	}

}
