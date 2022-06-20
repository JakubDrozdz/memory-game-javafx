package pl.jakubdrozdz.NewGame;

import javafx.application.Platform;
import javafx.scene.text.Text;

import java.time.Duration;
import java.time.LocalDateTime;

public class NewGameModel {
    Text textTime;
    LocalDateTime startTime;
    public NewGameModel(Text textTime) {
        timer.start();
        this.textTime=textTime;
        this.startTime=LocalDateTime.now();
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
    public void interrupt(){
        timer.interrupt();
        timerEnd = true;
    }
}
