package controllers;

import coordinators.MainMenuCoordinator;

public class MenuController extends SceneController {
	
	private static MenuController menuController = null;
	
	private static MainMenuCoordinator mainMenuReceiver = MainMenuCoordinator.getInstance();
	
	private MenuController() {	}
	
	
	
	
	/*--------------------- MAIN COMMANDS ---------------------*/
	
	public void useKey2() {
		mainMenuReceiver.previousSelection();
	}
	public void useKey8() {
		mainMenuReceiver.nextSelection();
	}
	public void useKeyEnter() {
		mainMenuReceiver.confirmSelection();
	}
	public void useKeyEscape() {
		//Exit Game
	}
	
	
	
	
	
	/*--------------------- SINGLETON METHODS ---------------------*/
	public static MenuController getInstance() {
		if(menuController == null) {
			menuController = new MenuController();
		}
		return menuController;
	}
	
	/*---------------------TEST METHODS ----------------*/
	public void setCoordinator(MainMenuCoordinator menu) {
		mainMenuReceiver = menu;
	}
}
