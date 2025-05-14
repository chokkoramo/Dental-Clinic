package org.dentalclinic.logic;

import jakarta.persistence.Entity;
import java.io.Serializable;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class LegalGuardian extends Person implements Serializable {
//    private int legalGuardianId;
    private String typeOfGuardian;

    public LegalGuardian() {
    }

    public LegalGuardian(int id, String dni, String firstName, String lastName, String phone, String address, LocalDate dateOfBirth, String typeOfGuardian) {
        super(id, dni, firstName, lastName, phone, address, dateOfBirth);
        this.typeOfGuardian = typeOfGuardian;
    }

//    public int getlegalGuardianId() {
//        return legalGuardianId;
//    }
//
//    public void setlegalGuardianId(int legalGuardianId) {
//        this.legalGuardianId = legalGuardianId;
//    }

    public String getTypeOfGuardian() {
        return typeOfGuardian;
    }

    public void setTypeOfGuardian(String typeOfGuardian) {
        this.typeOfGuardian = typeOfGuardian;
    }
}
