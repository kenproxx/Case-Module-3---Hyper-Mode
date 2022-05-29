package controller;

import model.User;
import service.user.ServiceUserImp;
import util.Alert;
import util.Common;
import util.Error;
import util.Link;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register_user")
public class RegisterServlet extends HttpServlet {

    ServiceUserImp serviceUserImp = new ServiceUserImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showRegisterForm(request, response);
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            rd = request.getRequestDispatcher(Link.REGISTER_CLIENT);
            rd.forward(request, response);
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_023);
        } catch (IOException ex) {
            System.err.println(Error.ERROR_024);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        createUser(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        User user;
        try {
            user = getValuesFromClient(request);
            serviceUserImp.createUser(user);
            requestDispatcher = request.getRequestDispatcher(Link.REGISTER_CLIENT);
            request.setAttribute("message", Alert.ALERT_005);
            requestDispatcher.forward(request, response);
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_025);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private User getValuesFromClient(HttpServletRequest request) {
        User user = null;

        boolean gender;

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        String tempGender = request.getParameter("gender");
        if (tempGender.equals("1")) {
            gender = Common.MALE;
        } else {
            gender = Common.FEMALE;
        }
        String tempDateOfBirth = request.getParameter("dateOfBirth");
        Date dateOfBirth = Date.valueOf(tempDateOfBirth);

        String phone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        int roleId = 1;

        int status = 1;

        String address = request.getParameter("address");

        user = new User(roleId, firstName, lastName, gender, dateOfBirth, phone, address, email, username, password, status);

        return user;
    }
}
