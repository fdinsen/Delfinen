
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
    private int[] user_Privileges;
    //-------------//
    // CONSTRUCTOR //
    //-------------//
    public Controller(DataSource datasource, int profileId) {
        this.datasource = datasource;
        this.user_Privileges = datasource.getUser_Privileges();
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

    public int[] getUser_Privileges() {
        return user_Privileges;
    }
    
    //-----------------//
    // PrivilegeMapper //
    //-----------------//
    
    public boolean[] getPrivileges(int ID) {
        return datasource.getPrivileges(ID);
    }
    
}
