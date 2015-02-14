package coordinatorTest;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import coordinators.CoordinatorScheduler;
import coordinators.CoordinatorType;
import coordinators.MainMenuCoordinator;
import coordinators.MainOption;

public class MainMenuCoordinatorTest {
	
	private MainMenuCoordinator mainMenuCoord;
	private CoordinatorScheduler scheduler;
	
	@Before
	public void init() {
		mainMenuCoord = MainMenuCoordinator.getInstance();
		scheduler = EasyMock.createNiceMock(CoordinatorScheduler.class);
		mainMenuCoord.setScheduler(scheduler);
	}
	
	@Test
	public void testNextSelectionStart() {
		mainMenuCoord.setCurrentSelection(MainOption.Start);
		mainMenuCoord.nextSelection();
		assertEquals(MainOption.Load, mainMenuCoord.getCurrentSelection());
	}
	@Test 
	public void testNextSelectionLoad() {
		mainMenuCoord.setCurrentSelection(MainOption.Load);
		mainMenuCoord.nextSelection();
		assertEquals(MainOption.Exit, mainMenuCoord.getCurrentSelection());
	}
	@Test 
	public void testNextSelectionExit() {
		mainMenuCoord.setCurrentSelection(MainOption.Exit);
		mainMenuCoord.nextSelection();
		assertEquals(MainOption.Start, mainMenuCoord.getCurrentSelection());
	}
	
	@Test
	public void testPreviousSelectionStart() {
		mainMenuCoord.setCurrentSelection(MainOption.Start);
		mainMenuCoord.previousSelection();
		assertEquals(MainOption.Exit, mainMenuCoord.getCurrentSelection());
	}
	@Test 
	public void testPreviousSelectionLoad() {
		mainMenuCoord.setCurrentSelection(MainOption.Load);
		mainMenuCoord.previousSelection();
		assertEquals(MainOption.Start, mainMenuCoord.getCurrentSelection());
	}
	@Test 
	public void testPreviousSelectionExit() {
		mainMenuCoord.setCurrentSelection(MainOption.Exit);
		mainMenuCoord.previousSelection();
		assertEquals(MainOption.Load, mainMenuCoord.getCurrentSelection());
	}
	@Test
	public void testConfirmSelectionLoad() {
		scheduler.changeCoordinator(CoordinatorType.LOAD);
		EasyMock.expectLastCall();
		EasyMock.replay(scheduler);
		
		mainMenuCoord.setCurrentSelection(MainOption.Load);
		mainMenuCoord.confirmSelection();
		EasyMock.verify(scheduler);
	}
	
	

}
