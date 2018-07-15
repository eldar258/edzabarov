package ru.job4j.newtracker;


import org.slf4j.LoggerFactory;
import ru.job4j.xmlxsltjdbc.SQLRequester;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;

/**
 * Class ru.job4j.newtracker.
 *
 * @author edzabarov
 * @since 08.07.2018
 */
public class Tracker implements AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(Tracker.class);

    private Connection connection;
    private Properties config;
    private Properties request;
    private SQLRequester sqlRequester;

    public Tracker() {
        config = new Properties();
        request = new Properties();
        sqlRequester = new SQLRequester(this.request);

        try {
            config.load(getClass().getResourceAsStream("/properties/config.properties"));
            request.load(getClass().getResourceAsStream("/properties/request.properties"));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public void open() throws SQLException {
        this.connection = this.sqlRequester.connectDatabase(this.config.getProperty("host"), this.config.getProperty("main"),
                this.config.getProperty("user"), this.config.getProperty("password"));

        if (!this.sqlRequester.isResults(this.connection, "checkDB", this.config.getProperty("current"))) {
            createDB();
        } else {
            if (!this.sqlRequester.isResults(this.connection, "checkTable", this.config.getProperty("tableItem"))) {
                createTable();
            }
        }
    }

    private void createDB() throws SQLException {
        this.sqlRequester.sqlQueriesFromFile(this.connection, this.config.getProperty("pathSCreateDB"));
        createTable();
    }

    private void createTable() throws SQLException {
        this.connection.close();
        this.connection = this.sqlRequester.connectDatabase(this.config.getProperty("host"), this.config.getProperty("current"),
                this.config.getProperty("user"), this.config.getProperty("password"));
        this.sqlRequester.sqlQueriesFromFile(this.connection, this.config.getProperty("pathSCreateTable"));
    }

    public Item add(Item item) throws SQLException{
        try (PreparedStatement ps = this.connection.prepareStatement(request.getProperty("addItem"))) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.executeUpdate();
        }
        return item;
    }

    public void ubdate(Item item) throws SQLException{
        try (PreparedStatement ps = connection.prepareStatement(request.getProperty(request.getProperty("updateItem")))) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.setInt(3, item.getId());
            ps.executeUpdate();
        }
    }

    public void delete(Item item) throws SQLException{
        try (PreparedStatement ps = connection.prepareStatement(request.getProperty(request.getProperty("deleteItem")))) {
            ps.setInt(1, item.getId());
            ps.executeUpdate();
        }
    }

    public List<Item> findByName(String key) throws SQLException{
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(request.getProperty(request.getProperty("findItemByName")))) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item temp = new Item(rs.getInt("ItemID"), rs.getString("Name"), rs.getString("Description"));
                result.add(temp);
            }
        }
        return result;
    }

    public Item findById(int id) throws SQLException{
        Item result = null;
        try (PreparedStatement ps = connection.prepareStatement(request.getProperty(request.getProperty("findItemByID"))) ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = new Item(rs.getInt("ItemID"), rs.getString("Name"), rs.getString("Description"));
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
