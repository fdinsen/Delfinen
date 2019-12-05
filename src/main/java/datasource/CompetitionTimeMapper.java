package datasource;

import model.Competition;
import model.CompetitionTime;
import model.TrainingTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompetitionTimeMapper {

    private Connection con = null;

    public void addCompetitionTime(CompetitionTime ct) {
        String SQL = "INSERT INTO competition_times (c_time_id, competitions_id, member_id, c_time_ms) VALUES (?,?,?,?)";
        con = DBConnector.getConnection();

        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, ct.getCompetitionTimeID());
            ps.setInt(2, ct.getCompetitionID());
            ps.setInt(3, ct.getMemberID());
            ps.setInt(4, ct.getTimeInMS());
            ps.execute();

            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex + " connection failed");
        }

    }

    public ArrayList<CompetitionTime> getAllCompetitionTimesTimes(int competitionID) {
        ArrayList<CompetitionTime> competitions = new ArrayList<>();
        try {
            con = DBConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM competition_times "
                    + "WHERE competitions_id = ? order by c_time_ms desc");
            
            stmt.setInt(1, competitionID);
            ResultSet rsCompetitionTime = stmt.executeQuery();
            while (rsCompetitionTime.next()) {
                int competitionsTimeID = rsCompetitionTime.getInt("c_time_id");
                int competitionMemberID = rsCompetitionTime.getInt("member_id");
                int competitionTimeMS = rsCompetitionTime.getInt("c_time_ms");

                CompetitionTime competitionTime = new CompetitionTime(competitionsTimeID,competitionID,competitionMemberID,competitionTimeMS);
                competitions.add(competitionTime);
            }
            rsCompetitionTime.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Problem med at hente alle konkurrencer, prøv igen");
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return competitions;
    }

}
