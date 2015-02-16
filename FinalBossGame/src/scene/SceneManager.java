package scene;

import coordinators.GameCoordinator;
import coordinators.InventoryCoordinator;
import coordinators.MenuCoordinator;
import stats.PlayerStats;

/**
 *
 * @author ChrisMoscoso
 */
public class SceneManager {

    private static SceneManager sceneManager = null;
    
    public Scene activeScene;
    private Scene gameScene, menuScene;

    public static final int GAME_SCENE = 1;
    public static final int MENU_SCENE = 2;

    private SceneManager() {
        menuScene = new MenuScene();
        gameScene = new GameScene();
        activeScene = menuScene;
       
        
        /*gameScene.addModelObject("game", GameCoordinator.getInstance());
        gameScene.addModelObject("menu", MenuCoordinator.getInstance());
        gameScene.addModelObject("inevntory", InventoryCoordinator.getInstance());
        
        menuScene.addModelObject("menu", MenuCoordinator.getInstance());*/

    }

    public void setActiveScene(int scene) {
        switch (scene) {
            case GAME_SCENE:
                activeScene = gameScene;
                break;
            case MENU_SCENE:
                activeScene = menuScene;
            default:
                throw new IllegalArgumentException("Invalid Scene Number");
        }
    }

    public Scene getActiveScene() {
        return activeScene;
    }
    
    public static SceneManager getInstance(){
        if(sceneManager == null){
            sceneManager = new SceneManager();
        }
        return sceneManager;
    }

}
