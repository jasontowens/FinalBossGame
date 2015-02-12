package map;

import entity.Entity;
import item.Item;
import java.awt.Dimension;
import java.util.ArrayList;

/**
 *
 * @author ChrisMoscoso
 */
public class GameMap {
    
    private int length; // in tiles
    private int width; // in tiles
    
    
    private Dimension tileSize;
    
    
    GameMap(int tileWidth, int tileHeight){
        this.tileSize = new Dimension(tileWidth, tileHeight);
    }
    
    GameMap(Dimension tileSize){
        this.tileSize = tileSize;
    }
    
    public CoordinatePair getLocation(Entity entity){
        return null;
    } 
    
    public CoordinatePair getLocation(Item item){return null;}
    public ArrayList<Pair<Entity,CoordinatePair>> getAllEntities( ){return null;} 
    public ArrayList<Pair<Item,CoordinatePair>> getAllItems( ){return null;} 
    public  ArrayList<Pair<Tile,CoordinatePair>> getAllTiles( ){return null;}
    

    public CoordinatePair addItem(Item item,  CoordinatePair location){return null;}
    public void addTile(Tile tile, CoordinatePair location){}
    public void removeItem(Item item){}
    public void removeEntity(Entity entity){};
    public CoordinatePair requestMovement(Entity entity, CoordinatePair change){return null;
}
    public CoordinatePair requestMovement(Item item , CoordinatePair change ){return null;
}
    
    
}
