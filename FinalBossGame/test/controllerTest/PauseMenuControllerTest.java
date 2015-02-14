package controllerTest;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import controllers.LoadMenuController;
import controllers.PauseMenuController;
import coordinators.PauseMenuCoordinator;

public class PauseMenuControllerTest {
	
	private PauseMenuController pauseMenu;
	private PauseMenuCoordinator coordinator;
	
	@Before
	public void Init() {
		coordinator = EasyMock.createNiceMock(PauseMenuCoordinator.class);
		pauseMenu = PauseMenuController.getInstance();
		PauseMenuController.setPauseReceiver(coordinator);
	}

	@Test
	public void testMultipleCallsYieldsSameController() {
		assertEquals(PauseMenuController.getInstance(), PauseMenuController.getInstance());
	}
	
	@Test
	public void testSingletonDoesNotReferToDifferentSceneController() {
		assertNotSame(PauseMenuController.getInstance(), LoadMenuController.getInstance());
	}
	
	@Test
	public void testUseKey2() {
		coordinator.nextSelection();
		EasyMock.expectLastCall();
		EasyMock.replay(coordinator);
		
		pauseMenu.useKey2();
		EasyMock.verify(coordinator);
	}
	
	@Test
	public void testUseKey8() {
		coordinator.previousSelection();
		EasyMock.expectLastCall();
		EasyMock.replay(coordinator);
		
		pauseMenu.useKey8();
		EasyMock.verify(coordinator);
	}
	
	@Test
	public void testUseKeyEnter() {
		coordinator.confirmSelection();
		EasyMock.expectLastCall();
		EasyMock.replay(coordinator);
		
		pauseMenu.useKeyEnter();
		EasyMock.verify(coordinator);
	}
	
	@Test
	public void testUseKeyEscape() {
		coordinator.unPause();
		EasyMock.expectLastCall();
		EasyMock.replay(coordinator);
		
		pauseMenu.useKeyEscape();
		EasyMock.verify(coordinator);
	}

}
