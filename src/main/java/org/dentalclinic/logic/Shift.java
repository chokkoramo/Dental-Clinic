package org.dentalclinic.logic;

import jakarta.persistence.*;
import java.io.Serializable;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Shift implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shiftId;
    private LocalDate date;
    private String time;
    private String description;

    @ManyToOne
    @JoinColumn(name = "shiftId")
    private Dentist dentistMap;

    @ManyToOne
    @JoinColumn(name = "shiftId")
    private Patient patientMap;

    public Shift() {
    }

    public Shift(int shiftId, LocalDate date, String time, String description, Dentist dentistMap, Patient patientMap) {
        this.shiftId = shiftId;
        this.date = date;
        this.time = time;
        this.description = description;
        this.dentistMap = dentistMap;
        this.patientMap = patientMap;
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
}
