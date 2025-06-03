package org.dentalclinic.logic;

import org.dentalclinic.persistence.PersistenceController;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    PersistenceController persisController = new PersistenceController();

    public List<User> getUser() {
        return persisController.getUser();
    }

    public void createUser(String userName, String hashedPassword, String rol) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(hashedPassword);
        user.setRol(rol);
        persisController.createUser(user);
    }

    public boolean checkLogin(String username, String password) {

        boolean login = false;

        List<User> userList = new ArrayList<User>();
        userList = persisController.getUsers();

        for (User user : userList) {
            if (user.getUserName().equals(username)) {
                if (BCrypt.checkpw(password, user.getPassword())) {
                    login = true;
                } else {
                    login = false;
                }
            }
        }
        return login;
    }

    public void deleteUser(int id) {
        persisController.deleteUser(id);
    }

    public User getUserById(int id) {
        return persisController.getUserPerId(id);
    }

    public void modifyUsers(User u) {
        persisController.modifyUsers(u);
    }

    public List<Patient> getAllPatients() {
        return persisController.getAllPatients();
    }

    public void createDentist(String startingTime, String endingTime, String dni, String name, String lastName, String phone, String address, LocalDate dateOfBirth) {
        Schedule schedule = new Schedule();
        schedule.setStartingTime(startingTime);
        schedule.setEndingTime(endingTime);
        this.createSchedule(startingTime, endingTime);

        Dentist dentist = new Dentist();
        dentist.setFirstName(name);
        dentist.setLastName(lastName);
        dentist.setPhone(phone);
        dentist.setAddress(address);
        dentist.setSchedule(schedule);
        dentist.setDni(dni);
        dentist.setDateOfBirth(dateOfBirth);

        persisController.createDentist(dentist);
    }

    public List<Dentist> getAllDentists() {
        return persisController.getAllDentists();
    }

    public Dentist getDentistById(int id) {
        return persisController.getDentistById(id);
    }

    public void modifyDentist(Dentist dentist) {
        persisController.modifyDentist(dentist);
    }

    public void deleteDentist(int id) {
        persisController.deleteDentist(id);
    }

    public void modifySchedule(Schedule schedule) throws Exception {
        persisController.modifySchedule(schedule);
    }

    public void createSchedule(String startingTime, String endingTime) {
        Schedule schedule = new Schedule();
        schedule.setStartingTime(startingTime);
        schedule.setEndingTime(endingTime);
        persisController.createSchedule(schedule);
    }

    public void createPatient(String firstName, String lastName, String address, String phone, LocalDate patientDateOfBirth, String bloodType, Boolean medicalInsurance, String patientDNI) {
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDni(patientDNI);
        patient.setAddress(address);
        patient.setPhone(phone);
        patient.setBloodType(bloodType);
        patient.setMedicalInsurance(medicalInsurance);
        patient.setDateOfBirth(patientDateOfBirth);

        persisController.createPatient(patient);

    }

    public void createPatient(String firstName, String lastName, String address, String phone, LocalDate patientDateOfBirth, String bloodType, Boolean medicalInsurance, String patientDNI, String nameLegalGuardian,
                              String lastNameLegalGuardian, String addressLegalGuardian, String phoneLegalGuardian, String legalGuardianDNI, LocalDate legalGuardianDateOfBirth, String typeOfLegalGuardian) {
        LegalGuardian legalGuardian = new LegalGuardian();
        legalGuardian.setLastName(lastNameLegalGuardian);
        legalGuardian.setAddress(addressLegalGuardian);
        legalGuardian.setDni(legalGuardianDNI);
        legalGuardian.setFirstName(nameLegalGuardian);
        legalGuardian.setTypeOfGuardian(typeOfLegalGuardian);
        legalGuardian.setPhone(phoneLegalGuardian);
        legalGuardian.setDateOfBirth(legalGuardianDateOfBirth);

        persisController.createLegalGuardian(legalGuardian);

        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDni(patientDNI);
        patient.setAddress(address);
        patient.setPhone(phone);
        patient.setBloodType(bloodType);
        patient.setMedicalInsurance(medicalInsurance);
        patient.setDateOfBirth(patientDateOfBirth);
        patient.setaLegalGuardian(legalGuardian);

        persisController.createPatient(patient);
    }

    public void deletePatient(int id) {
        persisController.deletePatient(id);
    }

    public Patient getPatientById(int id) {
        return persisController.getPatientById(id);
    }

    public void modifyPatient(Patient patient) {
        persisController.modifyPatient(patient);
        if (patient.getaLegalGuardian() != null) {
            this.modifyLegalGuardian(patient.getaLegalGuardian());
        }

    }

    public void modifyLegalGuardian(LegalGuardian legalGuardian) {
        persisController.modifyLegalGuardian(legalGuardian);

    }

    public void createShift(int dentistId, int patientId, String affeccion, LocalDate date, String time) {
        Patient patient = this.getPatientById(patientId);
        Dentist dentist = this.getDentistById(dentistId);
        Shift shift = new Shift();
        shift.setAffection(affeccion);
        shift.setDate(date);
        shift.setTime(time);
        shift.setPatientMap(patient);
        shift.setDentistMap(dentist);
        persisController.createShift(shift);

    }

    public List<Shift> getAllShifts() {
        return persisController.getAllShifts();
    }

    public void deleteShift(int shiftId) {
        persisController.deleteShift(shiftId);
    }


}
