package pl.jakubdrozdz.NewGame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
    public NewGameView(Stage stage, Scene scene) {
        basicSetUp(scene);
        save = new Button("Save score");
        menu.getChildren().add(save);
        menu.getChildren().add(board);
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
        board=new GridPane();
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
