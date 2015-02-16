package map;

import entity.Entity;
import item.Item;
import java.awt.Dimension;
import java.util.ArrayList;
import main.RunGame;
import gameobject.GameObject;

/**
 *
 * @author Jason Owens
 */
public class GameMap {

    private static GameMap thisMap = null;
    
    private int height; // in tiles
    private int width; // in tiles
    private ArrayList<Pair<Entity, CoordinatePair>> entitiesOnMap;
    private ArrayList<Pair<Item, CoordinatePair>> itemsOnMap;
    private Tile[][] tilesOnMap;
    private Dimension tileSize;
    private final MotionValidator mValidator;
    private Entity player;

    /*-----------CONSTRUCTORS-----------------*/
    public void takeTiles(Tile[][] map){
        this.tilesOnMap = map;
        this.width = tilesOnMap.length;
        this.height = tilesOnMap[0].length;
        this.tileSize = new Dimension(RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);        
    }
    
    private GameMap() {
        this.tileSize = new Dimension(RunGame.TILE_WIDTH, RunGame.TILE_HEIGHT);
        mValidator = MotionValidator.getInstance();
        entitiesOnMap = new ArrayList<Pair<Entity, CoordinatePair>>();
        itemsOnMap = new ArrayList<Pair<Item, CoordinatePair>>();
        
        thisMap = this; //singleton
    }

    /*-----------Singleton------------------*/
    public static GameMap getInstance() {
        if(thisMap == null) {
            //throw new Error("GameMap singleton has not yet been instatiated, you can not call it yet.");
            thisMap = new GameMap();
        }
        return thisMap;
    }
    /*------------ACCESSORS-----------------*/
    //don't use this for printing every entity
    public CoordinatePair getLocation(Entity entity) {
        for (Pair p : entitiesOnMap) {
            if (p.getLeft() == entity) {
                return (CoordinatePair) p.getRight();
            }
        }
        return null;
    }

    public CoordinatePair getLocation(Item item) {
        for (Pair p : itemsOnMap) {
            if (p.getLeft() == item) {
                return (CoordinatePair) p.getRight();
            }
        }
        return null;
    }
    
    public ArrayList<Item> findItemsByName(String name) {
    	ArrayList<Item> foundList = new ArrayList<Item>();
    	
    	for(Pair i : itemsOnMap) {
    		GameObject found = ((GameObject) i.getLeft());
    		if(found.getName().equals(name)){
    			foundList.add((Item) found);
    		}
    	}
    	
    	return foundList;
    }

    public ArrayList<Pair<Entity, CoordinatePair>> getAllEntities() {
        return entitiesOnMap;
    }

    public ArrayList<Pair<Item, CoordinatePair>> getAllItems() {
        return itemsOnMap;
    }

    public Tile[][] getAllTiles() {
        return tilesOnMap;
    }

    /*-----------MUTATORS------------------*/
    
    public void addTile(Tile tile, CoordinatePair location){
        tilesOnMap[location.getX()][location.getY()] = tile;
    }    
    
    public CoordinatePair addItem(Item item, CoordinatePair location) {
        itemsOnMap.add(new Pair<>(item, location));
        ((GameObject) item).setLocation(location);
        return location; //why?
    }

    public CoordinatePair addEntity(Entity entity, CoordinatePair location) {
        entitiesOnMap.add(new Pair<>(entity, location));
        entity.setLocation(location);
        return location; //because
    }

    public void removeItem(Item item) {
        for (int i = 0; i != itemsOnMap.size(); ++i) {
            Pair p = itemsOnMap.get(i);
            if (p.getLeft() == item) {
                itemsOnMap.remove(i);
                return;
            }
        }
    }

    public void removeEntity(Entity entity) {
        for (int i = 0; i != entitiesOnMap.size(); ++i) {
            Pair p = entitiesOnMap.get(i);
            if (p.getLeft() == entity) {
                entitiesOnMap.remove(i);
                return;
            }
        }
    }

