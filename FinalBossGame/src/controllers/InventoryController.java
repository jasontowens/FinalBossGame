
package controllers;
import coordinators.GameCoordinator;
import coordinators.InventoryCoordinator;

public class InventoryController extends SceneController {
	
    private static InventoryController inventoryController = null;
    private static InventoryCoordinator inventoryReceiver = InventoryCoordinator.getInstance();
	
	private InventoryController() {} 
	
	public void useKey2() // move down in inventory
	{
		inventoryReceiver.nextItem();
        }

	public void useKey8() // move up in inventory
	{
		inventoryReceiver.previousItem();
        } 

        public void useKey5() // backspace/delete
	{
		inventoryReceiver.dropItem();
	}

	public void useKeyI() // go back to Game
	{
		inventoryReceiver.exitInventory();
                GameCoordinator.getInstance().showInventory(false);
	}

	public void useKeyEnter() // use item 
	{
            inventoryReceiver.activateItem();
        }
	
	public static InventoryController getInstance() {
		if(inventoryController == null) {
			inventoryController = new InventoryController();
		}
		return inventoryController;
	}
	
	public void setInventoryCoordinator(InventoryCoordinator coord) {
		inventoryReceiver = coord;
	}
}