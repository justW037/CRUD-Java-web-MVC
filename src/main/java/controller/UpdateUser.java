package controller;

import DAO.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "updatedUser", value = "/updatedUser" )
public class UpdateUser extends HttpServlet {
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDao userDao = new UserDao();
        User user = userDao.getUserById(userId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        UserDao userDao = new UserDao();
        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setUsername(username);
        updatedUser.setEmail(email);
        userDao.updateUser(updatedUser);

        response.sendRedirect("getalluser");
    }

    public void destroy() {
    }
}
