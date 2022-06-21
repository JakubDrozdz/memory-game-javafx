package pl.jakubdrozdz.NewGameSetUp;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class NewGameSetUpModel {
    public NewGameSetUpModel() {
    }
    public boolean checkDimension(String val1, String val2, Label l){
        int v1,v2;
        try{
            v1 = Integer.parseInt(val1);
            v2 = Integer.parseInt(val2);
        }catch(NumberFormatException nfe){
            l.setText("Enter correct format (number)");
            return false;
        }
        if(!((v1 > 0 && v1 <= 6) && (v2 > 0 && v2 <= 6))){
            l.setText("Enter number in correct range (1-6)");
            return false;
        }
        return true;
    }
}
