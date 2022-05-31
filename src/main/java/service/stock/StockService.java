package service.stock;

import model.ImportRecord;

import service.product.IProductService;
import service.product.ProductServiceImp;
import util.DBHandle;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StockService {
    private Connection connection;
    private PreparedStatement statement;
    private IProductService productService;

    public StockService() {
        connection = DBHandle.getConnection();
        productService = new ProductServiceImp();
    }

    public StockService(IProductService productService) {
        connection = DBHandle.getConnection();
        this.productService = productService;
    }

    private List<ImportRecord> getRecordOneParam(PreparedStatement statement, int param) throws SQLException {
        List<ImportRecord> importRecords = new LinkedList<>();
        statement.setInt(1, param);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            importRecords.add(parseResultSet(resultSet));
        }
        return importRecords;
    }

    private ImportRecord parseResultSet(ResultSet resultSet) throws SQLException {
        ImportRecord importRecord = new ImportRecord();
        importRecord.setImportID(resultSet.getInt("import.id"));
        importRecord.setProductDetailID(resultSet.getInt("product_id"));
        importRecord.setProductCode(resultSet.getString("product_code"));
        importRecord.setPrice(resultSet.getInt("bid"));
        importRecord.setPrice(resultSet.getInt("bid"));
        importRecord.setPrice(resultSet.getInt("bid"));
        importRecord.setImportDateTime(resultSet.getTimestamp("import_date").toLocalDateTime());
        importRecord.setStatus(resultSet.getInt("import.status"));
        importRecord.setProduct(productService.getProductByProductID(resultSet.getInt("product_id")));
        return importRecord;
    }
}
