package ru.job4j.benchmark;

import ru.job4j.xmlxsltjdbc.SQLRequester;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 22.07.2018
 */
public class ConnectorSQL implements AutoCloseable {
    protected Properties config;
    protected Properties request;
    private SQLRequester sqlRequester;
    protected Connection connection;

    public ConnectorSQL(Properties config, Properties request) {
        this.config = config;
        this.request = request;
        sqlRequester = new SQLRequester(request);
    }

    public void open() throws SQLException {
        this.connection = this.sqlRequester.connectDatabase(this.config.getProperty("host"),
                this.config.getProperty("root"), this.config.getProperty("user"), this.config.getProperty("password"));
        if (!this.sqlRequester.isResults(this.connection, "checkDB", this.config.getProperty("db"))) {
            createDB();
        } else {
            reconnect();
            if (!this.sqlRequester.isResults(this.connection, "checkTable", this.config.getProperty("currentTable"))) {
                createTable();
            }
        }
    }

    private void createDB() throws SQLException {
        this.sqlRequester.sqlQueriesFromFile(this.connection, this.config.getProperty("pathSCreateDB"));
        reconnect();
        createTable();
    }

    private void reconnect() throws SQLException {
        this.connection.close();
        this.connection = this.sqlRequester.connectDatabase(this.config.getProperty("host"), this.config.getProperty("db"),
                this.config.getProperty("user"), this.config.getProperty("password"));
    }

    private void createTable() throws SQLException {
        this.sqlRequester.sqlQueriesFromFile(this.connection, this.config.getProperty("pathSCreateTable"));
    }

    public void switchAutoCommit() throws SQLException {
        this.connection.setAutoCommit(!this.connection.getAutoCommit());
    }

    public void commit() throws SQLException {
        this.connection.commit();
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) this.connection.close();
    }
}
