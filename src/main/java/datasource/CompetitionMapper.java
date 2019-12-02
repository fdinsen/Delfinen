package datasource;

import model.Competition;
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
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM delfinen.competitions where t_id = ?");
            stmt.setInt(1, tournamentID);
            ResultSet rsCompetition = stmt.executeQuery();
            while (rsCompetition.next()) {
                int competitionsId = rsCompetition.getInt("competitions_id");
                int swimmingDiscipline = rsCompetition.getInt("discipline_id");

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
        String SQL = "INSERT INTO competitions (competitions_id, t_id, discipline_id)"
                + "VALUES (?, ?, ?)";
        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, competition.getCompetitionsId());
            ps.setInt(2, competition.getTournamentID());
            ps.setInt(3, competition.getSwimmingDiscipline());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke tilføje konkurrence, prøv igen");
        }
    }

    public void updateTournament(Competition competition) {
        con = DBConnector.getConnection();
        String SQL = "UPDATE competitions SET competitions_id = ?, t_id = ?, discipline_id = ? WHERE competitions_id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, competition.getCompetitionsId());
            ps.setInt(2, competition.getTournamentID());
            ps.setInt(3, competition.getSwimmingDiscipline());
            ps.setInt(4, competition.getTournamentID());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kunne ikke opdatere konkurrencen, prøv igen");
        }
    }
}
