package org.dentalclinic.logic;

import org.dentalclinic.persistence.PersistenceController;

public class Controller {
    PersistenceController persisController = new PersistenceController();

    public void createUser(int userId, String firstName, String lastName, String email, String password, String role){
        User user = new User(userId, firstName, password,  role);
        persisController.createUser(user);
    }
}
