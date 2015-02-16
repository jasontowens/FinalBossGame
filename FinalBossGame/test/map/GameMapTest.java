/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import entity.Entity;
import entity.MotionType;
import entity.Occupation;
import inventory.Inventory;
import item.Equipable;
import item.Item;
import item.Takeable;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import stats.PlayerStats;
import stats.Stats;

/**
 *
 * @author Owner
 */
public class GameMapTest {
    private Tile[][] tiles;
    private Entity testEntity;
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
        for(int i = 0; i != 10;++i){
            for(int j = 0; j != 20;++j){
                tiles[i][j] = EasyMock.createNiceMock(Tile.class);
            }
        }
        GameMap map = new GameMap(tiles);
        inventory = EasyMock.createNiceMock(Inventory.class);
        occupation = EasyMock.createNiceMock(Occupation.class);
        stats = EasyMock.createNiceMock(PlayerStats.class);
        map = EasyMock.createNiceMock(GameMap.class);

        item = EasyMock.createNiceMock(Takeable.class);
        coordinate = EasyMock.createNiceMock(CoordinatePair.class);
        mergeStats = EasyMock.createNiceMock(Stats.class);
        equip = EasyMock.createNiceMock(Equipable.class);
        testEntity = new Entity("Jason", "A perso", "Not/a/real/filepath.png",
        		MotionType.GROUND, inventory, occupation, stats, map);
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of getLocation method, of class GameMap.
     */
    @Test
    public void testGetLocation_Entity() {
        
        CoordinatePair coordinate = new CoordinatePair(5,5);
        EasyMock.expect(map.addEntity(testEntity, coordinate)).andReturn(coordinate);
        //EasyMock.
        
        
        
        EasyMock.expect(inventory.removeItem(location)).andReturn(item);
        EasyMock.expect(map.getLocation(myEntity)).andReturn(coordinate);
        
        EasyMock.replay(map);
        EasyMock.replay(inventory);
        
        myEntity.dropItem(location);
        
        EasyMock.verify(map);
        EasyMock.verify(inventory);
        
        System.out.println("getLocation");
        Entity entity = testEntity;
        GameMap instance = map;
        CoordinatePair expResult = new CoordinatePair(5,5);
        CoordinatePair result = instance.getLocation(entity);
        assertEquals(expResult, result);
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
