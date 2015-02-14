package scene;

import viewport.ViewPort;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import main.RunGame;

/**
 *
 * @author ChrisMoscoso
 */
public abstract class Scene {
    
    ArrayList<ViewPort> viewports = new ArrayList<ViewPort>();
    HashMap<String, Object> modelObjects = new HashMap<String, Object>();
    
    
    public BufferedImage getImage(){
        BufferedImage i = new BufferedImage(RunGame.WIDTH , RunGame.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        for(ViewPort v : viewports){
            v.drawGraphics(i.getGraphics());
        }
        return i;
    }
    
    public void addModelObject(String name, Object modelObj){
        modelObjects.put(name, modelObj);
    }
    
    public Object getModelObject(String name){
        return modelObjects.get(name);
    }
    
}
