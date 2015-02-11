package controllers;

import java.util.List;

import util.Observer;

public class SceneControllerDispatcher implements Observer {
	
	private List<SceneController> sceneControllers;
	private SceneController activeController;
	
	public SceneControllerDispatcher() {
		
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
