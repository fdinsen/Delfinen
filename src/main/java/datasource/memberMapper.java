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
import model.TeamType;

public class memberMapper {
    private Connection con = null;
    
    public void createMember(Member member){
        con = DBConnector.getConnection();
        String SQL = "INSERT INTO members (member_name, phone_number, address, email, birthday, trainer_id, membership_status, membership_type) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, member.getName());
            ps.setString(2, member.getPhone());
            ps.setString(3, member.getAddress());
            ps.setString(4, member.getEmail());
            ps.setDate(5, member.getBirthday());
            ps.setInt(6, member.getTrainerId());
            ps.setString(7, member.getMembershipStatus());
            ps.setString(8, member.getMembershipType());
            
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(memberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke oprette ny bruger, prøv igen");
        }
    }
    
    public void updateMember(Member member){
        con = DBConnector.getConnection();
        String SQL = "UPDATE members SET member_name = ?, phone_number = ?, address = ?, email = ?, birthday = ?, trainer_id = ?, membership_status = ?, membership_type = ?) "
                + "WHERE member_id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, member.getName());
            ps.setString(2, member.getPhone());
            ps.setString(3, member.getAddress());
            ps.setString(4, member.getEmail());
            ps.setDate(5, member.getBirthday());
            ps.setInt(6, member.getTrainerId());
            ps.setString(7, member.getMembershipStatus());
            ps.setString(8, member.getMembershipType());
            ps.setInt(9, member.getMemberId());
            
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(memberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke opdatere medlemet, prøv igen");
        }
    }
    
    
    public List<Member> getMemberByPhone(String phone){
        Statement stmt;

        try {
            con = DBConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rsMember = stmt.executeQuery("SELECT * FROM members WHERE phone_number = " + phone);
            while (rsMember.next()) {
                int memberId = rsMember.getInt("membership_id");
                String memberName = rsMember.getString("membership_name");
                String address = rsMember.getString("address");
                String email = rsMember.getString("email");
                LocalDate birthday = rsMember.getDate("birthday").toLocalDate();
                int trainerId = rsMember.getInt("trainer_id");
                MembershipStatus membershipStatus = MembershipStatus.valueOf(rsMember.getString("membership_status"));
                MembershipType membershipType = MembershipType.valueOf(rsMember.getString("membership_type"));
                rsMember.close();
                stmt.close();
                con.close();
                Member member = new Member(memberId, memberName, phone, address, email, birthday, trainerId, membershipStatus, membershipType);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(memberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return member;
    }
    
    public List<Member> getMemberByName(String name){
        
    }
    
    public List<Member> getMemberByEmail(String email){
        
    }
}

