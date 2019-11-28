
package ui;
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
}
