package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Member;
import enums.MembershipStatus;
import enums.MembershipType;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class RestanceMapper {

    private Connection con = null;

    public ArrayList<Member> getAllRestance() {
        ArrayList membersWithRestance = new ArrayList();
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
                Calendar cet = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
                LocalDate birthday = rs.getDate("birthday",cet).toLocalDate();
                int trainerId = rs.getInt("trainer_id");
                MembershipStatus membershipStatus
                        = MembershipStatus.valueOf(rs.getString("membership_status"));
                MembershipType membershipType
                        = MembershipType.valueOf(rs.getString("membership_type"));
                ArrayList<String> disciplines 
                        = new MemberMapper().getMemberSwimmingDiscipline(memberId);
                membersWithRestance.add(
                        new Member(memberId, memberName, phoneNumber, address,
                                email, birthday, trainerId,
                                membershipStatus, membershipType, disciplines));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return membersWithRestance;
    }

    public boolean memberHasRestance(int memberID) {
        boolean memberExists = false;
        con = DBConnector.getConnection();
        String SQL = "SELECT * FROM restance join members ON restance.member_id = "
                + "members.member_id WHERE members.member_id = ?";
        try (PreparedStatement ps = con.prepareStatement(SQL)) {
            ps.setInt(1, memberID);
            ResultSet rs = ps.executeQuery();

            memberExists = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return memberExists;
    }

    public boolean markAsPaid(int memberID) {
        if (memberHasRestance(memberID)) {
            con = DBConnector.getConnection();
            String SQL = "DELETE FROM restance WHERE member_id = ?";
            try (PreparedStatement ps = con.prepareStatement(SQL)) {
                ps.setInt(1, memberID);
                ps.execute();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean makeNewSeason() {
        if (getAllRestance().isEmpty()) {
            con = DBConnector.getConnection();
            String SQLGettingMembers = "SELECT member_id FROM members";
            String SQLInsertingMembers = "INSERT INTO restance (member_id) VALUES (?)";
            ArrayList<Integer> listOfMembers = new ArrayList();

            try (PreparedStatement ps = con.prepareStatement(SQLGettingMembers)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    listOfMembers.add(rs.getInt("member_id"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!listOfMembers.isEmpty()) {
                try (PreparedStatement ps = con.prepareStatement(SQLInsertingMembers)) {
                    for (Integer id : listOfMembers) {
                        ps.setInt(1, id);
                        ps.execute();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Something that shouldn't happen went wrong "
                        + "in the MakeNewSeason() method in RestanceMapper.");
            }

        } else {
            return false;
        }
        return true;
    }

}
