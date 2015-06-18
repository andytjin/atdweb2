/*
 * Licsense Header
 */
package WhiteBoxTest;

import Domain.Factuur;
import Domain.Klant;
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
public class FactuurTest {

    private Factuur f;
    private Klant k;

    public FactuurTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        k = new Klant("Test", "TestAdres", "TestGeboorte", "TestTel", "TestPostCode", "TestEmail", true);

        f = new Factuur(123, "12-01-2015", "12-02-2015", 10.00, false, "Factuur 01", k);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCheckFactuur(){
        assertEquals(f.checkFactuur("12-02-2015"), true);
    }
    
    @Test
    public void testSetBetaald(){
        f.setIsBetaald(true);
        assertEquals(f.getIsBetaald(), true);
    }
    
    @Test
    public void testGetFactuurNummer(){
        assertEquals(f.getFactuurNummer(), 123);
    }
    
    @Test
    public void testGetKlantNaam(){
        assertEquals(f.getKlantNaam(), "Test");
    }
    
    @Test
    public void testSetFactuurNummer(){
        f.setFactuurNummer(1234);
        assertEquals(f.getFactuurNummer(), 1234);
    }
    
    @Test
    public void testGetOmschrijving(){
        assertEquals(f.getOmschrijving(), "Factuur 01");
    }
    
    @Test
    public void testGetFactuurDatum(){
        assertEquals(f.getFactuurDatum(), "12-01-2015");
    }
    
    @Test
    public void testSetFactuurDatum(){
        f.setFactuurDatum("12-03-2015");
        assertEquals(f.getFactuurDatum(), "12-03-2015");
    }
    
    @Test
    public void testGetVervalDatum(){
        assertEquals(f.getVervalDatum(), "12-02-2015");
    }
    
    @Test
    public void testSetVervalDatum(){
        f.setVervalDatum("12-04-2015");
        assertEquals(f.getVervalDatum(), "12-04-2015");
    }
    
    @Test
    public void testGetBrutoPrijs(){
        assertEquals(f.getBrutoPrijs(), 10.00, 0);
    }
    
    @Test
    public void testSetBrutoPrijs(){
        f.setBrutoPrijs(100.00);
        assertEquals(f.getBrutoPrijs(), 100.00, 0);
    }
    
}
