import de.semp.medical.spo2.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jens
 */
public class SensorControl implements ISpO2Observer {
    private int currenthr;
    private int currentspo2;
    private boolean isRunning;
    Display display;
    static public SpO2emulated emu = new SpO2emulated();
    
    public SensorControl(){
        this.isRunning   =  false;
        this.currenthr   =  70;
        this.currentspo2 =  50;
        this.display = Display.getinstance();
    }
    
    
    public static void start(){
        emu.addObserver(new SensorControl());
        emu.start();
        boolean j = emu.isRun();
    }
    
    @Override
    public void onNewPulse(int pulse, int spo2) {
        currenthr = pulse;
        display.updatepulse(currenthr);
        currentspo2 = spo2;
        display.updatespo2(currentspo2);
    }

    @Override
    public void onErrorState(ErrorState oxiError) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void end(){
        emu.stop();
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
