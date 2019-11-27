package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Member;
import model.MembershipStatus;
import model.MembershipType;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class RestanceMapper {

    private Connection con = null;

    public ArrayList<Member> getAllRestance() {
        ArrayList<Member> membersWithRestance = new ArrayList();
        con = DBConnector.getConnection();
        try (Statement stmt = con.createStatement()) {
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
                String address = rs.getString("address");
                String email = rs.getString("email");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                int trainerId = rs.getInt("trainer_id");
                MembershipStatus membershipStatus = 
                        MembershipStatus.valueOf(rs.getString("membership_status"));
                MembershipType membershipType = 
                        MembershipType.valueOf(rs.getString("membership_type"));
                membersWithRestance.add(
                        new Member(memberId, memberName, phoneNumber, address, 
                                email, birthday, trainerId, 
                                membershipStatus, membershipType));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return membersWithRestance;
    }

    public boolean userHasRestance(int memberId) {
        boolean memberExists = false;
        con = DBConnector.getConnection();
        String SQL = "SELECT * FROM restance join members ON restance.member_id = "
                    + "members.member_id WHERE members.member_id = ?";
        try (PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setInt(1, memberId);
            ResultSet rs = ps.executeQuery();
            
            memberExists = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return memberExists;
    }
    
    
}
