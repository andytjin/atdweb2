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
public class MonteurTest {
    
    private Monteur m;
    
    public MonteurTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        m = new Monteur("Naam", 1, "Pass");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getID method, of class Monteur.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Monteur instance = m;
        int expResult = 1;
        int result = instance.getID();
        assertEquals(expResult, result);

    }

    /**
     * Test of checkPassword method, of class Monteur.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String s = "Pass";
        Monteur instance = m;
        boolean expResult = true;
        boolean result = instance.checkPassword(s);
        assertEquals(expResult, result);

    }

    /**
     * Test of getNaam method, of class Monteur.
     */
    @Test
    public void testGetNaam() {
        System.out.println("getNaam");
        Monteur instance = m;
        String expResult = "Naam";
        String result = instance.getNaam();
        assertEquals(expResult, result);

    }
    
}
