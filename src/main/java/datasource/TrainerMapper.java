package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Trainer;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class TrainerMapper {

    private Connection con = null;

    public void createTrainer(Trainer trainer) {
        con = DBConnector.getConnection();
        String sql = "INSERT INTO trainers (trainer_name) VALUES (?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, trainer.getTrainerName());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTrainer(Trainer trainer) {
        con = DBConnector.getConnection();
        String newTrainerName = trainer.getTrainerName();
        int oldTrainerId = trainer.getId();
        String sql = "UPDATE trainers SET trainer_name = ? WHERE trainer_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newTrainerName);
            ps.setInt(2, oldTrainerId);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteTrainer(int trainerID) {
        con = DBConnector.getConnection();
        String sql = "DELETE FROM trainers WHERE trainer_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, trainerID);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Trainer getTrainer(int trainerID) {
        Trainer trainer = null;
        con = DBConnector.getConnection();
        String sql = "SELECT * FROM trainers WHERE trainer_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, trainerID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String name = rs.getString("trainer_name");
                int id = rs.getInt("trainer_id");
                trainer = new Trainer(name, id);
            }
        }catch (SQLException ex) {
            Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trainer;
    }

    public String getTrainerName(int trainerID) {
        
        return getTrainer(trainerID).getTrainerName();        
    }
    
    public String[] getAllTrainers() {
        ArrayList<String> allTrainers = new ArrayList();
        con = DBConnector.getConnection();
        String sql = "SELECT * FROM trainers";
        try(Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                int trainerID = rs.getInt("trainer_id");
                String trainerName = rs.getString("trainer_name");
                if(trainerID != 1) {
                    allTrainers.add(trainerName);
                }
            }
        }catch (SQLException ex) {
            Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] allTrainerNames = new String[allTrainers.size()];
        int count = 0;
        for (String trainer : allTrainers) {
            allTrainerNames[count] = trainer;
            count++;
        }
        return allTrainerNames;
    }
}
