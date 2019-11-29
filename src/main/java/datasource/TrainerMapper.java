package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        try(PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newTrainerName);
            ps.setInt(2, oldTrainerId);
            ps.execute();
        } catch (SQLException ex) {
                Logger.getLogger(RestanceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void deleteTrainer(int trainerId) {

    }

    public Trainer getTrainer(int trainerId) {

        return new Trainer("temp");
    }
}
