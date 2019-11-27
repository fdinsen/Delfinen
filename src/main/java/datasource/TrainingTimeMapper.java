package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.SwimmingDiscipline;
import model.TrainingTime;

public class TrainingTimeMapper {
    private Connection con = null;
    
    public void addTime(TrainingTime trainingTime){
        String SQL = "INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES (?,?,?,?);";
        con = DBConnector.getConnection();
        try {
            
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, trainingTime.getDate().toString());
            ps.setInt(2, trainingTime.getMemeberID());
            ps.setInt(3, trainingTime.getTimeInMS());
            ps.setString(4, trainingTime.getSd().toString());
            System.out.println(SQL);
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex+"connection failed");
        }

    }
    public List<TrainingTime> getMemberTimes(int memberID){
        throw new UnsupportedOperationException("Not supported yet");
    }
    public List<TrainingTime> getTop5(SwimmingDiscipline sd){
        
        throw new UnsupportedOperationException("Not supported yet");
    }
    
}
