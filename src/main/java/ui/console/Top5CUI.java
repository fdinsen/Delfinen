package ui.console;

import Controllers.Controller;
import java.util.ArrayList;
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
        String[] svimmingDicStrings = controller.getAllDisciplines();
        ArrayList<TrainingTime> top5Junior = controller.getTop5Junior(id);
        ArrayList<TrainingTime> top5Senior = controller.getTop5Senior(id);
        do {
            printHeader("Top 5 Junior: " + svimmingDicStrings[id-1]);
            
            if(top5Junior != null && top5Junior.size() != 0){
                print("\tFormat: Min:Sek:Ms");
            for (TrainingTime trainingTime : controller.getTop5Junior(id)) {
                counter++;
                member = controller.getMemberByID(trainingTime.getMemberID());
                print(counter + ". " + member.getName() + " - " + trainingTime.getTimeInMinutes());
            }
            }else{
                print("Ingen tider fundet");
            }
            print("");
            printHeader("Top 5 Senior: " + svimmingDicStrings[id-1]);
            if(top5Senior != null && top5Senior.size() != 0){
            print("\tFormat: Min:Sek:Ms");
            for (TrainingTime trainingTime : controller.getTop5Senior(id)) {
                counter++;
                member = controller.getMemberByID(trainingTime.getMemberID());
                print(counter + ". " + member.getName() + " - " + trainingTime.getTimeInMinutes());
            }
            }else{
                print("Ingen tider fundet");
            }
            print("");
            printExit();
            if(getMenuInput() == 0){
                exit = true;
            }
        }while(!exit);
    }


}
