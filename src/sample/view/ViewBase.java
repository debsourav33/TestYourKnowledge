package sample.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import database.Show_question_with_options;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewBase implements ViewMaker {
    private Stage stage;
    private String labelText;
    private String filename;
    private EventHandler<? super MouseEvent> handlerBack;
    private EventHandler<? super MouseEvent> handlerNext;

    public ViewBase(Stage stage, String labelText, String filename,
                    EventHandler<? super MouseEvent> handlerBack, EventHandler<? super MouseEvent> handlerNext) {
        if (stage == null) {
            throw new IllegalArgumentException("Stage cannot be null");
        }

        if (handlerBack == null) {
            throw new IllegalArgumentException("Handler cannot be null");
        }
        if (handlerNext == null){
            throw new IllegalArgumentException("Handler cannot be null");
        }

        this.stage = stage;
        this.labelText = labelText;
        this.filename = filename;
        this.handlerBack = handlerBack;
        this.handlerNext = handlerNext;
    }


    @Override
    public Scene getScene() throws SQLException {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        Label label = new Label(labelText);
        label.setFont(new Font(32));
        root.setHgap(5);
        root.setVgap(5);
        root.setAlignment(Pos.BASELINE_LEFT);

        root.add(label,2,0,48,1);

        ScrollPane scrollPane = new ScrollPane();
        //scrollPane.setContent(root);

        String[] fileData = new String[60];
        int lines=0;
        FileReader fr= null;
        try {
            fr = new FileReader(""+filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Fetching information from database

        Show_question_with_options show = new Show_question_with_options(filename);

        BufferedReader br = new BufferedReader(fr);
        Scanner sc = new Scanner(br);
        while(sc.hasNext()){
            fileData[lines]=sc.nextLine()+".";
            lines++;
        }

        Text[] Question = new Text[50];
        CheckBox[] answer = new CheckBox[50];
        CheckBox[] Options1 = new CheckBox[50];
        CheckBox[] Options2 = new CheckBox[50];
        CheckBox[] Options3 = new CheckBox[50];

        for(int i=0; i<10; i++){
            Question[i] = new Text(show.question[i]);

        }
        /*for(int i=0, j=1; i<20; i++,j++){
            if(j%5==0) j++;
            Options[i] = new CheckBox(fileData[j]);
            Options[i].setMnemonicParsing(false);
        }*/
        for(int i = 0; i<10; i++)
        {
            answer[i] = new CheckBox(show.answer[i]);
            answer[i].setMnemonicParsing(false);

            Options1[i] = new CheckBox(show.option1[i]);//new added options where database data has been added
            Options1[i].setMnemonicParsing(false);
            //System.out.println(show.option1[i]);//new added options where database data has been added
            Options2[i] = new CheckBox(show.option2[i]);//new added options where database data has been added
            Options2[i].setMnemonicParsing(false);
            //System.out.println(show.option2[i]);//new added options where database data has been added
            Options3[i] = new CheckBox(show.option3[i]);//new added options where database data has been added
            Options3[i].setMnemonicParsing(false);
            //System.out.println(show.option3[i]);//new added options where database data has been added
        }


        for(int i=0; i<10; i++){
            root.add(Question[i],2,4*(i+1)+2*i ); //new added options where database data has been added
            root.add(answer[i],2,4*(i+1)+1+2*i );  //new added options where database data has been shown
            root.add(Options1[i],2,4*(i+1)+2+2*i ); //new added options where database data has been shown
            root.add(Options2[i],2,4*(i+1)+3+2*i ); //new added options where database data has been shown
            root.add(Options3[i],2,4*(i+1)+4+2*i ); //new added options where database data has been Shown
        }

        Button backButton = new Button("Back");
        backButton.setOnMousePressed(handlerBack);

        int next = 0;// edit from this line so that the options can show the the text
        Button nextButton = new Button("Next");


            nextButton.setOnMousePressed(handlerNext);


        Button closeButton = new Button("Close");
        closeButton.setOnMousePressed(e -> stage.close());

        ButtonBar bbar = new ButtonBar();
        bbar.getButtons().addAll(backButton, nextButton);
        root.add(bbar,64,34);

        final FlowPane container = new FlowPane();

        scrollPane.setContent(root);

        return new Scene(scrollPane,1200,900);
    }
}
