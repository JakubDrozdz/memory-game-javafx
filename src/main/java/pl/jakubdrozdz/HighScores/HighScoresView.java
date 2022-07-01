package pl.jakubdrozdz.HighScores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import pl.jakubdrozdz.Interfaces.IBasicWindow;
import pl.jakubdrozdz.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HighScoresView implements IBasicWindow {
    Scene homeScene;
    VBox menu;
    static Button btn;
    StackPane sp;
    Label label;
    VBox panel;
     TableView<Player> table;
    TableColumn<Player,String> nameCol;
    TableColumn<Player,Double> pointsCol;
    TableColumn<Player,Integer> firstTriesCol;
    TableColumn<Player,Double> totalCol;
    public HighScoresView(Stage stage, Scene scene) {
        stage.setTitle("High Scores");
        basicSetUp(scene);
        panel = new VBox();
        panel.setAlignment(Pos.CENTER);
        label = new Label("Leaderboard");
        label.setFont(Font.font("arial",FontWeight.BOLD, FontPosture.REGULAR, 32));
        label.setAlignment(Pos.CENTER);
        panel.getChildren().add(label);
        panel.setSpacing(15);
        menu.getChildren().add(panel);

        table = new TableView<Player>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        panel.getChildren().add(table);
        nameCol = new TableColumn<>("Name");
        pointsCol = new TableColumn<>("Points");
        firstTriesCol = new TableColumn<>("First tries");
        totalCol = new TableColumn<>("Total");

        setScene(stage);
        stage.setHeight(400);



    }

    @Override
    public void basicSetUp(Scene scene) {
        homeScene = scene;
        menu = new VBox();
        menu.setAlignment(Pos.TOP_LEFT);
        btn = new Button("Back to menu");
        btn.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 16));
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
