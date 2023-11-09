package controller;

import DAO.UserDao;
import jakarta.servlet.ServletException;
import model.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class addUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        UserDao userDao = new UserDao();
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        userDao.addUser(newUser);

        response.sendRedirect("getalluser");
    }
}
