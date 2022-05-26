package controller;

import model.User;
import service.user.ServiceUserImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    ServiceUserImp serviceUserImp = new ServiceUserImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "signUp":
                showSignUp(request, response);
        }
    }

    private void showSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("template/signup.html");
        request.setAttribute("test", "Đăng Ký Thằng công");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "signUp":
                try {
                    signUp(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case"login":
                login(request, response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        serviceUserImp.LoginUp(new User(username, password, email));

        response.sendRedirect("template/signup.html");
    }
}
