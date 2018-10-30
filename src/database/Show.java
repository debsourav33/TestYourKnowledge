package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Show extends Database_connector{

   // Connection conn = DriverManager.getConnection(CONNECTION_STRING,USERNAME,PASSWORD);
    public Statement statement = conn.createStatement();
    public Show() throws SQLException {

      //  System.out.println("connection established");

    }
}
