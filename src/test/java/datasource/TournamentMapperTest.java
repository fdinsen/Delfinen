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
public class TournamentMapperTest {
    public TournamentMapperTest() throws IOException {

    }

    @Test
    public void getAllTournaments2019() {
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
    public void getAllTournaments2018() {
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
}
