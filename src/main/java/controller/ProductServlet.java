package controller;

import model.Bill;
import model.ImportRecord;
import model.Product;
import service.product.IProductService;
import service.product.ProductServiceImp;
import service.stock.StockService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    public static final int RECORD_PER_PAGE_DISPLAY = 10;
    public static final int START_PAGE_DISPLAY = 1;
    private IProductService productService = new ProductServiceImp();
    private StockService stockService = new StockService();
    private List<ImportRecord> importRecords;
    private List<Bill> billRecords;
    private Product product;
    private int currentPage = 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            default:
                showProductList(request, response);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("product-name").equals("")) {
            request.setAttribute("status", 1);
            request.setAttribute("message", "Tên sản phẩm trống");
            showForm(request, response);
            return;
        }
        product = parseRequestData(request);
        try {
            if (productService.addNewProduct(product)) {
                request.setAttribute("message", "Thêm Thành công");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showForm(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("product-name").equals("")) {
            request.setAttribute("status", 1);
            request.setAttribute("message", "Tên sản phẩm trống");
            showForm(request, response);
            return;
        }
        product = parseRequestData(request);
        product.setProductID(Integer.parseInt(request.getParameter("id")));
        try {
            if (productService.updateProduct(product)) {
                request.setAttribute("status", 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showForm(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        String type = request.getParameter("type");
        int id = 0;

        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }
        if (action == null) {
            action = "";
        }
        if (type == null) {
            type = "";
        }

        switch (action) {
            case "create":
                showForm(request, response);
                break;
            case "update":
                try {
                    product = productService.getProductByProductID(id);
                    request.setAttribute("product", product);
                    showForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "detail":
                switch (type) {
                    case "product":
                        try {
                            product = productService.getProductByProductID(id);
                            showDetail(request, response, type);
                        } catch (SQLException | IOException | ServletException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        showProductList(request, response);
                }
                break;
            default:
                showProductList(request, response);
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        String button = request.getParameter("button");
        if (button == null) {
            button = "";
        }
        int size;
        int pages = START_PAGE_DISPLAY;


        switch (button) {
            case "next":
                if (++currentPage > pages) {
                    currentPage = pages;
                }
                break;
            case "previous":
                if (--currentPage < 1) {
                    currentPage = 1;
                }
                break;
            case "page":
                if (request.getParameter("page") != null) {
                    currentPage = Integer.parseInt(request.getParameter("page"));
                }
                break;
            default:
                currentPage = 1;
        }

        int[] pageIndex = new int[10];
        int pageIndexStart = (currentPage - 1) * 10;
        for (int times = 1; times <= 10; times++) {
            pageIndex[times - 1] = pageIndexStart + times;
        }

    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response, String type) throws ServletException, IOException {
        String requestDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        if (importRecords != null) {
            importRecords.sort((o1, o2) -> o2.getImportDateTime().compareTo(o1.getImportDateTime()));
        }
        request.setAttribute("type", type);
        request.setAttribute("requestDate", requestDate);
        request.setAttribute("product", product);
        request.setAttribute("importRecords", importRecords);
        request.setAttribute("billRecords", billRecords);
        request.getRequestDispatcher("view/admin/product/detail.jsp").forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("action", request.getParameter("action"));
            request.getRequestDispatcher("view/admin/product/form.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (request.getParameter("confirm") == null) {
                showProductList(request, response);
            } else if (request.getParameter("confirm").equals("ok")) {
                int id = Integer.parseInt(request.getParameter("id"));
                if (productService.deleteProduct(id)) {
                    request.setAttribute("status", 1);
                    showProductList(request, response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Product parseRequestData(HttpServletRequest request) {
        Product product = new Product();
//        product.setDetailID(Integer.parseInt(request.getParameter("id")));
        product.setProductName(request.getParameter("product-name"));
        product.setDescription(request.getParameter("product-description"));
        product.addImages(request.getParameter("image-link-1"));
        product.addImages(request.getParameter("image-link-2"));
        product.addImages(request.getParameter("image-link-3"));
        product.addImages(request.getParameter("image-link-4"));
        return product;
    }

}
