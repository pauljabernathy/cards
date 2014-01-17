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

/**
 *
 * @author paul
 */
public class DeckTest {

    public DeckTest() {
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

    @Test
    public void testInitializeDeck() {
        System.out.println("\ntesting initializeDeck()");
        Deck deck = new Deck(false);
        deck.initializeDeck(false);
        ArrayList<Card> cards = deck.getCards();
        System.out.println("size = " + cards.size());
        for(int i = 4; i < cards.size(); i++) {
            if(Rank.getIntValue(cards.get(i).getRank()) != Rank.getIntValue(cards.get(i - 4).getRank()) + 1) {
                System.out.println(cards.get(i));
                System.out.println(cards.get(i - 4));
                fail("cards out of order");
            }
        }
        assertEquals(52, cards.size());
    }

    //@Test
    public void testDeal() {
        System.err.println("deal");
        Deck instance = new Deck(false);

        ArrayList<Card> cardsInDeck = instance.getCards();
        System.out.println("original deck:");
        for(int i = 0; i < cardsInDeck.size(); i++) {
            System.out.println(cardsInDeck.get(i));
        }
        
        ArrayList<Card> hand = instance.deal(3);
        System.out.println("hand.size() = " + hand.size());
        System.out.println("deck size = " + cardsInDeck.size());

        System.out.println("my hand:");
        for(int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i));
        }
        System.out.println("cards remaining in deck:");
        for(int i = 0; i < cardsInDeck.size(); i++) {
            System.out.println(cardsInDeck.get(i));
        }
    }

    /**
     *
     */
    //@Test
    public void testShuffle() {
        System.out.println("shuffle");
        Deck instance = new Deck(false);
        instance.initializeDeck(false);

        ArrayList<Card> cardsInDeck = instance.getCards();
        System.out.println("original deck:");
        for(int i = 0; i < cardsInDeck.size(); i++) {
            System.out.println(cardsInDeck.get(i));
        }

        instance.shuffle();

        cardsInDeck = instance.getCards();
        System.out.println("\n\n\nafter shuffle:");
        for(int i = 0; i < cardsInDeck.size(); i++) {
            System.out.println(cardsInDeck.get(i));
        }
    }
    
    //TODO:  method for determining how out of order a deck is
}