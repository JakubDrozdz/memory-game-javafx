package pl.jakubdrozdz.NewGameSetUp;


public class NewGameSetUpModel {
    int v1,v2;
    public NewGameSetUpModel() {
    }
    public String checkDimension(String val1, String val2){
        try{
            v1 = Integer.parseInt(val1);
            v2 = Integer.parseInt(val2);
        }catch(NumberFormatException nfe){
            System.out.println("v1:"+v1 + "v2:"+v2);
            return ("Enter correct format (number)");
        }
        if(!((v1 > 0 && v1 <= 6) && (v2 > 0 && v2 <= 6))){
            System.out.println("v1:"+v1 + "v2:"+v2);
            return ("Enter number in correct range (1-6)");
        }
        if((v1*v2)%2!=0){
            System.out.println("v1:"+v1 + "v2:"+v2);
            return ("Tiles amount cannot be odd number! Please enter dimension which multiplication equals even number");
        }
        return "";
    }
}
