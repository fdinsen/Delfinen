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
import enums.MembershipStatus;
import enums.MembershipType;
import java.sql.Statement;
import java.util.Arrays;

public class MemberMapper {

    private Connection con = null;

    public void createMember(Member member) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
        con = DBConnector.getConnection();
        String SQL = "INSERT INTO members (member_name, phone_number, address, "
                + "email, birthday, trainer_id, membership_status, membership_type) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        StringBuilder SQLDisciplines = new StringBuilder("INSERT INTO member_swiming_discipline "
                + "(member_id, discipline_id) VALUES");
        String values = " (?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, member.getName());
            ps.setString(2, member.getPhone());
            ps.setString(3, member.getAddress());
            ps.setString(4, member.getEmail());
            Date date = java.sql.Date.valueOf(member.getBirthday().toString());
            Calendar cet = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
            ps.setDate(5, date, cet);
            ps.setInt(6, member.getTrainerId());
            ps.setString(7, member.getMembershipStatus().toString());
            ps.setString(8, member.getMembershipType().toString());
            
            ps.execute();
            ResultSet memberIdSet = ps.getGeneratedKeys();
            ArrayList<String> memberDisciplines = member.getMemberDisciplines();

            if (!memberDisciplines.isEmpty() && memberIdSet.next()) {
                ArrayList<String> disciplineNames
                        = new ArrayList(Arrays.asList(new DisciplineMapper().getAllDisciplines()));
                int memberId = memberIdSet.getInt(1);

                //This might not be the best way to do this, but it was
                //what I could come up with at the time
                //The amount of disciplines vary from 0-4, so to avoid making 
                //multiple runs, the SQL script is appended with the correct
                //amount of (?,?) needed.
                for (int i = 0; i < memberDisciplines.size(); i++) {
                    if (i != 0) {
                        SQLDisciplines.append(",");
                    }
                    SQLDisciplines.append(values);
                }
                PreparedStatement psb = con.prepareStatement(SQLDisciplines.toString());

                //Then the values have to be set on the script. Since there are
                //two values for each row, this loop is run through twice for 
                //each discipline a member is practicing.
                int count = 0;
                for (int i = 1; i <= memberDisciplines.size() * 2; i++) {
                    //the uneven times, the memberId is added
                    if (i % 2 != 0) {
                        psb.setInt(i, memberId);
                        //the even times the id for the discipline is added
                    } else {
                        psb.setInt(i, disciplineNames.indexOf(
                                memberDisciplines.get(count)) + 1);
                        count++;
                    }

                }

                psb.execute();
                psb.close();
                //Old version, made multiple calls to database, heavyload
//                for (String discipline : member.getMemberDisciplines()) {
//                    PreparedStatement psb = con.prepareStatement(SQLDisciplines);
//                    psb.setInt(1, memberId);
//                    psb.setInt(2, disciplineNames.indexOf(discipline) + 1);
//                    psb.execute();
//                    psb.close();
//                }
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke oprette ny bruger, prøv igen");

        }
    }

    public void deleteMember(int memberId) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
        con = DBConnector.getConnection();
        String SQL = "DELETE FROM members WHERE member_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, memberId);

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex + " cannot delete member");
        }
    }

    public void updateMember(Member member) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
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
            ps.setDate(5, date, cet);
            ps.setInt(6, member.getTrainerId());
            ps.setString(7, member.getMembershipStatus().toString());
            ps.setString(8, member.getMembershipType().toString());
            ps.setInt(9, member.getMemberId());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke opdatere medlemet, prøv igen");
        }
    }

    public ArrayList<Member> getMemberByPhone(String phone) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
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
                LocalDate birthday = rsMember.getDate("birthday", cet).toLocalDate();
                int trainerId = rsMember.getInt("trainer_id");
                MembershipStatus membershipStatus = MembershipStatus.valueOf(rsMember.getString("membership_status"));
                MembershipType membershipType = MembershipType.valueOf(rsMember.getString("membership_type"));

                ArrayList<String> disciplines
                        = getMemberSwimmingDiscipline(memberId);
                Member member = new Member(memberId, memberName, phone,
                        address, email, birthday, trainerId, membershipStatus,
                        membershipType, disciplines);
                members.add(member);
            }
            rsMember.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Problem med at finde bruger via telefon nr., prøv igen");
            Logger
                    .getLogger(MemberMapper.class
                            .getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    public ArrayList<Member> getMemberByName(String name) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
        ArrayList<Member> members = new ArrayList<>();

        try {
            con = DBConnector.getConnection();
            PreparedStatement stmt
                    = con.prepareStatement("SELECT * FROM members WHERE member_name = ?");
            stmt.setString(1, name);
            ResultSet rsMember = stmt.executeQuery();
            while (rsMember.next()) {
                int memberId = rsMember.getInt("member_id");
                String memberPhone = rsMember.getString("phone_number");
                String address = rsMember.getString("address");
                String email = rsMember.getString("email");
                Calendar cet = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
                LocalDate birthday
                        = rsMember.getDate("birthday", cet).toLocalDate();
                int trainerId = rsMember.getInt("trainer_id");
                MembershipStatus membershipStatus
                        = MembershipStatus.valueOf(rsMember.getString("membership_status"));
                MembershipType membershipType
                        = MembershipType.valueOf(rsMember.getString("membership_type"));
                ArrayList<String> disciplines
                        = getMemberSwimmingDiscipline(memberId);
                Member member = new Member(memberId, name, memberPhone,
                        address, email, birthday, trainerId, membershipStatus,
                        membershipType, disciplines);
                members.add(member);
            }
            rsMember.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Problem med at finde bruger via navnet., prøv igen");
            Logger
                    .getLogger(MemberMapper.class
                            .getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    public ArrayList<Member> getMemberByEmail(String email) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
        ArrayList<Member> members = new ArrayList<>();

        try {
            con = DBConnector.getConnection();
            PreparedStatement stmt
                    = con.prepareStatement("SELECT * FROM members WHERE email = ?");
            stmt.setString(1, email);
            ResultSet rsMember = stmt.executeQuery();
            while (rsMember.next()) {
                int memberId = rsMember.getInt("member_id");
                String memberName = rsMember.getString("member_name");
                String memberPhone = rsMember.getString("phone_number");
                String address = rsMember.getString("address");
                Calendar cet
                        = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
                LocalDate birthday
                        = rsMember.getDate("birthday", cet).toLocalDate();
                int trainerId = rsMember.getInt("trainer_id");
                MembershipStatus membershipStatus
                        = MembershipStatus.valueOf(rsMember.getString("membership_status"));
                MembershipType membershipType
                        = MembershipType.valueOf(rsMember.getString("membership_type"));
                ArrayList<String> disciplines
                        = getMemberSwimmingDiscipline(memberId);
                Member member = new Member(memberId, memberName, memberPhone,
                        address, email, birthday, trainerId, membershipStatus,
                        membershipType, disciplines);
                members.add(member);
            }
            rsMember.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Problem med at finde bruger via email., prøv igen");
            Logger
                    .getLogger(MemberMapper.class
                            .getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    public Member getMemberByID(int memberID) {
        Member member;
        con = DBConnector.getConnection();

        String sql = "SELECT * FROM members WHERE member_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, memberID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String memberName = rs.getString("member_name");
                String memberPhone = rs.getString("phone_number");
                String address = rs.getString("address");
                Calendar cet
                        = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
                LocalDate birthday
                        = rs.getDate("birthday", cet).toLocalDate();
                int trainerId = rs.getInt("trainer_id");
                MembershipStatus membershipStatus
                        = MembershipStatus.valueOf(rs.getString("membership_status"));
                MembershipType membershipType
                        = MembershipType.valueOf(rs.getString("membership_type"));
                ArrayList<String> disciplines
                        = getMemberSwimmingDiscipline(memberID);
                member = new Member(memberID, memberName, memberPhone,
                        address, email, birthday, trainerId, membershipStatus,
                        membershipType, disciplines);
                return member;
            }
        } catch (SQLException ex) {
            System.out.println("Problem med at finde bruger via ID., prøv igen");
            Logger
                    .getLogger(MemberMapper.class
                            .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<String> getMemberSwimmingDiscipline(int memberID) {

        //int[] disciplines = new int[4];
        ArrayList<String> disciplines = new ArrayList();
        String SQL = "SELECT discipline_name FROM "
                + "delfinen.member_swiming_discipline NATURAL JOIN disciplines "
                + "WHERE member_id = ?;";

        try {
            con = DBConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, memberID);

            ResultSet rsMemberSD = ps.executeQuery();

            while (rsMemberSD.next()) {
                String swimmingName = rsMemberSD.getString("discipline_name");
                disciplines.add(swimmingName);
            }

        } catch (SQLException ex) {
            System.out.println(ex + "problem med get member swiming discipline");
        }

        return disciplines;
    }
}
