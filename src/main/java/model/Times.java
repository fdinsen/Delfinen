package model;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public abstract class Times {

    private int timeInMS;
    private SwimmingDiscipline sd;
    private String name;

    public int getTimeInMS() {
        return timeInMS;
    }

    public SwimmingDiscipline getSd() {
        return sd;
    }

    public String getName() {
        return name;
    }

    public Times(int timeInMs, SwimmingDiscipline sd, String name) {
        this.timeInMS = timeInMs;
        this.sd = sd;
        this.name = name;
    }
}
