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
import java.util.Map;

@WebServlet(name = "LoginClientServlet", urlPatterns = "/login")
public class LoginClientServlet extends HttpServlet {
    ServiceUserImp serviceUserImp = new ServiceUserImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showLoginClientForm(request, response);
    }

    private void showLoginClientForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        try {
            requestDispatcher = request.getRequestDispatcher("/view/user/loginUser.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            System.out.println(Error.ERROR_006);
        } catch (IOException e) {
            System.out.println(Error.ERROR_005);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        confirmLoginClient(request, response);
    }

    private void confirmLoginClient(HttpServletRequest request, HttpServletResponse response) {
        User admin;
        Map<String, String> listClient;
        String username;
        String password;
        RequestDispatcher requestDispatcher;
        try {
            admin = serviceUserImp.selectAdmin();
            listClient = serviceUserImp.selectClient();
            username = request.getParameter("username");
            password = request.getParameter("password");
            if (password.equals(listClient.get(username))) {
                requestDispatcher = request.getRequestDispatcher(Link.LOGIN_CLIENT_TO_REDIRECT_HOME);
                requestDispatcher.forward(request, response);
            }
             else  if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                request.getSession().setAttribute("admin", admin);
                response.sendRedirect("/dashboard");
            } else {
                request.setAttribute(Error.ERROR, Error.ERROR_004);
                requestDispatcher = request.getRequestDispatcher("/view/user/loginUser.jsp");
                requestDispatcher.forward(request, response);
            }
        }catch(ServletException e){
                e.printStackTrace();
            } catch(SQLException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }
        }

    }
