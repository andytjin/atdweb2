/*
 * Licsense Header
 */
package Domain;

import java.util.ArrayList;
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
public class OnderhoudsbeurtTest {

    private Onderhoudsbeurt o;
    private Calendar cal = Calendar.getInstance();
    private Auto a;
    private Monteur m;
    private Klant k;
    public OnderhoudsbeurtTest() {
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
        m = new Monteur("Naam", 1, "Pass");
        o = new Onderhoudsbeurt(123, cal, a, m, "In-Onderhoud");
        o.setAantalBestedeUur(5);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of prijs method, of class Onderhoudsbeurt.
     */
    @Test
    public void testPrijs() {
        System.out.println("prijs");
        Onderhoudsbeurt instance = o;
        double expResult = 250.0;
        double result = instance.prijs();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getKenteken method, of class Onderhoudsbeurt.
     */
    @Test
    public void testGetKenteken() {
        System.out.println("getKenteken");
        Onderhoudsbeurt instance = o;
        String expResult = "12-34-56";
        String result = instance.getKenteken();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDeAuto method, of class Onderhoudsbeurt.
     */
    @Test
    public void testGetDeAuto() {
        System.out.println("getDeAuto");
        Onderhoudsbeurt instance = o;
        Auto expResult = a;
        Auto result = instance.getDeAuto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDeMonteur method, of class Onderhoudsbeurt.
     */
    @Test
    public void testGetDeMonteur() {
        System.out.println("getDeMonteur");
        Onderhoudsbeurt instance = o;
        Monteur expResult = m;
        Monteur result = instance.getDeMonteur();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonteurID method, of class Onderhoudsbeurt.
     */
    @Test
    public void testGetMonteurID() {
        System.out.println("getMonteurID");
        Onderhoudsbeurt instance = o;
        int expResult = 1;
        int result = instance.getMonteurID();
        assertEquals(expResult, result);
    }

    /**
     * Test of voegArtikelToe method, of class Onderhoudsbeurt.
     */
    @Test
    public void testVoegArtikelToe() {
        System.out.println("voegArtikelToe");
        ArtikelType at = new ArtikelType("Band");
        Artikel a = new Artikel("1234", 10, 100, 19.99, at);
        int n = 5;
        int id = 0;
        Onderhoudsbeurt instance = o;
        instance.voegArtikelToe(a, n, id);
    }

    /**
     * Test of getGebruikteArtikelen method, of class Onderhoudsbeurt.
     */
    @Test
    public void testGetGebruikteArtikelen() {
        System.out.println("getGebruikteArtikelen");
        Onderhoudsbeurt instance = o;
        ArrayList<GebruikteArtikelen> expResult = null;
        ArrayList<GebruikteArtikelen> result = instance.getGebruikteArtikelen();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAantalBestedeUur method, of class Onderhoudsbeurt.
     */
    @Test
    public void testSetAantalBestedeUur() {
        System.out.println("setAantalBestedeUur");
        int u = 10;
        Onderhoudsbeurt instance = o;
        instance.setAantalBestedeUur(u);
        assertEquals(instance.getAantalBestedeUur(), 10);
    }

    /**
     * Test of getAantalBestedeUur method, of class Onderhoudsbeurt.
     */
    @Test
    public void testGetAantalBestedeUur() {
        System.out.println("getAantalBestedeUur");
        Onderhoudsbeurt instance = null;
        int expResult = 0;
        int result = instance.getAantalBestedeUur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Onderhoudsbeurt.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Onderhoudsbeurt instance = o;
        String expResult = "In-Onderhoud";
        String result = instance.getStatus();
        assertEquals(expResult, result);

    }

    /**
     * Test of setStatus method, of class Onderhoudsbeurt.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String s = "Gerepareerd";
        Onderhoudsbeurt instance = o;
        instance.setStatus(s);
        assertEquals(instance.getStatus(), "Gerepareerd");
    }

    /**
     * Test of equalsDienst method, of class Onderhoudsbeurt.
     */
    @Test
    public void testEqualsDienst() {
        System.out.println("equalsDienst");
        Object andere = o;
        Onderhoudsbeurt instance = o;
        boolean expResult = true;
        boolean result = instance.equalsDienst(andere);
        assertEquals(expResult, result);

    }

    /**
     * Test of getNaam method, of class Onderhoudsbeurt.
     */
    @Test
    public void testGetNaam() {
        System.out.println("getNaam");
        Onderhoudsbeurt instance = o;
        String expResult = "Naam";
        String result = instance.getNaam();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDeMonteur method, of class Onderhoudsbeurt.
     */
    @Test
    public void testSetDeMonteur() {
        System.out.println("setDeMonteur");
        Monteur nieuw = new Monteur("Naam2", 1, "password");
        Onderhoudsbeurt instance = o;
        instance.setDeMonteur(nieuw);
        assertEquals(o.getNaam(), "Naam2");
    }
}
