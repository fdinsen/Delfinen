
package Controllers;
import datasource.DataSource;
import enums.SwimmingDiscipline;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class ChairmanController extends Controller{

    //-------------//
    // CONSTRUCTOR //
    //-------------//
    public ChairmanController(DataSource datasource, int profileId) {
        super(datasource, profileId);
    }

    //--------------//
    // MemberMapper //
    //--------------//
    
    public void createMember(Member member) {
        datasource.createMember(member);
    }
    
    public void updateMember(Member member) {
        datasource.updateMember(member);
    }
    
    //---------------//
    // TrainerMapper //
    //---------------//
    
    public void createTrainer(Trainer trainer) {
        datasource.createTrainer(trainer);
    }
    
    public void updateTrainer(Trainer trainer) {
        datasource.updtateTrainer(trainer);
    }
    
    public void deleteTrainer(int trainerID) {
        datasource.deleteTrainer(trainerID);
    }
    
    public void getTrainer(int trainerID) {
        datasource.getTrainer(trainerID);
    }
    
    //---------//
    // METHODS //
    //---------//
    
    @Override
    public String toString() {
        return "Formand";
    }
}
