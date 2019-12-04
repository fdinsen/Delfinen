
package ui.console;

import Controllers.Controller;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class MainMenuUI extends UI {
    private int[] posibleOptionsInMenu = new int[]{1,3,4,5,8,13};
    
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
            printHeader();
            counter = 0;
            for (int option: visibleOptionsInMenu){
                counter++;
                if(option == 1){
                    print(counter + ". Medlemer");
                }else{
                    print(counter + allMenuOptions[option]);
                }
                
            }
            print("0. Afslut");
            input = getMenuInput();

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
                        MemberCUI memberCUI = new MemberCUI(controller);
                        break;
                    case 5:
                        //Se restance
                        RestanceCUI restanceCUI = new RestanceCUI(controller);
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
                        Top5CUI top5 = new Top5CUI(controller);
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
