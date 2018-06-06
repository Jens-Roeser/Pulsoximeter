/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jens
 */
public class DisplayTest {
    private Display display;
    
    public DisplayTest() {
        display = Display.getinstance();
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updatelimit method, of class Display.
     */
    @Test
    public void testUpdatelimits() {
        System.out.println("updatelimit");
        //input
        String lower_hr = "30";
        String upper_hr = "60";
        String spo2_val = "50";
        int lower_hrint = Integer.parseInt(lower_hr);
        int upper_hrint = Integer.parseInt(upper_hr);
        int spo2_valint = Integer.parseInt(spo2_val);
        
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        
        HRSurveillance hr = display.gethrinst();
        SPO2Surveillance sp = display.getspo2inst();
        
        //output
        String spo2_out = display.getspo2limit();
        String low_out = display.getlow();
        String up_out = display.gethigh();
        int lowhr = hr.getlowhr();
        int uphr  = hr.gethighhr();
        int spo2  = sp.getspo2();
        
        //test Textbox
        assertEquals(spo2_val, spo2_out);
        assertEquals(lower_hr, low_out);
        assertEquals(upper_hr, up_out);
        //test Surveillance
        assertEquals(lower_hrint, lowhr);
        assertEquals(upper_hrint, uphr);
        assertEquals(spo2_valint, spo2);
    }

    /**
     * Test of updatepulse_lower method, of class Display.
     */
    @Test
    public void testPulselowerlimit() {
        System.out.println("Pulselowerlimit");
        String lower_hr = "30";
        int lower_hrint = Integer.parseInt(lower_hr);
        
        display.Limit_lower(lower_hr);
        HRSurveillance hr = display.gethrinst();
        
        //output
        String low_out = display.getlow();
        int lowhr = hr.getlowhr();
        
        //test Textbox
        assertEquals(lower_hr, low_out);
        //test Surveillance
        assertEquals(lower_hrint, lowhr);
    }

    /**
     * Test of updatepulse_upper method, of class Display.
     */
    @Test
    public void testPulseupperlimit() {
        System.out.println("Pulseupperlimit");
        String upper_hr = "60";
        int upper_hrint = Integer.parseInt(upper_hr);
        
        display.Limit_upper(upper_hr);
        HRSurveillance hr = display.gethrinst();
        
        int uphr  = hr.gethighhr();
        String up_out = display.gethigh();
        
        // test Textbox
        assertEquals(upper_hr, up_out);
        // test Surveillance
        assertEquals(upper_hrint, uphr);
    }

    /**
     * Test of updatespo2 method, of class Display.
     */
    @Test
    public void testUpdatespo2limit() {
        System.out.println("updatespo2limit");
        String spo2_val = "50";
        int spo2_valint = Integer.parseInt(spo2_val);
        
        display.Limit_spo2(spo2_val);
        SPO2Surveillance sp = display.getspo2inst();
        
        String spo2_out = display.getspo2limit();
        int spo2  = sp.getspo2();
                        
        assertEquals(spo2_val, spo2_out);
        assertEquals(spo2_valint, spo2);
    }

    /**
     * Test of updatepatient method, of class Display.
     */
    @Test
    public void testUpdatepatient() {
        System.out.println("updatepatient");
        String name = "Karl-Heinz ";
        String surname = "Schlabunski";
        String sex = "male";
        String birth = "24.06.2000";
        int age = 18;
        display.updatepatient(name, surname, sex, birth, age);

        Object[] patient = display.getname(display);
        assertEquals(name,(String)patient[0]);
        assertEquals(surname,(String)patient[1]);
        assertEquals(sex,(String)patient[2]);
        assertEquals(birth,(String)patient[3]);
        assertEquals(Integer.toString(age),(String)patient[4]);
    }

    /**
     * Test of updatepulse method, of class Display.
     */
    @Test
    //without alert
    public void testPulsenoalert() {
        System.out.println("Pulsenoalert");
        String lower_hr = "30";
        String upper_hr = "90";
        String spo2_val = "50";
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        int currenthr = 80;
        display.updatepulse(currenthr);
        
        String pulse = display.getpulse();
        String alerthr = display.getalerthr();
                
        assertEquals(Integer.toString(currenthr), pulse);
        assertEquals(alerthr, "");
    }
    
    /**
     * Test of updatepulse method, of class Display.
     */
    @Test
    //without alert
    public void testPulseupperalert() {
        System.out.println("Pulseupperalert");
        String lower_hr = "30";
        String upper_hr = "90";
        String spo2_val = "50";
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        int currenthr = 100;
        display.updatepulse(currenthr);
        
        String pulse = display.getpulse();
        String alerthr = display.getalerthr();
                
        assertEquals(Integer.toString(currenthr), pulse);
        assertEquals(alerthr, "Puls zu hoch");
    }
    
    /**
     * Test of updatepulse method, of class Display.
     */
    @Test
    //without alert
    public void testPulseloweralert() {
        System.out.println("Pulseloweralert");
        String lower_hr = "30";
        String upper_hr = "90";
        String spo2_val = "50";
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        int currenthr = 20;
        display.updatepulse(currenthr);
        
        String pulse = display.getpulse();
        String alerthr = display.getalerthr();
                
        assertEquals(Integer.toString(currenthr), pulse);
        assertEquals(alerthr, "Puls zu niedrig");
    }
    
    /**
     * Test of updatepulse method, of class Display.
     */
    @Test
    //without alert
    public void testPulselowthanhigh() {
        System.out.println("Pulse high than low");
        String lower_hr = "30";
        String upper_hr = "90";
        String spo2_val = "50";
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        int currenthr = 20;
        display.updatepulse(currenthr);
        String alerthr = display.getalerthr();
        String pulse = display.getpulse();
        assertEquals(Integer.toString(currenthr), pulse);
        assertEquals(alerthr, "Puls zu niedrig");
        currenthr = 100;
        display.updatepulse(currenthr);
        
        pulse = display.getpulse();
        alerthr = display.getalerthr();
                
        assertEquals(Integer.toString(currenthr), pulse);
        assertEquals(alerthr, "Puls zu hoch");
    }

    /**
     * Test of updatepulse method, of class Display.
     */
    @Test
    public void testPulsealertdeac() {
        System.out.println("Pulse low than deactivate");
        String lower_hr = "30";
        String upper_hr = "90";
        String spo2_val = "50";
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        int currenthr = 20;
        display.updatepulse(currenthr);
        String alerthr = display.getalerthr();
        String pulse = display.getpulse();
        assertEquals(Integer.toString(currenthr), pulse);
        assertEquals(alerthr, "Puls zu niedrig");
        
        currenthr = 80;
        display.updatepulse(currenthr);
        
        pulse = display.getpulse();
        alerthr = display.getalerthr();        
        assertEquals(Integer.toString(currenthr), pulse);
        assertEquals(alerthr, "");
    }
     
    /**
     * Test of updatepulse method, of class Display.
     */
    @Test
    public void testPulsealertlowdeac() {
        System.out.println("Pulse high than deactivate");
        String lower_hr = "30";
        String upper_hr = "90";
        String spo2_val = "50";
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        int currenthr = 200;
        display.updatepulse(currenthr);
        String alerthr = display.getalerthr();
        String pulse = display.getpulse();
        assertEquals(Integer.toString(currenthr), pulse);
        assertEquals(alerthr, "Puls zu hoch");
        
        currenthr = 80;
        display.updatepulse(currenthr);
        
        pulse = display.getpulse();
        alerthr = display.getalerthr();        
        assertEquals(Integer.toString(currenthr), pulse);
        assertEquals(alerthr, "");
    }
    
    
    // TODO: alarm deac
    /**
     * Test of updatespo2 method, of class Display.
     */
    @Test
    public void testUpdatespo2() {
        System.out.println("spo2 no alert");
        String lower_hr = "30";
        String upper_hr = "90";
        String spo2_val = "80";
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        int currentspo2 = 90;
        display.updatespo2(currentspo2);
        String spo = display.getspo2();
        String alertsp = display.getalertsp();        
        assertEquals(Integer.toString(currentspo2), spo);
        assertEquals(alertsp, "");
    }
     
    /**
     * Test of updatespo2 method, of class Display.
     */
    @Test
    public void testUpdatespo2alert() {
        System.out.println("spo2 alert");
        String lower_hr = "30";
        String upper_hr = "90";
        String spo2_val = "80";
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        int currentspo2 = 75;
        display.updatespo2(currentspo2);
        String spo = display.getspo2();
        String alertsp = display.getalertsp();        
        assertEquals(Integer.toString(currentspo2), spo);
        assertEquals(alertsp, "spo2 Wert zu niedrig");
    }

    /**
     * Test of updatespo2 method, of class Display.
     */
    @Test
    public void testUpdatespo2alertdeac() {
        System.out.println("spo2 alert deac");
        String lower_hr = "30";
        String upper_hr = "90";
        String spo2_val = "80";
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        int currentspo2 = 75;
        display.updatespo2(currentspo2);
        String spo = display.getspo2();
        String alertsp = display.getalertsp();        
        assertEquals(Integer.toString(currentspo2), spo);
        assertEquals(alertsp, "spo2 Wert zu niedrig");
        
        currentspo2 = 90;
        display.updatespo2(currentspo2);
        spo = display.getspo2();
        alertsp = display.getalertsp();        
        assertEquals(Integer.toString(currentspo2), spo);
        assertEquals(alertsp, "");
    }
}
