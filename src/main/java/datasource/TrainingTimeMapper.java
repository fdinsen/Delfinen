package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.SwimmingDiscipline;
import model.TrainingTime;

public class TrainingTimeMapper {

    private Connection con = null;

    public void addTime(TrainingTime trainingTime) {
        String SQL = "INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES (?,?,?,?);";
        con = DBConnector.getConnection();

        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, trainingTime.getDate().toString());
            ps.setInt(2, trainingTime.getMemeberID());
            ps.setInt(3, trainingTime.getTimeInMS());
            ps.setString(4, trainingTime.getSd().toString());
            ps.execute();

            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex + " connection failed");
        }

    }

    public List<TrainingTime> getMemberTimes(int memberID) {
        ArrayList<TrainingTime> trainningTimes = new ArrayList<>();
        String SQL = "SELECT * FROM training_times where member_id = ?";
        con = DBConnector.getConnection();

        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, memberID);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                
                int memeberId = result.getInt("member_id");
                String t_date = result.getString("t_date");
                int t_time_ms = result.getInt("t_time_ms");
                String sd = result.getString("swimming_discipline");
                LocalDate ld = LocalDate.parse(t_date);
                TrainingTime tt = new TrainingTime(memeberId,ld , t_time_ms, SwimmingDiscipline.valueOf(sd));
                
                trainningTimes.add(tt);
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex + " connection failed");
        }

        return trainningTimes;
    }

    public List<TrainingTime> getTop5(SwimmingDiscipline sd) {

        throw new UnsupportedOperationException("Not supported yet");
    }

}
