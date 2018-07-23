package ru.job4j.benchmark;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 22.07.2018
 */
public class ConnectVacancySQL extends ConnectorSQL {

    public ConnectVacancySQL(Properties config, Properties request) {
        super(config, request);
    }

    public void addVacancy(Vacancy vacancy) throws SQLException {
        PreparedStatement ps = this.connection.prepareStatement(request.getProperty("addVacancy"));
        ps.setString(1, vacancy.getUrl());
        ps.setString(2, vacancy.getText());
        ps.setTimestamp(3, vacancy.getDate());
        ps.execute();
    }

    public Date searchLastDate() throws SQLException {
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery(request.getProperty("selectLastDate"));
        Date result = null;
        if (rs.next()) {
            result = rs.getDate(1);
        }
        return result;
    }
}
