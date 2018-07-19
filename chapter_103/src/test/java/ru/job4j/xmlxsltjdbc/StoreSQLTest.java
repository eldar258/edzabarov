package ru.job4j.xmlxsltjdbc;

import org.junit.Test;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.xmlxsltjdbc.
 *
 * @author edzabarov
 * @since 16.07.2018
 */
public class StoreSQLTest {

    @Test
    public void whenStoreSQLGenerateDataThenInBDOnlyGeneratedData() {
        Properties config = new Properties();
        int n = 10;
        try {
            config.load(getClass().getResourceAsStream("/xmlxsltjdbc/properties/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (StoreSQL storeSQL = new StoreSQL(config)) {
            storeSQL.open();
            storeSQL.generate(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[] expected = new int[n];
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/java_a_from_z", "postgres",
                "password"))  {
            String sql = "SELECT Field FROM Entry ORDER BY Field";
            try (Statement st = connection.createStatement()) {
                try (ResultSet rs = st.executeQuery(sql)) {
                    for (int i = 0; i < expected.length && rs.next(); i++) {
                        expected[i] = rs.getInt("Field");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }
        assertThat(expected, is(result));
    }

}