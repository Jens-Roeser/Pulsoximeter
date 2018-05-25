/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jens
 */
public class SensorControl {
    private int currenthr;
    private int currentspo2;
    private boolean isRunning;
    Display display;
    
    public SensorControl(){
        this.isRunning   =  false;
        this.currenthr   =  70;
        this.currentspo2 =  50;
    }
    
    
    public static void start(){
        // TODO: isrunning = true
    }
    
    public static void end(){
        
    }
    
    public void updatesensorvalueshr(int hr){
        currenthr = hr;
        display.updatepulse(currenthr);
    }
    public void updatesensorvaluesspo2  (int spo2){
        currentspo2 = spo2;
        display.updatespo2(currentspo2);
    }
}
