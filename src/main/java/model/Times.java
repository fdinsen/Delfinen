package model;

import ComponentValidation.TimeComponent;
import ComponentValidation.ValidationComponent;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public abstract class Times {

    private int timeInMS;
    private int memberID;

    public int getTimeInMS() {
        return timeInMS;
    }

    public int getMemberID() {
        return memberID;
    }

    public Times(int timeInMs, int memberID) {
        this.timeInMS = timeInMs;
        this.memberID = memberID;
    }

    public String getTimeInMinutes() {
        int minutes = (timeInMS / 1000) / 60;
        int seconds = (timeInMS / 1000) % 60;
        int ms = (timeInMS / 1000) % 60 % 100;
        return minutes + ":" + seconds + ":" + ms;
    }

    public static int convertToMS(String time) {
        ValidationComponent timeInput = new TimeComponent();

        if (timeInput.checkComponent(time)) {
            String[] times = time.split(":");
            int timeInMS = 0;
            timeInMS += Integer.parseInt(times[0]) * 60 * 1000;
            timeInMS += Integer.parseInt(times[1]) * 1000;
            timeInMS += Integer.parseInt(times[2]);
            return timeInMS;
        }

        return -1;

    }

}
