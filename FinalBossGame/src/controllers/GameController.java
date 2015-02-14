package controllers;
import coordinators.GameCoordinator;

public class GameController extends SceneController {
	
	private static GameController gameController = null;
    private static GameCoordinator gameReceiver = GameCoordinator.getInstance();
	
	private GameController() {}
	
	public void useKey1() { // southwest
            gameReceiver.moveAvatar(1);
        }
	public void useKey2() { // south
            gameReceiver.moveAvatar(2);
        }
	public void useKey3() { // southeast
            gameReceiver.moveAvatar(3);
        }
	public void useKey4() { // west
            gameReceiver.moveAvatar(4);
        }
	public void useKey5() {
        }
	public void useKey6() { // east
            gameReceiver.moveAvatar(6);
        } 
	public void useKey7() { // northwest
            gameReceiver.moveAvatar(7);
        } 
	public void useKey8() { // north
            gameReceiver.moveAvatar(8);
        } 
	public void useKey9() { // northeast
            gameReceiver.moveAvatar(9);
        } 
	public void useKeyEnter() { // inventory
            gameReceiver.toggleInventory();
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
