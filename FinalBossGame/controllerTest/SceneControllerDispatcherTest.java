package controllerTest;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.GameController;
import controllers.LoadMenuController;
import controllers.MenuController;
import controllers.PauseMenuController;
import controllers.SceneController;
import controllers.SceneControllerDispatcher;
import coordinators.CoordinatorScheduler;
import coordinators.CoordinatorType;

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
	
	@Test
	public void testNotifyObserverChangingToGame() {
		CoordinatorScheduler scheduler = controllerDispatcher.getCoordinatorScheduler();
		scheduler.changeCoordinator(CoordinatorType.GAME);
		assertEquals(GameController.getInstance(), controllerDispatcher.getActiveController());
	}

	@Test
	public void testNotifyObserverChangingToLoad() {
		CoordinatorScheduler scheduler = controllerDispatcher.getCoordinatorScheduler();
		scheduler.changeCoordinator(CoordinatorType.LOAD);
		assertEquals(LoadMenuController.getInstance(), controllerDispatcher.getActiveController());
	}
	
	@Test
	public void testNotifyObserverChangingToPause() {
		CoordinatorScheduler scheduler = controllerDispatcher.getCoordinatorScheduler();
		scheduler.changeCoordinator(CoordinatorType.PAUSE);
		assertEquals(PauseMenuController.getInstance(), controllerDispatcher.getActiveController());
	}
	
	@Test
	public void testNotifyObserverChangingToMainMenu() {
		CoordinatorScheduler scheduler = controllerDispatcher.getCoordinatorScheduler();
		scheduler.changeCoordinator(CoordinatorType.MAIN_MENU);
		assertEquals(MenuController.getInstance(), controllerDispatcher.getActiveController());
	}
}
