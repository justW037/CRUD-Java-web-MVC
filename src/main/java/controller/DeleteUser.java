package controller;

import DAO.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet(name = "deleteUser", value = "/deleteUser" )
public class DeleteUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        UserDao userDao = new UserDao();
        User deleteUser = new User();
        deleteUser.setId(userId);
        userDao.deleteUser(deleteUser);

        response.sendRedirect("getalluser");

    }

}
