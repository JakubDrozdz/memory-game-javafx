package pl.jakubdrozdz.SaveScore;

import java.io.*;

public class SaveScoreModel {
    public SaveScoreModel(){
    }
    public void saveToFile(String input){
        try {
            File file = new File("src/resources/highScore.txt");
            file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write("\n" + input);
            bw.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("File error!");
        }
    }
}
