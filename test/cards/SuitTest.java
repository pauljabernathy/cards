/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paul
 */
public class SuitTest {

    public SuitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class Suit.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Suit[] expResult = null;
        Suit[] result = Suit.values();
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * Test of valueOf method, of class Suit.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "SPADES";
        Suit expResult = Suit.SPADES;
        Suit result = Suit.valueOf(name);
        System.out.println("result = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSuit method, of class Suit.
     */
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        int suit = 0;
        Suit expResult = Suit.SPADES;
        Suit result = Suit.getSuit(suit);
        System.out.println("result = " + result);
        assertEquals(expResult, result);
    }

}