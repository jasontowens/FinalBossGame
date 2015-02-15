package controllerTest;

import java.awt.Button;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xml.sax.SAXException;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.expectLastCall;
import controllers.*;

@RunWith(EasyMockRunner.class)
public class InputParserTest {

	private InputParser inputParser; 
	private SceneController sceneController; 
	private KeyEvent keyEvent;
	
	@Before
	public void init() throws InterruptedException {
		sceneController = createNiceMock(SceneController.class);
		inputParser = new InputParser();
		inputParser.getSceneControllerDispatcher().setActiveController(sceneController);
		keyEvent = new KeyEvent(new Button("click"), KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'Z');
		Thread.sleep(1000);
	}
	
	
	@Test
	public void testKeyPressed1() {
		sceneController.useKey1();
		expectLastCall();
	   
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_1);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressed2() {
		sceneController.useKey2();
		expectLastCall();
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_2);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressed3() {
		sceneController.useKey3();
		expectLastCall();
	   
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_3);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressed4() {
		sceneController.useKey4();
		expectLastCall();
	    
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_4);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressed5() {
		sceneController.useKey5();
		expectLastCall();
	   
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_5);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressed6() {
		sceneController.useKey6();
		expectLastCall();
	    
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_6);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressed7() {
		sceneController.useKey7();
		expectLastCall();
	   
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_7);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressed8() {
		sceneController.useKey8();
		expectLastCall();
	    
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_8);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressed9() {
		sceneController.useKey9();
		expectLastCall();
	   
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_9);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressedEnter() throws ParserConfigurationException, SAXException, IOException {
		sceneController.useKeyEnter();
		expectLastCall();
	    
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_ENTER);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressedEscape() {
		sceneController.useKeyEscape();
		expectLastCall();
	   
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_ESCAPE);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressedLeft() {
		sceneController.useKey4();
		expectLastCall();
	    
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_LEFT);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressedRight() {
		sceneController.useKey6();
		expectLastCall();
	    
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_RIGHT);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressedUp() {
		sceneController.useKey8();
		expectLastCall();
	   
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_UP);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressedDown() {
		sceneController.useKey2();
		expectLastCall();
	    
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_DOWN);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressedI() {
		sceneController.useKeyI();
		expectLastCall();
	    
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_I);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testKeyPressedA() {
		sceneController.useKeyA();
		expectLastCall();
	    
	    replay(sceneController);
	    
	    keyEvent.setKeyCode(KeyEvent.VK_A);
	    inputParser.keyPressed(keyEvent);
	    EasyMock.verify(sceneController);
	}
	
	@Test
	public void testNonMappedKeyPressedDown() {
		replay(sceneController);
		
		keyEvent.setKeyCode(KeyEvent.VK_B);
		inputParser.keyPressed(keyEvent);
		EasyMock.verify(sceneController);
	}
	
	@Test
	public void testMultipleKeyPresses() {
		sceneController.useKeyA();
		expectLastCall();
		
		replay(sceneController);
		
		keyEvent.setKeyCode(KeyEvent.VK_A);
		inputParser.keyPressed(keyEvent);
		inputParser.keyPressed(keyEvent);
		EasyMock.verify(sceneController);
	}
}
