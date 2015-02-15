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

    public Scene activeScene;
    private Scene gameScene, menuScene;

    public static final int GAME_SCENE = 1;
    public static final int MENU_SCENE = 2;

    public SceneManager(GameCoordinator gc, MenuCoordinator mc, InventoryCoordinator ic) {
        menuScene = new MenuScene();
        gameScene = new GameScene();
        activeScene = gameScene;
        
        //GameMap map = new GameMap();
        PlayerStats stats = new PlayerStats(3, 10, 11,
					   22,
					   5,
					   4,
					   6,
					   20,
					   30,
					   7,
					   8);
        
        gameScene.addModelObject("game", gc);
        gameScene.addModelObject("menu", mc);
        gameScene.addModelObject("inevntory", ic);
        
        menuScene.addModelObject("menu", mc);

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
}
