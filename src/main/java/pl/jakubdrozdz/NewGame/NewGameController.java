package pl.jakubdrozdz.NewGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.jakubdrozdz.Interfaces.IBasicController;

public class NewGameController implements IBasicController {
    Text textTime = new Text();
    NewGameModel newGameModel;
    NewGameView newGameView;

    public NewGameController(Stage stage, Scene homeScene) {
        newGameView = new NewGameView(stage,homeScene);
        newGameModel=new NewGameModel(textTime);
        newGameView.setScene(stage);
        buttonsController(stage,homeScene);
        newGameView.menu.getChildren().add(textTime);
    }

    @Override
    public void buttonsController(Stage stage, Scene homeScene) {
        newGameView.btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(homeScene);
                stage.setTitle("Memory Game");
            }
        });
        newGameView.b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newGameModel.interrupt();
            }
        });
    }
}
