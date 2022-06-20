package pl.jakubdrozdz.NewGame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.jakubdrozdz.Interfaces.IBasicWindow;

public class NewGameView implements IBasicWindow {
    VBox menu;
    protected static Button btn;
    Scene homeScene;
    StackPane sp;
    static Button b;
    public NewGameView(Stage stage, Scene scene) {
        stage.setTitle("Game");
        basicSetUp(scene);
        b = new Button();
        menu.getChildren().add(b);
        setScene(stage);
        new NewGameController(stage,homeScene,menu);
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
