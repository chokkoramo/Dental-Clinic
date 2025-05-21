package org.dentalclinic.logic;

import org.dentalclinic.persistence.PersistenceController;
import org.mindrot.jbcrypt.BCrypt;

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
            if(user.getUserName().equals(username)) {
                if (BCrypt.checkpw(password, user.getPassword())) {
                    login = true;
                }
                else {
                    login = false;
                }
            }
        }
        return login;
    }

    public void deleteUser(int id) {
        persisController.deleteUser(id);
    }

    public User getUserPerId(int id) {
        return persisController.getUserPerId(id);
    }

    public void modifyUsers(User u) {
        persisController.modifyUsers(u);
    }

    public List<Patient> getPatients() {
        return persisController.getPatients();
    }

    public void createPatient(String patientName, String patientLastName, String patientPassword, Boolean medicalInsurance, String bloodType, String rol) {
        Patient patient = new Patient();
        patient.setFirstName(patientName);
        patient.setLastName(patientLastName);

    }
}
