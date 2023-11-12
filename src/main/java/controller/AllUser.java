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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserDao userDao = new UserDao();
        List<User> userList = userDao.getAllUsers();

        request.setAttribute("userList", userList);

        request.getRequestDispatcher("/allUser.jsp").forward(request, response);
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

        response.sendRedirect("addUser.jsp");
    }

    public void destroy() {
    }
}
