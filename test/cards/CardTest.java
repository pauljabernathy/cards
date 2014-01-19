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

import org.apache.log4j.*;

/**
 *
 * @author paul
 */
public class CardTest {

    private static Logger logger;
    
    public CardTest() {
        if(logger == null) {
            logger = Logger.getLogger(this.getClass());
            logger.addAppender(new ConsoleAppender(new PatternLayout("%m%n")));
            logger.setLevel(Level.DEBUG);
        }
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
        logger.info("\ntesting getRank()");
        Card instance = new Card(Rank.JACK, Suit.SPADES);
        Rank expResult = Rank.JACK;
        Rank result = instance.getRank();
        logger.debug("result = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        logger.info("\ntesting getSuit()");
        Card instance = new Card(Rank.TEN, Suit.CLUBS);
        Suit expResult = Suit.CLUBS;
        Suit result = instance.getSuit();
        logger.debug("result = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Card
     */
    @Test
    public void testToString() {
        logger.info("\ntesting toString()");
        Card instance = new Card(Rank.SEVEN, Suit.HEARTS);
        String expResult = "SEVEN of HEARTS";
        String result = instance.toString();
        logger.debug("result = " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSomething() {
        logger.info("\ntesting something");
    }

}