package org.dentalclinic.persistence;

import org.dentalclinic.logic.*;

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
    public void createSchedule(Schedule schedule) {
        try {
            scheduleJpa.create(schedule);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createDentist(Dentist dentist) {
        try {
            dentistJpa.create(dentist);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Dentist> getAllDentists() {
        return dentistJpa.findDentistEntities();
    }

    public Dentist getDentistById(int id) {
        return dentistJpa.findDentist(id);
    }

    public void modifyDentist(Dentist dentist){
        try {
            dentistJpa.edit(dentist);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void modifySchedule(Schedule schedule) {
        try {
            scheduleJpa.edit(schedule);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteDentist(int id) {
        try {
            dentistJpa.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createLegalGuardian(LegalGuardian legalGuardian) {
        try {
            legalGuardianJpa.create(legalGuardian);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createPatient(Patient patient) {
        try {
            patientJpa.create(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Patient> getAllPatients() {
        return patientJpa.findPatientEntities();
    }

    public void deletePatient(int id) {
        try {
            patientJpa.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Patient getPatientById(int id) {
        return patientJpa.findPatient(id);
    }

    public void modifyPatient(Patient patient) {
        try {
            patientJpa.edit(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyLegalGuardian(LegalGuardian legalGuardian) {
        try {
            legalGuardianJpa.edit(legalGuardian);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createShift(Shift shift) {
        try {
            shiftJpa.create(shift);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Shift> getAllShifts() {
        return shiftJpa.findShiftEntities();
    }

    public void deleteShift(int shiftId) {
        try {
            shiftJpa.destroy(shiftId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
