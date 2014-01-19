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
public class NumericSortTest {

    private static Logger logger;
    
    public NumericSortTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        logger = Logger.getLogger(NumericSortTest.class);
        logger.setLevel(Level.INFO);
        logger.addAppender(new ConsoleAppender(new PatternLayout("%m%n")));
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
     * Test of compare method, of class NumericSort.
     */
    @Test
    public void testCompare() {
        logger.info("\ntesting compare()");
        Card left = new Card(Rank.TWO, Suit.HEARTS);
        Card right = new Card(Rank.FOUR, Suit.HEARTS);
        NumericSort instance = new NumericSort();
        int expResult = -1;
        int result = instance.compare(left, right);
        assertEquals(expResult, result);

        left = new Card(Rank.TWO, Suit.HEARTS);
        right = new Card(Rank.TWO, Suit.HEARTS);
        assertEquals(0, instance.compare(left, right));

        left = new Card(Rank.ACE, Suit.HEARTS);
        right = new Card(Rank.TWO, Suit.HEARTS);
        assertEquals(1, instance.compare(left, right));

        left = new Card(Rank.TWO, Suit.HEARTS);
        right = new Card(Rank.TWO, Suit.DIAMONDS);
        assertEquals(0, instance.compare(left, right));
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

        Arrays.sort(cards, new NumericSort());
        logger.debug("\nsorted?");
        for(int i = 0; i < cards.length; i++) {
            logger.debug(cards[i]);
        }
    }
}