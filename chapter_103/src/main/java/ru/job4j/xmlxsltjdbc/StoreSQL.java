package ru.job4j.xmlxsltjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Class ru.job4j.xmlxsltjdbc.
 *
 * @author edzabarov
 * @since 14.07.2018
 */
public class StoreSQL implements AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(StoreSQL.class);

    private Properties config;
    private Properties request;
    private Connection connection;
    private SQLRequester sqlRequester;

    public StoreSQL(Properties config) {
        this.config = config;
        request = new Properties();
        try {
            request.load(getClass().getResourceAsStream("/xmlxsltjdbc/properties/request.properties"));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        sqlRequester = new SQLRequester(request);

    }

    public void open() {
        try {
            this.connection = this.sqlRequester.connectDatabase(this.config.getProperty("host"), this.config.getProperty("main"),
                    this.config.getProperty("user"), this.config.getProperty("password"));

            if (!this.sqlRequester.isResults(this.connection, "checkDB", this.config.getProperty("current"))) {
                createDB();
            } else {
                reconnect();
                if (!this.sqlRequester.isResults(this.connection, "checkTable", this.config.getProperty("currentTable"))) {
                    createTable();
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void createDB() throws SQLException {
        this.sqlRequester.sqlQueriesFromFile(this.connection, this.config.getProperty("pathSCreateDB"));
        reconnect();
        createTable();
    }

    private void reconnect() throws SQLException {
        this.connection.close();
        this.connection = this.sqlRequester.connectDatabase(this.config.getProperty("host"), this.config.getProperty("current"),
                this.config.getProperty("user"), this.config.getProperty("password"));
    }

    private void createTable() throws SQLException {
        this.sqlRequester.sqlQueriesFromFile(this.connection, this.config.getProperty("pathSCreateTable"));
    }

    public void generate(int n) {
        try {
            startGenerate(n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void startGenerate(int n) throws SQLException {
        try (Statement st = this.connection.createStatement()) {
            st.execute(this.request.getProperty("deleteFromEntry"));
        }
        this.connection.setAutoCommit(false);
        try (Statement st = this.connection.createStatement()) {
            for (int i = 1; i <= n; i++) {
                st.execute(String.format(this.request.getProperty("insertIntoTable"), i));
            }
            this.connection.commit();
        }
        this.connection.setAutoCommit(true);
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }

}
