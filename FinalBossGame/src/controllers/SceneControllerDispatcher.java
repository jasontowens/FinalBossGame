package controllers;

import java.util.ArrayList;
import java.util.List;

import util.Observer;

public class SceneControllerDispatcher implements Observer {
	
	private List<SceneController> sceneControllers;
	private SceneController activeController;
	
	public SceneControllerDispatcher() {
		sceneControllers = new ArrayList<SceneController>();
		sceneControllers.add(MenuController.getInstance());
		sceneControllers.add(GameController.getInstance());
		sceneControllers.add(PauseMenuController.getInstance());
		sceneControllers.add(LoadMenuController.getInstance());
		activeController = MenuController.getInstance();
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

	@Override
	public void Notify() {
		// TODO Auto-generated method stub
		
	}
	
	

}
