package pl.jakubdrozdz.SaveScore;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.jakubdrozdz.HomeScreen.HomeScreenView;
import pl.jakubdrozdz.Interfaces.IBasicWindow;

import java.io.*;

public class SaveScoreView implements IBasicWindow {
    VBox menu;
    HBox r1;
    HBox r2;
    HBox r3;
    StackPane sp;
    Scene homeScene;
    Label name;
    Label score;
    double points;
    Label firstTries;
    TextField nameField;
    Button save;
    Stage stage;
    public SaveScoreView(Stage stage, Scene homeScene, double points) {
        this.stage = stage;
        basicSetUp(homeScene);
        stage.setTitle("Save result");
        this.points = points;
        rowSetup();
        save = new Button("Save result");
        menu.getChildren().add(save);

        setScene(stage);
    }

    @Override
    public void basicSetUp(Scene scene) {
        homeScene = scene;
        menu = new VBox();
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(20);
    }

    @Override
    public void setScene(Stage stage) {
        sp = new StackPane(menu);
        sp.setPadding(new Insets(20));
        stage.setScene(new Scene(sp,600,200));
    }
    public void rowSetup(){
        r1 = new HBox();
        r2 = new HBox();
        r3 = new HBox();
        r1.setAlignment(Pos.CENTER);
        r2.setAlignment(Pos.CENTER);
        r3.setAlignment(Pos.CENTER);
        menu.getChildren().add(r1);
        menu.getChildren().add(r2);
        menu.getChildren().add(r3);

        name = new Label("Enter player name:");
        String s = "Score " + points;
        this.score = new Label(s);
        firstTries = new Label("First tries 0");
        name.setPadding(new Insets(10));
        this.score.setPadding(new Insets(10));
        firstTries.setPadding(new Insets(10));
        r1.getChildren().add(name);
        r2.getChildren().add(this.score);
        r3.getChildren().add(firstTries);
        nameField = new TextField();
        r1.getChildren().add(nameField);
    }
}
