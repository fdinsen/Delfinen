
package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Member;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class RestanceMapper {
    private Connection con = null;
    
    public ArrayList<Member> getAllRestance() {
        ArrayList<Member> membersWithRestance = new ArrayList();
        con = DBConnector.getConnection();
        try (Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery(
                    "SELECT members.member_id, member_name, phone_number, "
                            + "address, email, birthday, trainer_id, "
                            + "membership_status, membership_type FROM "
                            + "restance join members ON restance.member_id = "
                            + "members.member_id;");
            while (rs.next()) {
                int memberId = rs.getInt("member_id");
                String memberName = rs.getString("member_name");
                String phoneNumber = rs.getString("phone_number");
                
                
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return membersWithRestance;
    }
}
