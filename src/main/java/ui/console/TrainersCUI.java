package ui.console;

import ComponentValidation.NameComponent;
import ComponentValidation.ValidationComponent;
import Controllers.Controller;
import model.Trainer;

class TrainersCUI extends UI {

    private int[] posibleOptionsInMenu = new int[]{3, 4};

    TrainersCUI(Controller controller) {
        this.controller = controller;
        setVisibleOptionsInMenu(posibleOptionsInMenu);
        printTrainersDialog();
    }

    private void printTrainersDialog() {
        boolean exit = false;
        int counter;
        int input;
        do {
            printTrainers();
            counter = 0;
            for (int option : visibleOptionsInMenu) {
                counter++;
                print(counter + allMenuOptions[option]);
            }
            printExit();
            input = getMenuInput();

            if (input < 0 || input > visibleOptionsInMenu.size()) {
                print(input + " Er ikke en mulighed i denne menu");
            } else if (input == 0) {
                //exit
                exit = true;
            } else {
                //Have to make the user input correspond, to the actual value of the method we need to call
                switch (userOptions.get(input - 1)) {
                    case 3:
                        //Create trainer
                        printAddTrainerDialog();
                        break;
                    case 4:
                        //Edit trainer
                        printEditTrainerDialog();
                        break;
                    default:
                        print("Der er sket en fejl, prøv igen");
                }
            }
        } while (!exit);
    }

    public void printEditTrainerDialog() {
        boolean exit = false;
        int input;
        do {
            printTrainers();
            print("Hvem vil du redigere?");
            printExit();
            input = getMenuInput();

            if (input == 0) {
                //exit
                exit = true;
            } else if (input < 0 || input > controller.getAllTrainers().length) {
                print(input + ", Er ikke en mulighed i denne menu");
            } else {
                String name;
                ValidationComponent validator = new NameComponent();
                do {
                    print("Indtast det nye navn på træneren:");
                    name = getStringInput();
                    printExit();
                    if (name.equals("0")) {
                        exit = true;
                        break;
                    }
                } while (!validator.checkComponent(name));
                if (!exit) {
                    Trainer trainer = new Trainer(name, input + 1);
                    controller.updateTrainer(trainer);
                    exit = true;
                }
            }
        } while (!exit);

    }

    public void printAddTrainerDialog() {
        boolean exit = false;
        String input;
        ValidationComponent validator = new NameComponent();
        do {
            printHeader();
            print("Skriv navn på træneren");
            printExit();
            input = getStringInput();

            if (input.equals("0")) {
                //exit
                exit = true;
                break;
            }
        } while (!validator.checkComponent(input));
        if (!exit) {
            Trainer trainer = new Trainer(input);
            controller.createTrainer(trainer);
        }
    }

    private void printTrainers() {
        int counter = 0;
        printHeader("Trænere ");
        print("Trænerne:");
        for (String trainer : controller.getAllTrainers()) {
            counter++;
            print("\t" + counter + ". " + trainer);
        }
    }

}
