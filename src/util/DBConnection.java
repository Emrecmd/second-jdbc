package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection connect() {
        Connection c = null;
        final String url = "jdbc:postgresql://localhost:5434/cms";
        final String username = "postgres";
        final String password = "password";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }



}
