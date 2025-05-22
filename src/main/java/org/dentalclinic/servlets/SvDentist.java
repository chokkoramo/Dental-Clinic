package org.dentalclinic.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.dentalclinic.logic.Controller;
import org.dentalclinic.logic.Dentist;

@WebServlet(name = "SvDentist", urlPatterns = {"/SvDentist"})
public class SvDentist extends HttpServlet {

    Controller controller = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Dentist> dentists = controller.getAllDentists();
        HttpSession session = request.getSession();
        session.setAttribute("dentists", dentists);
        response.sendRedirect("viewDentist.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String dni = request.getParameter("dni");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String startingTime = request.getParameter("startingTime");
        String endingTime = request.getParameter("endingTime");

        String dateOfBirthStr = request.getParameter("dateOfBirth");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = null;

        try {
            dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
        } catch (DateTimeParseException ex) {
            Logger.getLogger(SvDentist.class.getName()).log(Level.SEVERE, null, ex);
        }

        controller.createDentist(startingTime, endingTime, dni, name, lastName, phone, address, dateOfBirth);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}