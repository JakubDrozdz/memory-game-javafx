package pl.jakubdrozdz.SaveScore;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.jakubdrozdz.Interfaces.IBasicController;

public class SaveScoreController implements IBasicController {
    SaveScoreView saveScoreView;
    SaveScoreModel saveScoreModel;
    public SaveScoreController(Stage stage,Scene homeScene,double score){
        saveScoreView = new SaveScoreView(stage,homeScene,score);
        saveScoreModel = new SaveScoreModel();
        buttonsController(stage,homeScene);
    }

    @Override
    public void buttonsController(Stage stage, Scene homeScene) {
        saveScoreView.save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String input = saveScoreView.nameField.getText() + ";" + saveScoreView.points + ";0;" + saveScoreView.points + 0;
                saveScoreModel.saveToFile(input);
                saveScoreView.stage.setScene(homeScene);
                saveScoreView.stage.setTitle("Memory Game");
                saveScoreView.stage.setHeight(480);
            }
        });
    }
}
