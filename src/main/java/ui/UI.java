
package ui;
import Controllers.Controller;
/**
 *
 * @author <Frederik Keis Dinsen>
 */
public interface UI {
    
    void startUI();
    
    public Controller selectUser();
    
    public void setController(Controller controller);
}
