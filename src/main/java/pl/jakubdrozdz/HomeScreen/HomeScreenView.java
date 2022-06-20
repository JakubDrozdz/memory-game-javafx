package pl.jakubdrozdz.HomeScreen;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScreenView {
    public static Scene scene;
    Stage stage;
    Label label;
    VBox menu;
    static Button newGame;
    static Button highScores;
    static Button exit;
    StackPane sp;
    public HomeScreenView(Stage stage) {
        this.stage=stage;
        label = new Label("Memory Game");
        menu = new VBox();
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(20);
        menu.getChildren().add(label);
        newGame = new Button("New Game");
        menu.getChildren().add(newGame);
        highScores = new Button("High Scores");
        menu.getChildren().add(highScores);
        exit = new Button("Exit");
        menu.getChildren().add(exit);

        sp = new StackPane();
        sp.getChildren().add(menu);
        scene = new Scene(sp, 640, 480);
        stage.setTitle("Memory Game");
    }

    public Scene getScene() {
        return scene;
    }

}
