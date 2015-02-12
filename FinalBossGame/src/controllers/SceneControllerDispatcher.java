package controllers;

import java.util.ArrayList;
import java.util.List;

import coordinators.CoordinatorScheduler;
import util.Observer;

public class SceneControllerDispatcher implements Observer {
	
	private List<SceneController> sceneControllers;
	private SceneController activeController;
	private CoordinatorScheduler coordinatorScheduler;
	private static final int menuControllerLocation = 0;
	private static final int gameControllerLocation = 1;
	private static final int pauseMenuControllerLocation = 2;
	private static final int loadMenuControllerLocation = 3;
	
	public SceneControllerDispatcher() {
		sceneControllers = new ArrayList<SceneController>();
		sceneControllers.add(MenuController.getInstance());
		sceneControllers.add(GameController.getInstance());
		sceneControllers.add(PauseMenuController.getInstance());
		sceneControllers.add(LoadMenuController.getInstance());
		activeController = MenuController.getInstance();
		coordinatorScheduler = CoordinatorScheduler.getInstance();
		coordinatorScheduler.registerObserver(this);
	}

	public List<SceneController> getSceneControllers() {
		return sceneControllers;
	}

	public void setSceneControllers(List<SceneController> sceneControllers) {
		this.sceneControllers = sceneControllers;
	}

	public SceneController getActiveController() {
		return activeController;
	}

	public void setActiveController(SceneController activeController) {
		this.activeController = activeController;
	}
	
	public CoordinatorScheduler getCoordinatorScheduler() {
		return this.coordinatorScheduler;
	}

	@Override
	public void Notify() {
		switch (coordinatorScheduler.getCoordinatorType()) {
			case PAUSE:
				this.activeController = sceneControllers.get(pauseMenuControllerLocation);
				break;
			case GAME:
				this.activeController = sceneControllers.get(gameControllerLocation);
				break;
			case MAIN_MENU:
				this.activeController = sceneControllers.get(menuControllerLocation);
				break;
			case LOAD:
				this.activeController = sceneControllers.get(loadMenuControllerLocation);
				break;
			default :
				break;
		}
		
	}
	
	

}
