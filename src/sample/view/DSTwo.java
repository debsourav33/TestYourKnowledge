package sample.view;

import javafx.stage.Stage;
import sample.controller.DSTwoController;

public class DSTwo extends ViewBase {
    public DSTwo(Stage stage) {

        super(stage, "Data Structure questions", "Files/DataStructure_PageTwo",
                e -> new DSTwoController(stage).handleMousePress(e),
                event -> new DSTwoController(stage).handleNextButtonPress(event));

    }
}
