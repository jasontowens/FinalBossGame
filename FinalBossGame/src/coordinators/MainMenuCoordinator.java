package coordinators;

//Implemented as a singleton
public class MainMenuCoordinator {

	/*--------------------- DATA MEMBERS ---------------------*/
	private static MainOption currentSelection = null;
	private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
	
	//Instance of Singleton
	private static MainMenuCoordinator mainMenuCoordinator = null;
	
	private MainMenuCoordinator(){
		currentSelection = MainOption.Start;
	}
	
	
	
	/*--------------------- MAIN COMMANDS ---------------------*/
	
	//TODO: Once MainMenu object is created, add functionality
	public void confirmSelection(){
		switch (currentSelection){
		case Start:
			break;
		case Load:
			scheduler.changeCoordinator(CoordinatorType.LOAD);
			break;
		case Exit:
			break;
		}
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
	
	/*----------------Test Methods -------------------------*/
	public void setScheduler(CoordinatorScheduler sched) {
		scheduler = sched;
	}
	
	
}
