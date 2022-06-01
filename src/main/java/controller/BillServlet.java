package controller;

import model.Bill;
import service.bill.BillServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BillServlet", urlPatterns = "/bills")
public class BillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BillServiceImpl billServiceImpl = new BillServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "confirm":
                    confirmBill(request, response);
                    break;
                case "deny":
                    denyBill(request, response);
                    break;
                case "pending":
                    pendingBill(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "confirm":
                    showConfirmForm(request, response);
                    break;
                case "deny":
                    showDenyForm(request, response);
                    break;
                case "pending":
                    showPendingForm(request, response);
                    break;
                default:
                    listBill(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int page = 1;
        int recordsPerPage = 3;
        if (request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        BillServiceImpl dao = new BillServiceImpl();
        List<Bill> listBill = dao.selectAllBills((page - 1) * recordsPerPage,
                recordsPerPage);
        int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("listBill", listBill);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/bill/list.jsp");
        dispatcher.forward(request, response);

    }


    private void showConfirmForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Bill existingUser = billServiceImpl.selectBill(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/bill/confirmForm.jsp");
        request.setAttribute("bill", existingUser);
        dispatcher.forward(request, response);
    }

    private void showDenyForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Bill existingUser = billServiceImpl.selectBill(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/bill/denyForm.jsp");
        request.setAttribute("bill", existingUser);
        dispatcher.forward(request, response);
    }

    private void confirmBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int status = 1;
        Bill anotherBill = new Bill(id, status);
        billServiceImpl.updateBill(anotherBill);
        response.sendRedirect("/bills");
    }

    private void denyBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int status = -1;
        Bill anotherBill = new Bill(id, status);
        billServiceImpl.updateBill(anotherBill);
        response.sendRedirect("/bills");
    }

    private void showPendingForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Bill existingUser = billServiceImpl.selectBill(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/bill/pendingForm.jsp");
        request.setAttribute("bill", existingUser);
        dispatcher.forward(request, response);
    }

    private void pendingBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int status = 0;
        Bill anotherBill = new Bill(id, status);
        billServiceImpl.updateBill(anotherBill);
        response.sendRedirect("/bills");
    }
}
