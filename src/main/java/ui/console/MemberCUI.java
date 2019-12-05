package ui.console;

import ComponentValidation.FullDateComponent;
import Controllers.Controller;
import model.Member;
import model.Times;
import model.TrainingTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MemberCUI extends UI {

    private int[] posibleOptionsInMenu = new int[]{1, 0, 2, 7};
    private String[] swimmingDisciplines;

    public MemberCUI(Controller controller) {
        this.controller = controller;
        setVisibleOptionsInMenu(posibleOptionsInMenu);
        swimmingDisciplines = controller.getAllDisciplines();
        userDialog();
    }

    public void userDialog() {
        printUserMenu(0);
        printExit();
    }

    private Member findMember() {
        Member member = null;
        boolean exit = false;
        String input;
        ArrayList members = new ArrayList<>();

        do {
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

    private void printMember(Member member) {
        printHeader();
        String trainer = controller.getTrainerName(member.getTrainerId());
        print("Navn: " + member.getName());
        print("Telefon nr: " + member.getPhone());
        print("Adresse: " + member.getAddress());
        print("Email: " + member.getEmail());
        print("Fødselsdag: " + member.getBirthday());
        print("Hold: " + member.getTeamType());
        if (!(member.getTrainerId() == 1));
        {
            print("Træner: " + trainer);
        }

        if (member.getMemberDisciplines().size() > 0) {
            print("Svømmediscipliner");
            for (String discString : member.getMemberDisciplines()) {
                print("\t" + discString);
            }
        } else {
            print("Svømmediscipliner: INGEN");
        }

        print("Medlemskab: " + member.getMembershipStatus());
        print("Medlemstype: " + member.getMembershipType());
        print("Restance: " + member.getSubscription());
        print("Træningstider: ");
        printTrainingTimes(member.getMemberId());

    }
    
    private void printTrainingTimes(int memberID){
                ArrayList<TrainingTime> trainingTimes = controller.getMemberTimes(memberID);
        if (trainingTimes != null && trainingTimes.size() != 0) {
            print("\t\t format: mm:ss:ms");
            for (TrainingTime trainingTime : trainingTimes) {
                print("\t" + swimmingDisciplines[trainingTime.getSwimmingDiscipline() - 1] + " - Tid: " + trainingTime.getTimeInMinutes()
                        + " - Dato: " + trainingTime.getDate());
            }
        }else{
            print("\tIngen træningstider for denne bruger");
        }
    }

    //So user can select which member he wishes to see, if the member search returns more than one
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

    //memberID should be set to member id if the member have just been printed out to the user, else 0
    //So we know which options to show to the user
    private void printUserMenu(int memberID) {
        boolean exit = false;
        int counter;
        int input;
        do {
            printHeader();
            counter = 0;
            for (int option : visibleOptionsInMenu) {
                counter++;
                if (option == 1 && memberID != 0) {
                    print(counter + ". Se andet medlem");
                } else if (option == 7) {
                    if (memberID != 0) {
                        print(counter + allMenuOptions[option]);
                    }
                } else {
                    print(counter + allMenuOptions[option]);
                }
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
                    case 2:
                        //Remove member
                        deleteMember();
                        //exit = true;
                        break;
                    case 0:
                        //Create member
                        CreateMemberCUI createMemberCUI = new CreateMemberCUI(controller);
                        //exit = true;
                        break;

                    case 7:
                        //Add training time to member
                        addTrainingTimeToMember(memberID);
                        printMember(controller.getMemberByID(memberID));
                        //exit = true;
                        break;
                    case 1:
                        //see member
                        printHeader("Find medlem");
                        Member member = findMember();
                        if (member == null) {
                            //User has "exited" from findmember
                            printUserMenu(0);
                        } else {
                            printMember(member);
                            printUserMenu(member.getMemberId());
                        }
                        exit = true;
                        break;
                    default:
                        print("Der er sket en fejl, prøv igen");
                }
            }
        } while (!exit);
    }

    public void deleteMember() {
        boolean exit = false;
        Member member;
        do {
            printHeader("Slet et medlem");
            System.err.println("Hver sikker på du vil slette medlemmet, da det ikke kan gøres om!");
            member = findMember();
            if (member != null) {
                //Found user delete
                controller.deleteMember(member.getMemberId());
                exit = true;
            } else {
                //User exited
                exit = true;
            }
        } while (!exit);

    }

    private void addTrainingTimeToMember(int memberID) {
        boolean exit = false;
        LocalDate date;
        int TimeInMs = 0;
        int disciplineID ;

        //Training Time
        printHeader("Tilføj Trænings Tid - Dato");
        date = getDateInput();
        if (date == null) {
            //Exit
            exit = true;
        }

        //Training time
        if (!exit) {
            printHeader("Tilføj Trænings Tid - Tid");
            TimeInMs = getTimeInput();
            if (TimeInMs == 0) {
                //Exit
                exit = true;
            }
        }

        //Discipline
        if (!exit) {
            printHeader("Tilføj Trænings Tid - Disciplin");
            disciplineID = getDisciplineIDInput();
            //If not 0, correct number
            if (!(disciplineID == 0)) {    
                TrainingTime trainingTime = new TrainingTime(memberID, date, TimeInMs, disciplineID);
                controller.addTime(trainingTime);
            }

        }

    }

    private LocalDate getDateInput() {
        FullDateComponent dateValidator = new FullDateComponent();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String input;
        //Keeps going untill it correct or user exits
        do {
            print("Indtast dato (18/02/2004):");
            printExit();
            input = getStringInput();
            if (input.equals("0")) {
                return null;
            } else if (dateValidator.checkComponent(input)) {
                //Correct date
                return LocalDate.parse(input, formatter);
            }
        } while (true);

    }

    private int getTimeInput() {
        String input;
        do {
            print("Indtast tid (mm:ss:mss)");
            printExit();
            input = getStringInput();

            if (input.equals("0")) {
                return 0;
            } else {
                int temp = Times.convertToMS(input);
                print("" + temp);
                if (temp != -1) {
                    //Correct date
                    return temp;
                }
            }
        } while (true);

    }

    private int getDisciplineIDInput() {
        int inputInt;
        int counter;
        do {
            counter = 0;
            for (String str : swimmingDisciplines) {
                counter++;
                print(counter + ". " + str);
            }
            print("Vælg svømmeDisciplin");
            printExit();
            inputInt = getMenuInput();

            if (inputInt == 0) {
                return 0;
            } else if (inputInt >= 1 && inputInt <= swimmingDisciplines.length) {
                //Correct input
                return inputInt;
            }
        } while (true);
    }

}
