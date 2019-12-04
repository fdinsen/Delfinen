package ui.console;

import ComponentValidation.*;
import Controllers.Controller;
import enums.MembershipStatus;
import enums.MembershipType;
import model.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
        ArrayList<String> disciplines = null;
        boolean exit = false;
        String input;

        //Name
        PersonComponent personComponent = new NameComponent();
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
                print("Indtast vej navn og nr på medlem: ");
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
            personComponent = new BirthdayComponent();
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
                input = "";
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
            //chose trainer if membership type competitive
            if(membershipType != null && membershipType.equals(MembershipType.COMPETITIVE)){
                //Trainer
                if (!exit){
                    personComponent = new TrainerComponent();
                    do{
                        counter = 0;
                        printHeader();
                        print("Vælg hvilken træner medlemet skal have");
                        for(String trainer: controller.getAllTrainers()){
                            counter++;
                            print(counter + ". " + trainer);
                        }
                        printExit();
                        input = getStringInput();

                        if(input.equals("0")){
                            exit = true;
                            break;
                        }
                    }while (!personComponent.checkComponent(input));
                    if(!exit) {
                        trainerID = Integer.parseInt(input);
                    }
                }
            }
        }

        //Disciplines
        if (!exit){
            int counter;
            personComponent = new SwimmingDisciplinesComponent();
            do{
                counter = 0;
                printHeader();
                print("Vælg svømmediscipliner (eks. 1,2,4): ");
                for(String discipline: controller.getAllDisciplines()){
                    counter++;
                    print(counter + ". " + discipline);
                }
                printExit();
                input = getStringInput();

                if(input.equals("0")){
                    exit = true;
                    break;
                }
            }while (!personComponent.checkComponent(input));
            if(!exit) {
                disciplines = null;
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
                //controller.createMember(member);
            }
        }


    }
}
