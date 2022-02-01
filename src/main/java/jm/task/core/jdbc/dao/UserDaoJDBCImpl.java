package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection;

    {
        try {
            connection = Util.getMySQLConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE users(" +
                "id bigint NOT NULL AUTO_INCREMENT," +
                "name char(45)," +
                "lastname char(45)," +
                "age tinyint," +
                "PRIMARY KEY (id));";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException ignore) {

        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE users;";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException ignore) {

        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO users(name, lastname, age) values(?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
        } catch (SQLException ignore) {

        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException ignore) {

        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> list = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                list.add(user);
            }
            return list;
        } catch (SQLException ignore) {

        }
        return null;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM users;";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException ignore) {

        }
    }
}
