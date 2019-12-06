package datasource;

import model.TrainingTime;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainingTimeMapper {

    private final int SENIOR_AGE = 18;
    private Connection con = null;

    public void addTime(TrainingTime trainingTime) {
        String SQL = "INSERT INTO training_times (t_date, member_id,t_time_ms, discipline_id) VALUES (?,?,?,?)";
        con = DBConnector.getConnection();

        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, trainingTime.getDate().toString());
            ps.setInt(2, trainingTime.getMemberID());
            ps.setInt(3, trainingTime.getTimeInMS());
            ps.setInt(4, trainingTime.getSwimmingDiscipline());
            ps.execute();

            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex + " connection failed");
        }

    }

    public ArrayList<TrainingTime> getMemberTimes(int memberID) {
        ArrayList<TrainingTime> trainningTimes = new ArrayList<>();
        String SQL = "SELECT t_time_id, t_date, members.member_id, min(t_time_ms),discipline_id, members.member_name \n"
                + "FROM training_times \n"
                + "join members on training_times.member_id = members.member_id \n"
                + "where members.member_id = ?\n"
                + "group by discipline_id \n"
                + "order by min(t_time_ms) desc";
        con = DBConnector.getConnection();

        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, memberID);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int trainingTimeID = result.getInt("t_time_id");
                int memeberId = result.getInt("member_id");
                String t_date = result.getString("t_date");
                int t_time_ms = result.getInt("min(t_time_ms)");
                int sd = result.getInt("discipline_id");
                LocalDate ld = LocalDate.parse(t_date);
                TrainingTime tt = new TrainingTime(trainingTimeID, memeberId, ld, t_time_ms, sd);
                trainningTimes.add(tt);
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex + " connection failed");
        }

        return trainningTimes;
    }

    public List<TrainingTime> getTop5Senior(int swimmingDisciplineID) {
        ArrayList<TrainingTime> trainningTimes = new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalDate seniorBirthday = today.minus(SENIOR_AGE, ChronoUnit.YEARS);

        String SQL = "SELECT members.member_name, min(t_time_ms), training_times.member_id, t_date, discipline_id "
                + "FROM delfinen.training_times "
                + "join members on training_times.member_id = members.member_id "
                + "where discipline_id = ? AND members.birthday < ? "
                + "group by member_id "
                + "order by min(t_time_ms) limit 5";

        con = DBConnector.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, swimmingDisciplineID);
            ps.setString(2, seniorBirthday.toString());
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                int memberID = result.getInt("member_id");
                String t_date = result.getString("t_date");
                LocalDate ld = LocalDate.parse(t_date);

                int timeInMs = result.getInt("min(t_time_ms)");
                int sDiscipline = result.getInt("discipline_id");
                TrainingTime tt = new TrainingTime(memberID, ld, timeInMs, sDiscipline);
                trainningTimes.add(tt);

            }

        } catch (SQLException ex) {
            System.out.println(ex + " could not get top 5");
        }
        return trainningTimes;
    }

    public List<TrainingTime> getTop5Junior(int swimmingDisciplineID) {
        ArrayList<TrainingTime> trainningTimes = new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalDate seniorBirthday = today.minus(SENIOR_AGE, ChronoUnit.YEARS);

        String SQL = "SELECT members.member_name, min(t_time_ms), training_times.member_id, t_date, discipline_id "
                + "FROM delfinen.training_times "
                + "join members on training_times.member_id = members.member_id "
                + "where discipline_id = ? AND members.birthday > ? "
                + "group by member_id "
                + "order by min(t_time_ms) limit 5";

        con = DBConnector.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, swimmingDisciplineID);
            ps.setString(2, seniorBirthday.toString());
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                int memberID = result.getInt("member_id");
                String t_date = result.getString("t_date");
                LocalDate ld = LocalDate.parse(t_date);

                int timeInMs = result.getInt("min(t_time_ms)");
                int sDiscipline = result.getInt("discipline_id");
                TrainingTime tt = new TrainingTime(memberID, ld, timeInMs, sDiscipline);
                trainningTimes.add(tt);

            }

        } catch (SQLException ex) {
            System.out.println(ex + " could not get top 5");
        }
        return trainningTimes;
    }

    public void updateTrainingTime(TrainingTime trainingTime) {
        con = DBConnector.getConnection();
        String SQL = "UPDATE training_times SET t_date = ?, member_id = ?, t_time_ms = ?, discipline_id = ? WHERE t_time_id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            Date date = java.sql.Date.valueOf(trainingTime.getDate().toString());
            ps.setDate(1, date);
            ps.setInt(2, trainingTime.getMemberID());
            ps.setInt(3, trainingTime.getTimeInMS());
            ps.setInt(4, trainingTime.getSwimmingDiscipline());
            ps.setInt(5, trainingTime.getTrainingTimeID());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke opdatere træningstiden, prøv igen");
        }
    }

}
