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
import java.util.List;

@WebServlet(name = "ManagementUserServlet", urlPatterns = "/user")
public class ManagementUserServlet extends HttpServlet {
    private ServiceUserImp serviceUserImp = new ServiceUserImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create_user":
                createUser(request, response);
                break;
            case "delete_user":
                deleteUser(request, response);
                break;
            case "edit_user":
                updateUser(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view_user":
                showUserTable(request, response);
                break;
            case "create_user":
                showCreateUserForm(request, response);
                break;
            case "view_details_user":
                viewDetailsUser(request, response, Common.VIEW_DETAILS_USER);
                break;
            case "delete_user":
                viewDetailsUser(request, response, Common.DELETE_USER);
                break;
            case "edit_user":
                viewDetailsUser(request, response, Common.UPDATE_USER);
                break;
        }
    }

    //Hiển thị form đăng kí
    private void showCreateUserForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        try {
            requestDispatcher = request.getRequestDispatcher(Link.DASHBOARD_TO_CREATE_FORM_USER);
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            System.err.println(Error.ERROR_008);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Hiển thị bảng người dùng
    private void showUserTable(HttpServletRequest request, HttpServletResponse response) {
        List<User> listUser;
        RequestDispatcher requestDispatcher;
        try {
            listUser = serviceUserImp.selectAllUsers();
            request.setAttribute("listUser", listUser);
            requestDispatcher = request.getRequestDispatcher(Link.DASHBOARD_TO_VIEW_USER);
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            System.err.println(Error.ERROR_009);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Hiển thị bảng thông tin chi tiết người dùng
    private void viewDetailsUser(HttpServletRequest request, HttpServletResponse response, int type) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user;
        RequestDispatcher requestDispatcher = null;
        try {
            user = serviceUserImp.selectUser(id);
            request.setAttribute("user", user);
            if (type == Common.VIEW_DETAILS_USER) {
                requestDispatcher = request.getRequestDispatcher(Link.VIEW_DETAILS_USER);
            } else if (type == Common.DELETE_USER) {
                requestDispatcher = request.getRequestDispatcher(Link.DELETE_USER_FORM);
            } else if (type == Common.UPDATE_USER) {
                requestDispatcher = request.getRequestDispatcher(Link.UPDATE_USER_FORM);
            }
            requestDispatcher.forward(request, response);
        } catch (ServletException ex) {
            System.err.println(Error.ERROR_010);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //Hiển thị form đăng ký người dùng
    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        User user;
        try {
            user = getValuesFromForm(request, Common.CREATE_USER);
            serviceUserImp.createUser(user);
            requestDispatcher = request.getRequestDispatcher(Link.DASHBOARD_TO_CREATE_FORM_USER);
            request.setAttribute("message", Alert.ALERT_001);
            requestDispatcher.forward(request, response);
        } catch (ServletException | SQLException ex) {
            System.err.println(Error.ERROR_013);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Xóa user sau đó thông báo message
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id;
        User user;
        RequestDispatcher requestDispatcher;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            user = serviceUserImp.selectUser(id);
            if (user == null) {
                requestDispatcher = request.getRequestDispatcher("view/admin/error404.jsp");
            } else {
                serviceUserImp.deleteUser(id);
                requestDispatcher = request.getRequestDispatcher(Link.DASHBOARD_TO_DELETE_USER);
                request.setAttribute("message", Alert.ALERT_002);
            }
            requestDispatcher.forward(request, response);
        } catch (ServletException | SQLException e) {
            System.err.println(Error.ERROR_012);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Chỉnh sửa user sau đó thông báo message
    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        User user;
        try {
            user = getValuesFromForm(request, Common.UPDATE_USER);
            serviceUserImp.updateUser(user);
            request.setAttribute("message", Alert.ALERT_003);
            requestDispatcher = request.getRequestDispatcher(Link.UPDATE_USER_FORM);
            requestDispatcher.forward(request, response);
        } catch (ServletException | SQLException ex) {
            System.err.println(Error.ERROR_013);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //lấy values từ màn hình
    private User getValuesFromForm(HttpServletRequest request, int type) {
        User user = null;
        int roleId = 0;
        boolean gender;
        int status;

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

        String tempRole = request.getParameter("role");
        switch (tempRole) {
            case "1":
                roleId = Common.USER;
                break;
            case "2":
                roleId = Common.ADMIN;
                break;
        }

        String tempStatus = request.getParameter("status");
        if (tempStatus.equals("1")) {
            status = Common.ACTIVE;
        } else {
            status = Common.BLOCKED;
        }

        String address = request.getParameter("address");

        if (type == Common.CREATE_USER) {
            user = new User(roleId, firstName, lastName, gender, dateOfBirth, phone, address, email, username, password, status);
        } else if (type == Common.UPDATE_USER) {
            int id = Integer.parseInt(request.getParameter("id"));
            user = new User(id, roleId, firstName, lastName, gender, dateOfBirth, phone, address, email, username, password, status);
        }
        return user;
    }
}