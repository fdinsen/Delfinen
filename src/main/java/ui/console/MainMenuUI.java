
package ui.console;

import Controllers.Controller;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class MainMenuUI extends UI {
    private int[] posibleOptionsInMenu = new int[]{1,4,5,8,13,3};
    
    public MainMenuUI(Controller controller) {
        this.controller = controller;
        setVisibleOptionsInMenu(posibleOptionsInMenu);
        printMainMenu();
    }
    
    public void printMainMenu(){
        boolean exit = false;
        int counter;
        int input;
        do {
            counter = 0;
            for (int option: visibleOptionsInMenu){
                counter++;
                print(counter + allMenuOptions[option]);
            }
            printExit();
            input = getInput();

            if(input < 0 || input > visibleOptionsInMenu.size()){
                System.out.println(input + " Er ikke en mulighed i denne menu");
            }else if(input == 0){
                //exit
                exit = true;
            }else{
                //Have to make the user input correspond, to the actual value of the method we need to call
                switch (userOptions.get(input-1)){
                    case 1:
                        //See member
                        System.out.println("Se medlem");
                        break;
                    case 5:
                        //Se restance
                        System.out.println("Se restance");
                        break;
                    case 4:
                        //edit trainer
                        System.out.println("Rediger træner");
                        break;
                    case 8:
                        //see tournament
                        System.out.println("Se stævne");
                        break;
                    case 13:
                        //show top 5
                        System.out.println("Vis top 5");
                        break;
                    case 3:
                        //create trainer
                        System.out.println("Lav træner");
                        break;

                    default:
                        System.out.println("Der er sket en fejl, prøv igen");
                }
            }



        } while (!exit);
        
    }

    
    
    
    private void printExit(){
        print("0. Exit");
    }
}
