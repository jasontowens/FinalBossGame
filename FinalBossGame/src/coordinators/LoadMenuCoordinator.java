package coordinators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import map.CoordinatePair;
import map.GameMap;
import map.Pair;
import entity.Entity;
import factories.ObjectFactory;

public class LoadMenuCoordinator {
	
	/*--------------------- OTHER DATA MEMBERS ---------------------*/
	private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
	
	//Singleton Instance
	private static LoadMenuCoordinator loadMenuCoordinator = null;
	
	/*--------------------- MENU STATUS ---------------------*/
	private static int currentFileIndex = 0;
	private static String currentFile;
	private static ArrayList<String> saveFiles;
	//Might need to do file independent shit but I think java is good about it.
	private static final File saveFolder = new File("src/resources/saves/");
	private static final String fileExtension = ".xml";
	
	private GameMap loadedMap = new GameMap(30,21);
	
	private void setGameMap(GameMap map) {
		this.loadedMap = map;
	}
	
	/*--------------------- CONSTRUCTORS ---------------------*/
	private LoadMenuCoordinator(){
		saveFiles = new ArrayList<String>();
		getSaveFilesFromFileSystem();
		if(saveFiles.size() > 0) {
			currentFile = saveFiles.get(currentFileIndex);
		}
	}
	
	private static void getSaveFilesFromFileSystem() {
		for(File file : saveFolder.listFiles()) {
			if(!file.isDirectory()) {
				if(file.getName().endsWith(fileExtension)) {
					saveFiles.add(file.getAbsolutePath());
				}
			}
		}
	}
	
	public static void updateSaveFiles() {
		getSaveFilesFromFileSystem();
	}
	
	
	/*--------------------- LOAD COMMANDS ---------------------*/
	public void confirmSelection() throws ParserConfigurationException, SAXException, IOException{
		File saveFile = new File(currentFile);
		InputStream file = new FileInputStream(saveFile);
		createNewGame(file);
		scheduler.changeCoordinator(CoordinatorType.GAME);
	}
	
	private void createNewGame(InputStream file) throws ParserConfigurationException, SAXException, IOException {
		//TODO: create the new game map

				
		ObjectFactory objectFactory = new ObjectFactory(file,loadedMap);
		objectFactory.ParseFile();
		ArrayList<Pair<Entity, CoordinatePair>> entities = loadedMap.getAllEntities();
		Entity entity = entities.get(0).getLeft();
		GameCoordinator gameCoordinator = GameCoordinator.getInstance();
		gameCoordinator.setActiveMap(loadedMap);
		gameCoordinator.setAvatar(entity);
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
		updateSaveFiles();
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
		return currentFile.toString();
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
