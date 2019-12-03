package ui.console;

import ComponentValidation.PersonComponent;
import ComponentValidation.nameComponent;
import Controllers.Controller;

public class CreateMemberCUI extends UI {

    CreateMemberCUI(Controller controller) {
        this.controller = controller;
        createMemberDialog();
    }

    public void createMemberDialog() {
        boolean exit = false;
        String input;
        PersonComponent personComponent = new nameComponent();
        do {
            printHeader();
            print("Indtast fornavn på medlem: ");
            printExit();
            input = getStringInput();
            
            if(input == "0"){
                exit = true;
            }
        } while (personComponent.checkComponent(input) );
    }
}
