package datasource;

import model.Competition;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author olvvang
 */
public class CompetitionsMapperTest extends TestDataSetup{

    public CompetitionsMapperTest() throws IOException {
    }

    @Test
    public void TestgetAllTournementsID1() {
        ArrayList<Competition> actual;
        CompetitionMapper instanceTournamentMapper = new CompetitionMapper();
        actual = instanceTournamentMapper.getAllCompetitions(1);

        int expectedCID1 = 1;
        int expectedTID1 = 1;
        int expectedSwimingDisciplineId1 = 1;
        int expectedCID2 = 2;
        int expectedTID2 = 1;
        int expectedSwimingDisciplineId2 = 4;
        int expectedCID3 = 3;
        int expectedTID3 = 1;
        int expectedSwimingDisciplineId3 = 3;

        int expectedSize = 3;

        assertEquals(expectedCID1, actual.get(0).getCompetitionsId());
        assertEquals(expectedTID1, actual.get(0).getTournamentID());
        assertEquals(expectedSwimingDisciplineId1, actual.get(0).getSwimmingDiscipline());
        assertEquals(expectedCID2, actual.get(1).getCompetitionsId());
        assertEquals(expectedTID2, actual.get(1).getTournamentID());
        assertEquals(expectedSwimingDisciplineId2, actual.get(1).getSwimmingDiscipline());
        assertEquals(expectedCID3, actual.get(2).getCompetitionsId());
        assertEquals(expectedTID3, actual.get(2).getTournamentID());
        assertEquals(expectedSwimingDisciplineId3, actual.get(2).getSwimmingDiscipline());

        assertEquals(expectedSize,actual.size());
    }

    @Test
    public void TestgetAllTournementsID2() {
        ArrayList<Competition> actual;
        CompetitionMapper instanceTournamentMapper = new CompetitionMapper();
        actual = instanceTournamentMapper.getAllCompetitions(2);

        int expectedCID1 = 4;
        int expectedTID1 = 2;
        int expectedSwimingDiscipline1 = 3;
        int expectedCID2 = 5;
        int expectedTID2 = 2;
        int expectedSwimingDiscipline2 = 4;
        int expectedCID3 = 6;
        int expectedTID3 = 2;
        int expectedSwimingDiscipline3 = 2;

        int expectedSize = 3;

        assertEquals(expectedCID1, actual.get(0).getCompetitionsId());
        assertEquals(expectedTID1, actual.get(0).getTournamentID());
        assertEquals(expectedSwimingDiscipline1, actual.get(0).getSwimmingDiscipline());
        assertEquals(expectedCID2, actual.get(1).getCompetitionsId());
        assertEquals(expectedTID2, actual.get(1).getTournamentID());
        assertEquals(expectedSwimingDiscipline2, actual.get(1).getSwimmingDiscipline());
        assertEquals(expectedCID3, actual.get(2).getCompetitionsId());
        assertEquals(expectedTID3, actual.get(2).getTournamentID());
        assertEquals(expectedSwimingDiscipline3, actual.get(2).getSwimmingDiscipline());

        assertEquals(expectedSize,actual.size());
    }

    @Test
    public void TestAddCompetition() {
        ArrayList<Competition> actual;
        int expectedCID = 7;
        int expectedTID = 3;
        int expectedSwimingDiscipline = 3;

        CompetitionMapper instanceCompetitionMapper = new CompetitionMapper();
        Competition tournamentToBeAdded = new Competition(expectedCID,expectedTID,expectedSwimingDiscipline);
        instanceCompetitionMapper.addCompetition(tournamentToBeAdded);
        actual = instanceCompetitionMapper.getAllCompetitions(expectedTID);

        assertEquals(expectedCID, actual.get(0).getCompetitionsId());
        assertEquals(expectedTID, actual.get(0).getTournamentID());
        assertEquals(expectedSwimingDiscipline, actual.get(0).getSwimmingDiscipline());
    }

    @Test
    public void TestAddTwoCompetitionWithSameID() {
        ArrayList<Competition> actual;
        int expectedCID1 = 7;
        int expectedTID = 3;
        int expectedSwimingDiscipline1 = 3;
        int expectedCID2 = 8;
        int expectedSwimingDiscipline2 = 3;


        Competition tournamentToBeAdded1 = new Competition(expectedCID1,expectedTID,expectedSwimingDiscipline1);
        Competition tournamentToBeAdded2 = new Competition(expectedCID2,expectedTID,expectedSwimingDiscipline2);

        CompetitionMapper instanceCompetitionMapper = new CompetitionMapper();
        instanceCompetitionMapper.addCompetition(tournamentToBeAdded1);
        instanceCompetitionMapper.addCompetition(tournamentToBeAdded2);

        actual = instanceCompetitionMapper.getAllCompetitions(expectedTID);

        assertEquals(expectedCID1, actual.get(0).getCompetitionsId());
        assertEquals(expectedTID, actual.get(0).getTournamentID());
        assertEquals(expectedSwimingDiscipline1, actual.get(0).getSwimmingDiscipline());
        assertEquals(expectedCID2, actual.get(1).getCompetitionsId());
        assertEquals(expectedTID, actual.get(1).getTournamentID());
        assertEquals(expectedSwimingDiscipline2, actual.get(1).getSwimmingDiscipline());
    }

    @Test
    public void TestUpdateCompetition() {
        ArrayList<Competition> actual;
        int expectedCID = 1;
        int expectedTID = 1;
        int expectedSwimingDiscipline1 = 4;

        CompetitionMapper instanceCompetitionMapper = new CompetitionMapper();
        Competition CompetitionToBeUpdated = new Competition(expectedCID,expectedTID,expectedSwimingDiscipline1);
        instanceCompetitionMapper.updateTournament(CompetitionToBeUpdated);

        actual = instanceCompetitionMapper.getAllCompetitions(expectedTID);

        assertEquals(expectedCID, actual.get(0).getCompetitionsId());
        assertEquals(expectedTID, actual.get(0).getTournamentID());
        assertEquals(expectedSwimingDiscipline1, actual.get(0).getSwimmingDiscipline());
    }
}
