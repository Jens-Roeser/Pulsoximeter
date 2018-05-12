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

    private int lowerhr_int;
    private int upperhr_int;
    private SoundAlert sound;
    private NetworkAlert network;
    private Displayalert text;
    // Alarmstate false == not paused
    // Alarmstate true == paused
    private boolean alarmstate = false;
    
    HRSurveillance(String lowerhr,String  upperhr){
        this.lowerhr_int = Integer.parseInt(lowerhr);
        this.upperhr_int = Integer.parseInt(upperhr);
    }

    protected void resetdefault(String lowerhr,String  upperhr){
        this.lowerhr_int = Integer.parseInt(lowerhr);
        this.upperhr_int = Integer.parseInt(upperhr);
    }
    
    protected void updatelowerhr(String lowerhr){
        this.lowerhr_int = Integer.parseInt(lowerhr);
    }
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
       if  (hr < lowerhr_int && alarmstate == true){
          text.lower_hralarm();
       }
       else if (hr > upperhr_int && alarmstate == true) {
          text.upper_hralarm();
       }
    }
}
