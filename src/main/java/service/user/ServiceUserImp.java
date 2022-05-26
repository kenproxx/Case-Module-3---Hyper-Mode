package service.user;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ServiceUserImp implements IServiceUser{
    @Override
    public User selectAdmin() throws SQLException {
        User admin = null;
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String username;
        String password;
        try{
            connection =
        }
    }

    @Override
    public void createUser(User user) throws SQLException {

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public Map<String, String> selectClient() {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }
}
