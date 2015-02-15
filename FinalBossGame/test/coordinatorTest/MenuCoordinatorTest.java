package coordinatorTest;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import menu.Menu;
import menu.Menu.MenuOption;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import coordinators.CoordinatorScheduler;
import coordinators.CoordinatorType;
import coordinators.MenuCoordinator;

public class MenuCoordinatorTest {
	
	private MenuCoordinator mainMenuCoord;
	private CoordinatorScheduler scheduler;
	private Menu mainMenu;
	
	@Before
	public void init() {
		mainMenuCoord = MenuCoordinator.getInstance();
		scheduler = EasyMock.createNiceMock(CoordinatorScheduler.class);
		mainMenu = EasyMock.createNiceMock(Menu.class);
		mainMenuCoord.setScheduler(scheduler);
	}
	
	@Test
	public void testNextSelection() {
		mainMenuCoord.setCurrentMenu(mainMenu);
		
		mainMenu.next();
		EasyMock.expectLastCall();
		
		EasyMock.replay(mainMenu);
		
		mainMenuCoord.next();
	}
	@Test 
	public void testPreviousSelection() {
		mainMenuCoord.setCurrentMenu(mainMenu);
		
		mainMenu.prev();
		EasyMock.expectLastCall();
		
		EasyMock.replay(mainMenu);
		
		mainMenuCoord.prev();
	}
	
	@Test
	public void testConfirmSelectionNewGame() throws ParserConfigurationException, SAXException, IOException {
		scheduler.changeCoordinator(CoordinatorType.GAME);
		EasyMock.expectLastCall();
		EasyMock.replay(scheduler);
		
		EasyMock.expect(mainMenu.getCurrentSelection()).andReturn(MenuOption.NEW_GAME);
		
		EasyMock.replay(mainMenu);
	
		mainMenuCoord.setCurrentMenu(mainMenu);
		mainMenuCoord.confirmSelection();
		
		EasyMock.verify(scheduler);
		EasyMock.verify(mainMenu);
	}
	
	@Test
	public void testConfirmSelectionLoadMenu() throws ParserConfigurationException, SAXException, IOException {		
		EasyMock.expect(mainMenu.getCurrentSelection()).andReturn(MenuOption.SWITCH_TO_LOAD_MENU);
		
		EasyMock.replay(mainMenu);
	
		mainMenuCoord.setCurrentMenu(mainMenu);
		mainMenuCoord.confirmSelection();
		
		EasyMock.verify(mainMenu);
	}
		
	@Test
	public void testConfirmSelectionResumeGame() throws ParserConfigurationException, SAXException, IOException {
		scheduler.changeCoordinator(CoordinatorType.GAME);
		EasyMock.expectLastCall();
		EasyMock.replay(scheduler);
		
		EasyMock.expect(mainMenu.getCurrentSelection()).andReturn(MenuOption.RESUME_GAME);
		
		EasyMock.replay(mainMenu);
	
		mainMenuCoord.setCurrentMenu(mainMenu);
		mainMenuCoord.confirmSelection();
		
		EasyMock.verify(scheduler);
		EasyMock.verify(mainMenu);
	}
	
	@Test
	public void testConfirmSelectionMainMenu() throws ParserConfigurationException, SAXException, IOException {
		EasyMock.expect(mainMenu.getCurrentSelection()).andReturn(MenuOption.RETURN_TO_MAIN_MENU);
		
		EasyMock.replay(mainMenu);
	
		mainMenuCoord.setCurrentMenu(mainMenu);
		mainMenuCoord.confirmSelection();
		EasyMock.verify(mainMenu);
	}
}
