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
public class CardTest {

    public CardTest() {
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
     * Test of getRank method, of class Card.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        Card instance = new Card(Rank.JACK, Suit.SPADES);
        Rank expResult = Rank.JACK;
        Rank result = instance.getRank();
        System.out.println("result = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        Card instance = new Card(Rank.TEN, Suit.CLUBS);
        Suit expResult = Suit.CLUBS;
        Suit result = instance.getSuit();
        System.out.println("result = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Card
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Card instance = new Card(Rank.SEVEN, Suit.HEARTS);
        String expResult = "SEVEN of HEARTS";
        String result = instance.toString();
        System.out.println("result = " + result);
        assertEquals(expResult, result);
    }

}