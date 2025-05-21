package org.dentalclinic.persistence;

import org.dentalclinic.logic.Patient;
import org.dentalclinic.logic.User;

import java.util.List;

public class PersistenceController {
    DentistJpaController dentistJpa;
    LegalGuardianJpaController legalGuardianJpa;
    PatientJpaController patientJpa;
    PersonJpaController personJpa;
    ScheduleJpaController scheduleJpa;
    SecretaryJpaController secretaryJpa;
    ShiftJpaController shiftJpa;
    UserJpaController userJpa;

    public PersistenceController() {
        userJpa = new UserJpaController();
        scheduleJpa = new ScheduleJpaController();
        dentistJpa = new DentistJpaController();
        patientJpa= new PatientJpaController();
        personJpa = new PersonJpaController();
        legalGuardianJpa = new LegalGuardianJpaController();
        secretaryJpa = new SecretaryJpaController();
        shiftJpa = new ShiftJpaController();
    }

    public void createUser(User user){
        try {
            userJpa.create(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getUser() {
        return userJpa.findUserEntities();
    }

    public void deleteUser(int id){
        try {
            userJpa.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getUsers() {
        return userJpa.findUserEntities();
    }

    public User getUserPerId(int id) {
        return userJpa.findUser(id);
    }

    public void modifyUsers(User u) {
        try {
            userJpa.edit(u);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Patient> getPatients() {
        return patientJpa.findPatientEntities();
    }
}
