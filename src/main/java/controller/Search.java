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


@WebServlet(name = "search", value = "/search" )
public class Search  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameKeyword = request.getParameter("searchKeyword");
        List<User> userList = new UserDao().searchUsersByName(usernameKeyword);
        request.setAttribute("userList", userList);

        request.getRequestDispatcher("/allUser.jsp").forward(request, response);
    }
}
