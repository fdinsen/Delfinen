package ui.console;

import ComponentValidation.FullDateComponent;
import ComponentValidation.ValidationComponent;
import ComponentValidation.YearComponent;
import Controllers.Controller;
import model.Tournament;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TournamentsCUI extends UI {
    int[] posibleOptionsInMenu = new int[]{9,15};

    TournamentsCUI(Controller controller) {
        this.controller = controller;
        setVisibleOptionsInMenu(posibleOptionsInMenu);
        chooseTournamentDialog();
    }

    private void chooseTournamentDialog() {
        boolean exit = false;
        int counter;
        String input;
        ValidationComponent validator = new YearComponent();
        do {
            counter = 0;
            print("Vælg et år (eks. '2017')");
            printExit();
            input = getStringInput();

            if(input.equals("0")){
                exit = true;
            }else if(!validator.checkComponent(input)){
                System.out.println(input + " er ikke et korrekt årstal");
            }else{
                if(controller.getAllTournaments(Integer.parseInt(input)).size() == 0){
                    //No tournaments
                    print("Ingen stævner fundet");
                }else{
                    seeTournamentsDialog(input);
                }

            }

        } while (!exit);
    }

    private void seeTournamentsDialog(String year) {
        boolean exit = false;
        int counter;
        int input;
        do {
            printTournaments(year);
            counter = 0;
            for (int option : visibleOptionsInMenu) {
                counter++;
                print(counter + allMenuOptions[option]);
            }
            printExit();
            input = getMenuInput();

            if (input < 0 || input > visibleOptionsInMenu.size()) {
                print(input + " Er ikke en mulighed i denne menu");
            } else if (input == 0) {
                //exit
                exit = true;
            } else {
                //Have to make the user input correspond, to the actual value of the method we need to call
                switch (userOptions.get(input - 1)) {
                    case 8:
                        //Create Tournament
                        printAddTournamentDialog();
                        break;
                    case 15:
                        //Edit Tournament
                        printEditTournamentDialog();
                        break;
                    default:
                        print("Der er sket en fejl, prøv igen");
                }
            }
        } while (!exit);
    }

    private void printEditTournamentDialog() {
        printHeader("Rediger stævne");
    }

    private void printAddTournamentDialog() {
        boolean exit = false;
        ValidationComponent validator;
        String input;
        LocalDate date;

        //Date
        do{
            printHeader("Tilføj stævne");
            print("Indtast dato for stævne (02/10/2019)");
            input = getStringInput();
            validator = new FullDateComponent();
            if(input.equals("0")){
                exit = true;
            }else if(!validator.checkComponent(input)){
                //Correct date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                date = LocalDate.parse(input, formatter);
            }
        }while(!exit);
    }

    private void printTournaments(String year) {
        int counter = 0;
        printHeader("Stævner ");
        print("Stævner:");
        for (Tournament tournament : controller.getAllTournaments(Integer.parseInt(year))) {
            counter++;
            print("\t" + counter + ". " + tournament.getName() + " - " + tournament.getLocation() + " - " + tournament.getDate());
        }
    }
}
