package datasource;

import model.Tournament;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 *
 * @author olvvang
 */
public class TournamentMapperTest extends TestBaseIntegration{

    public TournamentMapperTest() throws IOException {
    }

    @Test
    public void TestgetAllTournaments2019() {
        ArrayList<Tournament> actual;
        TournamentMapper instanceTournamentMapper = new TournamentMapper();
        actual = instanceTournamentMapper.getAllTournaments(2019);

        int expectedID1 = 1;
        String expectedName = "JuleCup";
        String str = "2019-02-18";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expectedDate = LocalDate.parse(str, formatter);
        String expectedLocation = "Espergærde";
        int expectedSize = 3;

        assertEquals(expectedID1, actual.get(0).getId());
        assertEquals(expectedName, actual.get(0).getName());
        assertEquals(expectedDate, actual.get(0).getDate());
        assertEquals(expectedLocation, actual.get(0).getLocation());
        assertEquals(expectedSize,actual.size());
    }

    @Test
    public void TestgetAllTournaments2018() {
        ArrayList<Tournament> actual;
        TournamentMapper instanceTournamentMapper = new TournamentMapper();
        actual = instanceTournamentMapper.getAllTournaments(2018);

        int expectedID1 = 4;
        String expectedName = "FerieCup";
        String str = "2018-08-19";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expectedDate = LocalDate.parse(str, formatter);
        String expectedLocation = "Roskilde";
        int expectedSize = 1;

        assertEquals(expectedID1, actual.get(0).getId());
        assertEquals(expectedName, actual.get(0).getName());
        assertEquals(expectedDate, actual.get(0).getDate());
        assertEquals(expectedLocation, actual.get(0).getLocation());
        assertEquals(expectedSize,actual.size());
    }

    @Test
    public void TestAddTournament() {
        int expectedID = 5;
        String expectedName = "FerieCup";
        String str = "2017-08-19";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expectedDate = LocalDate.parse(str, formatter);
        String expectedLocation = "Roskilde";
        int expectedSize = 1;
        Tournament tournamentToBeAdded = new Tournament(expectedID,expectedName,expectedDate,expectedLocation);

        ArrayList<Tournament> actual;
        TournamentMapper instanceTournamentMapper = new TournamentMapper();
        instanceTournamentMapper.addTournament(tournamentToBeAdded);

        actual = instanceTournamentMapper.getAllTournaments(2017);

        assertEquals(expectedID, actual.get(0).getId());
        assertEquals(expectedName, actual.get(0).getName());
        assertEquals(expectedDate, actual.get(0).getDate());
        assertEquals(expectedLocation, actual.get(0).getLocation());
        assertEquals(expectedSize,actual.size());
    }

    @Test
    public void TestAddTwoTournaments() {
        int expectedID = 5;
        int expectedID2 = 6;
        String expectedName = "MelCup";
        String str = "2017-08-19";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expectedDate = LocalDate.parse(str, formatter);
        String expectedLocation = "Roskilde";
        int expectedSize = 2;
        Tournament tournamentToBeAdded = new Tournament(expectedID,expectedName,expectedDate,expectedLocation);
        Tournament tournamentToBeAdded2 = new Tournament(expectedID2,expectedName+2,expectedDate,expectedLocation+2);

        ArrayList<Tournament> actual;
        TournamentMapper instanceTournamentMapper = new TournamentMapper();

        //Adding
        instanceTournamentMapper.addTournament(tournamentToBeAdded);
        instanceTournamentMapper.addTournament(tournamentToBeAdded2);

        actual = instanceTournamentMapper.getAllTournaments(2017);

        assertEquals(expectedID, actual.get(0).getId());
        assertEquals(expectedName, actual.get(0).getName());
        assertEquals(expectedDate, actual.get(0).getDate());
        assertEquals(expectedLocation, actual.get(0).getLocation());
        assertEquals(expectedSize,actual.size());
    }
}
