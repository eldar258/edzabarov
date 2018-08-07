package ru.job4j.jsp;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.httpprotocol.Store;
import ru.job4j.httpprotocol.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Class ru.job4j.jsp.
 *
 * @author edzabarov
 * @since 31.07.2018
 */
public class DBStore implements Store<User> {

    private final static BasicDataSource SOURCE = new BasicDataSource();
    private static DBStore instance;
    private Properties dbProperties;
    private final static Logger LOG = LoggerFactory.getLogger(DBStore.class);

    private DBStore() {
        this.dbProperties = new Properties();
        try {
            dbProperties.load(getClass().getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        SOURCE.setDriverClassName(dbProperties.getProperty("driver"));
        SOURCE.setUrl(dbProperties.getProperty("url"));
        SOURCE.setUsername(dbProperties.getProperty("userName"));
        SOURCE.setPassword(dbProperties.getProperty("password"));
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DBStore getInstance() {
        if (instance == null) {
            synchronized (DBStore.class) {
                if (instance == null) {
                    instance = new DBStore();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean add(User user) {
        boolean result = false;
        try (Connection connection = SOURCE.getConnection()) {
            //TODO check user;
            PreparedStatement preparedStatement = connection.prepareStatement(dbProperties.getProperty("insertUser"));
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setDate(6, new Date(user.getCreateDate().getTime()));
            preparedStatement.execute();
            result = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbProperties.getProperty("deleteUser"));
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean update(int id, String name, String role) {
        boolean result = false;
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbProperties.getProperty("updateUser"));
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, role);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            result = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        List<User> result = null;
        try (Connection connection = SOURCE.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(dbProperties.getProperty("findAllUsers"));
            result = new ArrayList<>();
            while (resultSet.next()) {
                User user = createOutUser(resultSet);
                result.add(user);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result != null && !result.isEmpty() ? result : new ArrayList(0);
    }

    @Override
    public String findRoleByLoginPassword(String login, String password) {
        String result = null;
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbProperties.getProperty("findRoleByLoginPasswordUser"));
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getString("name");
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public User findById(int id) {
        User result = null;
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dbProperties.getProperty("findByIdUser"));
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = createOutUser(resultSet);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    private User createOutUser(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getInt("id"), resultSet.getString("name"),
                resultSet.getString("login"), resultSet.getString("password"),
                resultSet.getString("role"), resultSet.getString("email"),
                resultSet.getDate("time_date"));
    }
}
