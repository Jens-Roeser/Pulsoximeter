
import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
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
class SoundAlert {

    private Display disp;
        File Clap = new File("C:\\Users\\jens-\\OneDrive\\Documents\\SEMT\\Pulsoximeter\\src\\img\\20180529_002.wav");
        
    SoundAlert(){
    }
    public void alert(){
        try{
          Clip clip = AudioSystem.getClip();
          clip.open(AudioSystem.getAudioInputStream(Clap));
          clip.start();
          Thread.sleep(clip.getMicrosecondLength()/1000); 
       }
        catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "Eingegebener Wert ist keine gültige Zahl","Warnung",JOptionPane.ERROR_MESSAGE);
        }
            this.disp = Display.getinstance();
        disp.alertspo2();
    }
    public void nospo2(){
        
    }
}
