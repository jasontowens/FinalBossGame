package controllers;

public class LoadMenuController extends SceneController {
	
	private static LoadMenuController loadMenuController = null;
	
	private LoadMenuController() { }
	
	public void useKey2() {}
	public void useKey8() {}
	public void useKeyEnter() {}
	public void useKeyEscape() {}
	
	
	public static LoadMenuController getInstance() {
		if(loadMenuController == null) {
			loadMenuController = new LoadMenuController();
		}
		return loadMenuController;
	}

}
