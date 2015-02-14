package coordinatorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import coordinators.LoadMenuCoordinator;

public class LoadMenuCoordinatorTest {
	
	@Test
	public void testSingletonMethods() {
		assertEquals(LoadMenuCoordinator.getInstance(), LoadMenuCoordinator.getInstance());
	}
	

}
