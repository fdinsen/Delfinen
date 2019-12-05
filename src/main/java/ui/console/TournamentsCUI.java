package ui.console;

import ComponentValidation.*;
import Controllers.Controller;
import model.Tournament;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TournamentsCUI extends UI {
    int[] posibleOptionsInMenu = new int[]{10,8,9,15};

    TournamentsCUI(Controller controller) {
        this.controller = controller;
        setVisibleOptionsInMenu(posibleOptionsInMenu);
        TournamentsMenu();
    }

    private void chooseTournamentYearDialog() {
        boolean exit = false;
        String input;
        ValidationComponent validator = new YearComponent();
        do {
            printHeader();
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
                    printTournaments(input);
                }

            }

        } while (!exit);
    }

    private void chooseTournamentForCompetition() {
        boolean exit = false;
        String input;
        int inputInt;
        ArrayList<Tournament> tournaments;
        ValidationComponent validator = new YearComponent();
        do {
            printHeader();
            print("Vælg et år (eks. '2017')");
            printExit();
            input = getStringInput();
            int tournamentID;

            if(input.equals("0")){
                exit = true;
            }else if(!validator.checkComponent(input)){
                System.out.println(input + " er ikke et korrekt årstal");
            }else{
                tournaments = controller.getAllTournaments(Integer.parseInt(input));
                if(tournaments.size() == 0){
                    //No tournaments
                    print("Ingen stævner fundet");
                }else{
                    //Get user to pick which tournament
                    do{
                        printTournaments(input);
                        print("Vælg hvilket stævne du vil se konkurrencer for:");
                        printExit();
                        inputInt = getMenuInput();
                        if(inputInt == 0){
                            exit = true;
                        }else if(inputInt < 1 || inputInt > tournaments.size()){
                            //Wrong input
                            print("Ikke et tilladt input");
                        }else{
                            //Correct
                            tournamentID = tournaments.get(inputInt).getId();
                            CompetitionCUI competitionCUI = new CompetitionCUI(controller, tournamentID);
                            exit = true;
                        }
                    }while(!exit);
                }

            }

        } while (!exit);
    }

    private void TournamentsMenu() {
        boolean exit = false;
        int counter;
        int input;
        do {
            printHeader("Stævner ");
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
                    case 10:
                        //See Competition
                        chooseTournamentForCompetition();
                        break;
                    case 8:
                        //Choose year
                        chooseTournamentYearDialog();
                        break;
                    case 9:
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
        LocalDate date = null;
        String name = "";
        String location;

        //Date
        do{
            printHeader("Tilføj stævne");
            print("Indtast dato for stævne (02/10/2019)");
            printExit();
            input = getStringInput();
            validator = new FullDateComponent();
            if(input.equals("0")){
                exit = true;
                break;
            }
        }while(!validator.checkComponent(input));
        if(!exit){
            //Correct date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            date = LocalDate.parse(input, formatter);
        }

        //Name
            if(!exit) {
                do {
                    printHeader("Tilføj stævne");
                    print("Indtast navn på stævnet");
                    input = getStringInput();
                    validator = new NameComponent();
                    if(input.equals("0")){
                        exit = true;
                        break;
                    }
                } while (!validator.checkComponent(input));
                if(!exit){
                    //Correct name
                    name = input;
                }
            }

            //Location
            if(!exit){
                do {
                    printHeader("Tilføj stævne");
                    print("Indtast adressen på stævnet (Billeshavevej 75 Korup 5210)");
                    input = getStringInput();
                    validator = new AddressComponent();
                    if(input.equals("0")){
                        exit = true;
                        break;
                    }
                } while (!validator.checkComponent(input));
                if(!exit){
                    //Correct address
                    location = input;
                    Tournament tournament = new Tournament(name,date,location);
                    controller.addTournament(tournament);
                }

            }

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
