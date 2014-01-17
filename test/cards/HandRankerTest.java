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
public class HandRankerTest {

    public HandRankerTest() {
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
     * Test of checkForPair method, of class HandRanker.
     */
    //@Test
    public void testCheckForPair() {
        System.out.println("checkForPair");

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
    //@Test
    public void testCheckForTwoPair() {
        System.out.println("checkForTwoPair");

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
    //@Test
    public void testCheckThreeOfAKind() {
        System.out.println("checkForThreeOfAKind");

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
        System.out.println("testCheckForStraight");
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
        System.out.println("testCheckForStraight");
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
        showCards(straight);
        checkStraightAgreement(cards, straight);

        //exact number
        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS)};
        straight = HandRanker.findStraight(cards);
        showCards(straight);
        checkStraightAgreement(cards, straight);

        cards = new Card[] { new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.DIAMONDS), new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS)};
        straight = HandRanker.findStraight(cards);
        showCards(straight);
        System.out.println("********************");
        //cards[4] = new Card(Rank.ACE, Suit.DIAMONDS);
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

    /**
     *
     */
    //@Test
    public void checkForFlush() {
        System.out.println("testCheckForFlush");
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
    //@Test
    public void testForFullHouse() {
        System.out.println("fullHouse");
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
    //@Test
    public void testCheckForFourOfAKind() {
        System.out.println("testCheckForFourOfAKind");
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
    //@Test
    public void testForStraightFlush() {
        System.out.println("testCheckForFlush");
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

    }

    private static void showCards(Card[] cards) {
        if(cards != null) {
            //System.out.println();
            for(Card card: cards) {
                System.out.print(card + "  ");
            }
            System.out.println();
        } else {
            //System.out.println();
            System.out.println("cards is null");
        }
    }

    private void checkStraightAgreement(Card[] hand, Card[] straight) {
        System.out.println("checkStraightAgreement");
        System.out.println("hand:");
        showHand(hand);

        if(straight != null) {
            System.out.println("\n\nstraight:");
            showHand(straight);
            System.out.println("HandRanker.checkForStraight(hand) = " +HandRanker.checkForStraight(hand));
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
            System.out.println(card.toString());
        }
    }
}