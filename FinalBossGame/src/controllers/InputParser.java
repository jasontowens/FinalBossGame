package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class InputParser implements KeyListener {
	private SceneControllerDispatcher sceneControllerDispatcher;
	private static final long TIMER_DELAY = 50;
	private long timerStart;
	
        
        
	public InputParser() {
		sceneControllerDispatcher = new SceneControllerDispatcher();
		timerStart = System.currentTimeMillis();
	}
	
	//Not listening for a keyTyped event.
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
            //System.out.println(e);
		if(System.currentTimeMillis() - timerStart >= TIMER_DELAY) {
			timerStart = System.currentTimeMillis();
			switch(e.getKeyCode()) {
				case KeyEvent.VK_1 : case KeyEvent.VK_NUMPAD1 :
					sceneControllerDispatcher.getActiveController().useKey1();
					break;
				case KeyEvent.VK_2 : case KeyEvent.VK_DOWN : case KeyEvent.VK_NUMPAD2 :
					sceneControllerDispatcher.getActiveController().useKey2();
					break;
				case KeyEvent.VK_3 : case KeyEvent.VK_NUMPAD3 :
					sceneControllerDispatcher.getActiveController().useKey3();
					break;
				case KeyEvent.VK_4 : case KeyEvent.VK_LEFT : case KeyEvent.VK_NUMPAD4 :
					sceneControllerDispatcher.getActiveController().useKey4();
					break;
				case KeyEvent.VK_5 : case KeyEvent.VK_NUMPAD5 :
					sceneControllerDispatcher.getActiveController().useKey5();
					break;
				case KeyEvent.VK_6 : case KeyEvent.VK_RIGHT : case KeyEvent.VK_NUMPAD6 :
					sceneControllerDispatcher.getActiveController().useKey6();
					break;
				case KeyEvent.VK_7 : case KeyEvent.VK_NUMPAD7 : 
					sceneControllerDispatcher.getActiveController().useKey7();
					break;
				case KeyEvent.VK_8 : case KeyEvent.VK_UP : case KeyEvent.VK_NUMPAD8 :
					sceneControllerDispatcher.getActiveController().useKey8();
					break;
				case KeyEvent.VK_9 : case KeyEvent.VK_NUMPAD9 :
					sceneControllerDispatcher.getActiveController().useKey9();
					break;
					//TODO This println
				case KeyEvent.VK_ENTER :
				try {
					sceneControllerDispatcher.getActiveController().useKeyEnter();
				} catch (ParserConfigurationException | SAXException
						| IOException e1) {
					System.out.println("We done screwed up.");
				}
					break;
				case KeyEvent.VK_ESCAPE: 
					sceneControllerDispatcher.getActiveController().useKeyEscape();
					break;
				case KeyEvent.VK_I: 
					sceneControllerDispatcher.getActiveController().useKeyI();
					break;
				case KeyEvent.VK_A:
					sceneControllerDispatcher.getActiveController().useKeyA();
					break;
				default : 
					break;
			}
		}
	
		
	}

	public SceneControllerDispatcher getSceneControllerDispatcher() {
		return sceneControllerDispatcher;
	}


	public void setSceneControllerDispatcher(
			SceneControllerDispatcher sceneControllerDispatcher) {
		this.sceneControllerDispatcher = sceneControllerDispatcher;
	}

	//Not listening for a keyReleasedEvent
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	

}
