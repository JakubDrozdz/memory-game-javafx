package pl.jakubdrozdz.NewGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGameController {
    public NewGameController(Stage stage, Scene homeScene) {
        NewGameView.btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(homeScene);
                stage.setTitle("Memory Game");
            }
        });
    }
}
