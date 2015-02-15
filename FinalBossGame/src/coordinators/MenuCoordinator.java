package coordinators;

import java.io.File;
import javax.swing.JFileChooser;
import menu.Menu;
import menu.Menu.MenuOption;

/**
 * Handles the logic for menus.
 *
 * @author ChrisMoscoso
 */
public class MenuCoordinator {

    Menu mainMenu, pauseMenu, loadMenu;
    Menu currentMenu;//currently active menu

    private static CoordinatorScheduler scheduler = CoordinatorScheduler.getInstance();
    //Instance of Singleton
    private static MenuCoordinator menuCoordinator = null;

    public MenuCoordinator() {
        //Create Main Menu
        MenuOption[] mainMenuOptions = {MenuOption.NEW_GAME, MenuOption.LOAD_GAME, MenuOption.EXIT};
        mainMenu = new Menu(mainMenuOptions);
        //Create Load Menu
        MenuOption[] loadMenuOptions = {MenuOption.OPEN_SAVE_FILE, MenuOption.RETURN_TO_MAIN_MENU};
        loadMenu = new Menu(loadMenuOptions);
        //Create Pause Menu
        MenuOption[] pauseMenuOptions = {MenuOption.RESUME_GAME, MenuOption.RETURN_TO_MAIN_MENU, MenuOption.EXIT};
        pauseMenu = new Menu(pauseMenuOptions);
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void confirmSelection() {
        switch (currentMenu.getCurrentSelection()) {
            case NEW_GAME:
                startNewGame();
                break;
            case LOAD_GAME:
                setCurrentMenu(loadMenu);
                break;
            case OPEN_SAVE_FILE:
                JFileChooser chooser = new JFileChooser("./resources");
                int choice = chooser.showOpenDialog(null);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File loadFile = chooser.getSelectedFile();
                    loadGame(loadFile);
                }
                break;
            case RESUME_GAME:
                scheduler.changeCoordinator(CoordinatorType.GAME);
                break;
            case RETURN_TO_MAIN_MENU:
                setCurrentMenu(mainMenu);
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    private void startNewGame(){
        
    }
    
    private void loadGame(File f){
        
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

}
