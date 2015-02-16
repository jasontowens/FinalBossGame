package coordinators;
import map.CoordinatePair;
import map.GameMap;
import entity.Entity;
import scene.SceneManager;
import viewport.MapViewPort;
import viewport.StatusViewPort;

public class GameCoordinator
{
    /*--------------------- OTHER DATA MEMBERS ---------------------*/
    private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
    private Entity avatar;
    private GameMap activeMap;
    private Boolean showInventory = false, showPauseMenu = false;

    public Boolean isShowInventory() {
        return showInventory;
    }

    public Boolean isShowPauseMenu() {
        return showPauseMenu;
    }
    
    
    //Instance of singleton
    private static GameCoordinator gameCoordinator = null;

    /*--------------------- CONSTRUCTOR ---------------------*/
    private GameCoordinator(){}

    /*--------------------- GAME STATUS CHANGES---------------------*/
    public void inventory()
    {
       scheduler.changeCoordinator(CoordinatorType.INVENTORY);
       showInventory = true;
    }

    public void pause()
    {
      scheduler.changeCoordinator(CoordinatorType.MENU);
      MenuCoordinator.getInstance().setCurrentMenu(MenuCoordinator.pauseMenu);
      showPauseMenu = true;
    }

    public void showPauseMenu(){
        showPauseMenu =false;
    }
    /*--------------------- GAME COMMANDS---------------------*/

    public void moveAvatar(int currentSelection)
    {
    	CoordinatePair movement;
        switch (currentSelection){
            case 1: // southwest
            	movement = new CoordinatePair(-1, -1);
                break;
            case 2: // south
            	movement = new CoordinatePair(0, -1);
                break;
            case 3: // southeast
                movement = new CoordinatePair(1, -1);
                break;
            case 4: // west
                movement = new CoordinatePair(-1, 0);
                break;
            case 6: // east
                movement = new CoordinatePair(1, 0);
                break;
            case 7: // northwest
                movement = new CoordinatePair(-1, 1);
                break;
            case 8: // north 
            	movement = new CoordinatePair(0, 1);
                break;
            case 9: // northeast
            	movement = new CoordinatePair(1, 1);
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
    public void setAvatar(Entity avatar){
    	this.avatar = avatar;
    }
    public void setActiveMap(GameMap map){
    	this.activeMap = map;
    }
    
    /*--------------------- SINGLETON METHODS ---------------------*/
    public static GameCoordinator getInstance() {
		if(gameCoordinator == null) {
			gameCoordinator = new GameCoordinator();
		}
		return gameCoordinator;
	}

    public GameMap getActiveMap() {
        return this.activeMap;
    }

    void showPauseMenu(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
