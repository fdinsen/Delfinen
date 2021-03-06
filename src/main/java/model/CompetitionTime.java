
package model;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class CompetitionTime extends Times {
    private int competitionTimeID;
    private int competitionID;
    
    public CompetitionTime(int competitionsTimeID,int competitionsID, int memberID, int timeInMs) {
        super(timeInMs, memberID);
        this.competitionTimeID = competitionsTimeID;
        this.competitionID = competitionsID;

    }
    
    public CompetitionTime(int competitionID, int memberID, int timeInMs) {
        super(timeInMs, memberID);
        this.competitionID = competitionID;
    }
    
    public int getCompetitionTimeID(){
        return competitionTimeID;
    }
    public int getCompetitionID(){return  competitionID;}
    
    @Override
    public String toString(){
        return "" + super.toString() +" "+ competitionTimeID + " " + competitionID ;  
    }
}
