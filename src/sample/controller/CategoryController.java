package sample.controller;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;
import sample.model.SceneName;

public class CategoryController {
    private Stage stage;

    public CategoryController(Stage stage){
        this.stage = stage;
    }

    public void handleOnFirstBack(MouseEvent event){ stage.setScene(Main.getScenes().get(SceneName.MAIN));}

    /** Display the first scene */
    public void handleOnPressButton1(MouseEvent event) { stage.setScene(Main.getScenes().get(SceneName.LANGUAGE1));
    }

    /** Display the second scene */
    public void handleOnPressButton2(MouseEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.DS1));
    }

    /** Display the third scene */
    public void handleOnPressButton3(MouseEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.ALGO1));
    }
}
