package org.dentalclinic.logic;

import java.util.Date;
import java.util.List;

public class Patient extends Person {
    private int patientId;
    private boolean medicalInsurance;
    private String bloodType;
    private LegalGuardian legalGuardian;
    private List<Shift> shiftList;

    public Patient() {
    }

    public Patient(int personId, String dni, String firstName, String lastName, String phone, String address, Date dateOfBirth, int patientId, boolean medicalInsurance, String bloodType, LegalGuardian legalGuardian, List<Shift> shiftList) {
        super(personId, dni, firstName, lastName, phone, address, dateOfBirth);
        this.patientId = patientId;
        this.medicalInsurance = medicalInsurance;
        this.bloodType = bloodType;
        this.legalGuardian = legalGuardian;
        this.shiftList = shiftList;
    }

    public int getpatientId() {
        return patientId;
    }

    public void setpatientId(int patientId) {
        this.patientId = patientId;
    }

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
