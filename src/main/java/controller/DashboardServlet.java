package controller;

import service.user.ServiceUserImp;
import util.Error;
import util.Link;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DashboardServlet", urlPatterns = "/dashboard")
public class DashboardServlet extends HttpServlet {
    private ServiceUserImp serviceUserImp;

    public void init() {
        serviceUserImp = new ServiceUserImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showDashboard(request, response);
    }

    private void showDashboard(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd;
        try {
            rd = request.getRequestDispatcher(Link.LOGIN_ADMIN_TO_DASHBOARD);
            rd.forward(request, response);
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_006);
        } catch (IOException ex) {
            System.err.println(Error.ERROR_005);
        }
    }
}
