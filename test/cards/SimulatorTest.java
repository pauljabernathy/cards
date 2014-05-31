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
import toolbox.Utilities;
import toolbox.stats.ProbDist;

/**
 *
 * @author paul
 */
public class SimulatorTest {
    
    private static Logger logger;
    
    public SimulatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        logger = Logger.getLogger(SimulatorTest.class);
        logger.addAppender(new ConsoleAppender(new PatternLayout("%m%n")));
        logger.setLevel(Level.DEBUG);
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
        logger.info("\ntesting incrementBestResults()");
        
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
        logger.info("\ntesting incrementAllResults()");
        
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
    
    @Test
    public void testGetTheoreticalProbabilities() {
        logger.info("\ntesting getTheoreticalProbabilities()");
        Simulator instance = new Simulator();
        ProbDist<Hand> p = null;
        p = instance.getTheoreticalProbabilities();
        for(Hand h : p.getValues()) {
            logger.debug(h);
        }
        for(int i = 0; i < p.getProbabilities().size(); i++) {
            logger.debug(p.getValue(i) + " " + p.getProbabilities().get(i) + " " + p.getValues().get(i));
        }
        logger.debug("values.size() = " + p.getValues().size());
        logger.debug("probs.size() = " + p.getProbabilities().size());
        //assertEquals(10, p.getProbabilities().size());
        double sum = Utilities.sum(p.getProbabilities());
        assertEquals(1.0, sum, .00001);
        logger.debug("sum = " + sum);
        logger.debug(p.toString());
    }
}