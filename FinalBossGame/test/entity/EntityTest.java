/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import inventory.Inventory;
import item.Equipable;
import item.Takeable;
import map.CoordinatePair;
import map.GameMap;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import stats.PlayerStats;
import stats.Stats;

/**
 *
 * @author Owner
 */
public class EntityTest {
    private Entity myEntity;
    private Inventory inventory;
    private Occupation occupation;
    private PlayerStats stats;
    private Stats mergeStats;
    private GameMap map;
    private Takeable item;
    private Equipable equip;
    private CoordinatePair coordinate;
    
    @Before
    public void setUp() {
        inventory = EasyMock.createNiceMock(Inventory.class);
        occupation = EasyMock.createNiceMock(Occupation.class);
        stats = EasyMock.createNiceMock(PlayerStats.class);
        map = EasyMock.createNiceMock(GameMap.class);

        item = EasyMock.createNiceMock(Takeable.class);
        coordinate = EasyMock.createNiceMock(CoordinatePair.class);
        mergeStats = EasyMock.createNiceMock(Stats.class);
        equip = EasyMock.createNiceMock(Equipable.class);
        myEntity = new Entity("Jason", "A perso", 36,
        		MotionType.GROUND, inventory, occupation, stats, map); //TODO: change ID to how Hanif wants it set up 

    }

    /**
     * Test of dropItem method, of class Entity.
     */
    @Test
    public void testDropItem() {
        int location = 0;
        EasyMock.expect(map.addItem(item, coordinate)).andReturn(coordinate);
        
        EasyMock.expect(inventory.removeItem(location)).andReturn(item);
        EasyMock.expect(map.getLocation(myEntity)).andReturn(coordinate);
        
        EasyMock.replay(map);
        EasyMock.replay(inventory);
        
        myEntity.dropItem(location);
        
        EasyMock.verify(map);
        EasyMock.verify(inventory);
    }

    /**
     * Test of useItem method, of class Entity.
     */
    @Test
    public void testUseItem() {
    	inventory.useItem(0, myEntity);
    	EasyMock.expectLastCall();
    	
    	EasyMock.replay(inventory);

        myEntity.useItem(0);
        
        EasyMock.verify(inventory);
    }

    /**
     * Test of move method, of class Entity.
     */
    
    @Test
    public void testMove() {
        map.requestMovement(myEntity, coordinate);
        EasyMock.expectLastCall();
        
        EasyMock.replay(map);
        
        myEntity.move(coordinate);
        
        EasyMock.verify(map);
    }

    /**
     * Test of addItem method, of class Entity.
     */
   
    @Test
    public void testAddItem() {
    	inventory.addItem(item);
        EasyMock.expectLastCall();
        
        EasyMock.replay(inventory);
        
        inventory.addItem(item);
        
        EasyMock.verify(inventory);
    }
    

    /**
     * Test of equipItem method, of class Entity.
     */
    
    @Test
    public void testEquipItem() {
        EasyMock.expect(inventory.equipItem(equip)).andReturn(true);
        
        EasyMock.replay(inventory);
        
        boolean result = myEntity.equipItem(equip);
        
        assertTrue(result);
    }
    @Test
    public void testEquipItemFailse() {
        EasyMock.expect(inventory.equipItem(equip)).andReturn(false);
        
        EasyMock.replay(inventory);
        
        boolean result = myEntity.equipItem(equip);
        
        assertFalse(result);
    }

    /**
     * Test of removeItem method, of class Entity.
     */
    
    @Test
    public void testRemoveItem() {
        inventory.removeItem(item);
        EasyMock.expectLastCall();
        
        EasyMock.replay(inventory);
        
        myEntity.removeItem(item);
        
        EasyMock.verify(inventory);
    }

    /**
     * Test of changeMoney method, of class Entity.
     */
    
    @Test
    public void testChangeMoney() {
        EasyMock.expect(inventory.modCurrency(10)).andReturn(true);
        
        EasyMock.replay(inventory);
        
        boolean result = myEntity.changeMoney(10);
        
        assertTrue(result);
        EasyMock.verify(inventory);
    }
    
    @Test
    public void testChangeMoneyFalse() {
    	EasyMock.expect(inventory.modCurrency(-5)).andReturn(false);
    	
    	EasyMock.replay(inventory);
    	
    	boolean result = myEntity.changeMoney(-5);
    	
    	assertFalse(result);
    	EasyMock.verify(inventory);
    }

    /**
     * Test of setMoney method, of class Entity.
     */
    @Test
    public void testSetMoney() {
        EasyMock.expect(inventory.setCurrency(10)).andReturn(true);
        
        EasyMock.replay(inventory);
        
        boolean result = myEntity.setMoney(10);
        
        assertTrue(result);
        
        EasyMock.verify(inventory);
    }
    
    @Test
    public void testSetMoneyReturnsFalse() {
        EasyMock.expect(inventory.setCurrency(-10)).andReturn(false);
        
        EasyMock.replay(inventory);
        
        boolean result = myEntity.setMoney(-10);
        
        assertFalse(result);
        
        EasyMock.verify(inventory);
    }

    /**
     * Test of setOccupation method, of class Entity.
     */
    
    @Test
    public void testSetOccupation() {
    	occupation.setName("name");
    	EasyMock.expectLastCall();
    	
    	EasyMock.replay(occupation);
    	
    	myEntity.setOccupation("name");
    	
    	EasyMock.verify(occupation);
    }
    /**
     * Test of mergeStats method, of class Entity.
     */
    
    @Test
    public void testMergeStats() {
        stats.mergeStats(mergeStats);
        EasyMock.expectLastCall();
        
        EasyMock.replay(stats);
        
        myEntity.mergeStats(mergeStats);
        
        EasyMock.verify(stats);
    }

    /**
     * Test of levelUp method, of class Entity.
     */
    
    @Test
    public void testLevelUp() {
       stats.levelUp();
       EasyMock.expectLastCall();
       
       EasyMock.replay(stats);
       
       myEntity.levelUp();
       
       EasyMock.verify(stats);
    }

    /**
     * Test of getMoney method, of class Entity.
     */
    
   @Test
   public void testLoseLives() {
	   stats.modLivesLeft(-1);
	   EasyMock.expectLastCall();
	   
	   EasyMock.replay(stats);
	   
	   myEntity.die();
	   
	   EasyMock.verify(stats);
   }    
}
