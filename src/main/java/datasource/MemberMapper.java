package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Member;
import model.MembershipStatus;
import model.MembershipType;

public class MemberMapper {

    private Connection con = null;

    public void createMember(Member member) {
        con = DBConnector.getConnection();
        String SQL = "INSERT INTO members (member_name, phone_number, address, email, birthday, trainer_id, membership_status, membership_type) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, member.getName());
            ps.setString(2, member.getPhone());
            ps.setString(3, member.getAddress());
            ps.setString(4, member.getEmail());
            Date date = java.sql.Date.valueOf(member.getBirthday().toString());
            Calendar cet = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
            ps.setDate(5, date,cet);
            ps.setInt(6, member.getTrainerId());
            ps.setString(7, member.getMembershipStatus().toString());
            ps.setString(8, member.getMembershipType().toString());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke oprette ny bruger, prøv igen");
        }
    }

    public void updateMember(Member member) {
        con = DBConnector.getConnection();
        String SQL = "UPDATE members SET member_name = ?, phone_number = ?, address = ?, email = ?, birthday = ?, trainer_id = ?, membership_status = ?, membership_type = ? WHERE member_id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, member.getName());
            ps.setString(2, member.getPhone());
            ps.setString(3, member.getAddress());
            ps.setString(4, member.getEmail());
            Date date = java.sql.Date.valueOf(member.getBirthday().toString());
            Calendar cet = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
            ps.setDate(5, date,cet);
            ps.setInt(6, member.getTrainerId());
            ps.setString(7, member.getMembershipStatus().toString());
            ps.setString(8, member.getMembershipType().toString());
            ps.setInt(9, member.getMemberId());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke opdatere medlemet, prøv igen");
        }
    }

    public ArrayList<Member> getMemberByPhone(String phone) {
        ArrayList<Member> members = new ArrayList<>();

        try {
            con = DBConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM members WHERE phone_number = ?");
            stmt.setString(1, phone);
            ResultSet rsMember = stmt.executeQuery();
            while (rsMember.next()) {
                int memberId = rsMember.getInt("member_id");
                String memberName = rsMember.getString("member_name");
                String address = rsMember.getString("address");
                String email = rsMember.getString("email");
                Calendar cet = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
                LocalDate birthday = rsMember.getDate("birthday",cet).toLocalDate();
                int trainerId = rsMember.getInt("trainer_id");
                MembershipStatus membershipStatus = MembershipStatus.valueOf(rsMember.getString("membership_status"));
                MembershipType membershipType = MembershipType.valueOf(rsMember.getString("membership_type"));

                Member member = new Member(memberId, memberName, phone, address, email, birthday, trainerId, membershipStatus, membershipType);
                members.add(member);
            }
            rsMember.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Problem med at finde bruger via telefon nr., prøv igen");
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    public ArrayList<Member> getMemberByName(String name) {
        ArrayList<Member> members = new ArrayList<>();

        try {
            con = DBConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM members WHERE member_name = ?");
            stmt.setString(1, name);
            ResultSet rsMember = stmt.executeQuery();
            while (rsMember.next()) {
                int memberId = rsMember.getInt("member_id");
                String memberPhone = rsMember.getString("phone_number");
                String address = rsMember.getString("address");
                String email = rsMember.getString("email");
                Calendar cet = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
                LocalDate birthday = rsMember.getDate("birthday",cet).toLocalDate();
                int trainerId = rsMember.getInt("trainer_id");
                MembershipStatus membershipStatus = MembershipStatus.valueOf(rsMember.getString("membership_status"));
                MembershipType membershipType = MembershipType.valueOf(rsMember.getString("membership_type"));
                Member member = new Member(memberId, name, memberPhone, address, email, birthday, trainerId, membershipStatus, membershipType);
                members.add(member);
            }
            rsMember.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Problem med at finde bruger via navnet., prøv igen");
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    public ArrayList<Member> getMemberByEmail(String email) {
        ArrayList<Member> members = new ArrayList<>();

        try {
            con = DBConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM members WHERE email = ?");
            stmt.setString(1, email);
            ResultSet rsMember = stmt.executeQuery();
            while (rsMember.next()) {
                int memberId = rsMember.getInt("member_id");
                System.out.println(rsMember.getInt("member_id"));
                String memberName = rsMember.getString("member_name");
                String memberPhone = rsMember.getString("phone_number");
                String address = rsMember.getString("address");
                System.out.println(rsMember.getDate("birthday"));
                System.out.println(rsMember.getDate("birthday").toLocalDate());
                Calendar cet = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
                LocalDate birthday = rsMember.getDate("birthday",cet).toLocalDate();
                int trainerId = rsMember.getInt("trainer_id");
                MembershipStatus membershipStatus = MembershipStatus.valueOf(rsMember.getString("membership_status"));
                MembershipType membershipType = MembershipType.valueOf(rsMember.getString("membership_type"));
                Member member = new Member(memberId, memberName, memberPhone, address, email, birthday, trainerId, membershipStatus, membershipType);
                members.add(member);
            }
            rsMember.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Problem med at finde bruger via email., prøv igen");
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }
}
