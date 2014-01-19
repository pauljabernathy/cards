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
public class SuitTest {

    private static Logger logger;
    public SuitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        logger = Logger.getLogger(SuitTest.class);
        logger.addAppender(new ConsoleAppender(new PatternLayout("%m%n")));
        logger.setLevel(Level.INFO);
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
        logger.info("\ntesting values()");
        Suit[] expResult = null;
        Suit[] result = Suit.values();
        for(int i = 0; i < result.length; i++) {
            logger.debug(result[i]);
        }
    }

    /**
     * Test of valueOf method, of class Suit.
     */
    @Test
    public void testValueOf() {
        logger.info("\ntesting valueOf()");
        String name = "SPADES";
        Suit expResult = Suit.SPADES;
        Suit result = Suit.valueOf(name);
        logger.debug("result = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSuit method, of class Suit.
     */
    @Test
    public void testGetSuit() {
        logger.info("\ntesting getSuit()");
        int suit = 0;
        Suit expResult = Suit.SPADES;
        Suit result = Suit.getSuit(suit);
        logger.debug("result = " + result);
        assertEquals(expResult, result);
    }

}