
package ui;

import Controllers.*;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class MainConsoleUI implements UI {

    private Controller controller;
    
    @Override
    public void startUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Controller selectUser() {
        System.out.println("SlectUser in MainConsoleUI has NOT been finished implementing.");
        return new TrainerController();
    }
    
    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
}
