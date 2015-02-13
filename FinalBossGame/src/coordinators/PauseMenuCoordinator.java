package coordinators;

//Implemented as a singleton
public class PauseMenuCoordinator {
	
	
	/*--------------------- MENU STATUS ---------------------*/
	private static String currentFile = "";
	private static PauseOption currentSelection = null;
	
	/*--------------------- OTHER DATA MEMBERS ---------------------*/
	private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
	
	//Instance of singleton
	private static PauseMenuCoordinator pauseMenuCoordinator = null;
	
	/*--------------------- CONSTRUCTORS ---------------------*/
	private PauseMenuCoordinator(){
		currentSelection = PauseOption.Resume;
		
		//TODO: Add any other setup for the currentFile?
	}
	
	/*--------------------- GAME STATUS CHANGES ---------------------*/
	public void unPause(){
		scheduler.changeCoordinator(CoordinatorType.GAME);
	}
	
	
	/*--------------------- PAUSE COMMANDS ---------------------*/
	
	//TODO: Once PauseMenu object is created, add functionality
	public void confirmSelection(){
		switch (currentSelection){
			case Resume:
				scheduler.changeCoordinator(CoordinatorType.GAME);
			case Save:
				break;
			case MainMenu:
				scheduler.changeCoordinator(CoordinatorType.MAIN_MENU);
			case Exit:
				break;
		}
	}
	
	public void nextSelection(){
		switch (currentSelection){
		case Resume:
			currentSelection = PauseOption.Save;
			break;
		case Save:
			currentSelection = PauseOption.MainMenu;
			break;
		case MainMenu:
			currentSelection = PauseOption.Exit;
			break;
		case Exit:
			currentSelection = PauseOption.Resume;
			break;
		}
	}
	
	public void previousSelection(){
		switch (currentSelection){
		case Resume:
			currentSelection = PauseOption.Exit;
			break;
		case Save:
			currentSelection = PauseOption.Resume;
			break;
		case MainMenu:
			currentSelection = PauseOption.Save;
			break;
		case Exit:
			currentSelection = PauseOption.MainMenu;
			break;
		}
	}
	
	/*--------------------- GETTER/SETTER METHODS ---------------------*/	
	public String getCurrentFile(){ return currentFile; }
	public PauseOption getCurrentSelection(){ return currentSelection; }
	
	public void setCurrentFile(String fileName){ currentFile = fileName; }
	public void setCurrentSelection(PauseOption option){ currentSelection = option; }
	
	/*--------------------- SINGLETON METHODS ---------------------*/
	public static PauseMenuCoordinator getInstance() {
		if(pauseMenuCoordinator == null) {
			pauseMenuCoordinator = new PauseMenuCoordinator();
		}
		return pauseMenuCoordinator;
	}
}
