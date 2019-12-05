
package datasource;

import model.*;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class DBFacade implements DataSource {

    //--------------//
    // MemberMapper //
    //--------------//
    @Override
    public void createMember(Member member) {
        new MemberMapper().createMember(member);
    }

    @Override
    public void updateMember(Member member) {
        new MemberMapper().updateMember(member);
    }
    
    @Override
    public ArrayList<String> getMemberSwimmingDiscipline(int memberID) {
        return new MemberMapper().getMemberSwimmingDiscipline(memberID);
    }

    @Override
    public void deleteMember(int memberID) {
        new MemberMapper().deleteMember(memberID);

    }

    @Override
    public List<Member> getMemberByPhone(String phonenumber) {
        return new MemberMapper().getMemberByPhone(phonenumber);
    }

    @Override
    public List<Member> getMemberByEmail(String email) {
        return new MemberMapper().getMemberByEmail(email);
    }

    @Override
    public List<Member> getMemberByName(String name) {
        return new MemberMapper().getMemberByName(name);
    }
    
        @Override
    public Member getMemberByID(int memberID) {
        return new MemberMapper().getMemberByID(memberID);
    }

    //----------------//
    // RestanceMapper //
    //----------------//
    
    @Override
    public List<Member> getAllRestance() {
        return new RestanceMapper().getAllRestance();
    }

    @Override
    public boolean memberHasRestance(int memberID) {
        return new RestanceMapper().memberHasRestance(memberID);
    }

    @Override
    public boolean markAsPaid(int memberID) {
        return new RestanceMapper().markAsPaid(memberID);
    }

    @Override
    public boolean makeNewSeason() {
        return new RestanceMapper().makeNewSeason();
    }
    
    //---------------//
    // TrainerMapper //
    //---------------//

    @Override
    public void createTrainer(Trainer trainer) {
        new TrainerMapper().createTrainer(trainer);
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        new TrainerMapper().updateTrainer(trainer);
    }

    @Override
    public void deleteTrainer(int trainerID) {
        new TrainerMapper().deleteTrainer(trainerID);
    }

    @Override
    public Trainer getTrainer(int trainerID) {
        return new TrainerMapper().getTrainer(trainerID);
    }
    
    @Override
    public String[] getAllTrainers() {
        return new TrainerMapper().getAllTrainers();
    }

    @Override
    public void updateTrainingTime(TrainingTime trainingTime) {
        new TrainingTimeMapper().updateTrainingTime(trainingTime);
    }

    ;

    //------------------//
    // TournamentMapper //
    //------------------//
    
    @Override
    public List<Tournament> getAllTournaments(int year) {
        return new TournamentMapper().getAllTournaments(year);
    }

    @Override
    public void addTournament(Tournament tournament) {
        new TournamentMapper().addTournament(tournament);
    }

    @Override
    public void updateTournament(Tournament tournament) {
        new TournamentMapper().updateTournament(tournament);
    }

    //-------------------//
    // CompetitionMapper //
    //-------------------//
    
    @Override
    public List<Competition> getAllCompetitions(int tournamentID) {
        return new CompetitionMapper().getAllCompetitions(tournamentID);
    }

    @Override
    public void addCompetition(Competition competition) {
        new CompetitionMapper().addCompetition(competition);
    }

    @Override
    public void updateCompetition(Competition competition) {
        new CompetitionMapper().updateTournament(competition);
    }

    //--------------------//
    // TrainingTimeMapper //
    //--------------------//
    
    @Override
    public void addTime(TrainingTime trainingTime) {
        new TrainingTimeMapper().addTime(trainingTime);
    }

    @Override
    public List<TrainingTime> getMemberTimes(int memberID) {
        return new TrainingTimeMapper().getMemberTimes(memberID);
    }

    @Override
    public List<TrainingTime> getTop5Senior(int swimmingDisciplineID) {
        return new TrainingTimeMapper().getTop5Senior(swimmingDisciplineID);
    }
    @Override
    public List<TrainingTime> getTop5Junior(int swimmingDisciplineID) {
        return new TrainingTimeMapper().getTop5Junior(swimmingDisciplineID);
    }
    @Override
    public String getTrainerName(int trainerID) {
        return new TrainerMapper().getTrainerName(trainerID);
    }

    //-----------------------//
    // CompetitionTimeMapper //
    //-----------------------//
    
    @Override
    public void addTime(CompetitionTime competitionTime) {
        new CompetitionTimeMapper().addCompetitionTime(competitionTime);
    }
    
    @Override
    public List<CompetitionTime> getAllTimes(int competitionID) {
        return new CompetitionTimeMapper().getAllCompetitionTimesTimes(competitionID);
    }

    //-----------------//
    // PrivilegeMapper //
    //-----------------//
    
    @Override
    public boolean[] getPrivileges(int id) {
        return new PrivilegeMapper().getPrivileges(id);
    }

    
    //------------------//
    // DisciplineMapper //
    //------------------//
    
    @Override
    public String[] getAllDisciplines() {
        return new DisciplineMapper().getAllDisciplines();
    }

}
