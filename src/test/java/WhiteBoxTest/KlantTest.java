/*
 * Licsense Header
 */
package WhiteBoxTest;

import Domain.Klant;
import Security.Encrypter;
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
public class KlantTest {

    private Klant k;

    public KlantTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        String encrypted = Encrypter.md5Hash("Password");
        k = new Klant("Username", "Naam", encrypted, "Adres", "GeboortDatum", "Telefoon", "Postcode", "Emailadres", true);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCheckPassword() {
        assertEquals(k.checkPassword("Password"), true);
    }

    @Test
    public void testSetPassword() {
        k.setPassword(Encrypter.md5Hash("Password1"));
        assertEquals(k.checkPassword("Password1"), true);
    }
    
    @Test
    public void TestSetGetEmailadres(){
        assertEquals(k.getEmailadres(), "Emailadres");
    }
    
    @Test
    public void testSetEmailadres(){
        k.setEmailadres("Emailadres2");
        assertEquals(k.getEmailadres(), "Emailadres2");
    }
    
    @Test
    public void testGetPostcode(){
        assertEquals(k.getPostcode(), "Postcode");
    }
    
    @Test
    public void testSetPostcode(){
        k.setPostcode("1234AB");
        assertEquals(k.getPostcode(), "1234AB");
    }
    
    @Test
    public void testGetTelefoonnummer(){
        assertEquals(k.getTelefoonnummer(), "Telefoon");
    }
    
    @Test
    public void testSetTelefoonnummer(){
        k.setTelefoonnummer("Telefoon2");
        assertEquals(k.getTelefoonnummer(), "Telefoon2");
    }
    
    @Test
    public void testGetGeboortedatum(){
        assertEquals(k.getGeboortedatum(), "GeboortDatum");
    }
    
    @Test
    public void testSetGeboortDatum(){
        k.setGeboortedatum("GeboorteDatum2");
        assertEquals(k.getGeboortedatum(), "GeboorteDatum2");
    }
    
    @Test
    public void testGetAdres(){
        assertEquals(k.getAdres(), "Adres");
    }
    
    @Test
    public void testSetAdres(){
        k.setAdres("Adres2");
        assertEquals(k.getAdres(), "Adres2");
    }
    
    @Test
    public void testGetNaam(){
        assertEquals(k.getNaam(), "Naam");
    }
    
    @Test
    public void testSetNaam(){
        k.setNaam("Naam2");
        assertEquals(k.getNaam(), "Naam2");
    }
    
    @Test
    public void testGetUsername(){
        assertEquals(k.getUsername(), "Username");
    }
    
    @Test
    public void testSetUsername(){
        k.setUsername("Username2");
        assertEquals(k.getUsername(), "Username2");
    }
    
    @Test
    public void testGetWiltHerinnering(){
        assertEquals(k.getWiltHerinnering(), "Ja");
    }
    
    @Test
    public void testWiltHerinnering(){
        k.setWiltHerinnering(false);
        assertEquals(k.isWiltHerinnering(), false);
    }
    
    @Test
    public void testIsWiltHerinnering(){
        assertEquals(k.isWiltHerinnering(), true);
    }
    
}
