package controllers;

public class GameController extends SceneController {
	
	private static GameController gameController = null;
	
	private GameController() {}
	
	public void useKey1() {}
	public void useKey2() {}
	public void useKey3() {}
	public void useKey4() {}
	public void useKey5() {}
	public void useKey6() {}
	public void useKey7() {}
	public void useKey8() {}
	public void useKey9() {}
	public void useKeyEnter() {} //is this one necessary for game play?
	public void useKeyEscape() {}
	
	public static SceneController getInstance() {
		if(gameController == null) {
			gameController = new GameController();
		}
		return gameController;
	}

}
