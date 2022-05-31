package util;

public class Query {
    public static final String SELECT_ADMIN_FROM_USER = "select username, password from user where role_id = 2;";
    public static final String SELECT_INFORMATION_FROM_USER = "select * from user where status <> -1;";
    public static final String SELECT_USER_WITH_ID = "select * from user where id = ?;";
    public static final String SELECT_CLIENT_WITH_ROLE = "select username, password from user where role_id <> 2 and status <> -1 and status <> 0;";
    public static final String CREATE_USER_WITH_PARAMETERS = "insert into user (role_id, first_name, last_name, gender, date_of_birth, phone, address, email, username, password, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_USER_WITH_ID = "update user set role_id = ?, first_name = ?, last_name = ?, gender = ?, date_of_birth = ?, phone = ?, address = ?, email = ?, username = ?, password = ?, status = ? where id = ?;";
    public static final String DELETE_USER_WITH_ID = "update user set status = -1 where id = ?;";

    public static final String SELECT_ALL_PRODUCT = "SELECT *\n" +
            "FROM product\n" +
            "WHERE product.status != -1;";

    public static final String SELECT_PRODUCT_OFFSET = "SELECT *\n" +
            "FROM product_detail\n" +
            "         JOIN product on product_detail.product_id = product.id\n" +
            "         JOIN catalog on product.catalog_id = catalog.id\n" +
            "         JOIN size on product_detail.size_id = size.id\n" +
            "WHERE product_detail.status != -1 LIMIT ? OFFSET ?;";

    public static final String SELECT_PRODUCT_FOR_HOMEPAGE = "SELECT * FROM product\n" +
            "JOIN attachment ON product.id = attachment.product.id\n" +
            "GROUP BY product.name";


    public static final String SELECT_ALL_IMAGE_FROM_PRODUCT = "SELECT * FROM attachment\n" +
            "WHERE product_id = ?;";


    public static final String SELECT_PRODUCT_BY_PRODUCT_ID = "SELECT *\n" +
            "FROM product\n" +
            "WHERE product.id = ?";

    public static final String SELECT_PRICE_BY_PRODUCT_ID = "SELECT * FROM product\n" +
            "JOIN sale ON product.id = sale.product.id\n" +
            "WHERE product.id = ?\n" +
            "ORDER BY created_date DESC LIMIT 1;";

    public static final String INSERT_NEW_PRODUCT = "INSERT INTO product" +
            "    ( product_name, description, status)\n" +
            "VALUES (?, ?, ?);";

    public static final String SELECT_NEW_PRODUCT = "SELECT product.id FROM product ORDER BY id DESC LIMIT 1;";

    public static final String INSERT_PRODUCT_IMAGE = "INSERT INTO attachment (product_id, image_link, status) VALUES (?,?,?)";

    public static final String UPDATE_PRODUCT = "UPDATE product\n" +
            "SET product.name = ?,\n" +
            "    description = ?,\n" +
            "    status = ?\n" +
            "WHERE id = ?;";

    public static final String SELECT_ATTACHMENT_ID_BY_PRODUCT_ID = "SELECT id FROM attachment\n" +
            "WHERE product_id = ?;";

    public static final String UPDATE_PRODUCT_IMAGE = "UPDATE attachment\n" +
            "SET image_link = ? \n" +
            "WHERE id = ?;";

    public static final String SELECT_MINIPROFILE = "SELECT username,password,email,img FROM player";
}
