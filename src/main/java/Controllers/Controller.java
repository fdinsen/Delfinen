
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
    private int profileId;
    //-------------//
    // CONSTRUCTOR //
    //-------------//
    public Controller(DataSource datasource, int profileId) {
        this.datasource = datasource;
        this.profileId = profileId;
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
    
    public int getProfileId() {
        return profileId;
    }
    
    public void setProfileId(int id) {
        this.profileId = id;
    }
    
    //-----------------//
    // PrivilegeMapper //
    //-----------------//
    
    public boolean[] getPrivileges(int ID) {
        return datasource.getPrivileges(ID);
    }
    
}
