package pl.jakubdrozdz.HighScores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.jakubdrozdz.Interfaces.IBasicWindow;

public class HighScoresView implements IBasicWindow {
    Scene homeScene;
    VBox menu;
    static Button btn;
    StackPane sp;
    Label label;
    public HighScoresView(Stage stage, Scene scene) {
        basicSetUp(scene);
        new HighScoresController(stage,homeScene);
        label = new Label("High Scores");
        menu.getChildren().add(label);
        setScene(stage);
    }

    @Override
    public void basicSetUp(Scene scene) {
        homeScene = scene;
        menu = new VBox();
        menu.setAlignment(Pos.TOP_LEFT);
        btn = new Button("Back to menu");
        menu.getChildren().add(btn);
        menu.setSpacing(20);
    }

    @Override
    public void setScene(Stage stage) {
        sp = new StackPane(menu);
        sp.setPadding(new Insets(20));
        stage.setScene(new Scene(sp,600,200));
    }
}
