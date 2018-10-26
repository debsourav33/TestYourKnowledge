package sample.view;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.controller.ViewOneController;

public class ViewOne extends ViewBase {
    /** Must inject a stage */
    public ViewOne(Stage stage) {

        super(stage, "Programming languages questions","Files/Language", e -> new ViewOneController(stage).handleMousePress(e));



    }
}
