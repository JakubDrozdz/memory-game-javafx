package pl.jakubdrozdz.NewGame;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import pl.jakubdrozdz.Card;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

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
        //thread.start();
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
    /*private volatile boolean threadEnd = false;
    Thread thread = new Thread(
            ()->{
                while(!threadEnd){
                    System.out.println(boardButtons.get(0).get(0).getImageName().equals(
                            boardButtons.get(1).get(0).getImageName()
                    ));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e=new InterruptedException("Game stopped");
                        System.out.println(e.getMessage());
                    }
                }
            }
    );*/
    public void interrupt(){
        timer.interrupt();
        timerEnd = true;
        //thread.interrupt();
        //threadEnd = true;
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
        boolean first = true;
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < pairs[i].length; j++) {
                int row = (int)(Math.random() * boardButtons.size());
                int col = (int)(Math.random() * boardButtons.get(0).size());
                boolean flag = false;
                if(first){
                    pairs[i][j] = boardButtons.get(row).get(col);
                    first = false;
                }
                System.out.println(pairs[0][0]);
                for (int k = 0; k <= i; k++) {
                    for (int l = 0; l <= j; l++) {
                        if(pairs[k][l].equals(boardButtons.get(row).get(col)));
                            flag=true;
                    }
                }
                if(!flag)
                    pairs[i][j] = boardButtons.get(row).get(col);
                else
                    j--;


                /*ArrayList<Integer> previousI1 = new ArrayList<>();
                ArrayList<Integer> previousI2 = new ArrayList<>();
                int i1 = (int)(Math.random() * (boardButtons.size()));
                int finalI1 = i1;
                while(previousI1.stream().filter(x->x==finalI1).count()>0){
                    i1 = (int)(Math.random() * (boardButtons.size()));
                }
                previousI1.add(i1);
                int i2 = (int)(Math.random() * (boardButtons.get((int)(Math.random() * (boardButtons.size()))).size()));
                int finalI2 = i2;
                while(previousI2.stream().filter(x->x== finalI2).count()>0)
                    i2 = (int)(Math.random() * (boardButtons.get((int)(Math.random() * (boardButtons.size()))).size()));
                previousI2.add(i2);
                pairs[i][j]=boardButtons.get(i1).get(i2);
                System.out.print(i1+","+i2+"  ");*/
            }
        }
    }
}
