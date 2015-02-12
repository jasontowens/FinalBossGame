package controllers;

public class PauseMenuController extends SceneController {

	private static PauseMenuController pauseMenuController = null;
	
	public void useKey2() {}
	public void useKey8() {}
	public void useKeyEnter() {}
	public void useKeyEscape() {}
	
	public static PauseMenuController getInstance() {
		if(pauseMenuController == null) {
			pauseMenuController = new PauseMenuController();
		}
		return pauseMenuController;
	}

}
