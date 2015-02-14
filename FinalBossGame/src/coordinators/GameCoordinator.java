package coordinators;
import map.GameMap;
import entity.Entity;
import viewport.MapViewPort;
import viewport.StatusViewPort;

public class GameCoordinator
{
    private boolean inInventory;
    private int selectedItem = 0;
    
    
    /*--------------------- OTHER DATA MEMBERS ---------------------*/
    private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
    private Entity avatar;
    private GameMap activeMap;
    
    //Instance of singleton
    private static GameCoordinator gameCoordinator = null;

    /*--------------------- CONSTRUCTOR ---------------------*/
    private GameCoordinator(Entity avatar, GameMap activeMap){
    	this.avatar = avatar;
    	this.activeMap = activeMap;
    }

    /*--------------------- GAME STATUS CHANGES---------------------*/
    public void toggleInventory(Entity entity)
    {
       //TODO: wait until view is implemented
    }

    public void pause()
    {
      scheduler.changeCoordinator(CoordinatorType.PAUSE);
    }

    /*--------------------- GAME COMMANDS---------------------*/

    public void moveAvatar(int currentSelection)
    {
        switch (currentSelection){
            case 1: // southwest
                --x;
                --y;
                break;
            case 2: // south
                --y;
                break;
            case 3: // southeast
                ++x;
                --y;
                break;
            case 4: // west
                --x;
                break;
            case 6: // east
                ++x;
                break;
            case 7: // northwest
                --x;
                ++y;
                break;
            case 8: // north 
                ++x;
                break;
            case 9: // northeast
                ++x;
                ++y;
                break;
	}
    }

    // inventory commands

    public void nextItem() // upperbound?
    {
        ++selectedItem;
    }

    public void previousItem()
    {
        if(selectedItem == 0)
            return;
        --selectedItem;
    }

    public void activateItem(Entity entity, int location) 
    {
        // wait for Matt to fix entity class
        entity.equipItem(location);
        entity.useItem(location);
    }

    public void dropItem(Entity entity, int location) 
    {
        entity.dropItem(location);
    }
    
    public static void setScheduler(CoordinatorScheduler scheduler) {
	GameCoordinator.scheduler = scheduler;
    }
    
  /*--------------------- SINGLETON METHODS ---------------------*/
    public static GameCoordinator getInstance() {
		if(gameCoordinator == null) {
			gameCoordinator = new GameCoordinator();
		}
		return gameCoordinator;
	}
}