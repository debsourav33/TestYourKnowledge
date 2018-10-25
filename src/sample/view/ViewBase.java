package sample.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ViewBase implements ViewMaker {
    private Stage stage;
    private String labelText;
    private String filename;
    private EventHandler<? super MouseEvent> handler;

    public ViewBase(Stage stage, String labelText, String filename, EventHandler<? super MouseEvent> handler) {
        if (stage == null) {
            throw new IllegalArgumentException("Stage cannot be null");
        }

        if (handler == null) {
            throw new IllegalArgumentException("Handler cannot be null");
        }

        this.stage = stage;
        this.labelText = labelText;
        this.filename = filename;
        this.handler = handler;
    }


    @Override
    public Scene getScene() {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        Label label = new Label(labelText);
        label.setFont(new Font(32));
        root.setHgap(5);
        root.setVgap(5);
        root.setAlignment(Pos.BASELINE_LEFT);

        root.add(label,2,0,48,1);

        String[] fileData = new String[1000];
        int lines=0;
        FileReader fr= null;
        try {
            fr = new FileReader(""+filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(fr);
        Scanner sc = new Scanner(br);
        while(sc.hasNext()){
            fileData[lines]=sc.nextLine()+".";
            lines++;
        }

        Text[] Question = new Text[5];
        CheckBox[] Options = new CheckBox[20];

        for(int i=0; i<5; i++){
            Question[i] = new Text(fileData[4*i+i]);

        }
        for(int i=0, j=1; i<20; i++,j++){
            if(j%5==0) j++;
            Options[i] = new CheckBox(fileData[j]);
            Options[i].setMnemonicParsing(false);
        }

        for(int i=0,j=0; i<5 && j<20; i++,j+=4){
            root.add(Question[i],2,4*(i+1)+2*i );
            root.add(Options[j],2,4*(i+1)+1+2*i );
            root.add(Options[j+1],2,4*(i+1)+2+2*i );
            root.add(Options[j+2],2,4*(i+1)+3+2*i );
            root.add(Options[j+3],2,4*(i+1)+4+2*i );
        }

        Button backButton = new Button("Back");
        backButton.setOnMousePressed(handler);
        Button closeButton = new Button("Close");
        closeButton.setOnMousePressed(e -> stage.close());
        ButtonBar bbar = new ButtonBar();
        //bbar.setPadding(new Insets(10));
        bbar.getButtons().addAll(backButton,closeButton);
        root.add(bbar,64,34);

        return new Scene(root,1200,900);
    }
}
