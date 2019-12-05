/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;

import ComponentValidation.TimeComponent;
import ComponentValidation.ValidationComponent;
import Controllers.Controller;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Competition;
import model.CompetitionTime;
import model.Member;
import model.Times;
import model.Tournament;

/**
 *
 * @author gamma
 */
public class CompetitionCUI extends UI {

    private int[] possibleOptionsInMenu = new int[]{10, 11, 12};
    private Tournament tournament;
    String[] disciplines;

    public CompetitionCUI(Controller controller, Tournament tournament) {
        this.controller = controller;
        this.tournament = tournament;
        setVisibleOptionsInMenu(possibleOptionsInMenu);
        disciplines = controller.getAllDisciplines();
        printCompetitionMenu(null);
    }

    private void printCompetitionMenu(Competition comp) {
        boolean exit = false;
        int counter;
        int input;
        do {
            counter = 0;
            printHeader(
                    tournament.getName() + " " + tournament.getDate().getYear());
            if (comp != null) {
                print("Du har valgt konkurrencen:");
                print("1. "
                        + disciplines[comp.getSwimmingDiscipline() - 1]);
                printHeader();
            }
            for (int option : visibleOptionsInMenu) {
                counter++;
                if (option == 10) {
                    print(counter + ". Se en konkurrence");
                } else {
                    print(counter + allMenuOptions[option]);
                }
            }
            printExit();
            input = getMenuInput();

            if (input < 0 || input > visibleOptionsInMenu.size() + 1) {
                print(input + " Er ikke en mulighed i denne menu");
            } else if (input == 0) {
                exit = true;
            } else {
                switch (userOptions.get(input - 1)) {
                    case 10:
                        //Se konkurrence
                        comp = seeCompetition();
                        if (comp == null) {
                            printCompetitionMenu(null);
                            //User has exited without selecting
                        } else {
                            printCompetition(comp);
                            printCompetitionMenu(comp);
                        }
                        exit = true;
                        break;
                    case 11:
                        //Tilføj ny konkurrence
                        addNewCompMenu();
                        break;
                    case 12:
                        //Tilføj medlem til konkurrence
                        addMemberToCompMenu(comp);
                        break;
                }
            }
        } while (!exit);

    }

    private Competition seeCompetition() {
        Competition comp = null;
        boolean exit = false;
        int input;
        ArrayList<Competition> competitions
                = controller.getAllCompetitions(tournament.getId());

        do {
            printHeader();
            printAllCompetitionsInTournament(competitions);
            printExit();
            input = getMenuInput();
            if (input == 0) {
                exit = true;
            } else if (input < competitions.size() + 1) {
                comp = competitions.get(input - 1);
                exit = true;
            } else {
                print(input + " er ikke en gyldig mulighed her.");
            }

        } while (!exit);
        return comp;
    }

    private void printAllCompetitionsInTournament(ArrayList<Competition> comps) {
        int counter = 1;
        String line;
        print("Konkurrencer:");

        if (comps.size() != 0) {
            for (Competition comp : comps) {
                line = "";
                line += counter + " ";
                line += disciplines[comp.getSwimmingDiscipline() - 1];
                print("\t" + line);
                counter++;
            }
        } else {
            print("Der er ingen konkurrencer i dette stævne");
        }

    }

    private void printCompetition(Competition competition) {
        printHeader();

        Member member;
        String discipline = disciplines[competition.getSwimmingDiscipline() - 1];
        ArrayList<CompetitionTime> times
                = controller.getAllTimes(competition.getCompetitionsId());
        if (times.size() != 0) {
            for (CompetitionTime time : times) {
                member = controller.getMemberByID(time.getMemberID());
                print(member.getName() + ": " + time.getTimeInMinutes());
            }
        } else {
            print("Der er ingen tider på denne konkurrence");
        }
        print("");

    }

