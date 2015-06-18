/*
 * Licsense Header
 */
package WhiteBoxTest;

import Domain.Artikel;
import Domain.ArtikelType;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Max
 */
public class ArtikelTest {
    
    private Artikel a;
    private ArtikelType at;
    
    public ArtikelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        at = new ArtikelType("Band");
        a = new Artikel("1A2B3C", 10, 100, 49.00, at);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSetAantal(){
        a.setAantal(200);
        assertEquals(a.getAantal(), 200);
    }
    
    @Test
    public void testGetAantal(){
        assertEquals(a.getAantal(), 100);
    }
    
    @Test
    public void testGetCode(){
        assertEquals(a.getCode(), "1A2B3C");
    }

    @Test
    public void testGetType(){
        assertEquals(a.getType(), "Band");
    }
    
    @Test
    public void testGetMinimum(){
        assertEquals(a.getMinimum(), 10);
    }
    
    @Test
    public void testGetPrijs(){
        assertEquals(49.00, a.getPrijs(), 0);
    }
    
    @Test
    public void testGetHetType(){
        assertEquals(a.getHetType(), at);
    }
    
    
    
    
}
