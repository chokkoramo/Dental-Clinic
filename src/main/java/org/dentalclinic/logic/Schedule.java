package org.dentalclinic.logic;

public class Schedule {
    private int scheduleId;
    private String startingTime;
    private String endingTime;

    public Schedule(int scheduleId, String startingTime, String endingTime) {
        this.scheduleId = scheduleId;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public int getscheduleId() {
        return scheduleId;
    }

    public void setscheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }
}
