package datasource;

import model.Competition;
import model.CompetitionTime;
import enums.SwimmingDiscipline;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author olvvang
 */
public class CompetitionTimeMapperTest extends TestDataSetup{

    public CompetitionTimeMapperTest() throws IOException {
    }

    @Test
    public void getAllCompetitionTimesID1() {
        ArrayList<CompetitionTime> actual;
        CompetitionTimeMapper instanceCompetitionTimeMapper = new CompetitionTimeMapper();
        actual = instanceCompetitionTimeMapper.getAllCompetitionTimesTimes(1);

        int expectedCTimeID = 2;
        int expectedCID = 1;
        int expectedMemberId = 2;
        int expectedCTimeMS = 4321;
        int expectedSize = 3;

        assertEquals(expectedCTimeID, actual.get(1).getCompetitionTimeID());
        assertEquals(expectedCID, actual.get(1).getCompetitionID());
        assertEquals(expectedMemberId, actual.get(1).getMemberID());
        assertEquals(expectedCTimeMS, actual.get(1).getTimeInMS());

        assertEquals(expectedSize,actual.size());
    }

    @Test
    public void TestgetAllTournementsID2() {
        ArrayList<CompetitionTime> actual;
        CompetitionTimeMapper instanceCompetitionTimeMapper = new CompetitionTimeMapper();
        actual = instanceCompetitionTimeMapper.getAllCompetitionTimesTimes(2);

        int expectedCTimeID = 5;
        int expectedCID = 2;
        int expectedMemberId = 3;
        int expectedCTimeMS = 600;
        int expectedSize = 2;

        assertEquals(expectedCTimeID, actual.get(1).getCompetitionTimeID());
        assertEquals(expectedCID, actual.get(1).getCompetitionID());
        assertEquals(expectedMemberId, actual.get(1).getMemberID());
        assertEquals(expectedCTimeMS, actual.get(1).getTimeInMS());

        assertEquals(expectedSize,actual.size());
    }

    @Test
    public void TestaddCompetitionTime() {
        int expectedCTimeID = 6;
        int expectedCID = 2;
        int expectedMemberId = 7;
        int expectedCTimeMS = 700;
        int expectedSize = 3;
        ArrayList<CompetitionTime> actual;
        CompetitionTimeMapper instanceCompetitionTimeMapper = new CompetitionTimeMapper();
        CompetitionTime competitionTimeToBeAdded = new CompetitionTime(expectedCTimeID,expectedCID,expectedMemberId,expectedCTimeMS);
        instanceCompetitionTimeMapper.addCompetitionTime(competitionTimeToBeAdded);

        actual = instanceCompetitionTimeMapper.getAllCompetitionTimesTimes(2);

        assertEquals(expectedCTimeID, actual.get(2).getCompetitionTimeID());
        assertEquals(expectedCID, actual.get(2).getCompetitionID());
        assertEquals(expectedMemberId, actual.get(2).getMemberID());
        assertEquals(expectedCTimeMS, actual.get(2).getTimeInMS());

        assertEquals(expectedSize,actual.size());
    }
}
