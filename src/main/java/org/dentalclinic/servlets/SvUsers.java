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
import org.dentalclinic.logic.User;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "SvUsers", urlPatterns = {"/SvUsers"})
public class SvUsers extends HttpServlet {

    Controller controller = new Controller ();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> userList;
        userList = controller.getUser();
        HttpSession session = request.getSession();
        session.setAttribute("userList", userList);
        System.out.println("Usuario: " + userList.get(0));

        // 🔥 Fragmento vulnerable (inyección JPQL)
        String name = request.getParameter("name"); // <- input externo (posible inyección)
        controller.buscarUsuarioPorNombre(name); // <- debes crear este método en tu lógica

        response.sendRedirect("viewUsers.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("username");
        String plainPassword = request.getParameter("password");
        String rol = request.getParameter("rol");

        String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());

        controller.createUser(userName, hashedPassword, rol);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}