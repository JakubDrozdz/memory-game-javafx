package pl.jakubdrozdz.NewGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.jakubdrozdz.Interfaces.IBasicController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class NewGameController implements IBasicController {
    Text textTime = new Text();
    NewGameModel newGameModel;
    NewGameView newGameView;

    public NewGameController(Stage stage, Scene homeScene,int dim1, int dim2) {
        newGameView = new NewGameView(stage,homeScene);
        newGameModel=new NewGameModel(textTime,dim1,dim2);
        newGameView.setScene(stage);
        buttonsController(stage,homeScene);
        newGameView.menu.getChildren().add(textTime);
        setUpBoard();
        setPairs();
        setActions();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                newGameModel.interrupt();
            }
        });
        //setFrontCard();

    }

    @Override
    public void buttonsController(Stage stage, Scene homeScene) {
        newGameView.btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(homeScene);
                stage.setTitle("Memory Game");
            }
        });
        newGameView.b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newGameModel.interrupt();
            }
        });
    }

    public void setUpBoard(){
        for (int i = 0; i < newGameModel.boardButtons.size(); i++) {
            for (int j = 0; j < newGameModel.boardButtons.get(i).size(); j++) {
                newGameView.board.add(newGameModel.boardButtons.get(i).get(j),i,j);
            }
        }
    }
    public void setActions(){
        for (int i = 0; i < newGameModel.boardButtons.size(); i++) {
            for (int j = 0; j < newGameModel.boardButtons.get(i).size(); j++) {
                int finalI = i;
                int finalJ = j;
                newGameModel.boardButtons.get(i).get(j).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        changeImage(finalI, finalJ);
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
                //newGameModel.images.put(fileName, newGameModel.images.get(fileName) + 1);
                //newGameModel.boardButtons.get(i).get(j).setImageName(fileName);
                newGameModel.pairs[i][j].setImageName(fileName);
                System.out.println("Setting " + newGameModel.pairs[i][j] + " with img "+ fileName);
            }
        }
    }
    public void setFrontCard(){
        for (int i = 0; i < newGameModel.boardButtons.size(); i++) {
            for (int j = 0; j < newGameModel.boardButtons.get(i).size(); j++) {
                int finalI = i;
                int finalJ = j;
                newGameModel.pairs[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        /*InputStream stream = null;
                        String filepath = "src/resources/"+ newGameModel.pairs[finalI][finalJ].getImageName() +".jpg";
                        try {
                            stream = new FileInputStream(filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image img = new Image(stream);
                        ImageView view = new ImageView(img);
                        view.setFitHeight(120);
                        view.setFitWidth(120);
                        newGameModel.pairs[finalI][finalJ].setGraphic(view);*/
                        InputStream stream = null;
                        String filepath = "src/resources/img"+ 1 +".jpg";
                        try {
                            stream = new FileInputStream(filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        Image img = new Image(stream);
                        ImageView view = new ImageView(img);
                        view.setFitHeight(120);
                        view.setFitWidth(120);
                        newGameModel.boardButtons.get(finalI).get(finalJ).setGraphic(view);
                    }
                });
            }
        }
    }
    public void changeImage(int i, int j){
        InputStream stream = null;
        String filepath = "src/resources/"+ newGameModel.boardButtons.get(i).get(j).getImageName() +".jpg";
        try {
            stream = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image img = new Image(stream);
        ImageView view = new ImageView(img);
        view.setFitHeight(120);
        view.setFitWidth(120);
        System.out.println(newGameModel.boardButtons.get(i).get(j).getImageName());
        newGameModel.boardButtons.get(i).get(j).setGraphic(view);
    }
}
