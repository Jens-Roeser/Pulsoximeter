
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
    Display disp;
    
    Displayalert(){
    }
    
    public void spo2alert(){
        this.disp = Display.getinstance();
        disp.alertspo2();
    }
    
    public void upper_hralarm(){
        this.disp = Display.getinstance();        
        boolean up = true;
        disp.alerthr(up);
    }
    
    public void lower_hralarm(){
        this.disp = Display.getinstance();        
        boolean up = false;
        disp.alerthr(up);
    }  
    
    public void nospo2(){
        this.disp = Display.getinstance();        
        disp.noalertspo2();
    }
    
    public void noupper_hr(){
        this.disp = Display.getinstance();
        boolean up = true;
        disp.noalerthr(up);
    }
    
    public void nolower_hr(){
        this.disp = Display.getinstance();
        boolean up = false;
        disp.noalerthr(up);
    }  
}
