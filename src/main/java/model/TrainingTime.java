
package model;

import java.time.LocalDate;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class TrainingTime extends Times {
    private LocalDate date;
    private SwimmingDiscipline sd;
    
    public TrainingTime(int memberID, LocalDate date, int timeInMs, SwimmingDiscipline sd){
        super(timeInMs,memberID);
        this.date = date;
        this.sd = sd;
    }

    public LocalDate getDate() {
        return date;
    }
    public SwimmingDiscipline getSwimmingDiscipline(){return sd;}
}
