package sample.view;

import javafx.stage.Stage;
import sample.controller.LanguageTwoController;

public class LanguageTwo extends ViewBase{
    public LanguageTwo(Stage stage) {

        super(stage, "Programming languages questions","Files/Language_PageTwo",
                e -> new LanguageTwoController(stage).handleMousePress(e),
                event -> new LanguageTwoController(stage).handleNextButtonPress(event));

    }
}
