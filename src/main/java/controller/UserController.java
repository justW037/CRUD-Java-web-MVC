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

@WebServlet("/")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        request.setCharacterEncoding("UTF-8");

        switch (action) {
            case "/getAllUsers":
                getAllUsers(request, response);
                break;
            case "/edit":
                showUpdateForm(request, response);
                break;
            case "/search":
                searchUsers(request, response);
                break;
            case "/new":
                showAddForm(request, response);
                break;
            case "/delete":
                deleteUser(request, response);
                break;
            case "/insert":
                addUser(request, response);
                break;
            case "/update":
                updateUser(request, response);
                break;
            default:
                getAllUsers(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userDao.getAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/allUser.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addUser.jsp").forward(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý thêm người dùng mới vào cơ sở dữ liệu
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);

        userDao.addUser(newUser);

        response.sendRedirect("getAllUsers");
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userDao.getUserById(userId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setUsername(username);
        updatedUser.setEmail(email);

        userDao.updateUser(updatedUser);

        response.sendRedirect("getAllUsers");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        User deleteUser = new User();
        deleteUser.setId(userId);

        userDao.deleteUser(deleteUser);

        response.sendRedirect("getAllUsers");
    }

    private void searchUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameKeyword = request.getParameter("searchKeyword");
        List<User> userList = userDao.searchUsersByName(usernameKeyword);
        request.setAttribute("userList", userList);

        request.getRequestDispatcher("/allUser.jsp").forward(request, response);
    }
}
