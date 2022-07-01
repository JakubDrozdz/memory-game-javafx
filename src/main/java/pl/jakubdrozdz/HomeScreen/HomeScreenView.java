package pl.jakubdrozdz.HomeScreen;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
        label.setFont(Font.font("arial",FontWeight.BOLD, FontPosture.REGULAR, 32));
        menu = new VBox();
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(20);
        menu.getChildren().add(label);
        newGame = new Button("New Game");
        newGame.setFont(Font.font("arial",FontWeight.NORMAL, FontPosture.REGULAR, 16));
        menu.getChildren().add(newGame);
        highScores = new Button("High Scores");
        highScores.setFont(Font.font("arial",FontWeight.NORMAL, FontPosture.REGULAR, 16));
        menu.getChildren().add(highScores);
        exit = new Button("Exit");
        exit.setFont(Font.font("arial",FontWeight.NORMAL, FontPosture.REGULAR, 16));
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
