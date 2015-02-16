package coordinatorTest;

import static org.junit.Assert.*;
import map.CoordinatePair;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import coordinators.CoordinatorScheduler;
import coordinators.CoordinatorType;
import coordinators.GameCoordinator;
import entity.Entity;

public class GameCoordinatorTest {
	
	private GameCoordinator coord;
	private CoordinatePair pair;
	private Entity ent;
	private CoordinatorScheduler sched;

	@Before
	public void setUp() throws Exception {
		coord = GameCoordinator.getInstance();
		ent = EasyMock.createNiceMock(Entity.class);
		sched = EasyMock.createNiceMock(CoordinatorScheduler.class);
		pair = EasyMock.createNiceMock(CoordinatePair.class);
		coord.setScheduler(sched);
		coord.setAvatar(ent);
	}

	@Test
	public void testPause() {
		sched.changeCoordinator(CoordinatorType.MENU);
		EasyMock.expectLastCall();
		
		EasyMock.replay(sched);
		
		coord.pause();
		
		EasyMock.verify(sched);
	}
	
	@Test
	public void testInventory() {
		sched.changeCoordinator(CoordinatorType.INVENTORY);
		EasyMock.expectLastCall();
		
		EasyMock.replay(sched);
		
		coord.inventory();
		
		EasyMock.verify(sched);
	}

}
