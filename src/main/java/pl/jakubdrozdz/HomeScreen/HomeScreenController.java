package pl.jakubdrozdz.HomeScreen;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.jakubdrozdz.HighScores.HighScoresController;
import pl.jakubdrozdz.Interfaces.IBasicController;
import pl.jakubdrozdz.NewGameSetUp.NewGameSetUpController;

import static pl.jakubdrozdz.HomeScreen.HomeScreenView.scene;

public class HomeScreenController implements IBasicController {
    Stage stage;
    public HomeScreenController(Stage stage){
        this.stage = stage;
        stage.setScene(new HomeScreenView(stage).getScene());
        stage.show();
        buttonsController(stage,scene);
    }

    @Override
    public void buttonsController(Stage stage, Scene homeScene) {
        HomeScreenView.newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new NewGameSetUpController(stage,scene);
            }
        });
        HomeScreenView.highScores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) { new HighScoresController(stage,scene);}
        });
        HomeScreenView.exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
    }
}
