
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
    private SoundAlert sound = new SoundAlert();
    private NetworkAlert network = new NetworkAlert();
    private Displayalert text = new Displayalert();
    
    SPO2Surveillance(String spo2){
        this.spo2_int = Integer.parseInt(spo2);
    }
    protected void resetdefault(String spo2){
        this.spo2_int = Integer.parseInt(spo2);
    }
    
    protected void updatespo2(String spo2){
        this.spo2_int = Integer.parseInt(spo2);
    }
    protected void alertspo2 (int spo2){
       if (spo2 < spo2_int && alarmstate == true){
           text.spo2alert();
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
}
