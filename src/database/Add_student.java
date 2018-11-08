package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add_student extends Database_connector {
    private String name;
    private String roll;
    private String department;
    private String username;
    private String pass;

    public Add_student(String name, String roll, String department, String username,String pass) throws SQLException {
        this.name = name;
        this.roll=roll;
        this.department = department;
        this.username = username;
        this.pass = pass;
        String insert = "INSERT INTO   student_information (Name, Roll, Department, User_name, Password ) VALUES ('" + name + "','" + roll + "','" + department + "','" + username + "','" + pass + "')";
        PreparedStatement insert_Student = conn.prepareStatement(insert);
        insert_Student.executeUpdate();


    }
}
