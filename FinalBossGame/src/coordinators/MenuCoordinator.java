package coordinators;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
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
                scheduler.changeCoordinator(CoordinatorType.GAME);
                GameCoordinator.getInstance().showPauseMenu(false);
                break;
            case SWITCH_TO_LOAD_MENU:
                setCurrentMenu(loadMenu);
                break;
            //Load Menu options
            case OPEN_SAVE_FILE:
                //URL location = MenuCoordinator.getClass().getLocation();
                InputStream is = RunGame.class.getResourceAsStream("/resources/saves/save1.xml");
                //File f = new File(is);
                JFileChooser chooser = new JFileChooser("/resources/levels");
                int choice = chooser.showOpenDialog(null);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File loadFile = chooser.getSelectedFile();
                    loadGame(loadFile);
                    System.out.println(loadFile.getPath());
                    scheduler.changeCoordinator(CoordinatorType.GAME);
                    SceneManager sm = SceneManager.getInstance();
                    sm.setActiveScene(SceneManager.GAME_SCENE);
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
                break;
            case SAVE_FILE:

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

    private void saveFile() {
        JFileChooser chooser = new JFileChooser("/resources/levels");
        int choice = chooser.showOpenDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File saveFile = chooser.getSelectedFile();
            /***** TO DO: SAVE TO FILE ****/
        }
    }

    private void startNewGame() {
        InputStream is = RunGame.class.getResourceAsStream("/resources/levels/level 1.xml");
        ml = MapLoader.getInstance(is);

        GameMap loadedMap = GameMap.getInstance();

        GameCoordinator gameCoordinator = GameCoordinator.getInstance();
        gameCoordinator.setActiveMap(loadedMap);
        SceneManager sm = SceneManager.getInstance();
        sm.setActiveScene(SceneManager.GAME_SCENE);

    }

    private void loadGame(File saveFile) throws ParserConfigurationException, SAXException, IOException {
        InputStream file = new FileInputStream(saveFile);

        GameMap loadedMap = GameMap.getInstance();

        ObjectFactory objectFactory = new ObjectFactory(file, loadedMap);
        objectFactory.ParseFile();
        ArrayList<Pair<Entity, CoordinatePair>> entities = loadedMap.getAllEntities();
        //Entity entity = entities.get(0).getLeft();
        GameCoordinator gameCoordinator = GameCoordinator.getInstance();
        gameCoordinator.setActiveMap(loadedMap);
        //gameCoordinator.setAvatar(entity);    
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
