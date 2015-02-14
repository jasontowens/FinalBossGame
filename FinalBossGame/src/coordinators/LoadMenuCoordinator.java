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
		/*Java does a weird thing with modulus this fixes it */
		currentFileIndex = --currentFileIndex % saveFiles.size()
				+ (currentFileIndex < 0 ? saveFiles.size() : 0);

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

	/*---------------------------TEST METHODS ----------------------*/
	public static CoordinatorScheduler getScheduler() {
		return scheduler;
	}


	public static void setScheduler(CoordinatorScheduler scheduler) {
		LoadMenuCoordinator.scheduler = scheduler;
	}


	public static LoadMenuCoordinator getLoadMenuCoordinator() {
		return loadMenuCoordinator;
	}


	public static void setLoadMenuCoordinator(
			LoadMenuCoordinator loadMenuCoordinator) {
		LoadMenuCoordinator.loadMenuCoordinator = loadMenuCoordinator;
	}


	public static int getCurrentFileIndex() {
		return currentFileIndex;
	}


	public static void setCurrentFileIndex(int currentFileIndex) {
		LoadMenuCoordinator.currentFileIndex = currentFileIndex;
	}


	public static String getCurrentFile() {
		return currentFile;
	}


	public static void setCurrentFile(String currentFile) {
		LoadMenuCoordinator.currentFile = currentFile;
	}


	public static ArrayList<String> getSaveFiles() {
		return saveFiles;
	}

	public void setSaveFiles(ArrayList<String> saveFiles) {
		LoadMenuCoordinator.saveFiles = saveFiles;
	}
	
	
	
}
