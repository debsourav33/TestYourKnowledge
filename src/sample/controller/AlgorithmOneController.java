package sample.controller;

import javafx.event.Event;
import javafx.stage.Stage;
import sample.Main;
import sample.model.SceneName;

public class AlgorithmOneController {
    private Stage stage;

    /** Must inject a stage */
    public AlgorithmOneController(Stage stage) {
        if (stage == null) {
            throw new IllegalArgumentException("Stage cannot be null");
        }

        this.stage = stage;
    }

    /** Display main scene when the "back" button is clicked */
    public void handleMousePress(Event event) {
        stage.setScene(Main.getScenes().get(SceneName.CATEGORIES));
    }

    public void handleNextButtonPress(Event event){
        stage.setScene(Main.getScenes().get(SceneName.CATEGORIES));
    }
}
