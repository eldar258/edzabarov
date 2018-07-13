package ru.job4j.newtracker;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * Class ru.job4j.newtracker.
 *
 * @author edzabarov
 * @since 08.07.2018
 */
public class Tracker implements AutoCloseable {
    private Connection connection;
    private Properties config;
    private Properties request;

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        try {
            tracker.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Tracker() {
        config = new Properties();
        request = new Properties();

        try {
            config.load(getClass().getResourceAsStream("/properties/config.properties"));
            request.load(getClass().getResourceAsStream("/properties/request.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        Connection conn = null;
        conn = connectDatabase(config.getProperty("main"));

        boolean existBD = isResults(conn, "checkDB", "current");
        if (!existBD) {
            //Создание бд
            sqlQueriesFromFile(getClass().getResource("/sqlscripts/sql_create_database.sql").getPath(), conn.createStatement());
        }
        conn.close();
        conn = connectDatabase(config.getProperty("current"));
        if (!(existBD && isResults(conn, "checkTable", "tableItem"))) {
            //Создание таблиц
            sqlQueriesFromFile(getClass().getResource("/sqlscripts/sql_create_table.sql").getPath(), conn.createStatement());
        }

        this.connection = conn;
    }

    private boolean isResults(Connection conn, String sql, String property) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(request.getProperty(sql));
        ps.setString(1, config.getProperty(property));
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    private Connection connectDatabase(String nameDatabase) throws SQLException {
        return DriverManager.getConnection(String.format("%s%s", config.getProperty("host"), nameDatabase),
                config.getProperty("user"), config.getProperty("password"));
    }

    private void sqlQueriesFromFile(String path, Statement statement) throws SQLException {
        try(Scanner scanner = new Scanner(new File(path))) {
            scanner.useDelimiter(";");

            while (scanner.hasNext()) {
                statement.execute(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Item add(Item item) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(request.getProperty("addItem"));
        ps.setString(1, item.getName());
        ps.setString(2, item.getDesc());
        ps.executeUpdate();
        return item;
    }

    public void ubdate(Item item) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(request.getProperty(request.getProperty("updateItem")));
        ps.setString(1, item.getName());
        ps.setString(2, item.getDesc());
        ps.setInt(3, item.getId());
        ps.executeUpdate();
    }

    public void delete(Item item) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(request.getProperty(request.getProperty("deleteItem")));
        ps.setInt(1, item.getId());
        ps.executeUpdate();
    }

    public List<Item> findByName(String key) throws SQLException{
        List<Item> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(request.getProperty(request.getProperty("findItemByName")));
        ps.setString(1, key);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Item temp = new Item(rs.getInt("ItemID"), rs.getString("Name"), rs.getString("Description"));
            result.add(temp);
        }
        return result;
    }

    public Item findById(int id) throws SQLException{
        Item result = null;
        PreparedStatement ps = connection.prepareStatement(request.getProperty(request.getProperty("findItemByID")));
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        result = new Item(rs.getInt("ItemID"), rs.getString("Name"), rs.getString("Description"));
        return result;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
