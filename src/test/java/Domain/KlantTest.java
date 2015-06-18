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
public class KlantTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkPassword method, of class Klant.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String pw = "";
        Klant instance = null;
        boolean expResult = false;
        boolean result = instance.checkPassword(pw);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Klant.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String ps = "";
        Klant instance = null;
        instance.setPassword(ps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailadres method, of class Klant.
     */
    @Test
    public void testGetEmailadres() {
        System.out.println("getEmailadres");
        Klant instance = null;
        String expResult = "";
        String result = instance.getEmailadres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmailadres method, of class Klant.
     */
    @Test
    public void testSetEmailadres() {
        System.out.println("setEmailadres");
        String email = "";
        Klant instance = null;
        instance.setEmailadres(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostcode method, of class Klant.
     */
    @Test
    public void testGetPostcode() {
        System.out.println("getPostcode");
        Klant instance = null;
        String expResult = "";
        String result = instance.getPostcode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPostcode method, of class Klant.
     */
    @Test
    public void testSetPostcode() {
        System.out.println("setPostcode");
        String pc = "";
        Klant instance = null;
        instance.setPostcode(pc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefoonnummer method, of class Klant.
     */
    @Test
    public void testGetTelefoonnummer() {
        System.out.println("getTelefoonnummer");
        Klant instance = null;
        String expResult = "";
        String result = instance.getTelefoonnummer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefoonnummer method, of class Klant.
     */
    @Test
    public void testSetTelefoonnummer() {
        System.out.println("setTelefoonnummer");
        String tel = "";
        Klant instance = null;
        instance.setTelefoonnummer(tel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGeboortedatum method, of class Klant.
     */
    @Test
    public void testGetGeboortedatum() {
        System.out.println("getGeboortedatum");
        Klant instance = null;
        String expResult = "";
        String result = instance.getGeboortedatum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGeboortedatum method, of class Klant.
     */
    @Test
    public void testSetGeboortedatum() {
        System.out.println("setGeboortedatum");
        String gd = "";
        Klant instance = null;
        instance.setGeboortedatum(gd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdres method, of class Klant.
     */
    @Test
    public void testGetAdres() {
        System.out.println("getAdres");
        Klant instance = null;
        String expResult = "";
        String result = instance.getAdres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdres method, of class Klant.
     */
    @Test
    public void testSetAdres() {
        System.out.println("setAdres");
        String ad = "";
        Klant instance = null;
        instance.setAdres(ad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNaam method, of class Klant.
     */
    @Test
    public void testGetNaam() {
        System.out.println("getNaam");
        Klant instance = null;
        String expResult = "";
        String result = instance.getNaam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNaam method, of class Klant.
     */
    @Test
    public void testSetNaam() {
        System.out.println("setNaam");
        String nm = "";
        Klant instance = null;
        instance.setNaam(nm);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Klant.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Klant instance = null;
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Klant.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String uname = "";
        Klant instance = null;
        instance.setUsername(uname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWiltHerinnering method, of class Klant.
     */
    @Test
    public void testGetWiltHerinnering() {
        System.out.println("getWiltHerinnering");
        Klant instance = null;
        String expResult = "";
        String result = instance.getWiltHerinnering();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWiltHerinnering method, of class Klant.
     */
    @Test
    public void testSetWiltHerinnering() {
        System.out.println("setWiltHerinnering");
        boolean b = false;
        Klant instance = null;
        instance.setWiltHerinnering(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isWiltHerinnering method, of class Klant.
     */
    @Test
    public void testIsWiltHerinnering() {
        System.out.println("isWiltHerinnering");
        Klant instance = null;
        boolean expResult = false;
        boolean result = instance.isWiltHerinnering();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Klant.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Klant instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
