package controller;

import model.Item;
import model.Product;
import service.product.IProductService;
import service.product.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/home")
public class HomePageServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "view-detail":
                    showDetailForm(request, response);
                    break;
                case "product":
                    showProductPage(request,response);
                    break;
                case "about":
                    showAboutPage(request,response);
                    break;
                case "contact":
                    showContactPage(request, response);
                    break;
                default:
                    listProduct(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showContactPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/contact.jsp");
        dispatcher.forward(request, response);
    }

    private void showAboutPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/about.jsp");
        dispatcher.forward(request, response);
    }

    private void showProductPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Item> itemList = productService.getProductForHomePage();
        request.setAttribute("itemList", itemList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/product.jsp");
        dispatcher.forward(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Item> itemList = productService.getProductForHomePage();
        request.setAttribute("itemList", itemList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showDetailForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productService.getProductByProductID(id);
        request.setAttribute("product", existingProduct);
        List<Integer> size = productService.getSizeListByProductID(id);
        request.setAttribute("size", size);
        int price = productService.price(id);
        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        String priceFormatter = formatter.format(price);
        request.setAttribute("price", priceFormatter);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/product-detail.jsp");
        dispatcher.forward(request, response);
    }
}
