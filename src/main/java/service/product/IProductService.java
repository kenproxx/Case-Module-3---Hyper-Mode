package service.product;

import model.Catalog;
import model.Item;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> getProductList() throws SQLException;

    List<Product> getProductList(Catalog catalog) throws SQLException;

    List<String> getImageLinks(Product product) throws SQLException;

    Product getProductByDetailID(int id) throws SQLException;

    Product getProductByProductID(int id) throws SQLException;

    List<Integer> getSizeList() throws SQLException;

    boolean addNewProduct(Product product) throws SQLException;

    boolean updateProduct(Product product) throws SQLException;

    boolean deleteProduct(int id) throws SQLException;

    List<Item> getProductForHomePage() throws SQLException;

    List<Integer> getSizeListByProductID(int id) throws SQLException;

    List<Product> getProductListPagination(int offset, int amount) throws SQLException;

    int getProductSize() throws SQLException;

    int price(int id) throws SQLException;
}
