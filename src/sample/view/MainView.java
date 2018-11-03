package sample.view;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.controller.MainController;

public class MainView implements ViewMaker {

    private Stage stage;

    /** Must inject a stage */
    public MainView(Stage stage) {
        this.stage = stage;
    }

    @Override
    public Scene getScene() {

        // Inject stage from Main into controller
        MainController controller = new MainController(stage);

        Button button1 = new Button("Categories");
        button1.setOnMousePressed(e -> controller.handleOnPressButton1(e));

        BorderPane root = new BorderPane();
        //root.setLeft(vbox);
        Label label = new Label("  Test your knowledge\n "+"  in various computer\n"+"  science & engineering fields\n");
        label.setFont(new Font(32));
        root.setTop(label);

        root.setCenter(button1);

        Button closeButton = new Button("Close");
        closeButton.setOnMousePressed(e -> stage.close());

        ButtonBar bbar = new ButtonBar();
        bbar.setPadding(new Insets(10));
        bbar.getButtons().add(closeButton);
        root.setBottom(bbar);
        Scene scene = new Scene(root, 800, 600);

        return scene;
    }

}
