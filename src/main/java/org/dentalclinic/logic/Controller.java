package org.dentalclinic.logic;

import org.dentalclinic.persistence.PersistenceController;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    PersistenceController persisController = new PersistenceController();

    public List<User> getUser() {
        return persisController.getUser();
    }

    public void createUser(String userName, String password, String rol) {
        User usu = new User();
        usu.setUserName(userName);
        usu.setPassword(password);
        usu.setRol(rol);
        persisController.createUser(usu);
    }

    public boolean checkLogin(String username, String password) {

        boolean login = false;

        List<User> userList = new ArrayList<User>();
        userList = persisController.getUsers();

        for (User usu : userList) {
            if(usu.getUserName().equals(username)) {
                if (usu.getPassword().equals(password)) {
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
}
