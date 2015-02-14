package coordinatorTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import coordinators.CoordinatorScheduler;
import coordinators.CoordinatorType;
import coordinators.LoadMenuCoordinator;

public class LoadMenuCoordinatorTest {
	
	private LoadMenuCoordinator coordinator;
	private ArrayList<String> testFiles;
	private CoordinatorScheduler scheduler;
	
	@Before
	public void Init() {
		coordinator = LoadMenuCoordinator.getInstance();
		testFiles = new ArrayList<String>();
		testFiles.add("Test file 1");
		testFiles.add("Test file 2");
		testFiles.add("Test file 3");
		coordinator.setSaveFiles(testFiles);
		
		scheduler = EasyMock.createNiceMock(CoordinatorScheduler.class);
		LoadMenuCoordinator.setScheduler(scheduler);
	}
	
	@Test
	public void testSingletonIsTheSame() {
		assertEquals(LoadMenuCoordinator.getInstance(), LoadMenuCoordinator.getInstance());
	}
	
	@Test
	public void testNextSelectionStartingAt0() {
		LoadMenuCoordinator.setCurrentFileIndex(0);
		coordinator.nextSelection();
		assertEquals(testFiles.get(1), LoadMenuCoordinator.getCurrentFile());
	}
	
	@Test
	public void testNextSelectionStartingAt1() {
		LoadMenuCoordinator.setCurrentFileIndex(1);
		coordinator.nextSelection();
		assertEquals(testFiles.get(2), LoadMenuCoordinator.getCurrentFile());
	}
	
	@Test
	public void testNextSelectionStartingAt2() {
		LoadMenuCoordinator.setCurrentFileIndex(2);
		coordinator.nextSelection();
		assertEquals(testFiles.get(0), LoadMenuCoordinator.getCurrentFile());
	}
	
	@Test
	public void testPreviousSelectionStartingAt0() {
		LoadMenuCoordinator.setCurrentFileIndex(0);
		coordinator.previousSelection();
		assertEquals(testFiles.get(2), LoadMenuCoordinator.getCurrentFile());
	}
	
	@Test
	public void testPreviousSelectionStartingAt1() {
		LoadMenuCoordinator.setCurrentFileIndex(1);
		coordinator.previousSelection();
		assertEquals(testFiles.get(0), LoadMenuCoordinator.getCurrentFile());
	}
	
	@Test
	public void testPreviousSelectionStartingAt2() {
		LoadMenuCoordinator.setCurrentFileIndex(2);
		coordinator.previousSelection();
		assertEquals(testFiles.get(1), LoadMenuCoordinator.getCurrentFile());
	}
	
	@Test
	public void testBackToMainMenu() {
		scheduler.changeCoordinator(CoordinatorType.MAIN_MENU);
		EasyMock.expectLastCall();
		
		EasyMock.replay(scheduler);
		
		coordinator.backToMainMenu();
		EasyMock.verify(scheduler);
	}
	
	
	

}
