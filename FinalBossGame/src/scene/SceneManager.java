package scene;

import stats.PlayerStats;

/**
 *
 * @author ChrisMoscoso
 */
public class SceneManager {

    public Scene activeScene;
    private Scene gameScene;

    public static final int GAME_SCENE = 1;

    public SceneManager() {
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
        
        gameScene.addModelObject("stats", stats);
    }

    public void setActiveScene(int scene) {
        switch (scene) {
            case GAME_SCENE:
                activeScene = gameScene;
                break;
            default:
                throw new IllegalArgumentException("Invalid Scene Number");
        }
    }

    public Scene getActiveScene() {
        return activeScene;
    }
}
