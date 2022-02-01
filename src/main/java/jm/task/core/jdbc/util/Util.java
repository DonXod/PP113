package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String HOSTNAME = "localhost";
    private static final String DBNAME = "pp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionURL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DBNAME;
        return DriverManager.getConnection(connectionURL, USERNAME, PASSWORD);
    }

}
