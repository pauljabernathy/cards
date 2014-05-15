/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;
import java.util.Date;

import toolbox.stats.*;

/**
 *
 * @author paul
 */
public class Simulator {

    private Logger logger;
    private Logger timestampLogger;
    private static final int NUM_RANKS = HandRanker.getNumRanks();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Simulator sim = new Simulator();
        sim.setLogLevel(Level.INFO);
        int numDeals = 90000;
        List<Histogram> hists = sim.doSimulation(numDeals);
        //sim.doOnePairSim(2500);
        showResults(hists, sim.getLogger());
    }

    public Simulator() {
        this.logger = this.createBasicLogger();
        this.timestampLogger = this.createTimeStampLogger();
    }
    
    public List<Histogram> doSimulation(int numRuns) {
        //timestampLogger.info("starting simulation");
        logger.info("");
        Deck deck = new Deck(false);
        logger.debug("deck.size() = " + deck.getCards().size());
        int[] bestResults = new int[10];
        int[] allResults = new int[10];
        int[] suits = new int[4];
        int[] ranks = new int[13];
        int handSize = 7;
        int suit = -1;
        int rank = -1;
        ArrayList<Card> handAL = new ArrayList<Card>();
        Card[] hand = new Card[handSize];
        for(int runNum = 0; runNum < numRuns; runNum++) {
            if(runNum % 10000 == 0) {
                logger.debug(runNum + " hands dealt");
            }
            deck.initializeDeck(true);
            deck.shuffle();
            handAL = deck.deal(handSize);
            handAL.toArray(hand);

            for(Card card: hand) {
                suit = Suit.getIntValue(card.getSuit());
                suits[suit]++;
                rank = Rank.getIntValue(card.getRank());
                ranks[rank]++;
            }
            //showHand(hand, logger);
            bestResults = this.incrementBestResults(hand, bestResults);
            allResults = this.incrementAllResults(hand, allResults);
        }
        Histogram bestHands = new Histogram();
        Histogram allHands = new Histogram();
        Histogram allSuits = new Histogram();
        Histogram allRanks = new Histogram();
        try {
            bestHands = new Histogram(new Hand[] { Hand.HIGH_CARD, Hand.ONE_PAIR, Hand.TWO_PAIRS, Hand.THREE_OF_A_KIND, Hand.STRAIGHT, Hand.FLUSH, Hand.FULL_HOUSE,  Hand.FOUR_OF_A_KIND, Hand.STRAIGHT_FLUSH, Hand.ROYAL_FLUSH }, bestResults);
            bestHands.setLabel("Best Results Histogram");
            logger.debug("\nbest results histogram");
            logger.debug(bestHands.toString());
        } catch(ProbabilityException e) {
            logger.error(e.getClass() + " in doSimulation():  " + e.getMessage());
        }
        
        try {
            allHands = new Histogram(new Hand[] { Hand.HIGH_CARD, Hand.ONE_PAIR, Hand.TWO_PAIRS, Hand.THREE_OF_A_KIND, Hand.STRAIGHT, Hand.FLUSH, Hand.FULL_HOUSE,  Hand.FOUR_OF_A_KIND, Hand.STRAIGHT_FLUSH, Hand.ROYAL_FLUSH }, allResults);
            allHands.setLabel("All Results Histogram");
            logger.debug("\nall results histogram");
            logger.debug(allHands.toString());
        } catch(ProbabilityException e) {
            logger.error(e.getClass() + " in doSimulation():  " + e.getMessage());
        }
        
        try {
            allSuits = new Histogram(new Suit[] { Suit.SPADES, Suit.HEARTS, Suit.DIAMONDS, Suit.CLUBS }, suits);
            allSuits.setLabel("Suits Histogram");
            logger.debug("\nsuits histogram");
            logger.debug(allSuits.toString());
        } catch(ProbabilityException e) {
            logger.error(e.getClass() + " in doSimulation():  " + e.getMessage());
        }
        
        try {
            allRanks = new Histogram(new Rank[] { Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE }, ranks);
            allRanks.setLabel("Ranks Histogram");
            logger.debug("\nranks histogram");
            logger.debug(allRanks.toString());
        } catch(ProbabilityException e) {
            logger.error(e.getClass() + " in doSimulation():  " + e.getMessage());
        }
        
        List<Histogram> hists = new ArrayList<Histogram>();
        hists.add(bestHands);
        hists.add(allHands);
        hists.add(allSuits);
        hists.add(allRanks);
        
        //timestampLogger.info("ending simulation");
        return hists;
    }
    
    private Logger createBasicLogger() {
        Logger logger = Logger.getLogger(this.getClass() + " basic");
        logger.setLevel(Level.DEBUG);
        logger.addAppender(new ConsoleAppender(new PatternLayout("%m%n")));
        return logger;
    }

    private Logger createTimeStampLogger() {
        Logger logger = Logger.getLogger(this.getClass() + " timestamp");
        logger.setLevel(Level.DEBUG);
        logger.addAppender(new ConsoleAppender(new PatternLayout("%d{dd MMM yyyy HH:mm:ss,SSS} %-5p [%t]: %m%n")));
        return logger;
    }

    public Logger getLogger() {
        return this.logger;
    }
    
    public void addAppender(Appender appender) {
        this.logger.addAppender(appender);
        this.timestampLogger.addAppender(appender);
    }
    
    public void setLogLevel(Level level) {
        this.logger.setLevel(level);
        this.timestampLogger.setLevel(level);
    }
    
    private void showHand(Card[] hand, Logger logger) {
        for(Card card: hand) {
            logger.debug(card.toString());
        }
    }
    
    protected int[] incrementBestResults(Card[] hand, int[] results) {
        if(results == null) {
            results = new int[NUM_RANKS];
        }
        if(HandRanker.checkForRoyalFlush(hand)) {
            results[9]++;
        }
        if(HandRanker.checkForStraightFlush(hand)) {
            results[8]++;
        } else if(HandRanker.checkForFourOfAKind(hand)) {
            results[7]++;
        } else if(HandRanker.checkForFullHouse(hand)) {
            results[6]++;
        } else if(HandRanker.checkForFlush(hand)) {
            results[5]++;
        } else if(HandRanker.checkForStraight(hand)) {
            results[4]++;
        } else if(HandRanker.checkForThreeOfAKind(hand)) {
            results[3]++;
        } else if(HandRanker.checkForTwoPairs(hand)) {
            results[2]++;
        } else if(HandRanker.checkForPair(hand)) {
            results[1]++;
        } else {
            results[0]++;
        }
        return results;
    }
    
    protected int[] incrementAllResults(Card[] hand, int[] results) {
        if(results == null) {
            results = new int[NUM_RANKS];
        }
        boolean foundSomething = false;
        if(HandRanker.checkForStraightFlush(hand)) {
            results[8]++;
            foundSomething = true;
        } if(HandRanker.checkForFourOfAKind(hand)) {
            results[7]++;
            foundSomething = true;
        } if(HandRanker.checkForFullHouse(hand)) {
            results[6]++;
            foundSomething = true;
        } if(HandRanker.checkForFlush(hand)) {
            results[5]++;
            foundSomething = true;
        } if(HandRanker.checkForStraight(hand)) {
            results[4]++;
            foundSomething = true;
        } if(HandRanker.checkForThreeOfAKind(hand)) {
            results[3]++;
            foundSomething = true;
        } if(HandRanker.checkForTwoPairs(hand)) {
            results[2]++;
            foundSomething = true;
        } if(HandRanker.checkForPair(hand)) {
            results[1]++;
            foundSomething = true;
        } if(!foundSomething) {
            results[0]++;
        }
        return results;
    }
    
    public static void showResults(List<Histogram> hists, Logger logger) {
        for(Histogram hist : hists) {
            logger.info("\n" + hist.toString());
        }
    }
    
    private void showResults(int[] results, int numRuns) {
        this.logger.info("High Card:  " + results[0] + "   " + (((double)results[0]) / numRuns) * 100.0 + "%");
        this.logger.info("One Pair:  " + results[1] + "   " + (((double)results[1]) / numRuns) * 100.0 + "%");
        this.logger.info("Two Pairs:  " + results[2] + "   " + (((double)results[2]) / numRuns) * 100.0 + "%");
        this.logger.info("Three of a Kind:  " + results[3] + "   " + (((double)results[3]) / numRuns) * 100.0 + "%");
        this.logger.info("Straight:  " + results[4] + "   " + (((double)results[4]) / numRuns) * 100.0 + "%");
        this.logger.info("Flush:  " + results[5] + "   " + (((double)results[5]) / numRuns) * 100.0 + "%");
        this.logger.info("Full House:  " + results[6] + "   " + (((double)results[6]) / numRuns) * 100.0 + "%");
        this.logger.info("Four of a Kind:  " + results[7] + "   " + (((double)results[7]) / numRuns) * 100.0 + "%");
        this.logger.info("Straight Flush:  " + results[8] + "   " + (((double)results[8]) / numRuns) * 100.0 + "%");
        this.logger.info("Royal Flush:  " + results[9] + "   " + (((double)results[9]) / numRuns) * 100.0 + "%");
    }
    
    public void doOnePairSim(int numRuns) {
        Deck deck = new Deck(false);
        int[] results = new int[10];
        int handSize = 7;
        ArrayList<Card> handAL = new ArrayList<Card>();
        Card[] hand = new Card[handSize];
        Date now = new Date();
        long previousMillis = now.getTime();
        long currentMillis = now.getTime();
        for(int runNum = 0; runNum < numRuns; runNum++) {
            //this.logger.debug("\n\n\n\nrun " + runNum);
            if(runNum % 100 == 0) {
                logger.debug("rum " + runNum);
            }
            deck.initializeDeck(true);
            deck.shuffle();
            handAL = deck.deal(handSize);
            handAL.toArray(hand);
            
            if(HandRanker.checkForPair(hand)) {
                results[1]++;
            }
            if(runNum % 100 == 0) {
                currentMillis =  new Date().getTime();
                //logger.debug(millis + "  " + previousMillis);
                logger.debug(currentMillis - previousMillis);
                previousMillis = currentMillis;
            }
        }
        
        logger.info("# of pairs = " + results[1] + ";  " + (double)results[1] / (double)numRuns + "%");
    }
    
    public ProbDist<Hand> getTheoreticalProbabilities() {
        ProbDist<Hand> p = new ProbDist<Hand>();
        /*p.add(Hand.ROYAL_FLUSH, Constants.ROYAL_FLUSH_PROB);
        p.add(Hand.STRAIGHT_FLUSH, Constants.STRAIGHT_FLUSH_PROB);
        p.add(Hand.FOUR_OF_A_KIND, Constants.FOUR_OF_A_KIND_PROB);
        p.add(Hand.FULL_HOUSE, Constants.FULL_HOUSE_PROB);
        p.add(Hand.FLUSH, Constants.FLUSH_PROB);
        p.add(Hand.STRAIGHT, Constants.STRAIGH_PROB);
        p.add(Hand.THREE_OF_A_KIND, Constants.THREE_OF_A_KIND_PROB);
        p.add(Hand.TWO_PAIRS, Constants.TWO_PAIRS_PROB);
        p.add(Hand.ONE_PAIR, Constants.ONE_PAIR_PROB);
        p.add(Hand.HIGH_CARD, Constants.HIGH_CARD_PROB);*/
        p.add(Hand.HIGH_CARD, Constants.HIGH_CARD_PROB);
        p.add(Hand.ONE_PAIR, Constants.ONE_PAIR_PROB);
        p.add(Hand.TWO_PAIRS, Constants.TWO_PAIRS_PROB);
        p.add(Hand.THREE_OF_A_KIND, Constants.THREE_OF_A_KIND_PROB);
        p.add(Hand.STRAIGHT, Constants.STRAIGHT_PROB);
        p.add(Hand.FLUSH, Constants.FLUSH_PROB);
        p.add(Hand.FULL_HOUSE, Constants.FULL_HOUSE_PROB);
        p.add(Hand.FOUR_OF_A_KIND, Constants.FOUR_OF_A_KIND_PROB);
        p.add(Hand.STRAIGHT_FLUSH, Constants.STRAIGHT_FLUSH_PROB);
        p.add(Hand.ROYAL_FLUSH, Constants.ROYAL_FLUSH_PROB);
        p.setLabel("Theortical Probabilities");
        return p;
    }
}
