package ui.console;

import Controllers.Controller;
import model.Member;

import java.util.ArrayList;

public class MemberCUI extends UI{
    private int[] posibleOptionsInMenu = new int[]{1,0,2};

    public MemberCUI(Controller controller) {
        this.controller = controller;
        setVisibleOptionsInMenu(posibleOptionsInMenu);
        userDialog();
    }

    public void userDialog(){
        printUserMenu();
        printExit();
    }

    private Member findMember() {
        Member member = null;
        boolean exit = false;
        String input = "";
        do {
            printHeader();
            print("Indtast tlf. nr., email eller navn på en bruger");
            printExit();
            input = getStringInput();

            if(input.equals("0")){
                exit = true;
            }else{
                switch (checkInputType(input)) {
                    case 0:
                        //Email
                        member = chooseUser(controller.getMemberByEmail(input));
                        exit = true;
                        break;
                    case 1:
                        //Phonenumber
                        member = chooseUser(controller.getMemberByPhone(input));
                        exit = true;
                        break;
                    case 2:
                        //name
                        member = chooseUser(controller.getMemberByName(input));
                        exit = true;
                        break;
                    default:
                        print("Prøv igen, dit input ser ud til at være forkert");
                        break;
                }
            }
        }while (!exit);
        return member;
    }

    private void printMember(Member member) {
            printHeader();
            print("Navn: " + member.getName());
            print("Telefon nr: " + member.getPhone());
            print("Adresse: " + member.getAddress());
            print("Email: " + member.getEmail());
            print("Fødselsdag: " + member.getBirthday());
            print("Træner: NOT IMPLEMENTED");
            print("Medlemskab: " + member.getMembershipStatus());
            print("Medlemstype: " + member.getMembershipType());
            print("Restance: NOT IMPLEMENTED");
            print("");

    }

    //So user can select which member he wishes to see, if the member search returns more than one
    private Member chooseUser(ArrayList<Member> members) {
        if(members.size() == 1){
            //Only one member
            return members.get(0);
        }else{
            //Multiple members, let the user decide
            //TODO
            return members.get(0);
        }
    }


    public void printUserMenu(){
            boolean exit = false;
            int counter;
            int input;
            do {
                printHeader();
                counter = 0;
                for (int option: visibleOptionsInMenu){
                    counter++;
                    print(counter + allMenuOptions[option]);
                }
                printExit();
                input = getMenuInput();

                if(input < 0 || input > visibleOptionsInMenu.size()){
                    print(input + " Er ikke en mulighed i denne menu");
                }else if(input == 0){
                    //exit
                    exit = true;
                }else{
                    //Have to make the user input correspond, to the actual value of the method we need to call
                    switch (userOptions.get(input-1)){
                        case 2:
                            //Edit member
                            print("Ret medlem");
                            exit = true;
                            break;
                        case 0:
                            //Create member
                            print("Tilføj medlem");
                            exit = true;
                            break;
                        case 1:
                            //see member
                            Member member = findMember();
                            printMember(member);
                            exit = true;
                            break;
                        default:
                            print("Der er sket en fejl, prøv igen");
                    }
                }
            } while (!exit);

        }
}