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
    private String option1 = null;
    private String option2 = null;
    private String option3 = null;
    public Insert_question(String subject) throws SQLException {

        Scanner scan = new Scanner(System.in);
        this.subject = subject;
        //Connection conn = DriverManager.getConnection(CONNECTION_STRING,USERNAME,PASSWORD);
        //System.out.println("connection established");
        String text = "";

             text = "Qus:";
            System.out.println(text);
            this.question = scan.nextLine();





            text = "Ans:";

            System.out.println(text);
            this.answer = scan.nextLine();


            text = "Opt1:";
            System.out.println(text);
            this.option1 = scan.nextLine();




            text = "Opt2:";
            System.out.println(text);
            this.option2 = scan.nextLine();



            text = "Opt3:";
            System.out.println(text);
            this.option3 = scan.nextLine();

        String insert ="INSERT INTO "+subject+"(Question, Answer, Option1, Option2, Option3 ) VALUES ('"+question+"','"+answer+"','"+option1+"','"+option2+"','"+option3+"')";
        PreparedStatement insert_QnS =  conn.prepareStatement(insert);
        insert_QnS.executeUpdate();

    }
}
