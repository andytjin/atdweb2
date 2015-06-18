/*
 * Licsense Header
 */
package WhiteBoxTest;

import Domain.Artikel;
import Domain.ArtikelType;
import Domain.GebruikteArtikelen;
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
public class GebruikteArtiekelenTest {

    private GebruikteArtikelen ga;
    private Artikel a;
    private ArtikelType at;

    public GebruikteArtiekelenTest() {
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
        ga = new GebruikteArtikelen(5, a);
        ga.setOnderhoudsBeurtId(123);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetOndhoudsBeurtId() {
        assertEquals(ga.getOnderhoudsBeurtId(), 123);
    }

    @Test
    public void testSetOnderhoudsBeurtId() {
        ga.setOnderhoudsBeurtId(1234);
        assertEquals(ga.getOnderhoudsBeurtId(), 1234);
    }

    @Test
    public void testSetGebruikteArtikelId() {
        ga.setGebruikteArtikelId(123);
        assertEquals(ga.getGebruikteArtikelId(), 123);
    }

    @Test
    public void testGetArtikelId() {
        assertEquals(ga.getGebruikteArtikelId(), "1A2B3C");
    }

    @Test
    public void testGetHetArtikel() {
        assertEquals(ga.getHetArtikel(), a);
    }

    @Test
    public void testGetAantal() {
        assertEquals(ga.getAantal(), 5);
    }
}
