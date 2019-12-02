
package ui.console;

import Controllers.Controller;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class MainMenuUI extends UI {
    private Controller controller;
    protected MainMenuUI(Controller controller) {
        this.controller = controller;
    }
    
    public void printMainMenu(){
        Boolean exit = false;
        int counter = 0;
        String StringMenu = "";
        do {
            if(controller.getUserPrivileges()[2]){
                counter++;
                StringMenu += counter + ". Medlemmer\n";
            }
            
            if(controller.getUserPrivileges()[6]){
                counter++;
                StringMenu += counter + ". Restance\n";
            }
            
            if(controller.getUserPrivileges()[9]){
                counter++;
                StringMenu += counter + ". Stævner\n";
            }
            
            if(controller.getUserPrivileges()[14]){
                counter++;
                StringMenu += counter + ". Top 5 tider\n";
            }
            
            if(controller.getUserPrivileges()[4] || controller.getUserPrivileges()[5]){
                counter++;
                StringMenu += counter + ". Tilføj/Ret Træner\n";
            }
            printExit();
        } while (!exit);
        
    }
    
    private void printExit(){
        print("0. Exit");
    }
}
