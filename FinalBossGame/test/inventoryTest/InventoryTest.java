package inventoryTest;

import static org.junit.Assert.*;
import inventory.Armory;
import inventory.Inventory;
import inventory.Sack;
import item.Equipable;
import item.Takeable;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import entity.Entity;

public class InventoryTest {
	private Sack sack;
	private Armory armory;
	private Inventory inventory;
	private Equipable takeable;
	private Entity entity;

	@Before
	public void setUp() throws Exception {
		sack = EasyMock.createNiceMock(Sack.class);
		armory = EasyMock.createNiceMock(Armory.class);
		takeable = EasyMock.createNiceMock(Equipable.class);
		entity = EasyMock.createNiceMock(Entity.class);
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
	
	@Test
	public void testUseItemArmory() {
		EasyMock.expect(sack.addItem(takeable)).andReturn(true);
		EasyMock.expect(armory.unequip(1)).andReturn(takeable);
		
		EasyMock.replay(sack);
		EasyMock.replay(armory);
		
		inventory.useItem(1, entity);
		
		EasyMock.verify(sack);
		EasyMock.verify(armory);	
	}
	
	@Test
	public void testUseItemSack() {
		EasyMock.expect(sack.useItem(1,entity)).andReturn(takeable);
		
		EasyMock.replay(sack);
		
		inventory.useItem(11, entity);
		
		EasyMock.verify(sack);	
	}
	/*
	 * TODO useItem methods
	 */
	
	@Test
	public void equipItem() {
		EasyMock.expect(sack.isInSack(takeable)).andReturn(true);
		EasyMock.expect(takeable.getClassName()).andReturn("Equipable");
		EasyMock.expect(armory.equip((Equipable) takeable)).andReturn(takeable);

		EasyMock.replay(sack);
		EasyMock.replay(takeable);
		EasyMock.replay(armory);
		
		boolean result = inventory.equipItem(takeable);
		
		assertTrue(result);
		
		EasyMock.verify(sack);
		EasyMock.verify(takeable);
		EasyMock.verify(armory);
	}
	
	@Test
	public void equipItemNonEquipableItem() {
		EasyMock.expect(sack.isInSack(takeable)).andReturn(true);
		EasyMock.expect(takeable.getClassName()).andReturn("MagicItem");
		
		EasyMock.replay(sack);
		EasyMock.replay(takeable);

		boolean result = inventory.equipItem(takeable);
		
		assertFalse(result);
		
		EasyMock.verify(sack);
		EasyMock.verify(takeable);
	}
	
	@Test
	public void equipItemNotInSack() {
		EasyMock.expect(sack.isInSack(takeable)).andReturn(false);
	
		EasyMock.replay(sack);
		
		boolean result = inventory.equipItem(takeable);
		
		assertFalse(result);
		
		EasyMock.verify(sack);
	}
	
	@Test
	public void removeItemGivenItem() {
		EasyMock.expect(sack.removeItem(takeable)).andReturn(takeable);
		
		EasyMock.replay(sack);
		
		inventory.removeItem(takeable);
		
		EasyMock.verify(sack);
	}
	
	@Test
	public void testModCurrencyPositive() {
		inventory.setCurrency(10);
		boolean result = inventory.modCurrency(12);
		
		assertEquals(22,inventory.getCurrency());
		assertTrue(result);
	}
	
	@Test
	public void testModCurrencyNegativeAmount() {
		inventory.setCurrency(10);
		boolean result = inventory.modCurrency(-3);
		
		assertEquals(7,inventory.getCurrency());
		assertTrue(result);
	}
	
	@Test
	public void testModCurrencyNegativeAmountFails() {
		inventory.setCurrency(10);
		boolean result = inventory.modCurrency(-15);
		
		assertEquals(10,inventory.getCurrency());
		assertFalse(result);
	}
	
	@Test
	public void testSetCurrency() {
		boolean result = inventory.setCurrency(12);
		assertTrue(result);
		assertEquals(12,inventory.getCurrency());
	}
	
	@Test
	public void testSetCurrencyFalse() {
		boolean result = inventory.setCurrency(-3);
		assertFalse(result);
		assertEquals(0,inventory.getCurrency());
	}

}
