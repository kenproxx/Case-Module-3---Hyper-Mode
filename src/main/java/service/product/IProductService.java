package service.product;

import model.Catalog;
import model.Item;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> getProductList() throws SQLException;

    List<String> getImageLinks(Product product) throws SQLException;

    Product getProductByProductID(int id) throws SQLException;


    boolean addNewProduct(Product product) throws SQLException;

    boolean updateProduct(Product product) throws SQLException;

    boolean deleteProduct(int id) throws SQLException;

    List<Item> getProductForHomePage() throws SQLException;

    int price(int id) throws SQLException;
}
