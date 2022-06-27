package pl.jakubdrozdz.SaveScore;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pl.jakubdrozdz.Interfaces.IBasicController;

public class SaveScoreController implements IBasicController {
    SaveScoreView saveScoreView;
    SaveScoreModel saveScoreModel;
    double points;
    int firstTries;
    public SaveScoreController(Stage stage,Scene homeScene,double score,int firstTries){
        saveScoreView = new SaveScoreView(stage,homeScene);
        saveScoreModel = new SaveScoreModel();
        this.points = score;
        this.firstTries = firstTries;
        saveScoreView.firstTriesLabel.setText("First tries " + firstTries);
        saveScoreView.score.setText("Score " + points);
        buttonsController(stage,homeScene);
    }

    @Override
    public void buttonsController(Stage stage, Scene homeScene) {
        saveScoreView.save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String input = saveScoreView.nameField.getText() + ";" + points + ";"+ firstTries+";" + (points+firstTries);
                saveScoreModel.saveToFile(input);
                saveScoreView.stage.setScene(homeScene);
                saveScoreView.stage.setTitle("Memory Game");
                saveScoreView.stage.setHeight(480);
            }
        });
    }
}
