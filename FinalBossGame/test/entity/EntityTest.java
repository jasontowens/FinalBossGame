/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import inventory.EquipSlot;
import item.Equipable;
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
    
    public EntityTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        inventory = EasyMock.createNiceMock(Inventory.class);
        occupation = EasyMock.createNiceMock(Occupation.class);
        myEntity = new Entity("Jason", "A BAMF.", "Not/a/real/filepath.png", MotionType.GROUND, inventory, new Occupation(), new PlayerStats(), new GameMap(10,10));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dropItem method, of class Entity.
     */
    @Test
    public void testDropItem() {
        System.out.println("dropItem");
        int location = 0;
        Entity instance = null;
        instance.dropItem(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of useItem method, of class Entity.
     */
    @Test
    public void testUseItem() {
        System.out.println("useItem");
        int location = 0;
        Entity instance = null;
        instance.useItem(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Entity.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        CoordinatePair change = null;
        Entity instance = null;
        instance.move(change);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class Entity.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Takeable item = null;
        Entity instance = null;
        instance.addItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equipItem method, of class Entity.
     */
    @Test
    public void testEquipItem() {
        System.out.println("equipItem");
        Equipable item = null;
        Entity instance = null;
        boolean expResult = false;
        boolean result = instance.equipItem(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItem method, of class Entity.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        Takeable item = null;
        Entity instance = null;
        instance.removeItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeMoney method, of class Entity.
     */
    @Test
    public void testChangeMoney() {
        System.out.println("changeMoney");
        int change = 0;
        Entity instance = null;
        boolean expResult = false;
        boolean result = instance.changeMoney(change);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMoney method, of class Entity.
     */
    @Test
    public void testSetMoney() {
        System.out.println("setMoney");
        int newAmount = 0;
        Entity instance = null;
        boolean expResult = false;
        boolean result = instance.setMoney(newAmount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOccupation method, of class Entity.
     */
    @Test
    public void testSetOccupation() {
        System.out.println("setOccupation");
        String occupationName = "";
        Entity instance = null;
        instance.setOccupation(occupationName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mergeStats method, of class Entity.
     */
    @Test
    public void testMergeStats() {
        System.out.println("mergeStats");
        Stats modifiers = null;
        Entity instance = null;
        instance.mergeStats(modifiers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of levelUp method, of class Entity.
     */
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
    @Test
    public void testSetMotionType() {
        System.out.println("setMotionType");
        MotionType myMotion2 = null;
        Entity instance = null;
        instance.setMotionType(myMotion2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
