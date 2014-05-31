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
import java.util.List;

/**
 *
 * @author paul
 */
public class HandRankerTest {

    private static Logger logger;
    
    public HandRankerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        logger = Logger.getLogger("HandRankerTest");
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
     * Test of checkForPair method, of class HandRanker.
     */
    @Test
    public void testCheckForPair() {
        logger.info("\ntesting checkForPair()");

        //null
        Card[] cards = null;

        //emtpy set
        cards = new Card[] { };
        assertEquals(false, HandRanker.checkForPair(cards));

        //not enough cards
        cards = new Card[] {new Card(Rank.TWO, Suit.CLUBS) };
        assertEquals(false, HandRanker.checkForPair(cards));

        //exact number
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS) };
        assertEquals(false, HandRanker.checkForPair(cards));

        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.KING, Suit.CLUBS) };
        assertEquals(true, HandRanker.checkForPair(cards));

        //not present
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS)};
        assertEquals(false, HandRanker.checkForPair(cards));

        //lowest card in hard
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS), new Card(Rank.QUEEN, Suit.CLUBS), new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.ACE, Suit.CLUBS)};
        assertEquals(true, HandRanker.checkForPair(cards));

        //highest card in hand
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.JACK, Suit.DIAMONDS), new Card(Rank.QUEEN, Suit.CLUBS), new Card(Rank.TWO, Suit.SPADES), new Card(Rank.ACE, Suit.CLUBS)};
        assertEquals(true, HandRanker.checkForPair(cards));

        //middle of hand
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.JACK, Suit.DIAMONDS), new Card(Rank.QUEEN, Suit.CLUBS), new Card(Rank.TEN, Suit.SPADES), new Card(Rank.ACE, Suit.CLUBS)};
        assertEquals(true, HandRanker.checkForPair(cards));

    }

    /**
     *
     */
    @Test
    public void testCheckForTwoPair() {
        logger.info("\ntesting checkForTwoPair()");

        //null
        Card[] cards = null;
        assertEquals(false, HandRanker.checkForTwoPairs(cards));

        //emtpy set
        cards = new Card[] { };
        assertEquals(false, HandRanker.checkForTwoPairs(cards));

        //not enough cards
        cards = new Card[] {new Card(Rank.TWO, Suit.CLUBS) };
        //assertEquals(false, HandRanker.checkForTwoPairs(cards));

        //4 cards
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.KING, Suit.SPADES), new Card(Rank.TEN, Suit.DIAMONDS) };
        assertEquals(true, HandRanker.checkForTwoPairs(cards));
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.KING, Suit.SPADES), new Card(Rank.NINE, Suit.DIAMONDS) };
        assertEquals(false, HandRanker.checkForTwoPairs(cards));
        cards = new Card[] { new Card(Rank.QUEEN, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.KING, Suit.SPADES), new Card(Rank.NINE, Suit.DIAMONDS) };
        //assertEquals(false, HandRanker.checkForTwoPairs(cards));

    }

    /**
     * Test of checkForPair method, of class HandRanker.
     */
    @Test
    public void testCheckThreeOfAKind() {
        logger.info("\ntesting checkForThreeOfAKind()");

        //null
        Card[] cards = null;
        assertEquals(false, HandRanker.checkForThreeOfAKind(cards));

        //emtpy set
        cards = new Card[] { };
        assertEquals(false, HandRanker.checkForThreeOfAKind(cards));

        //not enough cards
        cards = new Card[] {new Card(Rank.TWO, Suit.CLUBS) };
        assertEquals(false, HandRanker.checkForThreeOfAKind(cards));

        cards = new Card[] {new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.TWO, Suit.DIAMONDS) };
        assertEquals(false, HandRanker.checkForThreeOfAKind(cards));


        //exact number
        cards = new Card[] { new Card(Rank.ACE, Suit.CLUBS), new Card(Rank.ACE, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS)};
        assertEquals(true, HandRanker.checkForThreeOfAKind(cards));

        cards = new Card[] {new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.TWO, Suit.DIAMONDS), new Card(Rank.THREE, Suit.HEARTS) };
        assertEquals(false, HandRanker.checkForThreeOfAKind(cards));

        
        //not present
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS)};
        assertEquals(false, HandRanker.checkForThreeOfAKind(cards));

        //highest card in hand
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS), new Card(Rank.QUEEN, Suit.CLUBS), new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.ACE, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS)};
        assertEquals(true, HandRanker.checkForThreeOfAKind(cards));

        //lowest card in hand
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.JACK, Suit.DIAMONDS), new Card(Rank.QUEEN, Suit.CLUBS), new Card(Rank.TWO, Suit.SPADES), new Card(Rank.ACE, Suit.CLUBS)};
        assertEquals(true, HandRanker.checkForThreeOfAKind(cards));

        //middle of hand
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.JACK, Suit.DIAMONDS), new Card(Rank.QUEEN, Suit.CLUBS), new Card(Rank.TEN, Suit.SPADES), new Card(Rank.TEN, Suit.SPADES), new Card(Rank.ACE, Suit.CLUBS)};
        assertEquals(true, HandRanker.checkForThreeOfAKind(cards));



    }

    /**
     *
     */
    @Test
    public void testCheckForStraight() {
        logger.info("\ntesting checkForStraight()");
        Card[] cards = null;
        assertEquals(false, HandRanker.checkForStraight(cards));

        cards = new Card[] { };
        assertEquals(false, HandRanker.checkForStraight(cards));

        //not enough cards
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS)};
        assertEquals(false, HandRanker.checkForStraight(cards));

        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS)};
        assertEquals(false, HandRanker.checkForStraight(cards));

        //exact number
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS)};
        assertEquals(false, HandRanker.checkForStraight(cards));

        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS)};
        assertEquals(true, HandRanker.checkForStraight(cards));

        //more than 5
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS)};
        assertEquals(true, HandRanker.checkForStraight(cards));


        //unsorted
        cards = new Card[] { new Card(Rank.SIX, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.TWO, Suit.DIAMONDS)};
        assertEquals(true, HandRanker.checkForStraight(cards));

        cards = new Card[] { new Card(Rank.QUEEN, Suit.CLUBS), new Card(Rank.FIVE, Suit.CLUBS), new Card(Rank.TEN, Suit.DIAMONDS), new Card(Rank.EIGHT, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS), new Card(Rank.JACK, Suit.SPADES)};
        assertEquals(false, HandRanker.checkForStraight(cards));

        cards = new Card[] { new Card(Rank.JACK, Suit.CLUBS), new Card(Rank.FIVE, Suit.CLUBS), new Card(Rank.QUEEN, Suit.DIAMONDS), new Card(Rank.EIGHT, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS), new Card(Rank.NINE, Suit.SPADES)};
        assertEquals(true, HandRanker.checkForStraight(cards));

        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.ACE, Suit.DIAMONDS) };
        assertEquals(false, HandRanker.checkForStraight(cards));

    }

    /**
     *
     */
    @Test
    public void testFindStraight() {
        logger.info("\ntesting findStraight()");
        Card[] cards = null;
        assertEquals(null, HandRanker.findStraight(cards));

        cards = new Card[] { };
        assertEquals(null, HandRanker.findStraight(cards));

        //not enough cards
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS)};
        Card[] straight = HandRanker.findStraight(cards);
        showCards(straight);
        checkStraightAgreement(cards, straight);

        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS)};
        straight = HandRanker.findStraight(cards);
        //showCards(straight);
        checkStraightAgreement(cards, straight);

        //exact number
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS)};
        straight = HandRanker.findStraight(cards);
        showCards(straight);
        checkStraightAgreement(cards, straight);

        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS)};
        straight = HandRanker.findStraight(cards);
        showCards(straight);
        //cards[4] = new Card(Rank.ACE, Suit.DIAMONDS); //when uncommented, this line causes the test to fail, as it should
        checkStraightAgreement(cards, straight);

        //more than 5
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS)};
        straight = HandRanker.findStraight(cards);
        showCards(straight);
        checkStraightAgreement(cards, straight);


        //unsorted
        cards = new Card[] { new Card(Rank.SIX, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.TWO, Suit.DIAMONDS)};
        straight = HandRanker.findStraight(cards);
        showCards(straight);
        checkStraightAgreement(cards, straight);

        cards = new Card[] { new Card(Rank.QUEEN, Suit.CLUBS), new Card(Rank.FIVE, Suit.CLUBS), new Card(Rank.TEN, Suit.DIAMONDS), new Card(Rank.EIGHT, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS), new Card(Rank.JACK, Suit.SPADES)};
        straight = HandRanker.findStraight(cards);
        showCards(straight);
        assertEquals(null, straight);
        checkStraightAgreement(cards, straight);

        cards = new Card[] { new Card(Rank.JACK, Suit.CLUBS), new Card(Rank.FIVE, Suit.CLUBS), new Card(Rank.QUEEN, Suit.DIAMONDS), new Card(Rank.EIGHT, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS), new Card(Rank.NINE, Suit.SPADES)};
        straight = HandRanker.findStraight(cards);
        showCards(straight);
        checkStraightAgreement(cards, straight);

    }

    @Test
    public void testFindStraights() {
        logger.info("\ntesting findStraights()");
        Card[] cards = null;
        assertEquals(0, HandRanker.findStraights(cards).size());

        cards = new Card[] { };
        assertEquals(0, HandRanker.findStraights(cards).size());
        
        //not enough cards
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS)};
        List<Card[]> straights = HandRanker.findStraights(cards);
        //showCards(straight);
        checkAllStraightsAgreement(cards, straights);

        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS)};
        straights = HandRanker.findStraights(cards);
        //showCards(straight);
        checkAllStraightsAgreement(cards, straights);
        
        //5 cards
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS)};
        straights = HandRanker.findStraights(cards);
        checkAllStraightsAgreement(cards, straights);
        assertEquals(0, straights.size());

        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS)};
        straights = HandRanker.findStraights(cards);
        //cards[4] = new Card(Rank.ACE, Suit.DIAMONDS); //when uncommented, this line causes the test to fail, as it should
        checkAllStraightsAgreement(cards, straights);
        assertEquals(1, straights.size());
        
        //more than 5, one straight
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.DIAMONDS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.EIGHT, Suit.DIAMONDS)};
        straights = HandRanker.findStraights(cards);
        checkAllStraightsAgreement(cards, straights);
        assertEquals(1, straights.size());
        
        //more than 5, two straights
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.DIAMONDS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS)};
        straights = HandRanker.findStraights(cards);
        checkAllStraightsAgreement(cards, straights);
        assertEquals(2, straights.size());
        assertEquals(Rank.TWO, straights.get(0)[0].getRank());
        assertEquals(Rank.THREE, straights.get(1)[0].getRank());
        
        
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FOUR, Suit.HEARTS), new Card(Rank.TEN, Suit.CLUBS),  new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.SIX, Suit.HEARTS) };
        straights = HandRanker.findStraights(cards);
        checkAllStraightsAgreement(cards, straights);
        assertEquals(2, straights.size());
    }
    
    /**
     *
     */
    @Test
    public void checkForFlush() {
        logger.info("\ntesting checkForFlush()");
        Card[] cards = null;
        assertEquals(false, HandRanker.checkForFlush(cards));

        cards = new Card[] { };
        assertEquals(false, HandRanker.checkForFlush(cards));

        //not enough cards
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS) };
        assertEquals(false, HandRanker.checkForFlush(cards));
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS)};
        assertEquals(false, HandRanker.checkForFlush(cards));

        //5 cards
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.HEARTS) };
        assertEquals(true, HandRanker.checkForFlush(cards));
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.DIAMONDS) };
        assertEquals(false, HandRanker.checkForFlush(cards));

        //more than 5 cards
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.HEARTS) };
        assertEquals(true, HandRanker.checkForFlush(cards));
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.DIAMONDS), new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), };
        assertEquals(false, HandRanker.checkForFlush(cards));
    }

    /**
     *
     */
    @Test
    public void testForFullHouse() {
        logger.info("\ntestin checkForFullHouse()");
        Card[] cards = null;
        assertEquals(false, HandRanker.checkForFullHouse(cards));

        //not enough cards
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS) };
        assertEquals(false, HandRanker.checkForFullHouse(cards));

        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.DIAMONDS), new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS) };
        assertEquals(false, HandRanker.checkForFullHouse(cards));
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.DIAMONDS), new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS) };
        assertEquals(false, HandRanker.checkForFullHouse(cards));
        cards = new Card[] { new Card(Rank.THREE, Suit.DIAMONDS), new Card(Rank.KING, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS), new Card(Rank.THREE, Suit.CLUBS),  new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.FOUR, Suit.CLUBS), new Card(Rank.SIX, Suit.SPADES) };
        assertEquals(false, HandRanker.checkForFullHouse(cards));


        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.TWO, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.FIVE, Suit.SPADES),  new Card(Rank.FIVE, Suit.CLUBS), new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), };
        assertEquals(true, HandRanker.checkForFullHouse(cards));

    }
    /**
     *
     */
    @Test
    public void testCheckForFourOfAKind() {
        logger.info("\ntestCheckForFourOfAKind()");
        Card[] cards = null;
        assertEquals(false, HandRanker.checkForFourOfAKind(cards));

        cards = new Card[] { };
        assertEquals(false, HandRanker.checkForFourOfAKind(cards));

        //not enough cards
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS)};
        assertEquals(false, HandRanker.checkForFourOfAKind(cards));


        //exact number
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.TWO, Suit.SPADES), new Card(Rank.TWO, Suit.DIAMONDS), new Card(Rank.TWO, Suit.HEARTS)};
        assertEquals(true, HandRanker.checkForFourOfAKind(cards));

        cards = new Card[] { new Card(Rank.FOUR, Suit.CLUBS), new Card(Rank.TWO, Suit.SPADES), new Card(Rank.TWO, Suit.DIAMONDS), new Card(Rank.TWO, Suit.HEARTS)};
        assertEquals(false, HandRanker.checkForFourOfAKind(cards));

        //5 cards - a full hand
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS)};
        assertEquals(false, HandRanker.checkForFourOfAKind(cards));

        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.TWO, Suit.SPADES), new Card(Rank.TWO, Suit.DIAMONDS), new Card(Rank.TWO, Suit.HEARTS)};
        assertEquals(true, HandRanker.checkForFourOfAKind(cards));

        //more than 5
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS)};
        assertEquals(false, HandRanker.checkForFourOfAKind(cards));
    }


    /**
     *
     *
     */
    @Test
    public void testForStraightFlush() {
        logger.debug("\ntesting checkForFlush()");
        Card[] cards = null;
        assertEquals(false, HandRanker.checkForStraightFlush(cards));

        cards = new Card[] { };
        assertEquals(false, HandRanker.checkForStraightFlush(cards));

        //not enough cards
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS) };
        assertEquals(false, HandRanker.checkForStraightFlush(cards));
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS)};
        assertEquals(false, HandRanker.checkForStraightFlush(cards));

        //5 cards
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.HEARTS) };
        assertEquals(false, HandRanker.checkForStraightFlush(cards));
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.DIAMONDS) };
        assertEquals(false, HandRanker.checkForStraightFlush(cards));

        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.FOUR, Suit.HEARTS),  new Card(Rank.SIX, Suit.HEARTS) };
        assertEquals(true, HandRanker.checkForStraightFlush(cards));
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.FOUR, Suit.HEARTS),  new Card(Rank.SIX, Suit.HEARTS) };
        assertEquals(false, HandRanker.checkForStraightFlush(cards));

        //more than 5 cards
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.HEARTS) };
        assertEquals(false, HandRanker.checkForStraightFlush(cards));
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.DIAMONDS), new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), };
        assertEquals(false, HandRanker.checkForStraightFlush(cards));

        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FOUR, Suit.HEARTS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.SIX, Suit.HEARTS),  new Card(Rank.NINE, Suit.HEARTS) };
        assertEquals(true, HandRanker.checkForStraightFlush(cards));
        cards = new Card[] { new Card(Rank.TWO, Suit.DIAMONDS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FOUR, Suit.HEARTS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.SIX, Suit.HEARTS),  new Card(Rank.NINE, Suit.HEARTS) };
        assertEquals(false, HandRanker.checkForStraightFlush(cards));
        
        //one with more than one rank
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FOUR, Suit.HEARTS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.SIX, Suit.HEARTS),  new Card(Rank.SIX, Suit.DIAMONDS) };
        assertEquals(true, HandRanker.checkForStraightFlush(cards));
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FOUR, Suit.HEARTS), new Card(Rank.TEN, Suit.CLUBS),  new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.SIX, Suit.HEARTS) };
        assertEquals(true, HandRanker.checkForStraightFlush(cards));

    }

    @Test
    public void checkForRoyalFlush() {
        logger.info("\ntesting checkForRoyalFlush()");
        Card[] cards = null;
        assertEquals(false, HandRanker.checkForRoyalFlush(cards));

        cards = new Card[] { };
        //assertEquals(false, HandRanker.checkForRoyalFlush(cards));

        //not enough cards
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS) };
        //assertEquals(false, HandRanker.checkForRoyalFlush(cards));
        cards = new Card[] { new Card(Rank.KING, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.ACE, Suit.DIAMONDS)};
        //assertEquals(false, HandRanker.checkForRoyalFlush(cards));

        //5 cards
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.HEARTS) };
        //assertEquals(false, HandRanker.checkForRoyalFlush(cards));
        cards = new Card[] { new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.NINE, Suit.DIAMONDS) };
        //assertEquals(false, HandRanker.checkForRoyalFlush(cards));
        
        cards = new Card[] { new Card(Rank.TEN, Suit.HEARTS), new Card(Rank.NINE, Suit.HEARTS), new Card(Rank.QUEEN, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.KING, Suit.HEARTS) };
        //assertEquals(false, HandRanker.checkForRoyalFlush(cards));
        cards = new Card[] { new Card(Rank.TEN, Suit.DIAMONDS), new Card(Rank.ACE, Suit.HEARTS), new Card(Rank.QUEEN, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.KING, Suit.HEARTS) };
        //assertEquals(false, HandRanker.checkForRoyalFlush(cards));
        cards = new Card[] { new Card(Rank.TEN, Suit.HEARTS), new Card(Rank.ACE, Suit.HEARTS), new Card(Rank.QUEEN, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.KING, Suit.HEARTS) };
        //assertEquals(true, HandRanker.checkForRoyalFlush(cards));
        
        //7 cards
        cards = new Card[] { new Card(Rank.TEN, Suit.HEARTS), new Card(Rank.ACE, Suit.HEARTS), new Card(Rank.QUEEN, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.KING, Suit.HEARTS), new Card(Rank.FIVE, Suit.CLUBS), new Card(Rank.FIVE, Suit.HEARTS) };
        //assertEquals(true, HandRanker.checkForRoyalFlush(cards));
        cards = new Card[] { new Card(Rank.TEN, Suit.HEARTS), new Card(Rank.ACE, Suit.HEARTS), new Card(Rank.QUEEN, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.KING, Suit.HEARTS), new Card(Rank.KING, Suit.CLUBS), new Card(Rank.FIVE, Suit.HEARTS) };
        //assertEquals(true, HandRanker.checkForRoyalFlush(cards));
        cards = new Card[] { new Card(Rank.TEN, Suit.HEARTS), new Card(Rank.ACE, Suit.HEARTS), new Card(Rank.QUEEN, Suit.HEARTS), new Card(Rank.KING, Suit.CLUBS), new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS),  new Card(Rank.KING, Suit.HEARTS) };
        assertEquals(true, HandRanker.checkForRoyalFlush(cards));
    }
    
    private static void showCards(Card[] cards) {
        logger.debug("HandRanker.showCards()");
        StringBuilder sb = new StringBuilder();
        if(cards != null) {
            for(Card card: cards) {
                sb.append(card).append("  ");
            }
            logger.debug(sb);
            logger.debug("");
        } else {
            logger.debug("cards is null");
        }
    }

    private void checkAllStraightsAgreement(Card[] hand, List<Card[]> straights) {
        for(Card[] straight : straights) {
            checkStraightAgreement(hand, straight);
        }
    }
    
    private void checkStraightAgreement(Card[] hand, Card[] straight) {
        logger.debug("checkStraightAgreement()");
        logger.debug("hand:");
        showHand(hand);

        if(straight != null) {
            logger.debug("\n\nstraight:");
            showHand(straight);
            logger.debug("HandRanker.checkForStraight(hand) = " +HandRanker.checkForStraight(hand));
        }

        if(HandRanker.checkForStraight(hand)  && straight == null) {
            fail("checkForStraight was true but findStraight did not find it");
        }
        else if(!HandRanker.checkForStraight(hand) && straight != null) {
            fail("checkForStraight was false but findStraight found something");
        }
    }

    private void showHand(Card[] hand) {
        for(Card card: hand) {
            logger.debug(card.toString());
        }
    }
}