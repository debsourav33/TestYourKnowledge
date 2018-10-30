package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_question_answer extends Database_connector{
    private int id;
    private String subject;

    public Delete_question_answer(String subject, int id) throws SQLException {
        this.subject = subject;
        this.id = id;
        //Statement delete = conn.createStatement();
        String delete_string = "DELETE FROM "+subject+" WHERE id = "+id+"";
        //delete.executeQuery(delete_string);
        PreparedStatement delete = conn.prepareStatement(delete_string);
        delete.executeUpdate();
    }
}
