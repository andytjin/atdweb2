/*
 * Licsense Header
 */
package WhiteBoxTest;

import Domain.Auto;
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
public class AutoTest {
    
    private Auto a;
    private Klant k;
    public AutoTest() {
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
        a = new Auto("12-34-56", "c3", "Citroen", k);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetNaam(){
        assertEquals(a.getNaam(), "c3");
    }
    
    @Test
    public void testGetMerk(){
        assertEquals(a.getMerk(), "Citroen");
    }
    
    @Test
    public void testGetKlant(){
        assertEquals(a.getKlant(), k);
    }
    
    @Test
    public void testGetKenteken(){
        assertEquals(a.getKenteken(), "12-34-56");
    }
    
    @Test
    public void testGetDeEigenaarNaam(){
        assertEquals(a.getDeEigenaarsNaam(), "Test");
    }
}
