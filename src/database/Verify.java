package database;

import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Verify extends  Show {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public Verify(String username) throws SQLException {

        this.username = username;
        this.password = password;
        ResultSet rs = statement.executeQuery("SELECT  id,Password FROM `student_information` WHERE User_name = '"+username+"'");
        while (rs.next())
        {
            //this.id = rs.getInt(1);
            this.password = rs.getString(2);

        }



        System.out.println(password);

    }
}
