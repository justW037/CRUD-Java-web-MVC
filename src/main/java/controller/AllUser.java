package controller;

import DAO.UserDao;
import jakarta.servlet.ServletException;
import model.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "getalluser", value = "/getalluser" )
public class AllUser extends HttpServlet {
    public void init() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserDao userDao = new UserDao();
        List<User> userList = userDao.getAllUsers();

        request.setAttribute("userList", userList);

        request.getRequestDispatcher("/allUser.jsp").forward(request, response);
    }
    public void destroy() {
    }
}
