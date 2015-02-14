package controllerTest;

import static org.easymock.EasyMock.createNiceMock;
import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import controllers.LoadMenuController;
import controllers.MenuController;
import coordinators.LoadMenuCoordinator;

public class LoadMenuControllerTest {
	
	private LoadMenuCoordinator loadMenuCoordinator;
	private LoadMenuController menuController;

	@Before
	public void init() throws InterruptedException {
		loadMenuCoordinator = createNiceMock(LoadMenuCoordinator.class);
		menuController = LoadMenuController.getInstance();
		menuController.setLoadReceiver(loadMenuCoordinator);
	}

	@Test
	public void testMultipleCallsYieldsSameController() {
		assertEquals(LoadMenuController.getInstance(), LoadMenuController.getInstance());
	}
	
	@Test
	public void testSingletonDoesNotReferToDifferentSceneController() {
		assertNotSame(LoadMenuController.getInstance(), MenuController.getInstance());
	}
	
	@Test
	public void testUseKey2() {
		loadMenuCoordinator.nextSelection();
		EasyMock.expectLastCall();
		EasyMock.replay(loadMenuCoordinator);
		
		menuController.useKey2();
		EasyMock.verify(loadMenuCoordinator);
	}
	
	@Test
	public void testUseKey8() {
		loadMenuCoordinator.previousSelection();
		EasyMock.expectLastCall();
		EasyMock.replay(loadMenuCoordinator);
		
		menuController.useKey8();
		EasyMock.verify(loadMenuCoordinator);
	}
	
	@Test
	public void testUseKeyEnter() {
		loadMenuCoordinator.confirmSelection();
		EasyMock.expectLastCall();
		EasyMock.replay(loadMenuCoordinator);
		
		menuController.useKeyEnter();
		EasyMock.verify(loadMenuCoordinator);
	}
	
	@Test 
	public void testUseKeyEscape() {
		loadMenuCoordinator.backToMainMenu();
		EasyMock.expectLastCall();
		EasyMock.replay(loadMenuCoordinator);
		
		menuController.useKeyEscape();
		EasyMock.verify(loadMenuCoordinator);
	}
	
	

}
