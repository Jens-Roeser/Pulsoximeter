
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jens
 */
public class SPO2Surveillance {
    private int spo2_int;
    // Alarmstate false == not paused
    // Alarmstate true == paused
    private boolean alarmstate = false;
    private Displayalert text;
    
    SPO2Surveillance(){
        this.text = new Displayalert();
    }
    protected void resetdefault(String spo2){
        this.spo2_int = Integer.parseInt(spo2);
    }
    //Update spo2 limits
    protected void updatespo2(String spo2){
        this.spo2_int = Integer.parseInt(spo2);
    }
    protected void alertspo2 (int spo2){
        if (spo2 < spo2_int){
           text.spo2alert();
           if (alarmstate == true){
           // TODO: sound and Network
           }
        }
        else if (spo2 > spo2_int){
           text.nospo2();
        }
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

    int getspo2() {
        int low = spo2_int;
        return low;}
}
