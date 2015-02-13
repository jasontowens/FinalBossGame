package map;

/**
 *
 * @author ChrisMoscoso
 */
class CoordinatePair {
    private int x;
    private int y;
    
    public CoordinatePair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void set( int nextX, int nextY){
        this.x = nextX;
        this.y = nextY;
    }
    public void setX(int nextX){
        this.x = nextX;
    }
    public void setY(int nextY){
        this.y = nextY;
    }
    public void add(int addedX, int addedY){
        this.x += addedX;
        this.y += addedY;
    }
    public void addX(int addedX){
        this.x += addedX;    
    }
    public void addY(int addedY){
        this.y += addedY;
    }
}
