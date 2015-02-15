package controllers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import coordinators.MenuCoordinator;

public class MenuController extends SceneController {
	
	private static MenuController menuController = null;
	
	private static MenuCoordinator menuCoordinator = MenuCoordinator.getInstance();
	
	private MenuController() {	}
	
	
	
	
	/*--------------------- MAIN COMMANDS ---------------------*/
	
	public void useKey2() {
		menuCoordinator.next();
	}
	public void useKey8() {
		menuCoordinator.prev();
	}
	public void useKeyEnter() throws ParserConfigurationException, SAXException, IOException {
		menuCoordinator.confirmSelection();
	}	
	
	/*--------------------- SINGLETON METHODS ---------------------*/
	public static MenuController getInstance() {
		if(menuController == null) {
			menuController = new MenuController();
		}
		return menuController;
	}
	
	/*---------------------TEST METHODS ----------------*/
	public void setCoordinator(MenuCoordinator menu) {
		menuCoordinator = menu;
	}
}
