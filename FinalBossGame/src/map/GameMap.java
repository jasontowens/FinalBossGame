package map;

import entity.Entity;
import item.Item;
import java.awt.Dimension;
import java.util.ArrayList;
import map.CoordinatePair;

/**
 *
 * @author Jason Owens
 */
public class GameMap {
    
    private int length; // in tiles
    private int width; // in tiles
    
    //private CoordinatePair getLocation(Item item){return null;}
    private ArrayList<Pair<Entity,CoordinatePair>> entitiesOnMap;
    private ArrayList<Pair<Item,CoordinatePair>> itemsOnMap;
    //private ArrayList<Pair<Tile,CoordinatePair>> tilesOnMap;
    private Tile[][] tilesOnMap;
    
    private Dimension tileSize;
    
    
    GameMap(int tileWidth, int tileHeight){
        this.tileSize = new Dimension(tileWidth, tileHeight);
    }
    
    GameMap(Dimension tileSize){
        this.tileSize = tileSize;
    }
    
    //don't use this for printing every entity
    public CoordinatePair getLocation(Entity entity){
        for(Pair p: entitiesOnMap){
            if(p.getLeft() == entity){
                return (CoordinatePair)p.getRight();
            }
        }
        return null;
    } 
    
    public CoordinatePair getLocation(Item item){
        for(Pair p: itemsOnMap){
            if(p.getLeft() == item){
                return (CoordinatePair)p.getRight();
            }
        }
        return null;
    }
    
    public ArrayList<Pair<Entity,CoordinatePair>> getAllEntities( ){
        return entitiesOnMap;
    } 
    public ArrayList<Pair<Item,CoordinatePair>> getAllItems( ){
        return itemsOnMap;
    } 
    public  ArrayList<Pair<Tile,CoordinatePair>> getAllTiles( ){
        return tilesOnMap;
    }
    

    public CoordinatePair addItem(Item item,  CoordinatePair location){
        itemsOnMap.add(new Pair<Item, CoordinatePair>(item, location));
    }
    
    public void removeItem(Item item){
        for(int i =0; i!=itemsOnMap.size(); ++i){
            Pair p = itemsOnMap.get(i);
            if(p.getLeft() == item){
                itemsOnMap.remove(i);
                return;
            }
        }
    }
    public void removeEntity(Entity entity){
        for(int i =0; i!=entitiesOnMap.size(); ++i){
            Pair p = entitiesOnMap.get(i);
            if(p.getLeft() == entity){
                entitiesOnMap.remove(i);
                return;
            }
        }
    }
    public CoordinatePair requestMovement(Entity entity, CoordinatePair change){
        return null;
    }
    public CoordinatePair requestMovement(Item item , CoordinatePair change ){  
        return null;
    }
    
    
}
