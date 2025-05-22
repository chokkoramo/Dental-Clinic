package org.dentalclinic.logic;

import jakarta.persistence.*;
import java.io.Serializable;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Dentist extends Person implements Serializable {

//    private int dentistId;
    private String specialty;
    @OneToMany(mappedBy = "dentistMap")
    private List<Shift> shiftList;
    @OneToOne
    private User user;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;

    public Dentist() {
    }

    public Dentist(int id, String dni, String firstName, String lastName, String phone, String address, LocalDate dateOfBirth, String specialty, List<Shift> shiftList, User user, Schedule schedule) {
        super(id, dni, firstName, lastName, phone, address, dateOfBirth);
        this.specialty = specialty;
        this.shiftList = shiftList;
        this.user = user;
        this.schedule = schedule;
    }

//    public int getdentistId() {
//        return dentistId;
//    }
//
//    public void setdentistId(int dentistId) {
//        this.dentistId = dentistId;
//    }

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
