package pl.jakubdrozdz.NewGameSetUp;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class NewGameSetUpModel {
    public NewGameSetUpModel() {
    }
    public String checkDimension(String val1, String val2){
        String message=null;
        int v1,v2;
        try{
            v1 = Integer.parseInt(val1);
            v2 = Integer.parseInt(val2);
        }catch(NumberFormatException nfe){
            return ("Enter correct format (number)");
        }
        if(!((v1 > 0 && v1 <= 6) && (v2 > 0 && v2 <= 6))){
            return ("Enter number in correct range (1-6)");
        }
        if(v1*v2%2!=0){
            return ("Tiles amount cannot equals 0! Please enter dimension which multiplication equals even number");
        }
        return "";
    }
}
