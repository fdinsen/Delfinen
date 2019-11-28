package datasource;

import model.Competition;
import model.CompetitionTime;
import model.SwimmingDiscipline;
import model.TrainingTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompetitionTimeMapper {

    private Connection con = null;

    public void addTime(CompetitionTime ct) {
        String SQL = "INSERT INTO competition_times (c_time_id, competitions_id, member_id, c_time_ms) VALUES (?,?,?,?);";
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

    public List<CompetitionTime> getAllTimes(Competition competition) {
       return null;
    }

}
