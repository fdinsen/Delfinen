
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

    public int getId() {
        return tId;
    }

    public String getName() {
        return tName;
    }

    public LocalDate getDate() {
        return tDate;
    }

    public String getLocation() {
        return Location;
    }
}
