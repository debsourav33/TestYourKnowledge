package sample.view;

import javafx.scene.Scene;

import java.sql.SQLException;

public interface ViewMaker {
    Scene getScene() throws SQLException;
}
