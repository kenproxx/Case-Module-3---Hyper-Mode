package service.catalog;

import model.Catalog;

import java.sql.SQLException;
import java.util.List;

public interface ICatalogService {
    List<Catalog> getCatalogList() throws SQLException;
}
