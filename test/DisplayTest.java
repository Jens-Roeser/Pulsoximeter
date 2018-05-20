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
    
    public DisplayTest() {
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
        String lower_hr = "";
        String upper_hr = "";
        String spo2_val = "";
        Display display = new Display();
        display.updatelimit(lower_hr, upper_hr, spo2_val);
        //output
        display.getspo2();
        String low_out = display.pulse_lower.getText();
        String up_out = display.pulse_upper.getText();
        String spo2_out = display.spo2.getText();
        //int lowerhr_out = lowerhr_int;
        //int upperhr_out = upperhr_int;
        //int spo2_out    = spo2_int;
        // TODO: ask surveillance methods
        assertEquals(lower_hr, low_out);
        assertEquals(upper_hr, up_out);
        assertEquals(spo2_val, spo2_out);
        //assertEquals(lower_hr, lowerhr_int);
        //assertEquals(upper_hr, low_out);
        //assertEquals(spo2_val, low_out);
    }

    /**
     * Test of updatepulse_lower method, of class Display.
     */
    @Test
    public void testUpdatepulse_lower() {
        System.out.println("updatepulse_lower");
        String lower_hr = "";
        Display instance = new Display();
        instance.updatepulse_lower(lower_hr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatepulse_upper method, of class Display.
     */
    @Test
    public void testUpdatepulse_upper() {
        System.out.println("updatepulse_upper");
        String upper_hr = "";
        Display instance = new Display();
        instance.updatepulse_upper(upper_hr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatespo2 method, of class Display.
     */
    @Test
    public void testUpdatespo2_String() {
        System.out.println("updatespo2");
        String spo2_val = "";
        Display instance = new Display();
        instance.updatespo2(spo2_val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatepatient method, of class Display.
     */
    @Test
    public void testUpdatepatient() {
        System.out.println("updatepatient");
        String name = "";
        String surname = "";
        String sex = "";
        String birth = "";
        int age = 0;
        Display instance = new Display();
        instance.updatepatient(name, surname, sex, birth, age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatepulse method, of class Display.
     */
    @Test
    public void testUpdatepulse() {
        System.out.println("updatepulse");
        int currenthr = 0;
        Display instance = new Display();
        instance.updatepulse(currenthr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatespo2 method, of class Display.
     */
    @Test
    public void testUpdatespo2_int() {
        System.out.println("updatespo2");
        int currentspo2 = 0;
        Display instance = new Display();
        instance.updatespo2(currentspo2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of check_init method, of class Display.
     */
    @Test
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
    }

    /**
     * Test of alerthr method, of class Display.
     */
    @Test
    public void testAlerthr() {
        System.out.println("alerthr");
        boolean up = false;
        Display instance = new Display();
        instance.alerthr(up);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of noalerthr method, of class Display.
     */
    @Test
    public void testNoalerthr() {
        System.out.println("noalerthr");
        boolean up = false;
        Display instance = new Display();
        instance.noalerthr(up);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alertspo2 method, of class Display.
     */
    @Test
    public void testAlertspo2() {
        System.out.println("alertspo2");
        Display instance = new Display();
        instance.alertspo2();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of noalertspo2 method, of class Display.
     */
    @Test
    public void testNoalertspo2() {
        System.out.println("noalertspo2");
        Display instance = new Display();
        instance.noalertspo2();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
