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
    public void testUpdatelimit() {
        System.out.println("updatelimit");
        //input
        String lower_hr = "30";
        String upper_hr = "60";
        String spo2_val = "50";
        int lower_hrint = Integer.parseInt(lower_hr);
        int upper_hrint = Integer.parseInt(upper_hr);
        int spo2_valint = Integer.parseInt(spo2_val);
        
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        
        // TODO: evtl als Methode definieren falls öfters benötigt
        HRSurveillance hr = display.gethrinst();
        SPO2Surveillance sp = display.getspo2inst();
        
        //output
        String spo2_out = display.getspo2();
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
    public void testUpdatepulse_lower() {
        System.out.println("updatepulse_lower");
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
    public void testUpdatepulse_upper() {
        System.out.println("updatepulse_upper");
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
    public void testUpdatespo2_String() {
        System.out.println("updatespo2");
        String spo2_val = "50";
        int spo2_valint = Integer.parseInt(spo2_val);
        
        display.Limit_spo2(spo2_val);
        SPO2Surveillance sp = display.getspo2inst();
        
        String spo2_out = display.getspo2();
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
    public void testUpdatepulse() {
        System.out.println("updatepulse");
        String lower_hr = "30";
        String upper_hr = "90";
        String spo2_val = "50";
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        int currenthr = 80;
        display.updatepulse(currenthr);
        
        HRSurveillance hr = display.gethrinst();
        String pulse = display.getpulse();
        String alerthr = display.getalerthr();
                
        assertEquals(Integer.toString(currenthr), pulse);
        assertEquals(alerthr, "");
    }

    /**
     * Test of updatespo2 method, of class Display.
     */
    /*@Test
    public void testUpdatespo2_int() {
        System.out.println("updatespo2");
        int currentspo2 = 0;
        Display instance = new Display();
            SPO2Surveillance sp = display.getspo2inst();
        String alertsp = display.getalertsp();
        instance.updatespo2(currentspo2);
        assertEquals(alertsp, "");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of check_init method, of class Display.
     */
    /*@Test
    public void testCheck_init() {
        System.out.println("check_init");
        String lowhr = "";
        String uphr = "";
        String spo2 = "";
        Display instance = new Display();
        boolean expResult = false;
        boolean result = instance.check_init(lowhr, uphr, spo2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of alerthr method, of class Display.
     */
    /*@Test
    public void testAlerthr() {
        System.out.println("alerthr");
        boolean up = false;
        Display instance = new Display();
        instance.alerthr(up);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of noalerthr method, of class Display.
     */
    /*@Test
    public void testNoalerthr() {
        System.out.println("noalerthr");
        boolean up = false;
        Display instance = new Display();
        instance.noalerthr(up);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of alertspo2 method, of class Display.
     */
    /*@Test
    public void testAlertspo2() {
        System.out.println("alertspo2");
        Display instance = new Display();
        instance.alertspo2();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of noalertspo2 method, of class Display.
     */
    /*@Test
    public void testNoalertspo2() {
        System.out.println("noalertspo2");
        Display instance = new Display();
        instance.noalertspo2();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
