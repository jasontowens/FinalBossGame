package menuTest;

import static org.junit.Assert.*;
import menu.Menu;
import menu.Menu.MenuOption;

import org.junit.Before;
import org.junit.Test;

public class MenuTest {

	private Menu mainMenu;
	private Menu loadMenu;
	private Menu pauseMenu;
	@Before
	public void setUp() throws Exception {
		 MenuOption[] mainMenuOptions = {MenuOption.NEW_GAME, MenuOption.SWITCH_TO_LOAD_MENU, MenuOption.EXIT};
	     mainMenu = new Menu(mainMenuOptions);
	     MenuOption[] loadMenuOptions = {MenuOption.OPEN_SAVE_FILE, MenuOption.RETURN_TO_MAIN_MENU};
	     loadMenu = new Menu(loadMenuOptions);
	     //Create Pause Menu
	     MenuOption[] pauseMenuOptions = {MenuOption.RESUME_GAME, MenuOption.RETURN_TO_MAIN_MENU, MenuOption.SWITCH_TO_LOAD_MENU, MenuOption.SAVE_FILE,MenuOption.EXIT};
	     pauseMenu = new Menu(pauseMenuOptions);
	}

	@Test
	public void testMainMenuOptionsNext() {
		assertEquals(MenuOption.NEW_GAME, mainMenu.getCurrentSelection());
		mainMenu.next();
		assertEquals(MenuOption.SWITCH_TO_LOAD_MENU, mainMenu.getCurrentSelection());
		mainMenu.next();
		assertEquals(MenuOption.EXIT, mainMenu.getCurrentSelection());
		mainMenu.next();
		assertEquals(MenuOption.NEW_GAME, mainMenu.getCurrentSelection());
	}
	
	@Test
	public void testMainMenuOptionsPrevious() {
		assertEquals(MenuOption.NEW_GAME, mainMenu.getCurrentSelection());
		mainMenu.prev();
		assertEquals(MenuOption.EXIT, mainMenu.getCurrentSelection());
		mainMenu.prev();
		assertEquals(MenuOption.SWITCH_TO_LOAD_MENU, mainMenu.getCurrentSelection());
		mainMenu.prev();
		assertEquals(MenuOption.NEW_GAME, mainMenu.getCurrentSelection());
	}
	
	@Test
	public void testLoadMenuOptionsNext() {
		assertEquals(MenuOption.OPEN_SAVE_FILE, loadMenu.getCurrentSelection());
		loadMenu.next();
		assertEquals(MenuOption.RETURN_TO_MAIN_MENU, loadMenu.getCurrentSelection());
		loadMenu.next();
		assertEquals(MenuOption.OPEN_SAVE_FILE, loadMenu.getCurrentSelection());
	}
	
	@Test
	public void testLoadMenuOptionsPrevious() {
		assertEquals(MenuOption.OPEN_SAVE_FILE, loadMenu.getCurrentSelection());
		loadMenu.prev();
		assertEquals(MenuOption.RETURN_TO_MAIN_MENU, loadMenu.getCurrentSelection());
		loadMenu.prev();
		assertEquals(MenuOption.OPEN_SAVE_FILE, loadMenu.getCurrentSelection());
	}
	
	@Test
	public void testPauseMenuOptionsNext() {
		assertEquals(MenuOption.RESUME_GAME, pauseMenu.getCurrentSelection());
		pauseMenu.next();
		assertEquals(MenuOption.RETURN_TO_MAIN_MENU, pauseMenu.getCurrentSelection());
		pauseMenu.next();
		assertEquals(MenuOption.SWITCH_TO_LOAD_MENU, pauseMenu.getCurrentSelection());
		pauseMenu.next();
		assertEquals(MenuOption.SAVE_FILE, pauseMenu.getCurrentSelection());
		pauseMenu.next();
		assertEquals(MenuOption.EXIT, pauseMenu.getCurrentSelection());
		pauseMenu.next();
		assertEquals(MenuOption.RESUME_GAME, pauseMenu.getCurrentSelection());
	}
	
	@Test
	public void testPauseMenuOptionsPrevious() {
		assertEquals(MenuOption.RESUME_GAME, pauseMenu.getCurrentSelection());
		pauseMenu.prev();
		assertEquals(MenuOption.EXIT, pauseMenu.getCurrentSelection());
		pauseMenu.prev();
		assertEquals(MenuOption.SAVE_FILE, pauseMenu.getCurrentSelection());
		pauseMenu.prev();
		assertEquals(MenuOption.SWITCH_TO_LOAD_MENU, pauseMenu.getCurrentSelection());
		pauseMenu.prev();
		assertEquals(MenuOption.RETURN_TO_MAIN_MENU, pauseMenu.getCurrentSelection());
		pauseMenu.prev();
		assertEquals(MenuOption.RESUME_GAME, pauseMenu.getCurrentSelection());
	}
	
	

}
