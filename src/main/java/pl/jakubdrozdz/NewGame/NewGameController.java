package pl.jakubdrozdz.NewGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewGameController {
    Text textTime = new Text();
    NewGameModel newGame = new NewGameModel(textTime);
    public NewGameController(Stage stage, Scene homeScene, VBox menu) {
        NewGameView.btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(homeScene);
                stage.setTitle("Memory Game");
            }
        });
        NewGameView.b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newGame.interrupt();
            }
        });

        menu.getChildren().add(textTime);
    }
}
