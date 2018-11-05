package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Add_new_subject extends Database_connector {
    private String subject_name;

    public Add_new_subject(String subject_name) throws SQLException {

        this.subject_name = subject_name;

        PreparedStatement dropTable = conn.prepareStatement(
                String.format("DROP TABLE IF EXISTS %s", subject_name));
        dropTable.execute();

        PreparedStatement createTable = conn.prepareStatement("CREATE TABLE "+subject_name+"(id int NOT NULL AUTO_INCREMENT, Question varchar(5000), Answer varchar(5000), Option1 varchar(5000),Option2 varchar(5000),Option3 varchar(5000), PRIMARY KEY(id))") ;
        createTable.executeUpdate();

    }

}
