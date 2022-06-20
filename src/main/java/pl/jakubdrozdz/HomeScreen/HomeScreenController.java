package pl.jakubdrozdz.HomeScreen;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import pl.jakubdrozdz.HighScores.HighScoresView;
import pl.jakubdrozdz.NewGameSetUp.NewGameSetUpView;
import static pl.jakubdrozdz.HomeScreen.HomeScreenView.scene;

public class HomeScreenController {
    Stage stage;
    public HomeScreenController(Stage stage) {
        this.stage = stage;
        stage.setScene(new HomeScreenView(stage).getScene());
        stage.show();
        HomeScreenView.newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new NewGameSetUpView(stage,scene);
            }
        });
        HomeScreenView.highScores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new HighScoresView(stage,scene);
            }
        });
        HomeScreenView.exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
    }
}
