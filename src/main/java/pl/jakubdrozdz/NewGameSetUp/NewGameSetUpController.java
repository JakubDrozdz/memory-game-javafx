package pl.jakubdrozdz.NewGameSetUp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.jakubdrozdz.NewGame.NewGameView;


public class NewGameSetUpController {
    public NewGameSetUpController(Stage stage, Scene homeScene) {
        NewGameSetUpView.btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(homeScene);
                stage.setTitle("Memory Game");
            }
        });
        NewGameSetUpView.setDimension.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new NewGameView(stage,homeScene);
            }
        });
    }

}