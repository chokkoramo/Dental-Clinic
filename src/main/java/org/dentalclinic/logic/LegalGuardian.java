package org.dentalclinic.logic;

import java.util.Date;

public class LegalGuardian extends Person {
//    private int legalGuardianId;
    private String typeOfGuardian;

    public LegalGuardian() {
    }

    public LegalGuardian(String dni, String firstName, String lastName, String phone, String address, Date dateOfBirth, String typeOfGuardian) {
        super(dni, firstName, lastName, phone, address, dateOfBirth);
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
