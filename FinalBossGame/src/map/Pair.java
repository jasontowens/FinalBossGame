package map;

/**
 *
 * @author ChrisMoscoso
 */
public class Pair<T0, T1> {
    T0 left;
    T1 right;
    public Pair(T0 l, T1 r){
        left = l;
        right = r;        
    }
    public void setLeft(T0 l){
        left = l;
    }
    public void setRight(T1 r){
        right = r;
    }
    
    
    public T0 getLeft(){
        return left;
    }
    public T1 getRight(){
        return right;
    }
    
}
