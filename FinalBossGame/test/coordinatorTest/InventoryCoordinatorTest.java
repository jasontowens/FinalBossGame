package coordinatorTest;

import static org.junit.Assert.*;
import inventory.Armory;
import inventory.Sack;
import map.GameMap;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import coordinators.CoordinatorScheduler;
import coordinators.InventoryCoordinator;
import entity.Entity;

public class InventoryCoordinatorTest {
	
	private InventoryCoordinator inventoryCoordinator;
	private CoordinatorScheduler scheduler;
	private Entity ent;
	private Armory arm;
	private Sack sack;
	private GameMap map;

	@Before
	public void setUp() throws Exception {
		ent = EasyMock.createNiceMock(Entity.class);
		arm = EasyMock.createNiceMock(Armory.class);
		sack = EasyMock.createNiceMock(Sack.class);
		//map = EasyMock.createNiceMock(GameMap.class);
		scheduler = EasyMock.createNiceMock(CoordinatorScheduler.class);
		inventoryCoordinator = InventoryCoordinator.getInstance();
		inventoryCoordinator.setScheduler(scheduler);
		inventoryCoordinator.setAvatar(ent);
		//inventoryCoordinator.setActiveMap(map);
	}

	@Test
	public void testActivateItem() {
		ent.useItem(0);
		EasyMock.expectLastCall();
		
		EasyMock.replay(ent);
		
		inventoryCoordinator.activateItem();
		
		EasyMock.verify(ent);
	}
	
	@Test
	public void testDropItem() {
		ent.dropItem(0);
		EasyMock.expectLastCall();
		
		EasyMock.replay(ent);
		
		inventoryCoordinator.dropItem();
		
		EasyMock.verify(ent);
	}
	
	@Test
	public void testNextItem() {
		EasyMock.expect(ent.getArmory().size()).andReturn(5).anyTimes();
		EasyMock.expect(ent.getSack().length).andReturn(5).anyTimes();
		
		
	}

}
