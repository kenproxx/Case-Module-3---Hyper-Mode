package util;

public class Query {
    public static final String SELECT_ADMIN_FROM_USER = "select username, password from user where role_id = 2;";
    public static final String SELECT_INFORMATION_FROM_USER = "select * from user where status <> -1;";
    public static final String SELECT_USER_WITH_ID = "select * from user where id = ?;";
    public static final String SELECT_CLIENT_WITH_ROLE = "select username, password from user where role_id <> 2 and status <> -1 and status <> 0;";
    public static final String CREATE_USER_WITH_PARAMETERS = "insert into user (role_id, first_name, last_name, gender, date_of_birth, phone, address, email, username, password, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_USER_WITH_ID = "update user set role_id = ?, first_name = ?, last_name = ?, gender = ?, date_of_birth = ?, phone = ?, address = ?, email = ?, username = ?, password = ?, status = ? where id = ?;";
    public static final String DELETE_USER_WITH_ID = "update user set status = -1 where id = ?;";

    public static final String SELECT_ALL_PRODUCT = "SELECT *" +
            "FROM product_detail" +
            "         JOIN product on product_detail.product_id = product.id" +
            "         JOIN catalog on product.catalog_id = catalog.id" +
            "         JOIN size on product_detail.size_id = size.id" +
            "WHERE product_detail.status != -1;";

    public static final String SELECT_PRODUCT_OFFSET = "SELECT *" +
            "FROM product_detail" +
            "         JOIN product on product_detail.product_id = product.id" +
            "         JOIN catalog on product.catalog_id = catalog.id" +
            "         JOIN size on product_detail.size_id = size.id" +
            "WHERE product_detail.status != -1 LIMIT ? OFFSET ?;";

    public static final String SELECT_PRODUCT_FOR_HOMEPAGE = "SELECT * FROM product" +
            "JOIN attachment ON product.id = attachment.product_id" +
            "JOIN catalog ON product.catalog_id = catalog.id" +
            "GROUP BY product_name";

    public static final String SELECT_PRODUCT_FOR_DETAIL = "SELECT * FROM product" +
            "JOIN attachment ON product.id = attachment.product_id" +
            "JOIN catalog ON product.catalog_id = catalog.id" +
            "WHERE catalog_id = ?" +
            "group by product_name";


    public static final String SELECT_ALL_IMAGE_FROM_PRODUCT = "SELECT * FROM attachment" +
            "WHERE product_id = ?;";

    public static final String SELECT_PRODUCT_BY_DETAIL_ID = "SELECT *" +
            "FROM product_detail" +
            "         JOIN product on product_detail.product_id = product.id" +
            "         JOIN catalog on product.catalog_id = catalog.id" +
            "         JOIN size on product_detail.size_id = size.id " +
            "WHERE product_detail.id = ?;";

    public static final String SELECT_PRODUCT_BY_PRODUCT_ID = "SELECT *" +
            "FROM product_detail" +
            "         JOIN product on product_detail.product_id = product.id" +
            "         JOIN catalog on product.catalog_id = catalog.id" +
            "         JOIN size on product_detail.size_id = size.id " +
            "WHERE product.id = ?;";

    public static final String SELECT_PRICE_BY_PRODUCT_ID = "SELECT * FROM product" +
            "JOIN sale ON product.id = sale.product_id" +
            "WHERE product.id = ?" +
            "ORDER BY created_date DESC LIMIT 1;";

    public static final String SELECT_SIZE_BY_PRODUCT_ID = "SELECT size FROM product_detail" +
            "JOIN size ON product_detail.size_id = size.id" +
            "WHERE product_id = ?";

    public static final String SELECT_IMPORT_BY_PRODUCT_ID = "SELECT * FROM import" +
            "JOIN product_detail on import.product_detail_id = product_detail.id" +
            "WHERE product_detail_id = ?;";

    public static final String SELECT_IMPORT_BY_CATALOG_ID = "SELECT *" +
            "FROM import\n" +
            "         JOIN product_detail on import.product_detail_id = product_detail.id" +
            "         JOIN product on product_detail.product_id = product.id" +
            "WHERE catalog_id = ?;";

    public static final String SELECT_IMPORT_BY_SIZE = "SELECT *" +
            "FROM import\n" +
            "         JOIN product_detail on import.product_detail_id = product_detail.id" +
            "         JOIN size on product_detail.size_id = size.id" +
            "WHERE size = ?;";

    public static final String INSERT_NEW_PRODUCT = "INSERT INTO product" +
            "    (catalog_id, product_name, description, status)" +
            "VALUES (?, ?, ?, ?);";

    public static final String SELECT_NEW_PRODUCT = "SELECT product.id FROM product ORDER BY id DESC LIMIT 1;";

    public static final String INSERT_PRODUCT_SIZE = "INSERT INTO product_detail" +
            "    (product_id, size_id)" +
            "VALUES (?, " +
            "(SELECT size.id FROM size WHERE size = ?));";

    public static final String INSERT_PRODUCT_IMAGE = "INSERT INTO attachment (product_id, image_link, status) VALUES (?,?,?)";

    public static final String UPDATE_PRODUCT = "UPDATE product" +
            "SET catalog_id = ?," +
            "    product_name = ?," +
            "    description = ?," +
            "    status = ?" +
            "WHERE id = ?;";

    public static final String UPDATE_PRODUCT_SIZE = "UPDATE product_detail" +
            "SET size_id = (SELECT id FROM size WHERE size.size = ?)" +
            "WHERE id = ?;";

    public static final String SELECT_ATTACHMENT_ID_BY_PRODUCT_ID = "SELECT id FROM attachment" +
            "WHERE product_id = ?;";

    public static final String UPDATE_PRODUCT_IMAGE = "UPDATE attachment" +
            "SET image_link = ? " +
            "WHERE id = ?;";

    public static final String SELECT_FROM_SIZE = "SELECT * FROM size";

    public static final String SELECT_FROM_CATALOG = "SELECT * FROM catalog";

    public static final String SELECT_PRODUCT_BY_CATALOG_ID = "SELECT * " +
            "FROM product_detail" +
            "         JOIN product on product_detail.product_id = product.id" +
            "         JOIN catalog on product.catalog_id = catalog.id" +
            "         JOIN size on product_detail.size_id = size.id" +
            "WHERE catalog_id = ?;";

    public static final String SELECT_MINIPROFILE = "SELECT username,password,email,img FROM player";
}
