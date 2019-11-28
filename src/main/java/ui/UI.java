package ui;
//import java.util.regex;
import Controllers.Controller;
import java.util.Scanner;
/**
 *
 * @author <Frederik Keis Dinsen>
 */
public abstract class UI {
    
    public void print(String messageToPrint) {
        System.out.println(messageToPrint);
    }
    
    public int getInput(String messageToPrint) {
        Scanner scan = new Scanner(System.in);
        System.out.println(messageToPrint);
        int response = scan.nextInt();
        return response;
    }
    
    public void checkInputType(String input) {
        
    }
}
