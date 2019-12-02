
package ui.console;

import Controllers.Controller;
import java.util.ArrayList;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class MainMenuUI extends UI {
    private int[] posibleOptionsInMenu = new int[]{1,4,5,8,13,3};
    
    public MainMenuUI(Controller controller) {
        this.controller = controller;
        setVisibleOptionsInMenu(posibleOptionsInMenu);
        printMainMenu();
    }
    
    public void printMainMenu(){
        Boolean exit = false;
        int counter = 0;
        String StringMenu = "";
        do {
            for (int option: visibleOptionsInMenu){
                counter++;
                print(counter + allMenuOptions[option]);
            }
            printExit();
            getInput();
        } while (!exit);
        
    }

    
    
    
    private void printExit(){
        print("0. Exit");
    }
}
