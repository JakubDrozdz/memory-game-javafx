package pl.jakubdrozdz.HighScores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HighScoresModel {
    public HighScoresModel() {
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
        return playerData;
    }
    public String[][] sort(String[][] data){

        for (int i=1;i<data.length;++i){
            for(int j=1;j<data.length-i; ++j){
                if(Double.parseDouble(data[j+1][3])>Double.parseDouble(data[j][3])){
                    String[] tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
        return data;
    }
}
