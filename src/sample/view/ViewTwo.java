package sample.view;

import javafx.stage.Stage;
import sample.controller.ViewTwoController;

public class ViewTwo extends ViewBase {

    public ViewTwo(Stage stage) {

        super(stage, "Data Structure questions", "Files/Data Structure",e -> new ViewTwoController(stage).handleMousePress(e));

    }

}
