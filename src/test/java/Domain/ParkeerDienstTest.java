/*
 * Licsense Header
 */
package Domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Max
 */
public class ParkeerDienstTest {
    
    public ParkeerDienstTest() {
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
     * Test of setAantalUur method, of class ParkeerDienst.
     */
    @Test
    public void testSetAantalUur() {
        System.out.println("setAantalUur");
        int aU = 0;
        ParkeerDienst instance = null;
        instance.setAantalUur(aU);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prijs method, of class ParkeerDienst.
     */
    @Test
    public void testPrijs() {
        System.out.println("prijs");
        ParkeerDienst instance = null;
        double expResult = 0.0;
        double result = instance.prijs();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equalsDienst method, of class ParkeerDienst.
     */
    @Test
    public void testEqualsDienst() {
        System.out.println("equalsDienst");
        Object andere = null;
        ParkeerDienst instance = null;
        boolean expResult = false;
        boolean result = instance.equalsDienst(andere);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNaam method, of class ParkeerDienst.
     */
    @Test
    public void testGetNaam() {
        System.out.println("getNaam");
        ParkeerDienst instance = null;
        String expResult = "";
        String result = instance.getNaam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOnderhoudsbeurt method, of class ParkeerDienst.
     */
    @Test
    public void testGetOnderhoudsbeurt() {
        System.out.println("getOnderhoudsbeurt");
        ParkeerDienst instance = null;
        Onderhoudsbeurt expResult = null;
        Onderhoudsbeurt result = instance.getOnderhoudsbeurt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAantalUur method, of class ParkeerDienst.
     */
    @Test
    public void testGetAantalUur() {
        System.out.println("getAantalUur");
        ParkeerDienst instance = null;
        int expResult = 0;
        int result = instance.getAantalUur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
