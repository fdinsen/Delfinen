
package Controllers;
import datasource.DataSource;
import java.util.ArrayList;
import java.util.List;
import model.*;
/**
 *
 * @author <Frederik Keis Dinsen>
 */
public abstract class Controller {
    DataSource datasource;
    
    //-------------//
    // CONSTRUCTOR //
    //-------------//
    public Controller(DataSource datasource) {
        this.datasource = datasource;
    }
    
    //--------------//
    // MemberMapper //
    //--------------//
    
    public ArrayList<Member> getMemberByPhone(String phoneNumber) {
        return (ArrayList) datasource.getMemberByPhone(phoneNumber);
    }
    
    public ArrayList<Member> getMemberByEmail(String email) {
        return (ArrayList) datasource.getMemberByEmail(email);
    }
    
    public ArrayList<Member> getMemberByName(String name) {
        return (ArrayList) datasource.getMemberByName(name);
    }
    
}
