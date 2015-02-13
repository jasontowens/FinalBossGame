package controllers;

import coordinators.PauseMenuCoordinator;

public class PauseMenuController extends SceneController {

	private static PauseMenuController pauseMenuController = null;
	
	private static PauseMenuCoordinator pauseReceiver = PauseMenuCoordinator.getInstance();
	
	public void useKey2() {
		pauseReceiver.nextSelection();
	}
	public void useKey8() {
		pauseReceiver.previousSelection();
	}
	public void useKeyEnter() {
		pauseReceiver.confirmSelection();
	}
	public void useKeyEscape() {
		pauseReceiver.unPause();
	}
	
	public static PauseMenuController getInstance() {
		if(pauseMenuController == null) {
			pauseMenuController = new PauseMenuController();
		}
		return pauseMenuController;
	}

}
