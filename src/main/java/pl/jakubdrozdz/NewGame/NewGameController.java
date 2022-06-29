package pl.jakubdrozdz.NewGame;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.jakubdrozdz.Card;
import pl.jakubdrozdz.Interfaces.IBasicController;
import pl.jakubdrozdz.SaveScore.SaveScoreController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class NewGameController implements IBasicController {
    Text textTime = new Text();
    NewGameModel newGameModel;
    NewGameView newGameView;
    int clicked = 0;
    Card c1=new Card();
    Card c2=new Card();
    int pairsLeft;
    Stage stage;
    Scene homeScene;
    int firstTries;

    public NewGameController(Stage stage, Scene homeScene,int dim1, int dim2) {
        this.firstTries=0;
        this.stage = stage;
        this.homeScene = homeScene;
        this.stage.setWidth(600);
        this.stage.setHeight(600);
        newGameView = new NewGameView(stage,homeScene);
        newGameModel=new NewGameModel(textTime,dim1,dim2);
        buttonsController(stage,homeScene);
        newGameView.menu.getChildren().add(textTime);
        setUpBoard();
        setPairs();
        setActions();
        monitor.start();
        runBoardChecks.start();
        newGameView.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            final KeyCombination keyComb = new KeyCodeCombination(KeyCode.C, KeyCodeCombination.CONTROL_DOWN, KeyCodeCombination.SHIFT_DOWN);
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyComb.match(keyEvent)) {
                    stop();
                    stage.setScene(homeScene);
                    stage.setTitle("Memory Game");
                    keyEvent.consume();
                }
            }
        });
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                stop();
            }
        });

    }

    public void buttonsController(Stage stage, Scene homeScene) {
        newGameView.btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(homeScene);
                stage.setTitle("Memory Game");
                stage.setHeight(480);
                stage.setWidth(640);
                stop();
            }
        });

    }

    public void setUpBoard(){
        for (int i = 0; i < newGameModel.boardButtons.size(); i++) {
            for (int j = 0; j < newGameModel.boardButtons.get(i).size(); j++) {
                newGameView.board.add(newGameModel.boardButtons.get(i).get(j),i,j);
            }
        }
        pairsLeft = newGameModel.noOfPairs;
    }

    private volatile boolean threadEnd = false;
    Thread runBoardChecks = new Thread(
            ()->{
                while(!threadEnd){
                    Platform.runLater(
                            ()->{
                                if(clicked==2){
                                    stopActions();
                                    if(!c1.getImageName().equals(c2.getImageName())){
                                        try {
                                            Thread.sleep(2000);

                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        InputStream stream = null;
                                        String filepath = "src/resources/back.jpg";
                                        try {
                                            stream = new FileInputStream(filepath);
                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                        Image img1 = new Image(stream);
                                        ImageView view1 = new ImageView(img1);
                                        ImageView view2 = new ImageView(img1);
                                        view1.setFitHeight(120);
                                        view2.setFitHeight(120);
                                        view1.setFitWidth(120);
                                        view2.setFitWidth(120);
                                        c1.setGraphic(view1);
                                        c1.setReversed(false);
                                        c2.setGraphic(view2);
                                        c2.setReversed(false);
                                    }
                                    else{
                                        if(c1.getClicked() == 1 && c2.getClicked() == 1){
                                            firstTries++;
                                        }
                                        pairsLeft--;
                                    }
                                    setActions();
                                    c1 = new Card();
                                    c2 = new Card();
                                    clicked = 0;
                                }
                            }
                    );
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e=new InterruptedException("Game stopped");
                        System.out.println(e.getMessage());
                        stop();
                    }
                }
            }
    );

    private volatile boolean monitorEnd = false;
    Thread monitor = new Thread(
            ()->{
                Platform.runLater(
                        ()->{
                            this.stage.setWidth(newGameModel.dim1*120+100);
                            this.stage.setHeight(newGameModel.dim2*120+250);
                        }
                );
                while(!monitorEnd){
                    Platform.runLater(
                            ()->{
                                if(pairsLeft==0){
                                    newGameModel.interrupt();
                                    stopActions();
                                    threadEnd = true;
                                    runBoardChecks.interrupt();
                                }
                            }
                    );
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Monitor stopped");
                    }
                }
                newGameView.save.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        stop();
                        new SaveScoreController(stage,homeScene,((newGameModel.dim1*newGameModel.dim2)*100/Double.parseDouble(textTime.getText())),firstTries);
                    }
                });
            }

    );

    public void setActions(){
        for (int i = 0; i < newGameModel.boardButtons.size(); i++) {
            for (int j = 0; j < newGameModel.boardButtons.get(i).size(); j++) {
                int finalI = i;
                int finalJ = j;
                if(!newGameModel.boardButtons.get(i).get(j).isReversed()){
                    newGameModel.boardButtons.get(i).get(j).setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            newGameModel.boardButtons.get(finalI).get(finalJ).setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                }
                            });
                            changeImage(finalI, finalJ);
                        }
                    });
                }
            }
        }
    }
    public void stopActions(){
        for (int i = 0; i < newGameModel.boardButtons.size(); i++) {
            for (int j = 0; j < newGameModel.boardButtons.get(i).size(); j++) {
                int finalI = i;
                int finalJ = j;
                newGameModel.boardButtons.get(i).get(j).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                    }
                });
            }
        }
    }
    public void setPairs(){
        for (int i = 0; i < newGameModel.pairs.length; i++) {
            String fileName = "";
            fileName = newGameModel.imagesNames.get((int)(Math.random() * newGameModel.imagesNames.size()));
            for (int j = 0; j < newGameModel.pairs[i].length; j++) {
                newGameModel.pairs[i][j].setImageName(fileName);
                System.out.println("Setting " + newGameModel.pairs[i][j] + " with img "+ fileName);
                InputStream stream = null;
                String filepath = "src/resources/"+ newGameModel.pairs[i][j].getImageName() +".jpg";
                try {
                    stream = new FileInputStream(filepath);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Image img = new Image(stream);
                ImageView view = new ImageView(img);
                view.setFitHeight(120);
                view.setFitWidth(120);
                newGameModel.pairs[i][j].setView(view);
            }
        }
    }
    public void changeImage(int i, int j){
        newGameModel.boardButtons.get(i).get(j).setGraphic(newGameModel.boardButtons.get(i).get(j).getView());
        newGameModel.boardButtons.get(i).get(j).setReversed(true);
        newGameModel.boardButtons.get(i).get(j).setClicked();
        c2=c1;
        c1=newGameModel.boardButtons.get(i).get(j);
        clicked++;
    }
    public void stop(){
        newGameModel.interrupt();
        threadEnd = true;
        runBoardChecks.interrupt();
        monitorEnd = true;
        stopActions();
        monitor.interrupt();
    }

}
