package org.dentalclinic.logic;

import java.util.Date;
import java.util.List;

public class Dentist extends Person {

    private int dentistId;
    private String specialty;
    private List<Shift> shiftList;
    private User user;
    private Schedule schedule;

    public Dentist() {
    }

    public Dentist(int personId, String dni, String firstName, String lastName, String phone, String address, Date dateOfBirth, int dentistId, String specialty, List<Shift> shiftList, User user, Schedule schedule) {
        super(personId, dni, firstName, lastName, phone, address, dateOfBirth);
        this.dentistId = dentistId;
        this.specialty = specialty;
        this.shiftList = shiftList;
        this.user = user;
        this.schedule = schedule;
    }

    public int getdentistId() {
        return dentistId;
    }

    public void setdentistId(int dentistId) {
        this.dentistId = dentistId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Shift> getShiftList() {
        return shiftList;
    }

    public void setShiftList(List<Shift> shiftList) {
        this.shiftList = shiftList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
