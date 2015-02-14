package coordinators;

import java.util.ArrayList;

public class LoadMenuCoordinator {
	
	/*--------------------- OTHER DATA MEMBERS ---------------------*/
	private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
	
	//Singleton Instance
	private static LoadMenuCoordinator loadMenuCoordinator = null;
	
	/*--------------------- MENU STATUS ---------------------*/
	private static int currentFileIndex = 0;
	private static String currentFile = "";
	private static ArrayList<String> saveFiles;
	
	
	/*--------------------- CONSTRUCTORS ---------------------*/
	private LoadMenuCoordinator(){
		/*Need to read from some directory */
		//Commenting this out for now. Need to finalize this. Otherwise this breaks everything.
		//saveFiles = new ArrayList<String>();
		//currentFile = saveFiles.get(currentFileIndex);
	}
	
	
	/*--------------------- LOAD COMMANDS ---------------------*/
	public void confirmSelection(){
		//TODO: Send selected filename to appropriate interface, change coordinator to game
	}
	
	public void nextSelection(){
		currentFileIndex = (currentFileIndex + 1) % saveFiles.size(); //increment index by 1 while keeping within list size indices
		currentFile = saveFiles.get(currentFileIndex);
	}
	
	public void previousSelection(){
		currentFileIndex = (currentFileIndex - 1) % saveFiles.size(); //decrement index by 1 while keeping within list size indices
		currentFile = saveFiles.get(currentFileIndex);
	}
	
	
	
	/*--------------------- OTHER METHODS ---------------------*/
	public void backToMainMenu(){
		scheduler.changeCoordinator(CoordinatorType.MAIN_MENU);
	}
	
	/*--------------------- SINGLETON METHODS ---------------------*/
	public static LoadMenuCoordinator getInstance() {
		if(loadMenuCoordinator == null) {
			loadMenuCoordinator = new LoadMenuCoordinator();
		}
		return loadMenuCoordinator;
	}
}
