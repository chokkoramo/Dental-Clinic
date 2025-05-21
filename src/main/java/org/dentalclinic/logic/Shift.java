package org.dentalclinic.logic;

import jakarta.persistence.*;
import java.io.Serializable;

import java.time.LocalDate;

@Entity
public class Shift implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shiftId;
    private String affection;
    private LocalDate date;
    private String time;
    private String description;

    @ManyToOne
    @JoinColumn(name = "dentistMapId")
    private Dentist dentistMap;

    @ManyToOne
    @JoinColumn(name = "patientMapId")
    private Patient patientMap;

    public Shift(int shiftId, String affection, LocalDate date, String time, String description, Dentist dentistMap, Patient patientMap) {
        this.shiftId = shiftId;
        this.affection = affection;
        this.date = date;
        this.time = time;
        this.description = description;
        this.dentistMap = dentistMap;
        this.patientMap = patientMap;
    }

    public Shift() {
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public String getAffection() {
        return affection;
    }

    public void setAffection(String affection) {
        this.affection = affection;
    }

    public Dentist getDentistMap() {
        return dentistMap;
    }

    public void setDentistMap(Dentist dentistMap) {
        this.dentistMap = dentistMap;
    }

    public Patient getPatientMap() {
        return patientMap;
    }

    public void setPatientMap(Patient patientMap) {
        this.patientMap = patientMap;
    }
}
