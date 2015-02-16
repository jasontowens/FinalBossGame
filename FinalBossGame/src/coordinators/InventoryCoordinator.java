package coordinators;
import item.Takeable;
import map.GameMap;
import entity.Entity;

public class InventoryCoordinator
{
    private int selectedItem;
    
    /*--------------------- OTHER DATA MEMBERS ---------------------*/
    private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
    private Entity avatar;
    //TODO
    private GameMap activeMap;// = GameMap.getInstance(); 
    
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
        selectedItem = (++selectedItem) % (avatar.getSack().length+ avatar.getArmory().size());
    }

    public void previousItem()
    {
        if(--selectedItem == -1){
            selectedItem = avatar.getSack().length + avatar.getArmory().size();
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
    
    public Takeable getSelectedItem() {
    	//TODO if necessary
    	/*
    	if(selectedItem < avatar.getArmory().size()) {
    		return avatar.getArmory().g
    	}
    	if(selectedItem())
    	*/
    	return null;
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