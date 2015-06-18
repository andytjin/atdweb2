/*
 * Licsense Header
 */
package Domain;

import java.util.Calendar;
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
    
    private ParkeerDienst pd;
    private Calendar cal = Calendar.getInstance();
    
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
        pd = new ParkeerDienst(123, cal, 3);
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
        int aU = 8;
        ParkeerDienst instance = pd;
        instance.setAantalUur(aU);
        assertEquals(pd.getAantalUur(), 8);
    }

    /**
     * Test of prijs method, of class ParkeerDienst.
     */
    @Test
    public void testPrijs() {
        System.out.println("prijs");
        ParkeerDienst instance = pd;
        double expResult = 25.0;
        double result = instance.prijs();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of equalsDienst method, of class ParkeerDienst.
     */
    @Test
    public void testEqualsDienst() {
        System.out.println("equalsDienst");
        Object andere = pd;
        ParkeerDienst instance = pd;
        boolean expResult = false;
        boolean result = instance.equalsDienst(andere);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getNaam method, of class ParkeerDienst.
     */
    @Test
    public void testGetNaam() {
        System.out.println("getNaam");
        ParkeerDienst instance = pd;
        String expResult = "Geen monteur";
        String result = instance.getNaam();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOnderhoudsbeurt method, of class ParkeerDienst.
     */
    @Test
    public void testGetOnderhoudsbeurt() {
        System.out.println("getOnderhoudsbeurt");
        ParkeerDienst instance = pd;
        Onderhoudsbeurt expResult = null;
        Onderhoudsbeurt result = instance.getOnderhoudsbeurt();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAantalUur method, of class ParkeerDienst.
     */
    @Test
    public void testGetAantalUur() {
        System.out.println("getAantalUur");
        ParkeerDienst instance = pd;
        int expResult = 3;
        int result = instance.getAantalUur();
        assertEquals(expResult, result);

    }
    
}
