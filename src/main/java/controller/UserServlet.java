package controller;

import model.User;
import service.user.ServiceUserImp;
import util.DBHandle;
import util.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    ServiceUserImp serviceUserImp = new ServiceUserImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showIndex(request, response);
        }
    }

    private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", showAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public List<User> showAll() {
        List<User> list = new ArrayList<>();
        try (Connection connection = DBHandle.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Query.SELECT_MINIPROFILE)
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String img = rs.getString("img");
                list.add(new User(username, password, email, img));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
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

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        serviceUserImp.LoginUp(new User(username, password, email));
        response.sendRedirect("product");

    }
}
