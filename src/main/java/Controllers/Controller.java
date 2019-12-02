
package Controllers;
import datasource.DataSource;
import java.util.ArrayList;
import model.*;
/**
 *
 * @author <Frederik Keis Dinsen>
 */
public abstract class Controller {
    DataSource datasource;
    private boolean[] userPrivileges;
    private String svimmingDiscipline;
    //-------------//
    // CONSTRUCTOR //
    //-------------//
    public Controller(DataSource datasource, int profileID) {
        this.datasource = datasource;
        this.userPrivileges = datasource.getPrivileges(profileID);
        this.svimmingDiscipline = datasource.getSvimmingDisciplines();
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

    public boolean[] getUserPrivileges() {
        return userPrivileges;
    }
    
    //-----------------//
    // PrivilegeMapper //
    //-----------------//
    
}
