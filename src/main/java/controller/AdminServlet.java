package controller;

import model.User;
import service.user.ServiceUserImp;
import util.Error;
import util.Link;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    private final ServiceUserImp serviceUserImp = new ServiceUserImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showLoginAdminForm(request, response);
    }

    private void showLoginAdminForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            rd = request.getRequestDispatcher(Link.LOGIN_ADMIN_TO_LOGIN_ADMIN);
            rd.forward(request, response);
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_006);
        } catch (IOException ex) {
            System.err.println(Error.ERROR_005);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        confirmLoginAdmin(request, response);
    }

    private void confirmLoginAdmin(HttpServletRequest request, HttpServletResponse response) {
        User admin;
        String userName;
        String password;
        RequestDispatcher rd;
        try {
            admin = serviceUserImp.selectAdmin();
            userName = request.getParameter("username");
            password = request.getParameter("password");
            if (userName.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                request.getSession().setAttribute("admin", admin);
                response.sendRedirect("/dashboard");
            } else {
                request.setAttribute(Error.ERROR, Error.ERROR_004);
                rd = request.getRequestDispatcher(Link.LOGIN_ADMIN_TO_LOGIN_ADMIN);
                rd.forward(request, response);
            }
        } catch (ServletException | SQLException ex) {
            System.err.println(Error.ERROR_006);
        } catch (IOException ex) {
            System.err.println(Error.ERROR_005);
        }
    }
}
