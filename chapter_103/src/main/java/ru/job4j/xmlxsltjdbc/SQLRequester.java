package ru.job4j.xmlxsltjdbc;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * Class ru.job4j.xmlxsltjdbc.
 *
 * @author edzabarov
 * @since 14.07.2018
 */
public class SQLRequester {
    Properties request;

    public SQLRequester(Properties request) {
        this.request = request;
    }

    public boolean isResults(Connection conn, String sqlName, String parameter) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(this.request.getProperty(sqlName))) {
            ps.setString(1, parameter);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    public Connection connectDatabase(String host, String nameDatabase, String user, String password) throws SQLException {
        return DriverManager.getConnection(String.format("%s%s", host, nameDatabase),
                user, password);
    }

    public void sqlQueriesFromFile(Connection conn, String path) throws SQLException {
        try(Statement statement = conn.createStatement(); Scanner scanner = new Scanner(getClass().getResourceAsStream(path))) {
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                statement.execute(scanner.next());
            }
        }
    }

}
