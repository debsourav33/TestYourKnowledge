package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Show_subject_table extends Show {
    private String subject_list;
    public int table_size;
    public String[] subject_array = new String[100];

    public Show_subject_table() throws SQLException {
        this.subject_list = "subject_table" ;
        ResultSet rs = statement.executeQuery("SELECT Subjects FROM "+subject_list+"");
        int i = 0;
        while (rs.next())
        {
            this.subject_array[i] = rs.getString(1);

            i++;
            //System.out.println(rs.getString(1));
          //  System.out.println(this.subject_array[i-1]);
        }

        table_size = i;
        //System.out.println(table_size);

    }
}
