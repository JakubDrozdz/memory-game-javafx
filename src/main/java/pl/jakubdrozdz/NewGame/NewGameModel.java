package pl.jakubdrozdz.NewGame;

import javafx.application.Platform;
import javafx.scene.text.Text;
import pl.jakubdrozdz.Card;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class NewGameModel {
    Text textTime;
    LocalDateTime startTime;
    int dim1;
    int dim2;
    ArrayList<ArrayList<Card>> boardButtons;
    ArrayList<String> imagesNames;
    Card[][] pairs;
    int noOfPairs;
    public NewGameModel(Text textTime, int dim1,int dim2) {
        this.textTime=textTime;
        this.startTime=LocalDateTime.now();
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.boardButtons = new ArrayList<>();
        this.noOfPairs = (dim1*dim2)/2;
        pairs = new Card[noOfPairs][2];
        imagesNames=new ArrayList<>();
        setUpImagesNames();
        timer.start();
        setUpButtons();
        createPairs();
        thread.start();
    }
    private volatile boolean timerEnd = false;
    Thread timer = new Thread(
            () -> {
                while(!timerEnd){
                    Platform.runLater(
                            ()->{
                                textTime.setText(Long.toString(Duration.between(startTime,LocalDateTime.now()).toSeconds()));
                            }
                    );
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e=new InterruptedException("Timer stopped");
                        System.out.println(e.getMessage() + "\n" + "seconds: " + textTime.getText());
                    }
                }
            }
    );
    private volatile boolean threadEnd = false;
    Thread thread = new Thread(
            ()->{
                while(!threadEnd){
                    Platform.runLater(
                            ()->{
                                System.out.println(boardButtons.get(0).get(0).getImageName().equals(
                                        boardButtons.get(1).get(0).getImageName()
                                ));
                            }
                    );

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e=new InterruptedException("Game stopped");
                        System.out.println(e.getMessage());
                    }
                }
            }
    );
    public void interrupt(){
        timerEnd = true;
        timer.interrupt();
        threadEnd = true;
        thread.interrupt();

    }
    public void setUpButtons(){
        for (int i = 0; i < dim1; i++) {
            boardButtons.add(new ArrayList<>());
        }
        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                boardButtons.get(i).add(new Card());
            }
        }
    }
    public void setUpImagesNames(){
        imagesNames.add("img1");
        imagesNames.add("img2");
        imagesNames.add("img3");
        imagesNames.add("img4");
        imagesNames.add("img5");
        imagesNames.add("img6");
        imagesNames.add("img7");
    }
    public void createPairs(){
        ArrayList<Card> usedCards = new ArrayList<>();
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < pairs[i].length; j++) {
                int row = (int)(Math.random() * boardButtons.size());
                int col = (int)(Math.random() * boardButtons.get(0).size());
                pairs[i][j] = boardButtons.get(row).get(col);
                if(usedCards.size()>0){
                    while(usedCards.contains(pairs[i][j])){
                        row = (int)(Math.random() * boardButtons.size());
                        col = (int)(Math.random() * boardButtons.get(0).size());
                        pairs[i][j] = boardButtons.get(row).get(col);
                    }
                }
                pairs[i][j] = boardButtons.get(row).get(col);
                usedCards.add(pairs[i][j]);
            }
        }
    }
}
