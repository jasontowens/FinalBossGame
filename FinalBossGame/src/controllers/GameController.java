package controllers;
import coordinators.GameCoordinator;

public class GameController extends SceneController {
	
	private static GameController gameController = null;
    private static GameCoordinator gameReceiver = GameCoordinator.getInstance();
	
	private GameController() {}
	
	public void useKey1() { // southwest
            gameReceiver.moveAvatar(1);
        }
	public void useKey2() { // south / down in Inventory
			if (gameReceiver.isInInventory()){
				gameReceiver.nextItem();
			}
			else
				gameReceiver.moveAvatar(2);
        }
	public void useKey3() { // southeast
            gameReceiver.moveAvatar(3);
        }
	public void useKey4() { // west
            gameReceiver.moveAvatar(4);
        }
	public void useKey5() {
			System.out.println("5 was pressed... not really sure what to do...");
        }
	public void useKey6() { // east
            gameReceiver.moveAvatar(6);
        } 
	public void useKey7() { // northwest
            gameReceiver.moveAvatar(7);
        } 
	public void useKey8() { // north / up in Inventory
		if (gameReceiver.isInInventory()){
			gameReceiver.previousItem();
		}
		else
            gameReceiver.moveAvatar(8);
        } 
	public void useKey9() { // northeast
            gameReceiver.moveAvatar(9);
        } 
	public void useKeyI() { // Inventory button
		gameReceiver.toggleInventory();
	}
	public void useKeyEnter() { // inventory
		if (gameReceiver.isInInventory())
            gameReceiver.activateItem();
        } 
	public void useKeyEscape() { // 
            gameReceiver.pause();
        }
	
	public static GameController getInstance() {
		if(gameController == null) {
			gameController = new GameController();
		}
		return gameController;
	}

}
