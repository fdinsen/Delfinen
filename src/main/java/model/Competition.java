
package model;

import enums.SwimmingDiscipline;

public class Competition {
    private int competitionsId;
    private int tournamentID;
    private SwimmingDiscipline swimmingDiscipline;

    public Competition(int competitionsId, int tournamentID, SwimmingDiscipline swimmingDiscipline) {
        this.competitionsId = competitionsId;
        this.tournamentID = tournamentID;
        this.swimmingDiscipline = swimmingDiscipline;
    }

    public int getCompetitionsId() {
        return competitionsId;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public SwimmingDiscipline getSwimmingDiscipline() {
        return swimmingDiscipline;
    }
}
