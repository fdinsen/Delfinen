
package datasource;

import java.util.ArrayList;
import java.util.List;
import model.Trainer;
import model.Competition;
import model.Tournament;
import model.Times;
import model.TrainingTime;
import model.CompetitionTime;
import model.Member;
/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class FileHandler implements DataSource {
    //--------------//
    // MemberMapper //
    //--------------//
    @Override
    public void createMember(Member member) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMember(Member member) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMember(int memberID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Member> getMemberByPhone(String phonenumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Member> getMemberByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Member> getMemberByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<String> getMemberSwimmingDiscipline(int memberID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //----------------//
    // RestanceMapper //
    //----------------//
    
    @Override
    public List<Member> getAllRestance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean memberHasRestance(int memberID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean markAsPaid(int memberID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean makeNewSeason() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //---------------//
    // TrainerMapper //
    //---------------//

    @Override
    public void createTrainer(Trainer trainer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updtateTrainer(Trainer trainer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTrainer(int trainerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trainer getTrainer(int trainerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //------------------//
    // TournamentMapper //
    //------------------//
    
    @Override
    public List<Tournament> getAllTournaments(int year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTournament(Tournament tournament) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateTournament(Tournament tournament) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //-------------------//
    // CompetitionMapper //
    //-------------------//
    
    @Override
    public List<Competition> getAllCompetitions(int tournamentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCompetition(Competition competition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCompetition(Competition competition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //--------------------//
    // TrainingTimeMapper //
    //--------------------//
    
    @Override
    public void addTime(TrainingTime trainingTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TrainingTime> getMemberTimes(int memberID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TrainingTime> getTop5(int swimmingDisciplineID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //-----------------------//
    // CompetitionTimeMapper //
    //-----------------------//
    
    @Override
    public void addTime(CompetitionTime competitionTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<CompetitionTime> getAllTimes(int competitionID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //-----------------//
    // PrivilegeMapper //
    //-----------------//

    @Override
    public boolean[] getPrivileges(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTrainerName(int trainerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
