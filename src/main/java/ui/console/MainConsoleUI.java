package ui.console;

import Controllers.*;
import datasource.DataSource;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class MainConsoleUI extends UI {
            
    private final DataSource datasource;
    
    public MainConsoleUI(DataSource datasource) {
        this.datasource = datasource;
        
    }

    public void startUI(Controller controller) {
        MainMenuUI mainMenuUI = new MainMenuUI(controller);
    }

    public Controller selectUser() {
        boolean finished = false;
        while(!finished) {
            print("Vælg en bruger profil");
            print("-------------------------");
            print("1. - Kaserer");
            print("2. - Træner");
            print("3. - Formand");
            
            int input = getMenuInput();
            
            if (input != -1) {
                return new Controller(datasource, input);
            }
            print("\n-------------------------");
            print("Fejl, prøv igen.");
        } 
        //Should never be reached.
        //If it does, something has gone horribly wrong
        print("Something has gone horribly wrong😱");
        return null;
    }
}
