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
	private static final int inventoryControllerLocation = 2;
	
	public SceneControllerDispatcher() {
		sceneControllers = new ArrayList<SceneController>();
		sceneControllers.add(MenuController.getInstance());
		sceneControllers.add(GameController.getInstance());
		sceneControllers.add(InventoryController.getInstance());
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
			case GAME:
				this.activeController = sceneControllers.get(gameControllerLocation);
				break;
			case INVENTORY:
				this.activeController = sceneControllers.get(inventoryControllerLocation);
				break;
			case MENU:
				this.activeController = sceneControllers.get(menuControllerLocation);
				break;
			default :
				break;
		}
		
	}
	
	

}
