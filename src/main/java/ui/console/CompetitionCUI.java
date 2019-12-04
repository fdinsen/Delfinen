/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.console;

import Controllers.Controller;
import java.util.ArrayList;
import model.Competition;
import model.CompetitionTime;
import model.Member;

/**
 *
 * @author gamma
 */
public class CompetitionCUI extends UI{
    
    private int[] possibleOptionsInMenu = new int[] {10, 11, 12, 14};
    private int tournamentId;
    String[] disciplines;
    
    public CompetitionCUI(Controller controller, int tournamentId) {
        this.controller = controller;
        this.tournamentId = tournamentId;
        setVisibleOptionsInMenu(possibleOptionsInMenu);
        printCompetitionMenu();
    }
    
    private void printCompetitionMenu() {
        boolean exit = false;
        int counter;
        int input;
        do {
            counter = 0;
            printHeader();
            for (int option : visibleOptionsInMenu) {
                counter++;
                print(counter + allMenuOptions[option]);
            }
            printExit();
            input = getMenuInput();
            
            if (input < 0 || input > visibleOptionsInMenu.size()) {
                print(input + " Er ikke en mulighed i denne menu");
            } else if (input == 0){
                exit = true;
            } else {
                switch (userOptions.get(input - 1)) {
                    case 10: 
                        //Se konkurrence
                        
                }
            }
        }while(!exit); 
        
        
    }
    
    private void seeCompetition() {
        Competition comp = null;
        boolean exit = false;
        int input;
        disciplines = controller.getAllDisciplines();
        ArrayList<Competition> competitions = controller.getAllCompetitions(tournamentId);
        
        do {
            printHeader();
            printAllCompetitionsInTournament(competitions);
            
            input = getMenuInput();
            if(input == 0) {
                exit = true;
            } else {
                printCompetition(competitions.get(input - 1));
            }
            
        }while(!exit);
    }
    
    private void printAllCompetitionsInTournament(ArrayList<Competition> comps) {
        printHeader();
        int counter = 1;
        String line;
        
        for(Competition comp : comps) {
            line = "";
            line += counter + " ";
            line += disciplines[comp.getSwimmingDiscipline() + 1];
            
            counter++;
        }
        
    }

    private void printCompetition(Competition competition) {
        printHeader();
        
        Member member;
        String discipline = disciplines[competition.getSwimmingDiscipline() + 1];
        ArrayList<CompetitionTime> times 
                = controller.getAllTimes(competition.getCompetitionsId());
        for (CompetitionTime time : times) {
            member = controller.getMemberByID(time.getMemberID());
            print(member.getName() + ": " + time.getTimeInMinutes());
        }
        print("");
        
    }
}
