package inventoryTest;

import static org.junit.Assert.*;
import inventory.Armory;
import inventory.Inventory;
import inventory.Sack;
import item.Takeable;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
	private Sack sack;
	private Armory armory;
	private Inventory inventory;
	private Takeable takeable;

	@Before
	public void setUp() throws Exception {
		sack = EasyMock.createNiceMock(Sack.class);
		armory = EasyMock.createNiceMock(Armory.class);
		takeable = EasyMock.createNiceMock(Takeable.class);
		inventory = new Inventory(sack,armory);
	}

	@Test
	public void testConstructor() {
		assertEquals(0, inventory.getCurrency());
	}
	
	@Test
	public void testRemoveItem() {
		EasyMock.expect(sack.removeItem(10)).andReturn(takeable);
		EasyMock.replay(sack);
		
		inventory.removeItem(10);
		
		EasyMock.verify(sack);
	}
	
	@Test
	public void testAddItem() {
		EasyMock.expect(sack.addItem(takeable)).andReturn(true);
		EasyMock.replay(sack);
		
		inventory.addItem(takeable);
		
		EasyMock.verify(sack);
	}
	
	/*
	 * TODO useItem methods
	 */

}
