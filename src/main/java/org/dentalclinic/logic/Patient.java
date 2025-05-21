package org.dentalclinic.logic;

import jakarta.persistence.*;
import java.io.Serializable;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Patient extends Person implements Serializable {
//    private int patientId;
    private boolean medicalInsurance;
    private String bloodType;
    @OneToOne
    private LegalGuardian legalGuardian;
    @OneToMany(mappedBy = "patientMap")
    private List<Shift> shiftList;

    public Patient() {
    }

    public Patient(int id, String dni, String firstName, String lastName, String phone, String address, LocalDate dateOfBirth, boolean medicalInsurance, String bloodType, LegalGuardian legalGuardian, List<Shift> shiftList) {
        super(id, dni, firstName, lastName, phone, address, dateOfBirth);
        this.medicalInsurance = medicalInsurance;
        this.bloodType = bloodType;
        this.legalGuardian = legalGuardian;
        this.shiftList = shiftList;
    }

//    public int getpatientId() {
//        return patientId;
//    }
//
//    public void setpatientId(int patientId) {
//        this.patientId = patientId;
//    }

    public boolean isMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(boolean medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public LegalGuardian getaLegalGuardian() {
        return legalGuardian;
    }

    public void setaLegalGuardian(LegalGuardian aLegalGuardian) {
        this.legalGuardian = aLegalGuardian;
    }

    public List<Shift> getShiftList() {
        return shiftList;
    }

    public void setShiftList(List<Shift> shiftList) {
        this.shiftList = shiftList;
    }
}
