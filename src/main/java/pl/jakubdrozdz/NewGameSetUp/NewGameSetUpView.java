package pl.jakubdrozdz.NewGameSetUp;

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
import pl.jakubdrozdz.Interfaces.IBasicWindow;
import pl.jakubdrozdz.NewGameSetUp.NewGameSetUpController;

public class NewGameSetUpView implements IBasicWindow {
    VBox menu;
    protected static Button btn;
    VBox panel;
    HBox fields;
    Label l;
    TextField tf1;
    TextField tf2;
    protected static Button setDimension;
    StackPane sp;
    Scene homeScene;
    public NewGameSetUpView(Stage stage, Scene scene){
        stage.setTitle("New Game - set up");
        basicSetUp(scene);


        panel = new VBox();
        panel.setAlignment(Pos.CENTER);
        panel.setSpacing(15);
        fields = new HBox();
        fields.setSpacing(10);
        fields.setAlignment(Pos.CENTER);
        l = new Label("Enter dimension");
        tf1 = new TextField();
        tf2 = new TextField();

        fields.getChildren().add(tf1);
        fields.getChildren().add(tf2);

        panel.getChildren().add(l);
        panel.getChildren().add(fields);

        setDimension = new Button("Start game");
        panel.getChildren().add(setDimension);

        menu.getChildren().add(panel);

        setScene(stage);
        new NewGameSetUpController(stage,homeScene);
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