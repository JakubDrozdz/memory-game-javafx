package pl.jakubdrozdz.NewGame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.jakubdrozdz.Interfaces.IBasicWindow;

public class NewGameView implements IBasicWindow {
    VBox menu;
    Button btn;
    Scene homeScene;
    StackPane sp;
    StackPane spTmp;
    Button save;
    GridPane board;
    Scene scene;
    Text textTime;
    HBox time;
    Label timeLabel;
    public NewGameView(Stage stage, Scene scene) {
        basicSetUp(scene);
        save = new Button("Save score");
        save.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        textTime = new Text();
        textTime.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        timeLabel = new Label("Time (seconds): ");
        timeLabel.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        time = new HBox(timeLabel,textTime);
        time.setAlignment(Pos.CENTER);
        menu.getChildren().add(save);
        menu.getChildren().add(time);
        menu.getChildren().add(board);
        setScene(stage);
    }

    @Override
    public void basicSetUp(Scene scene) {
        homeScene = scene;
        menu = new VBox();
        menu.setAlignment(Pos.CENTER);
        btn = new Button("Back to menu");
        btn.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        menu.getChildren().add(btn);
        menu.setSpacing(20);
        board=new GridPane();
        board.setAlignment(Pos.CENTER);
    }

    @Override
    public void setScene(Stage stage) {
        sp = new StackPane(menu);
        sp.setPadding(new Insets(20));
        spTmp = sp;
        scene = new Scene(sp,600,400);
        stage.setScene(scene);
        stage.setTitle("Game");
    }
}
