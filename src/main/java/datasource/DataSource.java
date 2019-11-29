
package datasource;

import java.util.List;
import model.Trainer;
import model.Competition;
import model.Tournament;
import model.Times;
import model.TrainingTime;
import model.CompetitionTime;
import enums.SwimmingDiscipline;
import model.Member;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public interface DataSource {
    
    //--------------//
    // MemberMapper //
    //--------------//
    
    public void createMember(Member member);
    public void updateMember(Member member);
    public void deleteMember(int memberID);
    public List<Member> getMemberByPhone(String phonenumber);
    public List<Member> getMemberByEmail(String email);
    public List<Member> getMemberByName(String name);
    
    
    //----------------//
    // RestanceMapper //
    //----------------//
    public List<Member> getAllRestance();
    public boolean memberHasRestance(int memberID);
    public boolean markAsPaid(int memberID);
    public boolean makeNewSeason();
    
    //---------------//
    // TrainerMapper //
    //---------------//
    
    public void createTrainer(Trainer trainer);
    public void updtateTrainer(Trainer trainer);
    public void deleteTrainer(int trainerID);
    public Trainer getTrainer(int trainerID);

    //------------------//
    // TournamentMapper //
    //------------------//
    
    public List<Tournament> getAllTournaments(int year);
    public void addTournament(Tournament tournament);
    public void updateTournament(Tournament tournament);
    
    //-------------------//
    // CompetitionMapper //
    //-------------------//
    
    public List<Competition> getAllCompetitions(int tournamentID);
    public void addCompetition(Competition competition);
    public void updateCompetition(Competition competition);

    //--------------------//
    // TrainingTimeMapper //
    //--------------------//
    
    public void addTime(TrainingTime trainingTime);
    public List<TrainingTime> getMemberTimes(int memberID);
    public List<TrainingTime> getTop5(SwimmingDiscipline sd);
    
    //-----------------------//
    // CompetitionTimeMapper //
    //-----------------------//
    
    public void addTime(CompetitionTime competitionTime);
    public List<CompetitionTime> getAllTimes(int competitionID);
    
}
