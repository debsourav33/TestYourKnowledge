package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.model.SceneName;
import sample.view.*;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private static Map<SceneName, Scene> scenes = new HashMap<>();
    private GridPane grid = new GridPane();

    @Override
    public void start(Stage stage) {

        // Create and store all scenes up front
        scenes.put(SceneName.MAIN, new MainView(stage).getScene());
        scenes.put(SceneName.CATEGORIES, new CategoryView(stage).getScene());
        scenes.put(SceneName.SCENE1, new ViewOne(stage).getScene());
        scenes.put(SceneName.SCENE2, new ViewTwo(stage).getScene());
        scenes.put(SceneName.SCENE3, new ViewThree(stage).getScene());

        // Start with the main scene
        stage.setScene(scenes.get(SceneName.MAIN));
        stage.setTitle("Multi-Scene Demo");
        stage.show();
    }

    /** Returns a Map of the scenes by {@link SceneName} */
    public static Map<SceneName, Scene> getScenes() {
        return scenes;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
