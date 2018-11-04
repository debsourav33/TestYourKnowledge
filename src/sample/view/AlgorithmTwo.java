package sample.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.controller.AlgorithmTwoController;

public class AlgorithmTwo extends ViewBase {
    public AlgorithmTwo(Stage stage) {
        super(stage, "Algorithm questions", "Algorithm",
                e -> new AlgorithmTwoController(stage).handleMousePress(e),
                event -> new AlgorithmTwoController(stage).handleNextButtonPress(event));
    }
}
