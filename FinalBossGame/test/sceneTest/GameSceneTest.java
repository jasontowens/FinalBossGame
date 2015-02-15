
package sceneTest;

import viewport.InventoryViewPort;
import viewport.PauseViewPort;
import viewport.MapViewPort;
import viewport.StatusViewPort;
import viewport.ViewPort;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameSceneTest()
{
	@Test
	public void MultipleAdditions()
	{
		viewports.add(map);
		viewports.add(status);
		viewports.add(inventory);
		viewports.add(pause);
		assertEquals(ViewPort.map, viewports.add(map) );
		assertEquals(ViewPort.status, viewports.add(status) );
		assertEquals(ViewPort.inventory, viewports.add(inventory) );
		assertEquals(ViewPort.pause, viewports.add(pause) );
		
	}	
}


