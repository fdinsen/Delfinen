package datasource;

import model.Competition;
import enums.SwimmingDiscipline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompetitionMapper {
    private Connection con = null;

    public ArrayList<Competition> getAllCompetitions(int tournamentID) {
        ArrayList<Competition> competitions = new ArrayList<>();

        try {
            con = DBConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM competitions WHERE t_id = ?");
            stmt.setInt(1, tournamentID);
            ResultSet rsCompetition = stmt.executeQuery();
            while (rsCompetition.next()) {
                int competitionsId = rsCompetition.getInt("competitions_id");
                SwimmingDiscipline swimmingDiscipline = SwimmingDiscipline.valueOf(rsCompetition.getString("swimming_discipline"));

                Competition competition = new Competition(competitionsId,tournamentID,swimmingDiscipline);
                competitions.add(competition);
            }
            rsCompetition.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Problem med at hente alle konkurrencer, prøv igen");
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return competitions;
    }

    public void addCompetition(Competition competition) {
        con = DBConnector.getConnection();
        String SQL = "INSERT INTO competitions (competitions_id, t_id, swimming_discipline)"
                + "VALUES (?, ?, ?)";
        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, competition.getCompetitionsId());
            ps.setInt(2, competition.getTournamentID());
            ps.setString(3, competition.getSwimmingDiscipline().toString());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke tilføje konkurrence, prøv igen");
        }
    }

    public void updateTournament(Competition competition) {
        con = DBConnector.getConnection();
        String SQL = "UPDATE competitions SET competitions_id = ?, t_id = ?, swimming_discipline = ? WHERE competitions_id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, competition.getCompetitionsId());
            ps.setInt(2, competition.getTournamentID());
            ps.setString(3, competition.getSwimmingDiscipline().toString());
            ps.setInt(4, competition.getTournamentID());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke opdatere konkurrencen, prøv igen");
        }
    }
}
