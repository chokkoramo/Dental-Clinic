package org.dentalclinic.logic;

import java.util.Date;

public class Secretary extends Person {
//    private int secretaryId;
    private String sector;
    private User user;

    public Secretary() {
    }

    public Secretary(String dni, String firstName, String lastName, String phone, String address, Date dateOfBirth, User user, String sector) {
        super(dni, firstName, lastName, phone, address, dateOfBirth);
        this.user = user;
        this.sector = sector;
    }

//    public int getsecretaryId() {
//        return secretaryId;
//    }
//
//    public void setsecretaryId(int secretaryId) {
//        this.secretaryId = secretaryId;
//    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
