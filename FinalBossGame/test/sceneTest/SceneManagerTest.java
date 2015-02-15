package sceneTest;

import stats.PlayerStats;
import static org.junit.Assert.*;
import org.junit.Test;

public class SceneManagerTest {
	
	@Test
	public void CheckUpdate(){
		
		assertEquals(Scene.getActiveScene(), Scene.getActiveScene());
		
	}
	
	
}