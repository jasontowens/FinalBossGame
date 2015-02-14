package coordinatorTest;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import coordinators.CoordinatorScheduler;
import coordinators.CoordinatorType;
import coordinators.PauseMenuCoordinator;
import coordinators.PauseOption;

public class PauseMenuCoordinatorTest {
	
	private CoordinatorScheduler scheduler;
	private PauseMenuCoordinator coordinator;

	@Before
	public void Init() {
		scheduler = EasyMock.createNiceMock(CoordinatorScheduler.class);
		coordinator = PauseMenuCoordinator.getInstance();
		PauseMenuCoordinator.setScheduler(scheduler);
	}
	
	@Test
	public void testConfirmSelectionResume() {
		scheduler.changeCoordinator(CoordinatorType.GAME);
		EasyMock.expectLastCall();
		EasyMock.replay(scheduler);
		
		coordinator.setCurrentSelection(PauseOption.Resume);
		coordinator.confirmSelection();
		
		EasyMock.verify(scheduler);
	}
	
	@Test
	public void testConfirmSelectionMainMenu() {
		scheduler.changeCoordinator(CoordinatorType.MAIN_MENU);
		EasyMock.expectLastCall();
		EasyMock.replay(scheduler);
		
		coordinator.setCurrentSelection(PauseOption.MainMenu);
		coordinator.confirmSelection();
		
		EasyMock.verify(scheduler);
	}
	
	@Test
	public void testNextSelectionResume() {
		coordinator.setCurrentSelection(PauseOption.Resume);
		coordinator.nextSelection();
		assertEquals(PauseOption.Save, coordinator.getCurrentSelection());
	}
	
	@Test
	public void testNextSelectionSave() {
		coordinator.setCurrentSelection(PauseOption.Save);
		coordinator.nextSelection();
		assertEquals(PauseOption.MainMenu, coordinator.getCurrentSelection());
	}
	
	@Test
	public void testNextSelectionMainMenu() {
		coordinator.setCurrentSelection(PauseOption.MainMenu);
		coordinator.nextSelection();
		assertEquals(PauseOption.Exit, coordinator.getCurrentSelection());
	}
	
	@Test
	public void testNextSelectionExit() {
		coordinator.setCurrentSelection(PauseOption.Exit);
		coordinator.nextSelection();
		assertEquals(PauseOption.Resume, coordinator.getCurrentSelection());
	}
	
	@Test
	public void testPreviousSelectionResume() {
		coordinator.setCurrentSelection(PauseOption.Resume);
		coordinator.previousSelection();
		assertEquals(PauseOption.Exit, coordinator.getCurrentSelection());
	}
	
	@Test
	public void testPreviousSelectionSave() {
		coordinator.setCurrentSelection(PauseOption.Save);
		coordinator.previousSelection();
		assertEquals(PauseOption.Resume, coordinator.getCurrentSelection());
	}
	
	@Test
	public void testPreviousSelectionMainMenu() {
		coordinator.setCurrentSelection(PauseOption.MainMenu);
		coordinator.previousSelection();
		assertEquals(PauseOption.Save, coordinator.getCurrentSelection());
	}
	
	@Test
	public void testPreviousSelectionExit() {
		coordinator.setCurrentSelection(PauseOption.Exit);
		coordinator.previousSelection();
		assertEquals(PauseOption.MainMenu, coordinator.getCurrentSelection());
	}

}
