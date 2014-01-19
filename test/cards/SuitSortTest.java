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
import java.util.Arrays;

import org.apache.log4j.*;

/**
 *
 * @author paul
 */
public class SuitSortTest {

    private static Logger logger;
    
    public SuitSortTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        logger = Logger.getLogger(SuitSortTest.class);
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
     * Test of compare method, of class SuitSort.
     */
    @Test
    public void testCompare() {
        logger.info("\ntestin compare()");
        Card left = new Card(Rank.TWO, Suit.HEARTS);
        Card right = new Card(Rank.FOUR, Suit.HEARTS);
        SuitSort instance = new SuitSort();
        int result = instance.compare(left, right);
        assertEquals(0, result);

        left = new Card(Rank.TWO, Suit.HEARTS);
        right = new Card(Rank.TWO, Suit.DIAMONDS);
        assertEquals(-1, instance.compare(left, right));

        left = new Card(Rank.ACE, Suit.CLUBS);
        right = new Card(Rank.TWO, Suit.HEARTS);
        assertEquals(1, instance.compare(left, right));

        left = new Card(Rank.TWO, Suit.SPADES);
        right = new Card(Rank.TWO, Suit.DIAMONDS);
        assertEquals(-1, instance.compare(left, right));
    }

    /**
     *
     */
    @Test
    public void testSort() {
        logger.info("\ntesting sort()");
        Card[] cards = { new Card(Rank.ACE, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.EIGHT, Suit.SPADES), new Card(Rank.SEVEN, Suit.CLUBS), new Card(Rank.FOUR, Suit.HEARTS)};
        logger.debug("unsorted:");
        for(int i = 0; i < cards.length; i++) {
            logger.debug(cards[i]);
        }

        Arrays.sort(cards, new SuitSort());
        logger.debug("\nsorted?");
        for(int i = 0; i < cards.length; i++) {
            logger.debug(cards[i]);
        }
    }
}