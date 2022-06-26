package pl.jakubdrozdz.HighScores;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.jakubdrozdz.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HighScoresModel {
    //private ObservableList<Player> playerList;
    public HighScoresModel() {
        //playerList = FXCollections.observableArrayList(
        //        new Player("Jan",12.12,2,14.12)
        //);
    }
    public String[][] readFile(){
        String[][] playerData = null;
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/resources/highScore.txt"));
            String line;
            int counter = 0;
            while(br.readLine() != null){
                ++counter;
            }
            playerData = new String[counter][];
            br.close();
            br = new BufferedReader(new FileReader("src/resources/highScore.txt"));
            int i=0;
            while((line = br.readLine()) != null){
                playerData[i++] = line.split(";");
            }
            br.close();
        }catch(FileNotFoundException fnfe){
            System.out.println("File not found!");
        }
        catch(IOException e){
            System.out.println("Read error");
        }
        //for (int i = 1; i < playerData.length; i++) {
            //playerList.add(new Player(playerData[i][0],Double.parseDouble(playerData[i][1]),Integer.parseInt(playerData[i][2]),Double.parseDouble(playerData[i][3])));
        //}
        return playerData;
    }
}
