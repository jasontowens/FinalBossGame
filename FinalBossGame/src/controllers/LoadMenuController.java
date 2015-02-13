package controllers;

import coordinators.LoadMenuCoordinator;

public class LoadMenuController extends SceneController {
	
	private static LoadMenuController loadMenuController = null;
	
	private static LoadMenuCoordinator loadReceiver = LoadMenuCoordinator.getInstance();
	
	private LoadMenuController() { }
	
	public void useKey2() {
		loadReceiver.nextSelection();
	}
	public void useKey8() {
		loadReceiver.previousSelection();
	}
	public void useKeyEnter() {
		loadReceiver.confirmSelection();
	}
	public void useKeyEscape() {
		loadReceiver.backToMainMenu();
	}
	
	
	public static LoadMenuController getInstance() {
		if(loadMenuController == null) {
			loadMenuController = new LoadMenuController();
		}
		return loadMenuController;
	}

}