    /*-------------------USAGE---------------*/
    public void requestMovement(Entity entity, CoordinatePair change) {
        CoordinatePair ent = getLocation(entity);
        
        CoordinatePair desired = new CoordinatePair(ent.getX() + change.getX(), ent.getY() + change.getY());

        //if terrainIsCorrect
        //           if NotOccupiedByEntity
        //                   if NotOccupiedByObstacle
        Tile t = getTileAtCoordinatePair(desired);
        System.out.println("Terrain: " + t.getTerrain());
        System.out.println("Verify movement:" +t.getTerrain().verifyMovement(entity));
        if (t.getTerrain().verifyMovement(entity)) {    //terrain is passable
            Entity entityAtDesiredLocation = getEntityAt(desired);
            if (entityAtDesiredLocation != null) {
                return;
            }
            Item itemAtDesiredLocation = getItemAt(desired);
            if (itemAtDesiredLocation != null) {  //there is an item there.
                if (itemAtDesiredLocation.activate(entity)) { //item is not an obstacle
                    Pair tmp;
                    tmp = getEntityPair(entity);
                    tmp.setRight(desired); //actually moving the entity
                    
                    //apply AreaEffect
                    AreaEffect AE = t.getAreaEffect();
                    AE.affect(entity);
                    
                } else {
                    return;
                }
            }
            
        }else{
            return;
        }
        //Move the entity in the map
        getLocation(entity).add(change);
        entity.setLocation(getLocation(entity));
    }

    //note: this method WILL MOVE the entity if it is able to.
    public CoordinatePair requestMovement(Item item, CoordinatePair change) {
        Pair itemPair = getItemPair(item);
        CoordinatePair CP = (CoordinatePair) itemPair.getRight();

        CP.add(change);//new coordinate is old coordinate plus change
        return CP;
    }

    /*--------------PRIVATE UTILITY FUNCTIONS--------------*/
    private Tile getTileAtCoordinatePair(CoordinatePair CP) {
        return tilesOnMap[CP.getY()][CP.getX()];
    }

    private Pair getEntityPair(Entity entity) {
        for (Pair p : entitiesOnMap) {
            if (p.getRight() == entity) {
                return p;
            }
        }
        return null;
    }

    private Pair getPlayerEntityPair() {
        return getEntityPair(player);
    }

    private Pair getItemPair(Item item) {
        for (Pair c : itemsOnMap) {
            if (c.getLeft() == item) {
                return c;
            }
        }
        return null;
    }

    private Item getItemAt(CoordinatePair CP) {
        for (Pair c : itemsOnMap) {
            if (c.getRight() == CP) {
                return (Item) c.getLeft();
            }
        }
        return null;
    }

    private Entity getEntityAt(CoordinatePair CP) {
        for (Pair c : entitiesOnMap) {
            if (c.getRight() == CP) {
                return (Entity) c.getLeft();
            }
        }
        return null;
    }

    /**
     * @author Chris Moscoso
     *
     * If the width of the GameMap is larger than the supported number of tiles
     * wide or the length is larger than the supported number of tiles high then
     * only return a subset of all of the tiles which is dependent on the
     * position of the player entity.
     *
     * @return a 2D array of tiles to be shown on the screen.
     */
    public Tile[][] getTilesForScreen() {
        if (width < RunGame.NUM_OF_TILES_WIDE
                && height < RunGame.NUM_OF_TILES_HIGH) {
            return this.getAllTiles();
        } else {

            CoordinatePair c = (CoordinatePair) getPlayerEntityPair().getRight();
            int startingTileX = c.getX() - (RunGame.NUM_OF_TILES_WIDE - 1);
            int startingTileY = c.getY() - (RunGame.NUM_OF_TILES_HIGH - 1);

            Tile[][] tiles = new Tile[RunGame.NUM_OF_TILES_WIDE][RunGame.NUM_OF_TILES_HIGH];
            
            for (int x = startingTileX; x < RunGame.NUM_OF_TILES_WIDE; x++) {
                for (int y = startingTileY; y < RunGame.NUM_OF_TILES_HIGH; y++) {
                    tiles[x][y] = getTileAtCoordinatePair(new CoordinatePair(x, y));
                }
            }
            return tiles;
        }

    }

    public String toXML()
    {
    	String str = "";
    	
    	for(Pair e : entitiesOnMap) {
    			str += ((Entity) e.getLeft()).toXML();
    			str += "\n";
    	}
    	
    	for(Pair i : itemsOnMap) {
    			str += ((Item) i.getLeft()).toXML();
    			str += "\n";
    	}
    	
    	return str;
    }
}
