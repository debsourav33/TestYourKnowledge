package sample.view;

import javafx.stage.Stage;
import sample.controller.ViewThreeController;

public class ViewThree extends ViewBase {
    public ViewThree(Stage stage) {
        super(stage, "Algorithm questions", e -> new ViewThreeController(stage).handleMousePress(e));
    }
}
