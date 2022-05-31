package controller;

import model.BillDetail;
import model.Item;
import model.Product;
import service.product.IProductService;
import service.product.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/addtoCart")
public class AddToCartServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "cart":
                showCartDetail(request, response);
                break;
            default:
                listCart(request, response);
                break;
        }
    }

    private void listCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/cart-detail.jsp");
        dispatcher.forward(request, response);
    }

    private void showCartDetail(HttpServletRequest request, HttpServletResponse response) {
        int quantity = 1;
        int id;
        try {
            if (request.getParameter("id") != null) {
                id = Integer.parseInt(request.getParameter("id"));
                Product product = null;
                product = productService.getProductByProductID(id);
                if (product != null) {
                    if (request.getParameter("quantity") != null) {
                        quantity = Integer.parseInt(request.getParameter("quantity"));
                    }
                    HttpSession session = request.getSession();
                    if (session.getAttribute("billDetail") == null) {
                        BillDetail billDetail = new BillDetail();
                        List<Item> itemList = new ArrayList<Item>();
                        Item item = new Item();
                        item.setQuantity(quantity);
                        item.setProduct(product);
                        item.setPrice(productService.price(product.getProductID()));
                        itemList.add(item);
                        billDetail.setItems(itemList);
                        session.setAttribute("billDetail", billDetail);
                    } else {
                        BillDetail billDetail = (BillDetail) session.getAttribute("billDetail");
                        List<Item> itemList = billDetail.getItems();
                        boolean check = false;
                        for (Item item : itemList) {
                            if (item.getProduct().getProductID() == product.getProductID()) {
                                item.setQuantity(item.getQuantity() + quantity);
                                check = true;
                            }
                        }
                        if (!check) {
                            Item item = new Item();
                            item.setQuantity(quantity);
                            item.setProduct(product);
                            item.setPrice(productService.price(product.getProductID()));
                            itemList.add(item);
                            billDetail.setItems(itemList);
                        }
                        session.setAttribute("billDetail", billDetail);
                    }
                }
                response.sendRedirect("/cart");
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}


