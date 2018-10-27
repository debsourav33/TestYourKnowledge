package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert_question extends Database_connector {

    private  static String subject = null;
    private String question = null;
    private String answer = null;
    public Insert_question(String subject) throws SQLException {

        Scanner scan = new Scanner(System.in);
        this.subject = subject;
        //Connection conn = DriverManager.getConnection(CONNECTION_STRING,USERNAME,PASSWORD);
        //System.out.println("connection established");
        String text = "Qus:";
        System.out.println(text);
        this.question = scan.nextLine();
        text = "Ans:";
        System.out.println(text);
        this.answer = scan.nextLine();
        String insert ="INSERT INTO "+subject+"(Question, Answer) VALUES ('"+question+"','"+answer+"')";
        PreparedStatement insert_QnS =  conn.prepareStatement(insert);
        insert_QnS.executeUpdate();

    }
}
