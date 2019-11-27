
package model;

import java.time.LocalDate;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class TrainingTime extends Times {
    private int memeberID;
    private LocalDate date;
    
    public TrainingTime(int memberID, LocalDate date, int timeInMs, SwimmingDiscipline sd){
        super(timeInMs,sd);
        this.memeberID = memberID;
        this.date = date;
        
    }

    public int getMemeberID() {
        return memeberID;
    }

    public LocalDate getDate() {
        return date;
    }
}
