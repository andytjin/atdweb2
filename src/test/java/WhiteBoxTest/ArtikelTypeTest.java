/*
 * Licsense Header
 */
package WhiteBoxTest;

import Domain.ArtikelType;
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
public class ArtikelTypeTest {
    
    private ArtikelType at;
    
    public ArtikelTypeTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetType(){
        assertEquals(at.getType(), "Band");
    }
}
