package service.catalog;

import model.Catalog;
import util.DBHandle;
import util.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CatalogServiceImp implements ICatalogService{
    private Connection connection;
    private PreparedStatement statement;

    public CatalogServiceImp() {
        connection = DBHandle.getConnection();
    }

    public List<Catalog> getCatalogList() throws SQLException {
        List<Catalog> catalogList = new LinkedList<>();
        statement = connection.prepareStatement(Query.SELECT_FROM_CATALOG);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Catalog catalog = new Catalog();
            catalog.setCatalogID(resultSet.getInt("id"));
            catalog.setCatalogName(resultSet.getString("name"));
            catalog.setDescription(resultSet.getString("description"));
            catalog.setStatus(resultSet.getInt("status"));
            catalogList.add(catalog);
        }
        return catalogList;
    }
}
