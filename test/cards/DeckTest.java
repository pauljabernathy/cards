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

import java.util.ArrayList;

import org.apache.log4j.*;

/**
 *
 * @author paul
 */
public class DeckTest {

    private static Logger logger;
    public DeckTest() {
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        logger = Logger.getLogger(DeckTest.class);
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

    @Test
    public void testInitializeDeck() {
        this.logger.info("\ntesting initializeDeck()");
        Deck deck = new Deck(false);
        deck.initializeDeck(false);
        ArrayList<Card> cards = deck.getCards();
        this.logger.debug("size = " + cards.size());
        for(int i = 4; i < cards.size(); i++) {
            if(Rank.getIntValue(cards.get(i).getRank()) != Rank.getIntValue(cards.get(i - 4).getRank()) + 1) {
                this.logger.debug(cards.get(i));
                this.logger.debug(cards.get(i - 4));
                fail("cards out of order");
            }
        }
        assertEquals(52, cards.size());
        
        deck.initializeDeck(true);
        //assertEquals(54, deck.getCards().size());
    }

    @Test
    public void testDeal() {
        logger.info("\ntesting deal()");
        Deck instance = new Deck(false);

        ArrayList<Card> cardsInDeck = instance.getCards();
        this.logger.debug("original deck:");
        for(int i = 0; i < cardsInDeck.size(); i++) {
            this.logger.debug(cardsInDeck.get(i));
        }
        
        ArrayList<Card> hand = instance.deal(3);
        this.logger.debug("hand.size() = " + hand.size());
        this.logger.debug("deck size = " + cardsInDeck.size());

        this.logger.debug("my hand:");
        for(int i = 0; i < hand.size(); i++) {
            this.logger.debug(hand.get(i));
        }
        this.logger.debug("cards remaining in deck:");
        for(int i = 0; i < cardsInDeck.size(); i++) {
            this.logger.debug(cardsInDeck.get(i));
        }
    }

    /**
     *
     */
    @Test
    public void testShuffle() {
        this.logger.info("\ntesting shuffle()");
        Deck instance = new Deck(false);
        instance.initializeDeck(false);

        ArrayList<Card> cardsInDeck = instance.getCards();
        this.logger.debug("original deck:");
        for(int i = 0; i < cardsInDeck.size(); i++) {
            this.logger.debug(cardsInDeck.get(i));
        }

        instance.shuffle();

        cardsInDeck = instance.getCards();
        this.logger.debug("\n\n\nafter shuffle:");
        for(int i = 0; i < cardsInDeck.size(); i++) {
            this.logger.debug(cardsInDeck.get(i));
        }
    }
    
    //TODO:  method for determining how out of order a deck is
}