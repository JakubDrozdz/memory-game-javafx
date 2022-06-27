package pl.jakubdrozdz.HighScores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pl.jakubdrozdz.Interfaces.IBasicController;
import pl.jakubdrozdz.Player;

import java.util.ArrayList;

public class HighScoresController implements IBasicController {
    HighScoresView highScoresView;
    HighScoresModel highScoresModel;
    String[][] playersList;
    public HighScoresController(Stage stage, Scene homeScene){
        highScoresView = new HighScoresView(stage,homeScene);
        highScoresModel = new HighScoresModel();
        highScoresView.setScene(stage);
        playersList = highScoresModel.readFile();
        buttonsController(stage,homeScene);
        loadValues();
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
    public void loadValues(){
        highScoresView.nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        highScoresView.pointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));
        highScoresView.firstTriesCol.setCellValueFactory(new PropertyValueFactory<>("firstTries"));
        highScoresView.totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        highScoresView.table.getColumns().addAll(highScoresView.nameCol,highScoresView.pointsCol,highScoresView.firstTriesCol,highScoresView.totalCol);
        highScoresModel.sort(playersList);
        for (int i = 1; i < playersList.length; i++) {
            highScoresView.table.getItems().add(new Player(playersList[i][0],Double.parseDouble(playersList[i][1]),Integer.parseInt(playersList[i][2]),Double.parseDouble(playersList[i][3])));
        }
    }
}
