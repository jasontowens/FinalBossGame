package coordinatorTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import map.CoordinatePair;
import map.GameMap;
import map.Pair;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import coordinators.CoordinatorScheduler;
import coordinators.CoordinatorType;
import coordinators.GameCoordinator;
import coordinators.LoadMenuCoordinator;
import entity.Entity;
import factories.ObjectFactory;

public class LoadMenuCoordinatorTest {
	
	private LoadMenuCoordinator coordinator;
	private GameCoordinator gameCoord;
	private Entity entity;
	private CoordinatePair pair;
	private Pair<Entity,CoordinatePair> entityPair;
	private ObjectFactory objectFactory;
	private ArrayList<String> testFiles;
	private GameMap map;
	private CoordinatorScheduler scheduler;
	
	@Before
	public void Init() {
		coordinator = LoadMenuCoordinator.getInstance();
		testFiles = LoadMenuCoordinator.getSaveFiles();
		scheduler = EasyMock.createNiceMock(CoordinatorScheduler.class);
		gameCoord = EasyMock.createNiceMock(GameCoordinator.class);
		pair = EasyMock.createNiceMock(CoordinatePair.class);
		entityPair = EasyMock.createNiceMock(Pair.class);
		objectFactory = EasyMock.createNiceMock(ObjectFactory.class);
		map = EasyMock.createNiceMock(GameMap.class);
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
	
	@Test
	public void testConfirmSelection() throws ParserConfigurationException, SAXException, IOException {
		LoadMenuCoordinator.setCurrentFileIndex(0);
		loadMenuCoordinator.
		
		
		coordinator.confirmSelection();
		
	}
}
