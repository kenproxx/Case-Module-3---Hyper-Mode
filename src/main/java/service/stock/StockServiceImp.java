package service.stock;

import model.Catalog;
import model.ImportRecord;
import model.Product;
import service.product.IProductService;
import service.product.ProductServiceImp;
import util.DBHandle;
import util.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StockServiceImp implements IStockService{
    private Connection connection;
    private PreparedStatement statement;
    private IProductService productService;

    public StockServiceImp() {
        connection = DBHandle.getConnection();
        productService = new ProductServiceImp();
    }

    public StockServiceImp(IProductService productService) {
        connection = DBHandle.getConnection();
        this.productService = productService;
    }

    public List<ImportRecord> getImportRecordByProduct(Product product) throws SQLException {
        return getImportRecordByProduct(product.getDetailID());
    }

    public List<ImportRecord> getImportRecordByProduct(int detailID) throws SQLException {
        statement = connection.prepareStatement(Query.SELECT_IMPORT_BY_PRODUCT_ID);
        return getRecordOneParam(statement, detailID);
    }

    public List<ImportRecord> getImportRecordByCatalog(Catalog catalog) throws SQLException {
        return getImportRecordByCatalog(catalog.getCatalogID());
    }

    public List<ImportRecord> getImportRecordByCatalog(int id) throws SQLException {
        statement = connection.prepareStatement(Query.SELECT_IMPORT_BY_CATALOG_ID);
        return getRecordOneParam(statement, id);
    }

    public List<ImportRecord> getImportRecordBySize(int size) throws SQLException {
        statement = connection.prepareStatement(Query.SELECT_IMPORT_BY_SIZE);
        return getRecordOneParam(statement, size);
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
        importRecord.setProductDetailID(resultSet.getInt("product_detail_id"));
        importRecord.setProductCode(resultSet.getString("product_code"));
        importRecord.setPrice(resultSet.getInt("bid"));
        importRecord.setPrice(resultSet.getInt("bid"));
        importRecord.setPrice(resultSet.getInt("bid"));
        importRecord.setImportDateTime(resultSet.getTimestamp("import_date").toLocalDateTime());
        importRecord.setStatus(resultSet.getInt("import.status"));
        importRecord.setProduct(productService.getProductByDetailID(resultSet.getInt("product_detail_id")));
        return importRecord;
    }
}
