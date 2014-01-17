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
public class SimulatorTest {
    
    public SimulatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    public void testIncrementBestResults() {
        System.out.println("\ntesting incrementBestResults()");
        
        Simulator instance = new Simulator();
        Deck deck = new Deck(false);
        deck.shuffle();
        int handSize = 7;
        Card[] hand = new Card[handSize];
        hand[0] = new Card(Rank.ACE, Suit.SPADES);
        hand[1] = new Card(Rank.TWO, Suit.CLUBS);
        hand[2] = new Card(Rank.THREE, Suit.CLUBS);
        hand[3] = new Card(Rank.FOUR, Suit.SPADES);
        hand[4] = new Card(Rank.SIX, Suit.DIAMONDS);
        hand[5] = new Card(Rank.KING, Suit.HEARTS);
        hand[6] = new Card(Rank.ACE, Suit.CLUBS);
        
        int results[] = null;
        results = instance.incrementBestResults(hand, results);
        assertArrayEquals(new int[] { 0, 1, 0, 0, 0, 0, 0, 0, 0}, results);
        
        results = instance.incrementBestResults(null, results);
        assertArrayEquals(new int[] { 1, 1, 0, 0, 0, 0, 0, 0, 0}, results); //increments the "nothing" or "high card" slot because null hands are treated as being in the "high card" category
        
        results = instance.incrementBestResults(hand, results);
        assertArrayEquals(new int[] { 1, 2, 0, 0, 0, 0, 0, 0, 0}, results);
        
        
        hand = new Card[handSize];
        hand[0] = new Card(Rank.ACE, Suit.SPADES);
        hand[1] = new Card(Rank.TWO, Suit.CLUBS);
        hand[2] = new Card(Rank.THREE, Suit.CLUBS);
        hand[3] = new Card(Rank.FOUR, Suit.SPADES);
        hand[4] = new Card(Rank.SIX, Suit.DIAMONDS);
        hand[5] = new Card(Rank.FIVE, Suit.HEARTS);
        hand[6] = new Card(Rank.ACE, Suit.CLUBS);
        
        results = null;
        results = instance.incrementBestResults(hand, results);
        assertArrayEquals(new int[] { 0, 0, 0, 0, 1, 0, 0, 0, 0}, results);
        
        results = instance.incrementBestResults(null, results);
        assertArrayEquals(new int[] { 1, 0, 0, 0, 1, 0, 0, 0, 0}, results); //increments the "nothing" or "high card" slot because null hands are treated as being in the "high card" category
        
        results = instance.incrementBestResults(hand, results);
        assertArrayEquals(new int[] { 1, 0, 0, 0, 2, 0, 0, 0, 0}, results);
    }
    
    @Test
    public void testIncrementAllResults() {
        System.out.println("\ntesting incrementAllResults()");
        
        Simulator instance = new Simulator();
        Deck deck = new Deck(false);
        deck.shuffle();
        int handSize = 7;
        Card[] hand = new Card[handSize];
        hand[0] = new Card(Rank.ACE, Suit.SPADES);
        hand[1] = new Card(Rank.TWO, Suit.CLUBS);
        hand[2] = new Card(Rank.THREE, Suit.CLUBS);
        hand[3] = new Card(Rank.FOUR, Suit.SPADES);
        hand[4] = new Card(Rank.SIX, Suit.DIAMONDS);
        hand[5] = new Card(Rank.FIVE, Suit.HEARTS);
        hand[6] = new Card(Rank.ACE, Suit.CLUBS);
        
        int results[] = null;
        results = instance.incrementAllResults(hand, results);
        assertArrayEquals(new int[] { 0, 1, 0, 0, 1, 0, 0, 0, 0}, results);
        
        results = instance.incrementAllResults(null, results);
        assertArrayEquals(new int[] { 1, 1, 0, 0, 1, 0, 0, 0, 0}, results); //increments the "nothing" or "high card" slot because null hands are treated as being in the "high card" category
        
        results = instance.incrementAllResults(hand, results);
        assertArrayEquals(new int[] { 1, 2, 0, 0, 2, 0, 0, 0, 0}, results);
    }
}