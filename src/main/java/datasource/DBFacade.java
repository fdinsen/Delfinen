
package datasource;

import java.util.List;
import model.Trainer;
import model.Competition;
import model.Tournament;
import model.TrainingTime;
import model.CompetitionTime;
import model.Member;
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
    public int[] getMemberSwimmingDiscipline(int memberID) {
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
    public void updtateTrainer(Trainer trainer) {
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
    public List<TrainingTime> getTop5(int swimmingDisciplineID) {
        return new TrainingTimeMapper().getTop5(swimmingDisciplineID);
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

}
