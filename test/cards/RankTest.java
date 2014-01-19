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
public class RankTest {

    private static Logger logger;
    
    public RankTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        logger = Logger.getLogger(RankTest.class);
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
     * Test of values method, of class Rank.
     */
    @Test
    public void testValues() {
        logger.info("\ntesting values()");
        Rank[] expResult = null;
        Rank[] result = Rank.values();
        for(int i = 0; i < result.length; i++) {
            logger.debug(result[i]);
        }
    }

    /**
     * Test of valueOf method, of class Rank.
     */
    @Test
    public void testValueOf() {
        logger.info("\ntesting valueOf()");
        String name = "JACK";
        Rank expResult = Rank.JACK;
        Rank result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRank method, of class Rank.
     */
    @Test
    public void testGetRank() {
        logger.info("\ntesting getRank()");
        int rank = 0;
        Rank expResult = Rank.TWO;
        Rank result = Rank.getRank(rank);
        logger.debug("result = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Rank
     */
    @Test
    public void testToString() {
        logger.info("\ntesting toString()");
        Rank rank = Rank.EIGHT;
        String result = rank.toString();
        logger.debug("result = " + rank);
        String expResult = "EIGHT";
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testGetIntValue() {
        logger.info("\ntesting getIntValue()");

        Rank[] values = Rank.values();
        for(int i = 0; i < values.length; i++) {
            logger.debug(values[i] + " " + Rank.getIntValue(values[i]));
        }
    }
}