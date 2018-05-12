
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
class NetworkAlert {
    
    NetworkAlert(){
        
    }
    
    public void spo2alert(){
            JOptionPane.showMessageDialog(null, "spo2 Wert zu niedrig", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void upper_hralarm(){
            JOptionPane.showMessageDialog(null, "Puls zu hoch", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void lower_hralarm(){
            JOptionPane.showMessageDialog(null, "Puls zu niedrig", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
    }
}
