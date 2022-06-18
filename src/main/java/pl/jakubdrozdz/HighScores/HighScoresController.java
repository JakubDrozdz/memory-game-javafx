package pl.jakubdrozdz.HighScores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HighScoresController {
    public HighScoresController(Stage stage, Scene homeScene) {
        HighScoresView.btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(homeScene);
            }
        });
    }
}
