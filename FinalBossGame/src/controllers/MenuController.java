package controllers;

import coordinators.MainMenuCoordinator;

public class MenuController extends SceneController {
	
	private static MenuController menuController = null;
	
	private static MainMenuCoordinator mainMenuReciever = MainMenuCoordinator.getInstance();
	
	private MenuController() {	}
	
	
	
	
	/*--------------------- MAIN COMMANDS ---------------------*/
	
	public void useKey2() {
		mainMenuReciever.previousSelection();
	}
	public void useKey8() {
		mainMenuReciever.nextSelection();
	}
	public void useKeyEnter() {}
	public void useKeyEscape() {}
	
	
	
	
	
	/*--------------------- SINGLETON METHODS ---------------------*/
	public static MenuController getInstance() {
		if(menuController == null) {
			menuController = new MenuController();
		}
		return menuController;
	}
}
