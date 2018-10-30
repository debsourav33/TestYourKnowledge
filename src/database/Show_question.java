package database;
import java.sql.*;
import java.util.Scanner;

public class Show_question extends Show {
    private String subject;
    public String[] array_question = new String[50];
    public int[] array_question_id = new int[50];

    public Show_question(String subject) throws SQLException {

        ResultSet rs = statement.executeQuery("SELECT id,Question FROM "+subject+"");
        //String[] array_question = new String[50];
        int i = 0;
        while (rs.next())
        {
            this.array_question_id[i] = rs.getInt(1);
            this.array_question[i] = rs.getString(2);

            i++;
           //System.out.println(rs.getString(1));
            System.out.println("No. "+this.array_question_id[i-1] +": "+ this.array_question[i-1]);
        }

    }
}
