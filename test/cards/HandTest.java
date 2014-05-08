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
public class HandTest {

    public static Logger logger;
    
    public HandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        logger = Logger.getLogger(HandTest.class);
        logger.addAppender(new ConsoleAppender(new PatternLayout("%m%n")));
        logger.setLevel(Level.INFO);
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

    @Test
    public void testValues() {
        logger.info("\ntesting values");
        logger.info(Hand.FLUSH);
        assertEquals("FLUSH", Hand.FLUSH.toString());
    }

    @Test
    public void testValueOf() {
        logger.info("\ntesting valueOf()");
        logger.info(Hand.valueOf("STRAIGHT_FLUSH"));
        logger.info(Hand.valueOf(Hand.STRAIGHT_FLUSH_STR));
        assertEquals(Hand.STRAIGHT_FLUSH, Hand.valueOf("STRAIGHT_FLUSH"));
        logger.info(Hand.valueOf("FLUSH"));
        assertEquals(Hand.FLUSH, Hand.valueOf("FLUSH"));
    }

    @Test
    public void testGetHand() {
        logger.info("\ntesting getHand()");
        logger.info(Hand.getHand(5));
        assertEquals(Hand.FLUSH, Hand.getHand(5));
    }
    
    @Test
    public void testGetIntValue() {
        logger.info("\ntesting getIntValue()");
        assertEquals(Hand.FOUR_OF_A_KIND_INT, Hand.getIntValue(Hand.FOUR_OF_A_KIND));
    }
}