package controllerTest;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import controllers.GameController;
import controllers.MenuController;
import coordinators.MenuCoordinator;

public class MenuControllerTest {
	
	private MenuCoordinator mainMenuReciever;
	private MenuController menuController;
	
	
	@Before
	public void init() {
		mainMenuReciever = createNiceMock(MenuCoordinator.class);
		menuController = MenuController.getInstance();
		menuController.setCoordinator(mainMenuReciever);
	}

	@Test
	public void testMultipleCallsYieldsSameController() {
		assertEquals(MenuController.getInstance(), MenuController.getInstance());
	}
	
	@Test
	public void testSingletonDoesNotReferToDifferentSceneController() {
		assertNotSame(MenuController.getInstance(), GameController.getInstance());
	}
	
	@Test
	public void testUseKey2() {
		mainMenuReciever.next();
		expectLastCall();
		replay(mainMenuReciever);
		
		menuController.useKey2();
		
		EasyMock.verify(mainMenuReciever);
	}
	
	@Test
	public void testUseKey8() {
		mainMenuReciever.prev();
		expectLastCall();
		replay(mainMenuReciever);
		
		menuController.useKey8();
		
		EasyMock.verify(mainMenuReciever);
	}
	
	@Test
	public void testUseKeyEnter() throws ParserConfigurationException, SAXException, IOException {
		mainMenuReciever.confirmSelection();
		expectLastCall();
		replay(mainMenuReciever);
		
		menuController.useKeyEnter();
		
		EasyMock.verify(mainMenuReciever);
	}
	
	

}
