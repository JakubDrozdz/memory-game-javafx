package pl.jakubdrozdz;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.jakubdrozdz.HomeScreen.HomeScreenController;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {new HomeScreenController(stage);}

    public static void main(String[] args) {
        launch();
    }

}