/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import entity.Entity;
import item.Item;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Owner
 */
public class GameMapTest {
    
    public GameMapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLocation method, of class GameMap.
     */
    @Test
    public void testGetLocation_Entity() {
        System.out.println("getLocation");
        Entity entity = null;
        GameMap instance = null;
        CoordinatePair expResult = null;
        CoordinatePair result = instance.getLocation(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class GameMap.
     */
    @Test
    public void testGetLocation_Item() {
        System.out.println("getLocation");
        Item item = null;
        GameMap instance = null;
        CoordinatePair expResult = null;
        CoordinatePair result = instance.getLocation(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEntities method, of class GameMap.
     */
    @Test
    public void testGetAllEntities() {
        System.out.println("getAllEntities");
        GameMap instance = null;
        ArrayList<Pair<Entity, CoordinatePair>> expResult = null;
        ArrayList<Pair<Entity, CoordinatePair>> result = instance.getAllEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllItems method, of class GameMap.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        GameMap instance = null;
        ArrayList<Pair<Item, CoordinatePair>> expResult = null;
        ArrayList<Pair<Item, CoordinatePair>> result = instance.getAllItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllTiles method, of class GameMap.
     */
    @Test
    public void testGetAllTiles() {
        System.out.println("getAllTiles");
        GameMap instance = null;
        Tile[][] expResult = null;
        Tile[][] result = instance.getAllTiles();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class GameMap.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Item item = null;
        CoordinatePair location = null;
        GameMap instance = null;
        CoordinatePair expResult = null;
        CoordinatePair result = instance.addItem(item, location);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEntity method, of class GameMap.
     */
    @Test
    public void testAddEntity() {
        System.out.println("addEntity");
        Entity entity = null;
        CoordinatePair location = null;
        GameMap instance = null;
        CoordinatePair expResult = null;
        CoordinatePair result = instance.addEntity(entity, location);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItem method, of class GameMap.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        Item item = null;
        GameMap instance = null;
        instance.removeItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeEntity method, of class GameMap.
     */
    @Test
    public void testRemoveEntity() {
        System.out.println("removeEntity");
        Entity entity = null;
        GameMap instance = null;
        instance.removeEntity(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of requestMovement method, of class GameMap.
     */
    @Test
    public void testRequestMovement_Entity_CoordinatePair() {
        System.out.println("requestMovement");
        Entity entity = null;
        CoordinatePair change = null;
        GameMap instance = null;
        instance.requestMovement(entity, change);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of requestMovement method, of class GameMap.
     */
    @Test
    public void testRequestMovement_Item_CoordinatePair() {
        System.out.println("requestMovement");
        Item item = null;
        CoordinatePair change = null;
        GameMap instance = null;
        CoordinatePair expResult = null;
        CoordinatePair result = instance.requestMovement(item, change);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
