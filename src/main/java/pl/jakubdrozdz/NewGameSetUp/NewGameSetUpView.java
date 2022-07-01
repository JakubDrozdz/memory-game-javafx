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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import pl.jakubdrozdz.Interfaces.IBasicWindow;

public class NewGameSetUpView implements IBasicWindow {
    VBox menu;
    Button btn;
    VBox panel;
    HBox fields;
    Label l;
    TextField tf1;
    TextField tf2;
    Button setDimension;
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
        l.setFont(Font.font("arial",FontWeight.BOLD, FontPosture.REGULAR, 32));
        l.setMaxWidth(300);
        l.setAlignment(Pos.CENTER);
        l.setWrapText(true);
        l.setMaxHeight(250);
        tf1 = new TextField();
        tf1.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        tf2 = new TextField();
        tf2.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 16));

        fields.getChildren().add(tf1);
        fields.getChildren().add(tf2);

        panel.getChildren().add(l);
        panel.getChildren().add(fields);

        setDimension = new Button("Start game");
        setDimension.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        panel.getChildren().add(setDimension);

        menu.getChildren().add(panel);
    }

    @Override
    public void basicSetUp(Scene scene) {
        homeScene = scene;
        menu = new VBox();
        menu.setAlignment(Pos.TOP_LEFT);
        btn = new Button("Back to menu");
        btn.setFont(Font.font("arial",FontWeight.NORMAL, FontPosture.REGULAR, 16));
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
