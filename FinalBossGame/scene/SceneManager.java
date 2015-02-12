package scene;

import javax.imageio.ImageIO;

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
