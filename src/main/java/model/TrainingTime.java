
package model;

import java.time.LocalDate;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class TrainingTime extends Times {
    private LocalDate date;
    private int sd;
    
    public TrainingTime(int memberID, LocalDate date, int timeInMs, int sd){
        super(timeInMs,memberID);
        this.date = date;
        this.sd = sd;
    }
    

    public LocalDate getDate() {
        return date;
    }
    public int getSwimmingDiscipline(){
        return sd;
    }
}
