package org.dentalclinic.persistence;

import org.dentalclinic.logic.Dentist;
import org.dentalclinic.logic.User;

public class PersistenceController {
    DentistJpaController dentistJpa = new DentistJpaController();
    LegalGuardianJpaController legalGuardianJpa = new LegalGuardianJpaController();
    PatientJpaController patientJpa = new PatientJpaController();
    PersonJpaController personJpa = new PersonJpaController();
    ScheduleJpaController scheduleJpa = new ScheduleJpaController();
    SecretaryJpaController secretaryJpa = new SecretaryJpaController();
    ShiftJpaController shiftJpa = new ShiftJpaController();
    UserJpaController userJpa = new UserJpaController();


    public void createUser(User user) {
        try {
            userJpa.create(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
