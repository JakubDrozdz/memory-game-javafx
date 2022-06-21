package pl.jakubdrozdz.NewGameSetUp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.jakubdrozdz.HomeScreen.HomeScreenView;
import pl.jakubdrozdz.Interfaces.IBasicController;
import pl.jakubdrozdz.NewGame.NewGameController;
import pl.jakubdrozdz.NewGame.NewGameView;


public class NewGameSetUpController implements IBasicController {
    NewGameSetUpView newGameSetUpView;
    NewGameSetUpModel newGameSetUpModel;
    public NewGameSetUpController(Stage stage, Scene homeScene) {
        newGameSetUpView = new NewGameSetUpView(stage,homeScene);
        newGameSetUpModel = new NewGameSetUpModel();
        newGameSetUpView.setScene(stage);
        buttonsController(stage,homeScene);
    }


    @Override
    public void buttonsController(Stage stage, Scene homeScene) {

        newGameSetUpView.btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(homeScene);
                stage.setTitle("Memory Game");
                stage.setHeight(480);
            }
        });
        newGameSetUpView.setDimension.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String tf1 = newGameSetUpView.tf1.getText();
                String tf2 = newGameSetUpView.tf2.getText();
                String res = newGameSetUpModel.checkDimension(tf1,tf2);
                if(res.equals("")){
                    new NewGameController(stage,homeScene);
                }
                newGameSetUpView.l.setText(res);
                stage.setHeight(250);
            }
        });
    }
}