package itemTest;

import static org.junit.Assert.*;
import item.Takeable;
import map.GameMap;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import entity.Entity;
import stats.ItemStats;

public class TakeableTest {
	private Takeable takeable;
	private ItemStats stats;
	private GameMap map;
	private Entity entity;
	
	@Before
	public void setUp() {
		stats = EasyMock.createNiceMock(ItemStats.class);
		map = EasyMock.createNiceMock(GameMap.class);
		entity = EasyMock.createNiceMock(Entity.class);
		takeable = new Takeable("Takeable Item", "Description1", stats, map);
	}
	
	@Test
	public void testPublicConstructor(){
		assertEquals(4, takeable.getID());
	}
	
	@Test
	public void testActivate(){
		EasyMock.expect(map.removeItem(takeable));
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
