package controllerTest;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import controllers.LoadMenuController;
import controllers.MenuController;
import coordinators.MainMenuCoordinator;

public class MenuControllerTest {
	
	private MainMenuCoordinator mainMenuReciever;
	private MenuController menuController;
	
	
	@Before
	public void init() {
		mainMenuReciever = createNiceMock(MainMenuCoordinator.class);
		menuController = MenuController.getInstance();
		menuController.setCoordinator(mainMenuReciever);
	}

	@Test
	public void testMultipleCallsYieldsSameController() {
		assertEquals(MenuController.getInstance(), MenuController.getInstance());
	}
	
	@Test
	public void testSingletonDoesNotReferToDifferentSceneController() {
		assertNotSame(MenuController.getInstance(), LoadMenuController.getInstance());
	}
	
	@Test
	public void testUseKey2() {
		mainMenuReciever.previousSelection();
		expectLastCall();
		replay(mainMenuReciever);
		
		menuController.useKey2();
		
		EasyMock.verify(mainMenuReciever);
	}
	
	@Test
	public void testUseKey8() {
		mainMenuReciever.nextSelection();
		expectLastCall();
		replay(mainMenuReciever);
		
		menuController.useKey8();
		
		EasyMock.verify(mainMenuReciever);
	}
	
	

}
