
package model;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public abstract class Times {
    private int timeInMS;
    private SwimmingDiscipline sd;

    public int getTimeInMS() {
        return timeInMS;
    }

    public SwimmingDiscipline getSd() {
        return sd;
    }
    
    public Times(int timeInMs, SwimmingDiscipline sd){
        this.timeInMS = timeInMs;
        this.sd = sd;
    }
    }

