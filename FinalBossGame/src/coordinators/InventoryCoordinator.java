package coordinators;
import map.CoordinatePair;
import map.GameMap;
import entity.Entity;
import viewport.MapViewPort;
import viewport.StatusViewPort;

public class InventoryCoordinator
{
    private int selectedItem;
    
    /*--------------------- OTHER DATA MEMBERS ---------------------*/
    private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
    private Entity avatar;
    private GameMap activeMap;
    
    //Instance of singleton
    private static InventoryCoordinator inventoryCoordinator = null;

    /*--------------------- CONSTRUCTOR ---------------------*/
    private InventoryCoordinator()
    {
        selectedItem = 0;
    }

    /*--------------------- GAME STATUS CHANGES---------------------*/
    public void exitInventory()
    {
        scheduler.changeCoordinator(CoordinatorType.GAME);
    }

    /*--------------------- INVENTORY COMMANDS---------------------*/
    public void nextItem() 
    {
        //TODO: Talk to Jason about how inventory will be presented
        selectedItem = (selectedItem + 1) % avatar.getSack().length;
    }

    public void previousItem()
    {
        selectedItem = --selectedItem;
        if(selectedItem == -1){
            selectedItem = avatar.getSack().length;
        }
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
        InventoryCoordinator.scheduler = scheduler;
    }
    
    /*--------------------- ACCESSOR / MUTATOR METHODS ---------------------*/
    public void setAvatar(Entity avatar){
        this.avatar = avatar;
    }
    public void setActiveMap(GameMap map){
        this.activeMap = map;
    }
    
    /*--------------------- SINGLETON METHODS ---------------------*/
    public static InventoryCoordinator getInstance() {
        if(inventoryCoordinator == null){
            inventoryCoordinator = new InventoryCoordinator();
        }
        return inventoryCoordinator;
    }
}