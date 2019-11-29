package datasource;

import model.Tournament;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TournamentMapper {
    private Connection con = null;

    public ArrayList<Tournament> getAllTournaments(int year) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
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
                Calendar cet = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
                LocalDate tDate = rsTournaments.getDate("t_date", cet).toLocalDate();
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

    public void addTournament(Tournament tournament) {
        con = DBConnector.getConnection();
        String SQL = "INSERT INTO tournaments (t_name, t_date, t_location)"
                + "VALUES (?, ?, ?)";
        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, tournament.getName());
            Date date = java.sql.Date.valueOf(tournament.getDate().toString());
            ps.setDate(2, date);
            ps.setString(3, tournament.getLocation());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke tilføje stævne, prøv igen");
        }
    }

    public void updateTournament(Tournament tournament) {
        con = DBConnector.getConnection();
        String SQL = "UPDATE tournaments SET t_name = ?, t_date = ?, t_location = ? WHERE t_id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, tournament.getName());
            Date date = java.sql.Date.valueOf(tournament.getDate().toString());
            ps.setDate(2, date);
            ps.setString(3, tournament.getLocation());
            ps.setInt(4, tournament.getId());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke opdatere stævnet, prøv igen");
        }
    }
}
