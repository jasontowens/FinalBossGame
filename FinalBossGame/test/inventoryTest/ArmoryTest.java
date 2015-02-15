package inventoryTest;

import static org.junit.Assert.*;
import inventory.Armory;
import inventory.EquipSlot;
import item.Equipable;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class ArmoryTest {

	private Armory armory;
	private Equipable equipable;
	private Equipable equipable2;
	
	@Before 
	public void Init() {
		armory = new Armory();
		equipable = EasyMock.createNiceMock(Equipable.class);
		equipable2 = EasyMock.createNiceMock(Equipable.class);
	}
	
	@Test
	public void testDefaultConstructor() {
		assertEquals(10, armory.getNumOfSlots());
		assertEquals(10,armory.getEquippedItems().length);
		assertEquals(10, armory.getUsedSlots().length);
	}
	
	@Test
	public void testIntConstructor() {
		Armory newArmory = new Armory(20);
		assertEquals(20, newArmory.getNumOfSlots());
		assertEquals(20, newArmory.getEquippedItems().length);
		assertEquals(20, newArmory.getUsedSlots().length);
	}
	
	@Test
	public void equipWithNoItemsAdded() {
		EasyMock.expect(equipable.getSlot()).andReturn(EquipSlot.HEAD);
		EasyMock.replay(equipable);
		
		Equipable item = armory.equip(equipable);
		assertEquals(item,equipable);
		assertEquals(armory.getEquippedItems()[0], equipable);
		assertEquals(armory.getUsedSlots()[0],true);
		
		EasyMock.verify(equipable);
	}
	
	@Test
	public void equipWithItemAlreadyThere() {
		EasyMock.expect(equipable.getSlot()).andReturn(EquipSlot.HEAD);
		
		EasyMock.replay(equipable);
		
		
		Equipable item = armory.equip(equipable);

		assertEquals(item,equipable);
		assertEquals(armory.getEquippedItems()[0], equipable);
		assertEquals(armory.getUsedSlots()[0],true);
		
		EasyMock.verify(equipable);

		
		EasyMock.expect(equipable2.getSlot()).andReturn(EquipSlot.HEAD).times(2);
		EasyMock.replay(equipable2);
		
		Equipable item2 = armory.equip(equipable2);
	
		assertEquals(item2,equipable);
		assertEquals(armory.getEquippedItems()[0],equipable2);
		assertEquals(armory.getUsedSlots()[0],true);
		
		EasyMock.verify(equipable2);
	}

	@Test
	public void unequipWithNoItemsAdded() {
		Equipable item = armory.unequip(EquipSlot.HEAD);
		assertNull(item);
	}
	
	@Test
	public void unequipWithAHeadItem() {
		EasyMock.expect(equipable.getSlot()).andReturn(EquipSlot.HEAD);
		
		EasyMock.replay(equipable);
		
		
		Equipable item = armory.equip(equipable);

		assertEquals(item,equipable);
		assertEquals(armory.getEquippedItems()[0], equipable);
		assertEquals(armory.getUsedSlots()[0],true);
		
		EasyMock.verify(equipable);
		
		Equipable item2 = armory.unequip(EquipSlot.HEAD);

		assertEquals(item2,equipable);
		assertNull(armory.getEquippedItems()[0]);
		assertEquals(armory.getUsedSlots()[0],false);
	}
}
