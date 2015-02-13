package coordinators;

//Implemented as a singleton
public class PauseMenuCoordinator {
	
	
	/*--------------------- MENU STATUS ---------------------*/
	private static String currentFile = "";
	private static PauseOption currentSelection = null;
	
	//Instance of singleton
	private static PauseMenuCoordinator pauseMenuCoordinator = null;
	
	/*--------------------- CONSTRUCTORS ---------------------*/
	private PauseMenuCoordinator(){
		currentSelection = PauseOption.Resume;
		
		//TODO: Add any other setup for the currentFile?
	}
	
	/*--------------------- GAME STATUS CHANGES ---------------------*/
	public void unPause(){
		//TODO: 
	}
	
	
	/*--------------------- PAUSE COMMANDS ---------------------*/
	public void confirmSelection(){
		
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
