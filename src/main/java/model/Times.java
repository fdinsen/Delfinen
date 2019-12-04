package model;

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


    public int getMemberID(){
        return memberID;
    }

    public Times(int timeInMs, int memberID) {
        this.timeInMS = timeInMs;
        this.memberID = memberID;
    }

    public int getTimeInMinutes();


}
