/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jens
 */
public class HRSurveillance {
    private Displayalert text;
    private int lowerhr_int;
    private int upperhr_int;
    // Alarmstate false == not paused
    // Alarmstate true == paused
    private boolean alarmstate = false;
    
    HRSurveillance(Displayalert display){//String lowerhr,String  upperhr
        this.text = display;
        //this.lowerhr_int = Integer.parseInt(lowerhr);
        //this.upperhr_int = Integer.parseInt(upperhr);
    }

    private void resetdefault(String lowerhr,String  upperhr){
        this.lowerhr_int = Integer.parseInt(lowerhr);
        this.upperhr_int = Integer.parseInt(upperhr);
    }
    //Update lower HR limits
    protected void updatelowerhr(String lowerhr){
        this.lowerhr_int = Integer.parseInt(lowerhr);
    }
    //Update upper HR limits
    protected void updateupperhr(String  upperhr){
        this.upperhr_int = Integer.parseInt(upperhr);
    }
    protected void alertbreak(){
        if (alarmstate == true){
            alarmstate = false;
        }
        else if (alarmstate == false){
            alarmstate = true;
        }
        else {
            throw new java.lang.Error("State inserted is not known");
        }
    }    
    protected void alerthr(int hr){
        if  (hr < lowerhr_int){
            text.lower_hralarm();
            if (alarmstate == true){
              // TODO Sound
              // TODO Network
            }
        }
        else if (hr > upperhr_int) {
            text.upper_hralarm();
            if (alarmstate == true){
              // TODO Sound
              // TODO Network
            }
        }
        else if (hr < upperhr_int && hr > lowerhr_int){
             text.noupper_hr();
         }
    }
    int getlowhr() {
        int low = lowerhr_int;
        return low;
    }

    int gethighhr() {
        int low = upperhr_int;
        return low;
    }
}
