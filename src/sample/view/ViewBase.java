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

public class ViewBase implements ViewMaker {
    private Stage stage;
    private String labelText;
    private EventHandler<? super MouseEvent> handler;

    public ViewBase(Stage stage, String labelText, EventHandler<? super MouseEvent> handler) {
        if (stage == null) {
            throw new IllegalArgumentException("Stage cannot be null");
        }

        if (handler == null) {
            throw new IllegalArgumentException("Handler cannot be null");
        }

        this.stage = stage;
        this.labelText = labelText;
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

        Text Question1 = new Text("Which of the following is not a valid variable name declaration?");
        root.add(Question1, 2, 4);

        String Answer1[] = { "int _a3", "int a_3", "int 3_a", "int _3a" };

        CheckBox[] checkBoxAnswer1 = new CheckBox[Answer1.length];

        for(int i=0; i<Answer1.length; i++){

            checkBoxAnswer1[i] = new CheckBox((Answer1[i])+"");
            checkBoxAnswer1[i].setMnemonicParsing(false);
            root.add(checkBoxAnswer1[i], 2, 5+i);
        }


        Button backButton = new Button("Back");
        backButton.setOnMousePressed(handler);
        Button closeButton = new Button("Close");
        closeButton.setOnMousePressed(e -> stage.close());

        ButtonBar bbar = new ButtonBar();
        //bbar.setPadding(new Insets(10));
        bbar.getButtons().addAll(backButton,closeButton);
        root.add(bbar,80,100);

        return new Scene(root,1200,900);
    }
}
