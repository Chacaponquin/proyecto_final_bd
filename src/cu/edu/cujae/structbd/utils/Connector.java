package cu.edu.cujae.structbd.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {
    private static java.sql.Connection connection = null;
    public static java.sql.Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connection == null){
            createConnection();

        }

        return connection;
    }

    private static void createConnection(String serveraddres, String database, String user, String pass, String port) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://" + serveraddres + ":" + port + "/"+ database;
        java.sql.Connection connection = DriverManager.getConnection(url, user, pass);
        Connector.connection = connection;
    }

    private static void createConnection() throws SQLException, ClassNotFoundException {
        String username = System.getProperty("DATABASE_USERNAME");
        String password = System.getProperty("DATABASE_PASSWORD");
        String database = System.getProperty("DATABASE_NAME");
        String port = System.getProperty("DATABASE_PORT");

        createConnection("localhost", database, username, password, port);
    }
    
    public static void restartConnection(){
        try {
            createConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
    }
}


