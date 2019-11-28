
package model;

import java.time.LocalDate;


public class Tournament {
    private int tId;
    private String tName;
    private LocalDate tDate;
    private String Location;

    public Tournament(int tId, String tName, LocalDate tDate, String tLocation) {
        this.tId = tId;
        this.tName = tName;
        this.tDate = tDate;
        this.Location = tLocation;
    }

    public int gettId() {
        return tId;
    }

    public String gettName() {
        return tName;
    }

    public LocalDate gettDate() {
        return tDate;
    }

    public String getLocation() {
        return Location;
    }
}
