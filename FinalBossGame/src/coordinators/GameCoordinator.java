package coordinators;
import map.CoordinatePair;
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
    private GameCoordinator(){    }

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

    /*--------------------- INVENTORY COMMANDS---------------------*/
    public void nextItem() // upperbound?
    {
    	//TODO: Talk to Jason about how inventory will be presented
        selectedItem = (selectedItem + 1) % avatar.getSack().size();
        
    }

    public void previousItem()
    {
        selectedItem = --selectedItem % avatar.getSack().size()
        		+ (selectedItem < 0 ? avatar.getSack().size() : 0);
    }

    public void activateItem() 
    {
        avatar.useItem(selectedItem);
    }

    public void dropItem() 
    {
        avatar.dropItem(selectedItem);
    }
    
    
    /*--------------------- COORDINATOR COMMANDS---------------------*/
    public static void setScheduler(CoordinatorScheduler scheduler) {
    	GameCoordinator.scheduler = scheduler;
    }
    
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
}