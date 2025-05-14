package org.dentalclinic.logic;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Secretary extends Person {
//    private int secretaryId;
    private String sector;

    @OneToOne
    private User user;

    public Secretary() {
    }

    public Secretary(int id, String dni, String firstName, String lastName, String phone, String address, LocalDate dateOfBirth, String sector, User user) {
        super(id, dni, firstName, lastName, phone, address, dateOfBirth);
        this.sector = sector;
        this.user = user;
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
