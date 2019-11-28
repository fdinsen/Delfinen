package ui;

import Controllers.*;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class MainConsoleUI extends UI {

    private Controller controller;

    public void startUI(Controller controller) {
        print("Du er nu en " + controller);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Controller selectUser() {
        boolean finished = false;
        while(!finished) {
            print("Vælg en bruger profil");
            print("-------------------------");
            print("1. - Kaserer");
            print("2. - Træner");
            print("3. - Formand");
            
            int input = getInput();
            
            if (input != -1) {
                switch(input) {
                    case 1:
                        return new BookkeeperController();
                    case 2:
                        return new TrainerController();
                    case 3:
                        return new ChairmanController();
                    default:
                        print("error");
                    
                }
            }
        } 
        //Should never be reached.
        //If it does, something has gone horribly wrong
        print("Something has gone horribly wrong😱");
        return null;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

}
