package ui.console;

import Controllers.Controller;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Scanner;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public abstract class UI {
    protected Controller controller;
    protected ArrayList<Integer> visibleOptionsInMenu = new ArrayList<>();
    protected ArrayList<Integer> userOptions = new ArrayList<>();
    protected String[] allMenuOptions = {
        ". Opret medlem",
        ". Se Medlem",
        ". Ret Medlem",
        ". Tilføj træner",
        ". Ret træner",
        ". Se Restance",
        ". Marker som betalt",
        ". Tilføj ny træningstid",
        ". Se stævner",
        ". Tilføj stævne",
        ". Se konkurrence",
        ". Tilføj ny konkurrence",
        ". Tilføj medlem til konkurrence",
        ". Vis top 5 svømmere",
        ". Ret konkurrence",
        ". Ret stævne"
    };
    
    protected UI() {
        
    }
    
    public void print(String messageToPrint) {
        System.out.println(messageToPrint);
    }

    public int getInput() {
        System.out.print(">");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int userSelection = -1;
        try {
            userSelection = Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            System.err.println("Ugyldigt input!");
            System.out.println("Prøv igen");
        }
        return userSelection;
    }

    public int checkInputType(String input) {
        //Checks inputted string against three patterns:
        //If it is an email, the return value is 0
        //If it is a phone number, the return value is 1.
        //Finally an attempt to convert the input to an int is made
        //If it succeeds, the input must be a member_id, and 2 is returned.
        //If it none of these succeed, the return value is -1

        //The main problem with this setup is that member_ids cannot
        //be between 10 million and 99 million, since those numbers are
        //counted as phone numbers. But I doubt a swimming club will
        //ever reach that amount of members.
        String regexEmail = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
                + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:"
                + "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b"
                + "\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])"
                + "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+"
                + "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2"
                + "[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4]"
                + "[0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:"
                + "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a"
                + "\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])"
                + "+)\\])";
        String regexPhoneNumber = "([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])";
        String regexName = "[a-zA-Z ]+";
        if (Pattern.matches(regexEmail, input)) {
            return 0;
        } else if (Pattern.matches(regexPhoneNumber, input)) {
            return 1;
        } else if (input.matches(regexName)) {
            return 2;
        } else {
            try {
                Integer.parseInt(input);
                return 3;
            } catch (NumberFormatException ex) {
                return -1;
            }
        }
    }
    
    protected void setVisibleOptionsInMenu(int[] posibleOptionsInMenu) {
        for (int menuOption : posibleOptionsInMenu) {
            //Minus 1 as the database "starts" at one
            if (controller.getUserPrivileges()[menuOption] ) {
                System.out.println(menuOption);
                userOptions.add(menuOption);
                visibleOptionsInMenu.add(menuOption);
            }
        }
    }

    void printExit(){
        print("0. Exit");
    }
}
