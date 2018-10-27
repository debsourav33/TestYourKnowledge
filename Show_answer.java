package database;
import java.sql.*;
import java.util.Scanner;
public class Show_answer extends Show{
    private String subject;
    public String[] array_answer = new String[50];
    public int[] array_answer_id = new int[50];

    public Show_answer(String subject) throws SQLException {
        this.subject = subject;
        ResultSet rs = statement.executeQuery("SELECT id, Answer FROM "+subject+"");
        String[] array_question = new String[50];
        int i = 0;
        while (rs.next())
        {
           this.array_answer_id[i] = rs.getInt(1);
           this.array_answer[i] = rs.getString(2);

            i++;
            //System.out.println(rs.getString(1));
            System.out.println(this.array_answer_id[i-1] +" "+  this.array_answer[i-1]);
        }
    }
}