    private void addMemberToCompMenu(Competition comp) {
        if (comp == null) {
            comp = seeCompetition();
        }
        if (comp != null) {
            Member member = findMember();
            if (member != null) {
                printHeader();
                boolean exit = false;
                ValidationComponent timeInput = new TimeComponent();
                do {
                    print("Hvad var " + member.getName() + "s tid?");
                    print("(mm:ss:mss)");
                    printExit();
                    String input = getStringInput();
                    int timeMS = Times.convertToMS(input);
                    if (input.equals("0")) {
                        exit = true;
                    } else if (timeMS == -1) {
                        //Input passer ikke
                    } else {
                        String[] times = input.split(":");
                        int timeInMS = 0;
                        timeInMS += Integer.parseInt(times[0]) * 60 * 1000;
                        timeInMS += Integer.parseInt(times[1]) * 1000;
                        timeInMS += Integer.parseInt(times[2]);
                        CompetitionTime ctime = new CompetitionTime(
                                comp.getCompetitionsId(), member.getMemberId(), timeInMS);
                        controller.addTime(ctime);
                        comp = null;
                        exit = true;
                        print(member.getName() + "s tid er blevet tilføjet");
                    }

                } while (!exit);
            }
        }
    }

    private void addNewCompMenu() {
        Competition comp;
        boolean exit = false;
        int swimmingDisciplineId;
        int counter;

        printHeader();
        do {
            counter = 1;
            for (String discipline : disciplines) {
                print(counter + " " + discipline);
                counter++;
            }
            print("Hvilken disciplin?");
            printExit();
            int input = getMenuInput();
            if (input == 0) {
                exit = true;
            } else if (input > disciplines.length) {
                print("Ugyldigt input");
            } else {
                swimmingDisciplineId = input - 1;
                comp = new Competition(
                        tournament.getId(), swimmingDisciplineId);
                controller.addCompetition(comp);
                exit = true;
            }
        } while (!exit);

    }

    //De næste to metoder er kopieret fra MemberCUI
    //Det er ikke en pæn løsning at gentage koden, det ved jeg godt,
    //men det er for sent til at jeg kan komme på en anden løsning
    //lad os diskutere andre muligheder i morgen, torsdag.
    private Member findMember() {
        Member member = null;
        boolean exit = false;
        String input = "";
        ArrayList<Member> members = new ArrayList<>();

        do {
            printHeader();
            print("Indtast tlf. nr., email eller navn på en bruger");
            printExit();
            input = getStringInput();

            if (input.equals("0")) {
                exit = true;
            } else {
                switch (checkInputType(input)) {
                    case 0:
                        //Email
                        members = controller.getMemberByEmail(input);
                        break;
                    case 1:
                        //Phonenumber
                        members = controller.getMemberByPhone(input);
                        break;
                    case 2:
                        //name
                        members = controller.getMemberByName(input);
                        break;
                    default:
                        print("Prøv igen, dit input ser ud til at være forkert");
                        break;
                }
                if (members.isEmpty()) {
                    //No member found
                    print("Der kunne ikke findes en bruger på " + input);
                } else {
                    member = chooseUser(members);
                    exit = true;
                }
            }
        } while (!exit);
        return member;
    }

    private Member chooseUser(ArrayList<Member> members) {
        if (members.size() == 1) {
            //Only one member
            return members.get(0);
        } else {
            //Multiple members, let the user decide
            int counter;
            boolean exit = false;
            int input;
            do {
                counter = 0;
                print("Vælg en bruger");
                printHeader();
                for (Member member : members) {
                    counter++;
                    print(counter + ". " + member.getName() + " - " + member.getPhone());
                }
                printExit();

                //gets user input and if correct choice, returns the member
                input = getMenuInput();
                if (input == 0) {
                    return null;
                } else if (input < 0 || input > members.size()) {
                    print("Er ikke en bruger");
                    print("Prøv igen");
                } else {
                    return members.get(input - 1);
                }
            } while (!exit);

            return members.get(0);
        }
    }
}
