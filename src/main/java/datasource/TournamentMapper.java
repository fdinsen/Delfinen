package datasource;

import model.Member;
import model.MembershipStatus;
import model.MembershipType;
import model.Tournament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TournamentMapper {
    private Connection con = null;

    public ArrayList<Tournament> getAllTournaments(int year) {
        ArrayList<Tournament> tournaments = new ArrayList<>();

        try {
            con = DBConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM tournaments WHERE (t_date BETWEEN ? AND ?)");
            stmt.setString(1, year+"-01-01");
            stmt.setString(2, year+"-12-31");
            ResultSet rsTournaments = stmt.executeQuery();
            while (rsTournaments.next()) {
                int tId = rsTournaments.getInt("t_id");
                String tName = rsTournaments.getString("t_name");
                LocalDate tDate = rsTournaments.getDate("t_date").toLocalDate();
                String tLocation = rsTournaments.getString("t_location");

                Tournament tournament = new Tournament(tId,tName,tDate,tLocation);
                tournaments.add(tournament);
            }
            rsTournaments.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Problem med at hente alle stævner, prøv igen");
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tournaments;
    }
}
