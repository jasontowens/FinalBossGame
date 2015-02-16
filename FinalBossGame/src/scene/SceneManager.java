package scene;

import coordinators.CoordinatorScheduler;
import coordinators.CoordinatorType;
import coordinators.GameCoordinator;
import coordinators.InventoryCoordinator;
import coordinators.MenuCoordinator;
import stats.PlayerStats;
import util.Observer;

/**
 *
 * @author ChrisMoscoso
 */
public class SceneManager implements Observer {

    private static SceneManager sceneManager = null;
    private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();

    public Scene activeScene;
    private Scene gameScene, menuScene;

    public static final int GAME_SCENE = 1;
    public static final int MENU_SCENE = 2;

    private SceneManager() {
        menuScene = new MenuScene();
        gameScene = new GameScene();
        activeScene = menuScene;
        scheduler.registerObserver(this);

    }

    public void setActiveScene(int scene) {
        switch (scene) {
            case GAME_SCENE:
                activeScene = gameScene;
                break;
            case MENU_SCENE:
                activeScene = menuScene;
                break;
            default:
                throw new IllegalArgumentException("Invalid Scene Number");
        }
    }

    public Scene getActiveScene() {
        return activeScene;
    }

    public static SceneManager getInstance() {
        if (sceneManager == null) {
            sceneManager = new SceneManager();
        }
        return sceneManager;
    }

    @Override
    public void Notify() {
        
        System.out.println(scheduler.getCoordinatorType());
        
        
        switch (scheduler.getCoordinatorType()) {
            case GAME:
                setActiveScene(SceneManager.GAME_SCENE);
                break;
            case MENU:
                activeScene = menuScene;
                break;
            case INVENTORY:
                setActiveScene(SceneManager.GAME_SCENE);
                break;
            default:
                throw new IllegalArgumentException("Error in scene manager notify");
        }
    }

}
