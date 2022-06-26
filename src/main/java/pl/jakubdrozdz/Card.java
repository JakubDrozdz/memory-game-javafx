package pl.jakubdrozdz;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Card extends Button {
    private String imageName;
    private boolean isReversed;
    private ImageView view;
    public Card(){
        this.isReversed = false;
        this.imageName = "back";
        this.view = new ImageView();
        InputStream stream = null;
        try {
            stream = new FileInputStream("src/resources/back.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image img = new Image(stream);
        ImageView view = new ImageView(img);
        view.setFitHeight(120);
        view.setFitWidth(120);
        this.setGraphic(view);
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public boolean isReversed() {
        return isReversed;
    }

    public void setReversed(boolean reversed) {
        isReversed = reversed;
    }

    public ImageView getView() {
        return view;
    }

    public void setView(ImageView view) {
        this.view = view;
    }
}
