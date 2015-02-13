package coordinators;

//Implemented as a singleton
public class MainMenuCoordinator {

	private static MainOption currentSelection = null;
	
	//Instance of Singleton
	private static MainMenuCoordinator mainMenuCoordinator = null;
	
	private MainMenuCoordinator(){
		currentSelection = MainOption.Start;
	}
	
	
	
	/*--------------------- MAIN COMMANDS ---------------------*/
	
	//is this a void or a bool?
	public void confirmSelection(){
		//TODO: Not really sure what occurs here
	}
	
	public void nextSelection(){
		switch (currentSelection){
			case Start:
				currentSelection = MainOption.Load;
				break;
			case Load:
				currentSelection = MainOption.Exit;
				break;
			case Exit:
				currentSelection = MainOption.Start;
				break;
		}
	}
	
	public void previousSelection(){
		switch (currentSelection){
			case Start:
				currentSelection = MainOption.Exit;
				break;
			case Load:
				currentSelection = MainOption.Start;
				break;
			case Exit:
				currentSelection = MainOption.Load;
				break;
		}
	}
	
	public MainOption getCurrentSelection() {
		return currentSelection;
	}
	
	public void setCurrentSelection(MainOption option) {
		currentSelection = option;
	}
	
	/*--------------------- SINGLETON METHODS ---------------------*/
	public static MainMenuCoordinator getInstance() {
		if(mainMenuCoordinator == null) {
			mainMenuCoordinator = new MainMenuCoordinator();
		}
		return mainMenuCoordinator;
	}
	
}
