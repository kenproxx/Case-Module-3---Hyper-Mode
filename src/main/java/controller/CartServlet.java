package controller;

import model.BillDetail;
import service.product.IProductService;
import service.product.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        super.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        BillDetail billDetail =  (BillDetail) session.getAttribute("billDetail");
        request.setAttribute("billDetail",billDetail);
        response.sendRedirect("/view/user/cart-detail.jsp");
    }
}