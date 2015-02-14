package inventoryTest;

import static org.junit.Assert.*;
import inventory.Sack;
import item.Takeable;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class SackTest {
	
	private Sack sack;
	private Takeable takeable1;

	@Before
	public void setUp() throws Exception {
		sack = new Sack();
		takeable1 = EasyMock.createNiceMock(Takeable.class);
	}

	@Test
	public void testDefaultConstructors() {
		assertEquals(10, sack.getSizeOfSack());
		assertEquals(10, sack.getItemsInSack().length);
		assertEquals(10, sack.getSlotsInUse().length);
	}
	
	@Test
	public void testAddItemWithEmptySack() {
		boolean result = sack.addItem(takeable1);
		assertTrue(result);
		assertEquals(takeable1, sack.getItemsInSack()[0]);
		assertTrue(sack.getSlotsInUse()[0]);
	}
	
	@Test
	public void testAdd2ItemsWithEmptySack() {
		boolean result = sack.addItem(takeable1);
		assertTrue(result);
		assertEquals(takeable1, sack.getItemsInSack()[0]);
		assertTrue(sack.getSlotsInUse()[0]);
		
		result = sack.addItem(takeable1);
		assertTrue(result);
		assertEquals(takeable1, sack.getItemsInSack()[1]);
		assertTrue(sack.getSlotsInUse()[1]);
	}
	
	@Test
	public void testAddItemsUntilSackIsFull() {
		boolean result;
		for(int i = 0; i < sack.getSizeOfSack(); i++) {
			result = sack.addItem(takeable1);
			assertTrue(result);
			assertEquals(takeable1, sack.getItemsInSack()[i]);
			assertTrue(sack.getSlotsInUse()[i]);
		}
		
		result = sack.addItem(takeable1);
		assertFalse(result);
	}
	
	@Test
	public void testItemAt() {
		boolean result = sack.addItem(takeable1);
		assertTrue(result);
		assertEquals(takeable1, sack.getItemsInSack()[0]);
		assertTrue(sack.getSlotsInUse()[0]);
		
		assertEquals(takeable1, sack.itemAt(0));
		assertNotSame(takeable1, sack.itemAt(1));
	}
	
	@Test
	public void testRemoveItem() {
		
	}
	

}
