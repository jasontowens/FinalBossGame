package controllers;

public class MenuController extends SceneController {
	
	private static MenuController menuController = null;
	
	private MenuController() {	}
	
	public void useKey2() {}
	public void useKey8() {}
	public void useKeyEnter() {}
	public void useKeyEscape() {}
	
	public static MenuController getInstance() {
		if(menuController == null) {
			menuController = new MenuController();
		}
		return menuController;
	}
}
