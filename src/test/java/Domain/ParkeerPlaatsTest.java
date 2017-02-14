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
public class ParkeerPlaatsTest {

    private ParkeerPlaats pp;

    public ParkeerPlaatsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pp = new ParkeerPlaats();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setAantalBezet method, of class ParkeerPlaats.
     */
    @Test
    public void testSetAantalBezet() {
        System.out.println("setAantalBezet");
        int aB = 10;
        ParkeerPlaats instance = pp;
        instance.setAantalBezet(aB);
        assertEquals(pp.getAantalbezet(), 10);
    }

    /**
     * Test of isPlaats method, of class ParkeerPlaats.
     */
    @Test
    public void testIsPlaats() {
        System.out.println("isPlaats");
        ParkeerPlaats instance = pp;
        boolean expResult = true;
        boolean result = instance.isPlaats();
        assertEquals(expResult, result);
    }

    /**
     * Test of isBezet method, of class ParkeerPlaats.
     */
    @Test
    public void testIsBezet() {
        System.out.println("isBezet");
        ParkeerPlaats instance = pp;
        boolean expResult = false;
        boolean result = instance.isBezet();
        assertEquals(expResult, result);
    }

    /**
     * Test of voegToe method, of class ParkeerPlaats.
     */
    @Test
    public void testVoegToe() {
        System.out.println("voegToe");
        ParkeerPlaats instance =pp;
        instance.voegToe();
        assertEquals(instance.getAantalbezet(), 1);
    }

    /**
     * Test of vertrek method, of class ParkeerPlaats.
     */
    @Test
    public void testVertrek() {
        System.out.println("vertrek");
        ParkeerPlaats instance = pp;
        instance.vertrek();
        assertEquals(instance.getAantalbezet(), -1);
    }

    /**
     * Test of getAantalbezet method, of class ParkeerPlaats.
     */
    @Test
    public void testGetAantalbezet() {
        System.out.println("getAantalbezet");
        ParkeerPlaats instance = pp;
        int expResult = 0;
        int result = instance.getAantalbezet();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxAantal method, of class ParkeerPlaats.
     */
    @Test
    public void testGetMaxAantal() {
        System.out.println("getMaxAantal");
        ParkeerPlaats instance = pp;
        int expResult = 25;
        int result = instance.getMaxAantal();
        assertEquals(expResult, result);
    }

    /**
     * Test of aantalVrij method, of class ParkeerPlaats.
     */
    @Test
    public void testAantalVrij() {
        System.out.println("aantalVrij");
        ParkeerPlaats instance = pp;
        int expResult = 25;
        int result = instance.aantalVrij();
        assertEquals(expResult, result);
    }

}
