package map;

import entity.Entity;
import item.Item;
import java.awt.Dimension;
import java.util.ArrayList;

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
    private Tile[][] tilesOnMap;
    
    private final Dimension tileSize;
    
    private final MotionValidator mValidator;
    
    GameMap(int tileWidth, int tileHeight){
        this.tileSize = new Dimension(tileWidth, tileHeight);
        mValidator = MotionValidator.getInstance();
    }
    
    GameMap(Dimension tileSize){
        this.tileSize = tileSize;
        mValidator = MotionValidator.getInstance();
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
    public  Tile[][] getAllTiles( ){
        return tilesOnMap;
    }
    
    
    

    public CoordinatePair addItem(Item item,  CoordinatePair location){
        itemsOnMap.add(new Pair<>(item, location));
        return location; //why?
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
    private Tile tileAtCoordinatePair(CoordinatePair CP){
        return tilesOnMap[CP.getX()][CP.getY()];
    }
    
    private Pair getEntityPair(Entity entity){
        for(Pair p: entitiesOnMap){
            if(p.getRight() == entity)
                return p;
        }
        return null;
    }
    private Pair getItemPair(Item item){
        for(Pair c: itemsOnMap){
            if(c.getLeft() == item){
                return c;
            }
        }
        return null;
    }
    
    private Item getItemAt(CoordinatePair CP){
        for(Pair c: itemsOnMap){
            if(c.getRight() == CP){
                return (Item)c.getLeft();
            }
        }
        return null;
    }
    
    private Entity getEntityAt(CoordinatePair CP){
        for(Pair c: entitiesOnMap){
            if(c.getRight() == CP){
                return (Entity)c.getLeft();
            }
        }
        return null;
    }
    
    
    //note: this method WILL MOVE the entity if it is able to.
    public void requestMovement(Entity entity, CoordinatePair change){
        CoordinatePair ent = getLocation(entity);
       
        
        CoordinatePair desired = new CoordinatePair(ent.getX()+change.getX(),ent.getY()+change.getY());
        
        //if terrainIsCorrect
        //           if NotOccupiedByEntity
        //                   if NotOccupiedByObstacle
        
        
        Tile t = tileAtCoordinatePair(desired);
        if(t.getTerrain().verifyMovement(entity)){    //terrain is passable
            Entity entityAtDesiredLocation = getEntityAt(desired);
            if(entityAtDesiredLocation != null){
                return;
            }
            Item itemAtDesiredLocation = getItemAt (desired);
            if(itemAtDesiredLocation != null){  //there is an item there.
                if(itemAtDesiredLocation.activate(entity)){ //item is not an obstacle
                    Pair tmp;
                    tmp = getEntityPair(entity);
                    tmp.setRight(desired); //actually moving the entity
                }
                else{
                    //return;
                }
            }
            
        }
    }
    public CoordinatePair requestMovement(Item item, CoordinatePair change ){  
        Pair itemPair = getItemPair(item);
        CoordinatePair CP = (CoordinatePair)itemPair.getRight();
        
        CP.add(change);//new coordinate is old coordinate plus change
        return CP;
    }
    
    
}
