package pl.jakubdrozdz.HighScores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.jakubdrozdz.Interfaces.IBasicController;

public class HighScoresController implements IBasicController {
    HighScoresView highScoresView;
    public HighScoresController(Stage stage, Scene homeScene){
        highScoresView = new HighScoresView(stage,homeScene);
        highScoresView.setScene(stage);
        buttonsController(stage,homeScene);
    }

    @Override
    public void buttonsController(Stage stage, Scene homeScene) {
        highScoresView.btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(homeScene);
                stage.setTitle("Memory Game");
            }
        });
    }
}
