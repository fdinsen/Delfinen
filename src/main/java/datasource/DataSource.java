
package datasource;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public interface DataSource {
    
    //--------------//
    // MemberMapper //
    //--------------//
    
    void createMember(Member member);
    void updateMember(Member member);
    void deleteMember(int memberID);
    List<Member> getMemberByPhone(String phonenumber);
    List<Member> getMemberByEmail(String email);
    List<Member> getMemberByName(String name);
    Member getMemberByID(int memberID);
    ArrayList<String> getMemberSwimmingDiscipline(int memberID);
    
    
    //----------------//
    // RestanceMapper //
    //----------------//
    List<Member> getAllRestance();
    boolean memberHasRestance(int memberID);
    boolean markAsPaid(int memberID);
    boolean makeNewSeason();
    
    //---------------//
    // TrainerMapper //
    //---------------//
    
    void createTrainer(Trainer trainer);
    void updateTrainer(Trainer trainer);
    void deleteTrainer(int trainerID);
    Trainer getTrainer(int trainerID);
    String[] getAllTrainers();

    //------------------//
    // TournamentMapper //
    //------------------//
    
    List<Tournament> getAllTournaments(int year);
    void addTournament(Tournament tournament);
    void updateTournament(Tournament tournament);
    
    //-------------------//
    // CompetitionMapper //
    //-------------------//
    
    List<Competition> getAllCompetitions(int tournamentID);
    void addCompetition(Competition competition);
    void updateCompetition(Competition competition);

    //--------------------//
    // TrainingTimeMapper //
    //--------------------//
    
    void addTime(TrainingTime trainingTime);
    List<TrainingTime> getMemberTimes(int memberID);
    List<TrainingTime> getTop5Senior(int swimmingDisciplineID);
    List<TrainingTime> getTop5Junior(int swimmingDisciplineID);
    String getTrainerName(int trainerID);
    
    //-----------------------//
    // CompetitionTimeMapper //
    //-----------------------//
    
    void addTime(CompetitionTime competitionTime);
    List<CompetitionTime> getAllTimes(int competitionID);
    
    //-----------------//
    // PrivilegeMapper //
    //-----------------//
    
    boolean[] getPrivileges(int id);
    
    //------------------//
    // DisciplineMapper //
    //------------------//
    
    String[] getAllDisciplines();
}
