package map;

import entity.Entity;
import entity.MotionType;

public class MotionValidator {
    private static MotionValidator validator = null;
    public static MotionValidator getInstance() {
            if(validator == null) {
                    validator = new MotionValidator();
            }
            return validator;
    }
    /**
     * checks terrain of desired tile and checks for obstacles
     * @author Jason Owens
     * @param entityToMove 
     * @return boolean whether or not the Entity can move in the direction it's facing (change Entity Direction before calling)
     */
    public boolean canTraverse(Entity entityToMove) {
        MotionType entityMotion = entityToMove.getMotionType();
        
        
        if(!correctMotionType(entityMotion, ))



        return false;
    }
    /**
     * checks terrain of desired tile and checks for obstacles
     * @author Jason Owens
     * @param entityMotion 
     * @return boolean whether or not the Entity's MotionType is good enough for the terrain
     */    
    private boolean correctMotionType(MotionType entityMotion, MotionType terrainMotion){
        switch(entityMotion) {
            case GROUND:
                    switch(terrainMotion) {
                            case GROUND:
                                    return true;
                            case WATER:
                                    return false;
                            case UNATTAINABLE:
                                    return false;
                    }

                    return false;
            case WATER:
                    switch(terrainMotion) {
                            case GROUND:
                                    return true;
                            case WATER:
                                    return true;
                            case UNATTAINABLE:
                                    return false;
                    }

                    return false;
            case UNATTAINABLE:
                    return false;
        }
        return false; //shouldn't ever reach this
    }
}