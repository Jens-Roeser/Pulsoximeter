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
public class HRSurveillanceTest {
    
    public HRSurveillanceTest() {
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
     * Test of updatelowerhr method, of class HRSurveillance.
     */
    @Test
    public void testUpdatelowerhr() {
        System.out.println("updatelowerhr");
        String lowerhr = "";
        HRSurveillance instance = null;
        instance.updatelowerhr(lowerhr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateupperhr method, of class HRSurveillance.
     */
    @Test
    public void testUpdateupperhr() {
        System.out.println("updateupperhr");
        String upperhr = "";
        HRSurveillance instance = null;
        instance.updateupperhr(upperhr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alertbreak method, of class HRSurveillance.
     */
    @Test
    public void testAlertbreak() {
        System.out.println("alertbreak");
        HRSurveillance instance = null;
        instance.alertbreak();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alerthr method, of class HRSurveillance.
     */
    @Test
    public void testAlerthr() {
        System.out.println("alerthr");
        int hr = 0;
        HRSurveillance instance = null;
        instance.alerthr(hr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
