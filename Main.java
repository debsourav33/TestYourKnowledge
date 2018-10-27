package database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String subject = "data_structure";
        Show_question show = new Show_question(subject);
        System.out.println(show.array_question[1]);
        int id = 1;
        Add_new_subject new_subject = new Add_new_subject("operationg_system");
        //Insert_question insert_question = new Insert_question("data_structure");
        //Delete_question_answer delete_question_answer = new Delete_question_answer(subject,id);
    }
}
