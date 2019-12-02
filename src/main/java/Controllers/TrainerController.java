
package Controllers;
import datasource.DataSource;
import java.util.ArrayList;
import model.*;
/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class TrainerController extends Controller {

    public TrainerController(DataSource datasource, int profileId) {
        super(datasource, profileId);
    }

    //--------------//
    // MemberMapper //
    //--------------//
    
    public void updateMember(Member member) {
        datasource.updateMember(member);
    }
    
    //------------------//
    // TournamentMapper //
    //------------------//
    
    public ArrayList<Tournament> getAllTournaments(int year) {
        return (ArrayList) datasource.getAllTournaments(year);
    }
    
    public void addTournament(Tournament tournament) {
        datasource.addTournament(tournament);
    }
    
    public void updateTournamnet(Tournament tournament) {
        datasource.updateTournament(tournament);
    }
    
    //-------------------//
    // CompetitionMapper //
    //-------------------//
    
    public ArrayList<Competition> getAllCompetitions(int tournamnentID) {
        return (ArrayList) datasource.getAllCompetitions(tournamnentID);
    }
    
    public void addCompetition(Competition competition) {
        datasource.addCompetition(competition);
    }
    
    public void updateCompetition(Competition competition) {
        datasource.updateCompetition(competition);
    }
    
    //--------------------//
    // TrainingTimeMapper //
    //--------------------//
    
    public void addTime(TrainingTime trainingTime) {
        datasource.addTime(trainingTime);
    }
    
    public ArrayList<TrainingTime> getMemberTimes(int memberID) {
        return (ArrayList) datasource.getMemberTimes(memberID);
    }
    
    public ArrayList<TrainingTime> getTop5(int swimmingDisciplineID) {
        return (ArrayList) datasource.getTop5(swimmingDisciplineID);
    }
    
    //-----------------------//
    // CompetitionTimeMapper //
    //-----------------------//
    
    public void addTime(CompetitionTime competitionTime) {
        datasource.addTime(competitionTime);
    }
    
    public ArrayList<CompetitionTime> getAllTimes(int competitionID) {
        return (ArrayList) datasource.getAllTimes(competitionID);
    }
    
    @Override
    public String toString() {
        return "Træner";
    }
}
