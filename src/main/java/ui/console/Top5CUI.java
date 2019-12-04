package ui.console;

import Controllers.Controller;
import model.Member;
import model.TrainingTime;

class Top5CUI extends UI {
    Top5CUI(Controller controller) {
        this.controller = controller;
        printTop5Dialog();
    }

    private void printTop5Dialog() {
        boolean exit = false;
        int counter;
        int input;
        do {
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
                //Show top 5
                printTop5(input);
            }

        } while (!exit);
    }

    private void printTop5(int id) {
        boolean exit = false;
        int counter = 0;
        Member member;
        do {
            printHeader("Top 5 " + controller.getAllDisciplines()[id-1]);
            print(" ---- Format: Min:Sek:Ms");
            for (TrainingTime trainingTime : controller.getTop5(id)) {
                counter++;
                member = controller.getMemberByID(trainingTime.getMemberID());
                print(counter + ". " + member.getName() + " - " + trainingTime.getTimeInMinutes());
            }
            printExit();
            if(getMenuInput() == 0){
                exit = true;
            }
        }while(!exit);
    }


}
