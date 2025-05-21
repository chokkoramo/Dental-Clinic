package org.dentalclinic.servlets;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dentalclinic.logic.Controller;


@WebServlet(name = "SvDeleteUsers", urlPatterns = {"/SvDeleteUsers"})
public class SvDeleteUsers extends HttpServlet {

    Controller controller = new Controller ();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter ("id"));

        controller.deleteUser(id);

        response.sendRedirect("SvUsers");


    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}