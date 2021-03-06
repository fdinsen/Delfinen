
package model;


public class Competition {
    private int competitionsId;
    private int tournamentID;
    private int swimmingDisciplineID;

    public Competition(int competitionsId, int tournamentID, int swimmingDisciplineID) {
        this.competitionsId = competitionsId;
        this.tournamentID = tournamentID;
        this.swimmingDisciplineID = swimmingDisciplineID;
    }
    
    public Competition(int tournamentID, int swimmingDisciplineId) {
        this.swimmingDisciplineID = swimmingDisciplineId;
        this.tournamentID = tournamentID;
    }

    public int getCompetitionsId() {
        return competitionsId;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public int getSwimmingDiscipline() {
        return swimmingDisciplineID;
    }
    
}
