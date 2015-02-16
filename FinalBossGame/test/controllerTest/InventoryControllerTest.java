package controllerTest;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import controllers.InventoryController;
import coordinators.InventoryCoordinator;

public class InventoryControllerTest {
	
	private InventoryController cont = InventoryController.getInstance();
	private InventoryCoordinator coord;

	@Before
	public void setUp() throws Exception {
		coord = EasyMock.createNiceMock(InventoryCoordinator.class);
		cont.setInventoryCoordinator(coord);
	}

	@Test
	public void testUseKey2() {
		coord.nextItem();
		EasyMock.expectLastCall();
		
		EasyMock.replay(coord);
		
		cont.useKey2();
		
		EasyMock.verify(coord);
	}
	
	@Test
	public void testUseKey8() {
		coord.previousItem();
		EasyMock.expectLastCall();
		
		EasyMock.replay(coord);
		
		cont.useKey8();
		
		EasyMock.verify(coord);
	}
	
	@Test
	public void testUseKey5() {
		coord.dropItem();
		EasyMock.expectLastCall();
		
		EasyMock.replay(coord);
		
		cont.useKey5();
		
		EasyMock.verify(coord);
	}
	
	@Test
	public void testUseKeyI() {
		coord.exitInventory();
		EasyMock.expectLastCall();
		
		EasyMock.replay(coord);
		
		cont.useKeyI();
		
		EasyMock.verify(coord);
	}
	
	@Test
	public void testUseKeyEnter() {
		coord.activateItem();
		EasyMock.expectLastCall();
		
		EasyMock.replay(coord);
		
		cont.useKeyEnter();
		
		EasyMock.verify(coord);
	}

}
