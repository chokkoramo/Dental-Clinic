package org.dentalclinic.servlets;

import java.io.IOException;
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
        String patientName = request.getParameter("patientName");
        String patientLastName = request.getParameter("patientLastName");
        String patientPassword = request.getParameter("patientPassword");
        Boolean medicalInsurance = request.getParameter("medicalInsurance") != null;
        String bloodType = request.getParameter("bloodType");
        String rol = "Patient";

        controller.createPatient(patientName, patientLastName, patientPassword, medicalInsurance, bloodType, rol);
        response.sendRedirect("viewPatients.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}