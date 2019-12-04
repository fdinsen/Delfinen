package ui.console;

import ComponentValidation.*;
import Controllers.Controller;
import enums.MembershipStatus;
import enums.MembershipType;
import model.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class CreateMemberCUI extends UI {

    CreateMemberCUI(Controller controller) {
        this.controller = controller;
        createMemberDialog();
    }

    public void createMemberDialog() {
        String name = "";
        String phoneNumber = "";
        String address = "";
        String email = "";
        LocalDate birthday = null;
        int trainerID = 1;
        MembershipStatus membershipStatus = null;
        MembershipType membershipType = null;
        ArrayList<String> disciplines = new ArrayList<>();
        boolean exit = false;
        String input;

        //Name
        ValidationComponent personComponent = new NameComponent();
        do {
            printHeader();
            print("Indtast fornavn på medlem: ");
            printExit();
            input = getStringInput();

            if (input.equals("0")) {
                exit = true;
                break;
            }
        } while (!personComponent.checkComponent(input));
        if(!exit) {
            name = input;
        }

        //Phone
        if (!exit){
            personComponent = new PhoneComponent();
        do {
            printHeader();
            print("Indtast telefon nr. på medlem: ");
            printExit();
            input = getStringInput();

            if (input.equals("0")) {
                exit = true;
                break;
            }
        }while(!personComponent.checkComponent(input));
            if(!exit) {
                phoneNumber = input;
            }
    }
        //Address
        if (!exit){
            personComponent = new AddressComponent();
            do{
                printHeader();
                print("Indtast adresse informationer på medlemet (Billeshavevej 75 Korup 5210): ");
                printExit();
                input = getStringInput();

                if(input.equals("0")){
                    exit = true;
                    break;
                }
            }while (!personComponent.checkComponent(input));
            if(!exit) {
                address = input;
            }
        }

        //Birthday
        if (!exit){
            personComponent = new FullDateComponent();
            do{
                printHeader();
                print("Indtast fødselsdag, som følgende format: '05/02/1990' ");
                printExit();
                input = getStringInput();

                if(input.equals("0")){
                    exit = true;
                    break;
                }
            }while (!personComponent.checkComponent(input));
            if(!exit) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                birthday = LocalDate.parse(input, formatter);
            }
        }

        //Email
        if (!exit){
            personComponent = new EmailComponent();
            do{
                printHeader();
                print("Indtast email på medlem: ");
                printExit();
                input = getStringInput();

                if(input.equals("0")){
                    exit = true;
                    break;
                }
            }while (!personComponent.checkComponent(input));
            if(!exit) {
                email = input;
            }
        }

        //Membership type
        if (!exit){
            int counter;
            personComponent = new MembershipTypeComponent();
            do{
                counter = 0;
                printHeader();
                print("Vælg type svømmer: ");
                for(MembershipType type: MembershipType.values()){
                    counter++;
                    print(counter + ". " + type);
                }
                printExit();
                input = getStringInput();

                if(input.equals("0")){
                    exit = true;
                    break;
                }
            }while (!personComponent.checkComponent(input));
            if(!exit) {
                membershipType = MembershipType.values()[Integer.parseInt(input)-1];
            }
            //chose trainer and disciplines if membership type is competitive
            if(membershipType != null && membershipType.equals(MembershipType.COMPETITIVE)){
                //Trainer
                if (!exit){
                    boolean correct = false;
                    personComponent = new TrainerComponent();
                    String[] trainers = controller.getAllTrainers();
                    do{
                        counter = 0;
                        printHeader();
                        print("Vælg hvilken træner medlemet skal have");
                        for(String trainer: trainers){
                            counter++;
                            print(counter + ". " + trainer);
                        }
                        printExit();
                        input = getStringInput();

                        if(input.equals("0")){
                            exit = true;
                            break;
                        }else if(personComponent.checkComponent(input)){
                            //If correct input, check if correct option
                                if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > trainers.length ){
                                    //Wrong input
                                    print("Forkert input, prøv igen");
                                }else{
                                    //Correct input
                                    correct = true;
                                    break;
                                }
                            }else{
                            //Wrong input
                            print("Forkert input, prøv igen");
                        }
                    }while (!correct);
                    if(!exit) {
                        //Plus 1, as the default trainer has ID 1
                        trainerID = Integer.parseInt(input)+1;
                    }
                }
            }

            //Disciplines
            if (!exit){
                personComponent = new SwimmingDisciplinesComponent();
                IntInputComponent intValidation = new IntInputComponent();
                String[] diciplines = controller.getAllDisciplines();
                boolean correct = false;

                do{
                    counter = 0;
                    printHeader();
                    print("Vælg svømmediscipliner (eks. 1,2,4): ");
                    for(String discipline: diciplines){
                        counter++;
                        print(counter + ". " + discipline);
                    }
                    printExit();
                    input = getStringInput();

                    if(input.equals("0")){
                        exit = true;
                        break;
                    }else if(personComponent.checkComponent(input)){
                        //If correct input, check if all are correct options
                        String[] splitted = input.split(",");
                        for(String diciplinID: splitted){
                            if(Integer.parseInt(diciplinID) < 1 || Integer.parseInt(diciplinID) > diciplines.length ){
                                //Wrong input
                                print("Forkert input, prøv igen");
                                correct = false;
                                break;
                            }else{
                                //Correct input
                                correct = true;
                            }
                        }
                    }else{
                        //Wrong input
                        print("Forkert input, prøv igen");
                    }
                }while (!correct);
                if(!exit) {
                    //Splits the user answer and adds to the array
                    String[] splitted = input.split(",");
                    disciplines.addAll(Arrays.asList(splitted));
                }
            }
        }

        //Membership status
        if (!exit) {
            int counter;
            personComponent = new MembershipStatusComponent();
            do {
                counter = 0;
                printHeader();
                print("Vælg medlemskab:");
                for (MembershipStatus status : MembershipStatus.values()) {
                    counter++;
                    print(counter + ". " + status);
                }
                printExit();
                input = getStringInput();

                if (input.equals("0")) {
                    exit = true;
                    break;
                }
            } while (!personComponent.checkComponent(input));
            if (!exit) {
                membershipStatus = MembershipStatus.values()[Integer.parseInt(input) - 1];
                Member member = new Member(name,phoneNumber,address,email,birthday,trainerID,membershipStatus,membershipType,disciplines);
                controller.createMember(member);
            }
        }


    }
}
