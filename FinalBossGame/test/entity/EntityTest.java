/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import inventory.EquipSlot;
import item.Equipable;
import item.Item;
import item.Takeable;

import java.util.ArrayList;
import java.util.HashMap;

import map.CoordinatePair;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import stats.PlayerStats;
import stats.Stats;
import map.GameMap;
import inventory.Inventory;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

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
        myEntity = new Entity("Jason", "A perso", "Not/a/real/filepath.png",
        		MotionType.GROUND, inventory, occupation, stats, map);
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
        
    }

    /**
     * Test of levelUp method, of class Entity.
     */
    /*
    @Test
    public void testLevelUp() {
        System.out.println("levelUp");
        Entity instance = null;
        instance.levelUp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMoney method, of class Entity.
     */
    /*
    @Test
    public void testGetMoney() {
        System.out.println("getMoney");
        Entity instance = null;
        int expResult = 0;
        int result = instance.getMoney();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMotionType method, of class Entity.
     */
    /*
    @Test
    public void testGetMotionType() {
        System.out.println("getMotionType");
        Entity instance = null;
        MotionType expResult = null;
        MotionType result = instance.getMotionType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStats method, of class Entity.
     */
    /*
    @Test
    public void testGetStats() {
        System.out.println("getStats");
        Entity instance = null;
        PlayerStats expResult = null;
        PlayerStats result = instance.getStats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOccupation method, of class Entity.
     */
    /*
    @Test
    public void testGetOccupation() {
        System.out.println("getOccupation");
        Entity instance = null;
        Occupation expResult = null;
        Occupation result = instance.getOccupation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArmory method, of class Entity.
     */
    /*
    @Test
    public void testGetArmory() {
        System.out.println("getArmory");
        Entity instance = null;
        HashMap<EquipSlot, Equipable> expResult = null;
        HashMap<EquipSlot, Equipable> result = instance.getArmory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSack method, of class Entity.
     */
    /*
    @Test
    public void testGetSack() {
        System.out.println("getSack");
        Entity instance = null;
        ArrayList<Takeable> expResult = null;
        ArrayList<Takeable> result = instance.getSack();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMotionType method, of class Entity.
     */
    /*
    @Test
    public void testSetMotionType() {
        System.out.println("setMotionType");
        MotionType myMotion2 = null;
        Entity instance = null;
        instance.setMotionType(myMotion2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
}
