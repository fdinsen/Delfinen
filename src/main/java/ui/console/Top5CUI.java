package ui.console;

import Controllers.Controller;
import model.Member;
import model.TrainingTime;

public class Top5CUI extends UI {
    public Top5CUI(Controller controller) {
        this.controller = controller;
        printTop5(1);
        printTop5Dialog();
    }

    private void printTop5Dialog() {
        boolean exit = false;
        int counter;
        int input;
        do {
            printHeader();
            counter = 0;
            print("Vælg en svømmedisciplin");
            for (String discipline: controller.getAllDisciplines()){
                counter++;
                    print(counter + ". " + discipline);
            }
            printExit();
            input = getMenuInput();

            if(input < 0 || input > controller.getAllDisciplines().length){
                System.out.println(input + " Er ikke en mulighed i denne menu");
            }else if(input == 0){
                //exit
                exit = true;
            }else{
                //Have to make the user input correspond, to the actual value of the method we need to call
                switch (userOptions.get(input-1)){
                    case 1:
                        //Crawl
                        printTop5(input-1);
                        break;
                    case 2:
                        //Backcrawl
                        print("Se restance");
                        break;
                    case 3:
                        //Breaststroke
                        print("Rediger træner");
                        break;
                    case 4:
                        //Butterfly
                        print("Se stævne");
                        break;
                    default:
                        print("Der er sket en fejl, prøv igen");
                }
            }



        } while (!exit);
    }

    private void printTop5(int id) {
        int counter = 0;
        Member member;
        for(TrainingTime trainingTime : controller.getTop5(id)){
            counter++;
            member = controller.getMemberByID(trainingTime.getMemberID());
            print(counter + ". " + member.getName() + " - " + trainingTime.g)
        }
    }


}
