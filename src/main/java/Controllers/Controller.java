package Controllers;

import datasource.DataSource;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class Controller {

    private DataSource datasource;
    private int profileID;
    private boolean[] userPrivileges;

    //-------------//
    // CONSTRUCTOR //
    //-------------//
    public Controller(DataSource datasource, int profileID) {
        this.datasource = datasource;
        this.userPrivileges = datasource.getPrivileges(profileID);
        this.profileID = profileID;
    }
    //---------//
    // METHODS //
    //---------//
    
    public int getProfileID() {
        return profileID;
    }
    
    public boolean[] getUserPrivileges() {
        return userPrivileges;
    }
    
    //--------------//
    // MemberMapper //
    //--------------//
    public ArrayList<Member> getMemberByPhone(String phoneNumber) {
        return (ArrayList) datasource.getMemberByPhone(phoneNumber);
    }

    public ArrayList<Member> getMemberByEmail(String email) {
        return (ArrayList) datasource.getMemberByEmail(email);
    }

    public ArrayList<Member> getMemberByName(String name) {
        return (ArrayList) datasource.getMemberByName(name);
    }
    
    public Member getMemberByID(int memberID) {
        return datasource.getMemberByID(memberID);
    }

    public void updateMember(Member member) {
        datasource.updateMember(member);
    }

    public void createMember(Member member) {
        datasource.createMember(member);
    }
    
    public ArrayList<String> getMemberSwimmingDisciplines(int memberID) {
        return datasource.getMemberSwimmingDiscipline(memberID);
    }

    //----------------//
    // RestanceMapper //
    //----------------//
    public ArrayList<Member> getAllRestance() {
        return (ArrayList) datasource.getAllRestance();
    }

    public boolean memberHasRestance(int memberID) {
        return datasource.memberHasRestance(memberID);
    }

    public boolean markAsPaid(int memberID) {
        return datasource.markAsPaid(memberID);
    }

    public boolean makeNewSeason() {
        return datasource.makeNewSeason();
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

    public ArrayList<TrainingTime> getTop5Senior(int swimmingDisciplineID) {
        return (ArrayList) datasource.getTop5Senior(swimmingDisciplineID);
    }
    public ArrayList<TrainingTime> getTop5Junior(int swimmingDisciplineID) {
        return (ArrayList) datasource.getTop5Junior(swimmingDisciplineID);
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

    public Trainer getTrainer(int trainerID) {
        return datasource.getTrainer(trainerID);
    }
    public String getTrainerName(int trainerID){
        return datasource.getTrainerName(trainerID);
    }

    public String[] getAllTrainers() {
        return datasource.getAllTrainers();
    }

    public String[] getAllDisciplines() {
        return datasource.getAllDisciplines();
    }
}
