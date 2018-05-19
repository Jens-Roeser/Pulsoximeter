
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
class Displayalert {
    
    Display disp = new Display();
    
    Displayalert(){
        
    }
    
    public void spo2alert(){
        disp.alertspo2();
    }
    
    public void upper_hralarm(){
        boolean up = true;
        disp.alerthr(up);
    }
    
    public void lower_hralarm(){
        boolean up = false;
        disp.alerthr(up);
    }  
}
