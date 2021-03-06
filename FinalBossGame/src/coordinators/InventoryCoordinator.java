package coordinators;

import item.Takeable;
import map.GameMap;
import entity.Entity;
import inventory.Armory;
import inventory.EquipSlot;
import item.Equipable;
import java.util.HashMap;

public class InventoryCoordinator {

    private int selectedItem;

    /*--------------------- OTHER DATA MEMBERS ---------------------*/
    private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
    private Entity avatar;
    //TODO
    private GameMap activeMap;// = GameMap.getInstance(); 

    //Instance of singleton
    private static InventoryCoordinator inventoryCoordinator = null;

    /*--------------------- CONSTRUCTOR ---------------------*/
    private InventoryCoordinator() {
        selectedItem = 0;
        
    }

    /*--------------------- GAME STATUS CHANGES---------------------*/
    public void exitInventory() {
        scheduler.changeCoordinator(CoordinatorType.GAME);
    }

    /*--------------------- INVENTORY COMMANDS---------------------*/
    public void nextItem() {
        //TODO: Talk to Jason about how inventory will be presented
        selectedItem = (++selectedItem) % 10;
    }

    public void previousItem() {
        if (--selectedItem == -1) {
            selectedItem = 9;
        }
    }

    public void activateItem() {
    	/*
    	switch(selectedItem) {
    	case 0:
    		avatar.useItem(0);
    		break;
    	case 1:
    		avatar.useItem(7);
    		break;
    	case 2:
    		avatar.useItem(4);
    		break;
    	case 3:
    		avatar.useItem(5);
    		break;
    	case 4:
    		avatar.useItem(6);
    		break;
    	case 5:
    		avatar.useItem(10);
    		break;
    	case 6:
    		avatar.useItem(11);
    		break;
    	case 7:
    		avatar.useItem(12);
    		break;
    	case 8:
    		avatar.useItem(13);
    		break;
    	case 9:
    		avatar.useItem(14);
    		break;
    	default :
    		break;
    	}
    	*/
        avatar.useItem(selectedItem);
    }

    public void dropItem() {
        if(selectedItem >= 5){
            avatar.dropItem(selectedItem-5);
        }
        
    }

    /*
     * @author Chris, Kyle
     */
    public Takeable getSelectedItem() {
        return getItem(selectedItem);
    }

    /*
     * @author Chris, Kyle
     */
    public Takeable getItem(int i) {
        avatar = GameMap.getInstance().getAllEntities().get(0).getLeft();
        if (i < 5) {            
            HashMap<EquipSlot, Equipable> armory = avatar.getArmory();
            switch (i) {
                case 0:
                    return armory.get(EquipSlot.HEAD);
                case 1:
                    return armory.get(EquipSlot.MAINHAND);
                case 2:
                    return armory.get(EquipSlot.CHEST);
                case 3:
                    return armory.get(EquipSlot.LEGS);
                case 4:
                    return armory.get(EquipSlot.BOOTS);
                default:
                    break;
            }
        } else {
            return avatar.getSack()[i - 5];
        }
        return null;
    }

    /*--------------------- COORDINATOR COMMANDS---------------------*/
    public static void setScheduler(CoordinatorScheduler scheduler) {
        InventoryCoordinator.scheduler = scheduler;
    }

    /*--------------------- ACCESSOR / MUTATOR METHODS ---------------------*/
    public void setAvatar(Entity avatar) {
        this.avatar = avatar;
    }

    public void setActiveMap(GameMap map) {
        this.activeMap = map;
    }

    /*--------------------- SINGLETON METHODS ---------------------*/
    public static InventoryCoordinator getInstance() {
        if (inventoryCoordinator == null) {
            inventoryCoordinator = new InventoryCoordinator();
        }
        return inventoryCoordinator;
    }

    public int getSelectedItemIndex() {
        return this.selectedItem;
    }

}
