package coordinators;

import map.CoordinatePair;
import map.GameMap;
import entity.Entity;
import scene.SceneManager;

public class GameCoordinator {
    /*--------------------- OTHER DATA MEMBERS ---------------------*/

    private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
    private Entity avatar;
    private GameMap activeMap;
    private Boolean showInventory = false, showPauseMenu = false;

    public Boolean isShowInventory() {
        return showInventory;
    }

    //Instance of singleton
    private static GameCoordinator gameCoordinator = null;

    /*--------------------- CONSTRUCTOR ---------------------*/
    private GameCoordinator() {
    }

    /*--------------------- GAME STATUS CHANGES---------------------*/
    public void inventory() {
        scheduler.changeCoordinator(CoordinatorType.INVENTORY);
        showInventory = true;
    }

    public void pause() {
        scheduler.changeCoordinator(CoordinatorType.MENU);
        MenuCoordinator.getInstance().setCurrentMenu(MenuCoordinator.pauseMenu);
        //In this case we want to stay in the game scene
        SceneManager sm = SceneManager.getInstance();
        sm.setActiveScene(SceneManager.GAME_SCENE);
        showPauseMenu = true;
    }

    public Boolean showPauseMenu() {
        return this.showPauseMenu;
    }
    /*--------------------- GAME COMMANDS---------------------*/

    public void moveAvatar(int currentSelection) {
        CoordinatePair movement;
        switch (currentSelection) {
            case 1: // southwest
                movement = new CoordinatePair(-1, -1);
                avatar.setID(87);
                break;
            case 2: // south
                movement = new CoordinatePair(0, 1);
                avatar.setID(85);
                break;
            case 3: // southeast
                movement = new CoordinatePair(1, -11);
                avatar.setID(99);
                break;
            case 4: // west
                movement = new CoordinatePair(-1, 0);
                avatar.setID(96);
                break;
            case 6: // east
                movement = new CoordinatePair(1, 0);
                avatar.setID(97);
                break;
            case 7: // northwest
                movement = new CoordinatePair(-1, 1);
                avatar.setID(98);
                break;
            case 8: // north 
                movement = new CoordinatePair(0, -1);
                avatar.setID(86);
                break;
            case 9: // northeast
                movement = new CoordinatePair(1, 1);
                avatar.setID(88);
                break;
            default: // no movement
                movement = new CoordinatePair(0, 0);
                break;
        }
        avatar.move(movement);
    }

    /*--------------------- COORDINATOR COMMANDS---------------------*/
    public static void setScheduler(CoordinatorScheduler scheduler) {
        GameCoordinator.scheduler = scheduler;
    }

    /*--------------------- ACCESSOR / MUTATOR METHODS ---------------------*/
    public void setAvatar(Entity avatar) {
        this.avatar = avatar;
    }

    public void setActiveMap(GameMap map) {
        this.activeMap = map;
    }

    /*--------------------- SINGLETON METHODS ---------------------*/
    public static GameCoordinator getInstance() {
        if (gameCoordinator == null) {
            gameCoordinator = new GameCoordinator();
        }
        return gameCoordinator;
    }

    public GameMap getActiveMap() {
        return this.activeMap;
    }

    void showPauseMenu(boolean b) {
        this.showPauseMenu = b;
    }
}
