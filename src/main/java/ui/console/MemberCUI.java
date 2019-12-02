package ui.console;

import Controllers.Controller;
import model.Member;

import java.util.ArrayList;

public class MemberCUI extends UI{
    private int[] posibleOptionsInMenu = new int[]{1,4,5,8,13,3};

    public MemberCUI(Controller controller) {
        this.controller = controller;
        setVisibleOptionsInMenu(posibleOptionsInMenu);
        findMember();
    }

    private void findMember() {
        boolean exit = false;
        String input = "";
        Member member;
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
                        printMember(member);
                        printUserMenu();
                        exit = true;
                        break;
                    case 1:
                        //Phonenumber
                        member = chooseUser(controller.getMemberByPhone(input));
                        printMember(member);
                        printUserMenu();
                        exit = true;
                        break;
                    case 2:
                        //name
                        member = chooseUser(controller.getMemberByName(input));
                        printMember(member);
                        printUserMenu();
                        exit = true;
                        break;
                    default:
                        print("Prøv igen, dit input ser ud til at være forkert");
                        break;
                }
            }
        }while (!exit);
    }

    private void printMember(Member member) {
            print(member.getName());
        getMenuInput();
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
                        case 1:
                            //See member
                            print("Se medlem");
                            break;
                        case 5:
                            //Se restance
                            print("Se restance");
                            break;
                        case 4:
                            //edit trainer
                            print("Rediger træner");
                            break;
                        case 8:
                            //see tournament
                            print("Se stævne");
                            break;
                        case 13:
                            //show top 5
                            print("Vis top 5");
                            break;
                        case 3:
                            //create trainer
                            print("Lav træner");
                            break;

                        default:
                            print("Der er sket en fejl, prøv igen");
                    }
                }
            } while (!exit);

        }
}
