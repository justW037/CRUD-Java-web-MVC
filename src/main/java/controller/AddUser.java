package controller;

import DAO.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet(name = "add", value = "/add" )
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("addUser.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        UserDao userDao = new UserDao();
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        userDao.addUser(newUser);

        response.sendRedirect("add");
    }
}
