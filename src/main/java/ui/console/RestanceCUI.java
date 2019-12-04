package ui.console;

import Controllers.Controller;
import model.Member;

import java.util.ArrayList;

public class RestanceCUI extends UI {
    int[] posibleOptionsInMenu = new int[]{6};
    RestanceCUI(Controller controller) {
        this.controller = controller;
        setVisibleOptionsInMenu(posibleOptionsInMenu);
        printRestanceMenu();
    }

    public void printRestanceMenu(){
        boolean exit = false;
        int counter;
        int input;
        do {
            printAllRestance();
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
                    case 6:
                        //Mark as paid
                        printEditRestanceDialog();
                        break;
                    default:
                        print("Der er sket en fejl, prøv igen");
                }
            }



        } while (!exit);

    }

    public void printEditRestanceDialog(){
        boolean exit = false;
        int input;
        do {
            printAllRestance();
            print("Hvem har betalt?");
            printExit();
            input = getMenuInput();

            if(input == 0){
                //exit
                exit = true;
            }else{
                //Set as paid
                ArrayList<Member> members = controller.getAllRestance();
                int memberID = members.get(input-1).getMemberId();
                controller.markAsPaid(memberID);
                exit = true;
            }
        } while (!exit);

    }

    public void printAllRestance(){
        int counter = 0;
        printHeader("Medlemer med restance");
        if(controller.getAllRestance().size() != 0){
            for(Member member: controller.getAllRestance()){
                counter++;
                print(counter + ". " + member.getName() + " - " + member.getPhone() + " -  Skylder: " + member.getSubscription() + " kr.");
            }
        }else{
            print("Ingen medlemmer i restance");
        }

        print("-------");
    }
}
