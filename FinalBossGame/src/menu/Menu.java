

package menu;

/**
 * Maintains the state for a menu which will be queried by a ViewPort 
 * 
 * @author ChrisMoscoso
 */
public class Menu {
    
    private MenuOption[] options;
    private int selectionIndex; 
    
    public enum MenuOption{
        NEW_GAME, SWITCH_TO_LOAD_MENU, SAVE_FILE, EXIT, RESUME_GAME, OPEN_SAVE_FILE, RETURN_TO_MAIN_MENU
    }
    
    public Menu(MenuOption[] options){
        this.options = options;
        selectionIndex = 0;
    }
    
    public MenuOption[] getOptions(){
        return options;
    }
    
    public void setCurrentSelection(int selection){
        if(selectionIndex < 0){
            selectionIndex = options.length - 1;
        }
        else if(selectionIndex >= options.length){
            selectionIndex = 0;
        }else{
            selectionIndex = selection;
        }
        
    }
    
    public void next(){
        setCurrentSelection(++selectionIndex);
    }
    
    public void prev(){
        setCurrentSelection(--selectionIndex);
    }
    
    public MenuOption getCurrentSelection(){
        return options[selectionIndex];
    }
    
}
