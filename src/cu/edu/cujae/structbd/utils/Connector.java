package cu.edu.cujae.structbd.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static java.sql.Connection connection = null;
    public static java.sql.Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connection == null){
            createConnection();

        }

        return connection;
    }

    private static void createConnection(String serveraddres, String database, String user, String pass) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://" + serveraddres + ":5433/"+ database;
        java.sql.Connection connection = DriverManager.getConnection(url, user, pass);
        Connector.connection = connection;
    }

    private static void createConnection() throws SQLException, ClassNotFoundException {
        String username = System.getProperty("DATABASE_USERNAME");
        String password = System.getProperty("DATABASE_PASSWORD");
        String database = System.getProperty("DATABASE_NAME");

       createConnection("localhost", database, username, password);
    }
}


