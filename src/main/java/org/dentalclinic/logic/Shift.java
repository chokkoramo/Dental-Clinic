package org.dentalclinic.logic;

import java.util.Date;

public class Shift {
    private int shiftId;
    private Date date;
    private String time;
    private String description;

    public Shift() {
    }

    public Shift(int shiftId, Date date, String time, String description) {
        this.shiftId = shiftId;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
