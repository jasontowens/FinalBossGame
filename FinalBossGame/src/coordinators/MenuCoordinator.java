package coordinators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;

import map.CoordinatePair;
import map.GameMap;
import map.Pair;
import menu.Menu;
import menu.Menu.MenuOption;

import org.xml.sax.SAXException;

import entity.Entity;
import factories.ObjectFactory;

import java.net.URL;

import main.RunGame;
import static main.RunGame.ml;
import scene.SceneManager;
import util.MapLoader;
import util.XMLReader;

/**
 * Handles the logic for menus.
 *
 * @author ChrisMoscoso
 */
public class MenuCoordinator {

    public static Menu mainMenu, pauseMenu, loadMenu;
    Menu currentMenu;//currently active menu

    private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
    //Instance of Singleton
    private static MenuCoordinator menuCoordinator = null;

    public MenuCoordinator() {
        //Create Main Menu
        MenuOption[] mainMenuOptions = {MenuOption.NEW_GAME, MenuOption.SWITCH_TO_LOAD_MENU, MenuOption.EXIT};
        mainMenu = new Menu(mainMenuOptions);
        //Create Load Menu
        MenuOption[] loadMenuOptions = {MenuOption.OPEN_SAVE_FILE, MenuOption.RETURN_TO_MAIN_MENU};
        loadMenu = new Menu(loadMenuOptions);
        //Create Pause Menu
        MenuOption[] pauseMenuOptions = {MenuOption.RESUME_GAME, MenuOption.RETURN_TO_MAIN_MENU, MenuOption.SAVE_FILE, MenuOption.EXIT};
        pauseMenu = new Menu(pauseMenuOptions);

        currentMenu = mainMenu;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void confirmSelection() throws ParserConfigurationException, SAXException, IOException {
        switch (currentMenu.getCurrentSelection()) {
            case NEW_GAME:
                startNewGame();
                GameCoordinator.getInstance().showPauseMenu(false);
                scheduler.changeCoordinator(CoordinatorType.GAME);
                
                break;
            case SWITCH_TO_LOAD_MENU:
                setCurrentMenu(loadMenu);
                break;
            //Load Menu options
            case OPEN_SAVE_FILE:
                //URL location = MenuCoordinator.getClass().getLocation();
                //InputStream is = RunGame.class.getResourceAsStream("/resources/saves/save1.xml");
                //File f = new File(is);
                System.out.println("OVER HERE");
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("./FinalBossGame/src/resources/saves/"));
                int choice = chooser.showOpenDialog(null);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File loadFile = chooser.getSelectedFile();
                    loadGame(loadFile);
                    System.out.println(loadFile.getPath());
                    scheduler.changeCoordinator(CoordinatorType.GAME);
                    SceneManager sm = SceneManager.getInstance();
                    sm.setActiveScene(SceneManager.GAME_SCENE);
                    GameCoordinator.getInstance().showPauseMenu(false);
                }
                break;
            //Load menu and pause menu option
            case RESUME_GAME:
                scheduler.changeCoordinator(CoordinatorType.GAME);
                SceneManager sm = SceneManager.getInstance();
                sm.setActiveScene(SceneManager.GAME_SCENE);
                GameCoordinator.getInstance().showPauseMenu(false);
                break;
            case RETURN_TO_MAIN_MENU:
                setCurrentMenu(mainMenu);
                SceneManager.getInstance().setActiveScene(SceneManager.MENU_SCENE);
                GameMap.getInstance().refresh();
                break;
            case SAVE_FILE:
            	save();
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void next() {
        currentMenu.next();
    }

    public void prev() {
        currentMenu.prev();
    }

    private void save() {
    	JFileChooser chooser = new JFileChooser();
    	chooser.setCurrentDirectory(new File("./FinalBossGame/src/resources/saves/"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(null); //MAY NOT NEED TO BE NULL		
		if(returnVal == JFileChooser.APPROVE_OPTION){
			System.out.println("Saved to the file: " + chooser.getSelectedFile().getName());
		}
		File timeToWrite = chooser.getSelectedFile();
		try{
		PrintWriter writeFile = new PrintWriter(timeToWrite);
		writeFile.println(GameMap.getInstance().toXML());
		writeFile.close();
		}
		catch(FileNotFoundException a){
			a.printStackTrace();
		}
    }

	private void startNewGame() {        
    GameMap loadedMap = GameMap.getInstance();
    loadedMap.takeTiles(main.RunGame.ml.getAllTiles());
    
    InputStream file = getClass().getResourceAsStream("/resources/saves/save1.xml");
    XMLReader reader = XMLReader.getInstance(file);
    reader.setInputStream(file);
    ObjectFactory objectFactory = new ObjectFactory(file, loadedMap);
   
        GameCoordinator gameCoordinator = GameCoordinator.getInstance();
        gameCoordinator.setActiveMap(loadedMap);
        try {
			Entity avatar = objectFactory.ParseFile();
			if(avatar == null)
				System.out.println("null avatar");
			gameCoordinator.setAvatar(avatar);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        SceneManager sm = SceneManager.getInstance();
        sm.setActiveScene(SceneManager.GAME_SCENE);

    }

    private void loadGame(File saveFile) throws ParserConfigurationException, SAXException, IOException {
        InputStream file = new FileInputStream(saveFile);
    	XMLReader reader = XMLReader.getInstance(file);
        reader.setInputStream(file);
        GameMap loadedMap = GameMap.getInstance();
        loadedMap.takeTiles(main.RunGame.ml.getAllTiles());

        ObjectFactory objectFactory = new ObjectFactory(file, loadedMap);
        GameCoordinator gameCoordinator = GameCoordinator.getInstance();
        gameCoordinator.setActiveMap(loadedMap);
        try {
			Entity avatar = objectFactory.ParseFile();
			if(avatar == null)
				System.out.println("null avatar");
			gameCoordinator.setAvatar(avatar);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void setCurrentMenu(Menu menu) {
        currentMenu = menu;
    }

    /*--------------------- SINGLETON METHODS ---------------------*/
    public static MenuCoordinator getInstance() {
        if (menuCoordinator == null) {
            menuCoordinator = new MenuCoordinator();
        }
        return menuCoordinator;
    }

    public void setScheduler(CoordinatorScheduler scheduler2) {
        this.scheduler = scheduler2;

    }

}
