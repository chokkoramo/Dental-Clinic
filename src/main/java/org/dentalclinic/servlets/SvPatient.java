package org.dentalclinic.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.dentalclinic.logic.Controller;
import org.dentalclinic.logic.Patient;

@WebServlet(name = "SvPatient", urlPatterns = {"/SvPatient"})
public class SvPatient extends HttpServlet {

    Controller controller = new Controller ();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Patient> patientList;

        patientList = controller.getPatients();

        HttpSession session = request.getSession();
        session.setAttribute("patientList", patientList);

        System.out.println("Paciente: " + patientList.get(0));

        response.sendRedirect("viewPatients.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Datos del paciente
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String bloodType = request.getParameter("bloodType");
        String patientDNI = request.getParameter("patientDNI");
        boolean medicalInsurance = "si".equalsIgnoreCase(request.getParameter("medicalInsuranceYes"));

        // Fecha de nacimiento del paciente usando solo LocalDate
        String patientDobStr = request.getParameter("patientDateOfBirth");
        LocalDate patientDateOfBirth = LocalDate.parse(patientDobStr);

        // Datos del responsable
        String legalGuardianFirstName = request.getParameter("legalGuardianFirstName");
        String legalGuardianLastName = request.getParameter("legalGuardianLastName");
        String legalGuardianPhone = request.getParameter("legalGuardianPhone");
        String legalGuardianAddress = request.getParameter("legalGuardianAddress");
        String legalGuardianDNI = request.getParameter("legalGuardianDNI");
        String typeOfLegalGuardian = request.getParameter("typeOfLegalGuardian");
        String legalGuardianDobStr = request.getParameter("legalGuardianDateOfBirth");

        boolean hasLegalGuardian = legalGuardianFirstName != null && !legalGuardianFirstName.isEmpty()
                && legalGuardianLastName != null && !legalGuardianLastName.isEmpty()
                && legalGuardianPhone != null && !legalGuardianPhone.isEmpty()
                && legalGuardianAddress != null && !legalGuardianAddress.isEmpty()
                && legalGuardianDNI != null && !legalGuardianDNI.isEmpty()
                && typeOfLegalGuardian != null && !typeOfLegalGuardian.isEmpty();

        if (hasLegalGuardian && legalGuardianDobStr != null && !legalGuardianDobStr.isEmpty()) {
            LocalDate legalGuardianDateOfBirth = LocalDate.parse(legalGuardianDobStr);

            controller.createPatient(firstName, lastName, address, phone, patientDateOfBirth, bloodType, medicalInsurance, patientDNI,
                    legalGuardianFirstName, legalGuardianLastName, legalGuardianAddress, legalGuardianPhone, legalGuardianDNI, legalGuardianDateOfBirth, typeOfLegalGuardian);
        } else {
            controller.createPatient(firstName, lastName, address, phone, patientDateOfBirth, bloodType, medicalInsurance, patientDNI);
        }

        response.sendRedirect("index.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}