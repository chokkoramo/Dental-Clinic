package org.dentalclinic.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.dentalclinic.logic.Controller;
import org.dentalclinic.logic.User;

@WebServlet(name = "SvModifyUsers", urlPatterns = {"/SvModifyUsers"})
public class SvModifyUsers extends HttpServlet {

    Controller controller = new Controller ();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter ("id"));
        User usu = controller.getUserPerId(id);

        HttpSession session = request.getSession();
        session.setAttribute("modifyUser", usu);

        System.out.println("El usuario es: " + usu.getUserName());

        response.sendRedirect("modifyUsers.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuName = request.getParameter("userName");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");

        User u = (User) request.getSession().getAttribute("modifyUser");
        u.setUserName(usuName);
        u.setPassword(password);
        u.setRol(rol);

        controller.modifyUsers(u);

        response.sendRedirect("SvUsers");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}