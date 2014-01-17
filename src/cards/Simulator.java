/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;

import java.util.ArrayList;
import org.apache.log4j.*;
import java.util.Date;

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
        /*Deck deck = new Deck(false);
        ArrayList<Card> deal = new ArrayList<Card>();


        //deal a specified number of times, keeping track of numerical total for rank and suit
        int numRuns = 5;
        int numCardsPerDeal = 5;
        int rankTotal = 0;
        int suitTotal = 0;
        for(int i = 0; i < numRuns; i++) {
            deal = deck.deal(numCardsPerDeal);
            rankTotal += 0;
        }
        //divide rank and suit by number of runs, display average*/

        Simulator main = new Simulator();
        main.doSimulation(100000);
        main.doOnePairSim(2500);
    }

    public Simulator() {
        this.logger = this.createBasicLogger();
        this.timestampLogger = this.createTimeStampLogger();
    }
    public void doSimulation(int numRuns) {
        timestampLogger.info("starting simulation");
        Deck deck = new Deck(false);
        logger.info("deck.size() = " + deck.getCards().size());
        int[] bestResults = new int[10];
        int[] allResults = new int[10];
        int[] suits = new int[4];
        int[] ranks = new int[13];
        int handSize = 7;
        //int numRuns = 1000;
        int suit = -1;
        int rank = -1;
        ArrayList<Card> handAL = new ArrayList<Card>();
        Card[] hand = new Card[handSize];
        for(int runNum = 0; runNum < numRuns; runNum++) {
            if(numRuns % 1000 == 0) {
            logger.debug("\n\n\n\nrun " + runNum);
            }
            deck.initializeDeck(true);
            deck.shuffle();
            handAL = deck.deal(handSize);
            handAL.toArray(hand);

            for(Card card: hand) {
                //System.out.println(card.toString());
                suit = Suit.getIntValue(card.getSuit());
                suits[suit]++;
                rank = Rank.getIntValue(card.getRank());
                ranks[rank]++;
            }
            //showHand(hand, logger);
            bestResults = this.incrementBestResults(hand, bestResults);
            allResults = this.incrementAllResults(hand, allResults);
        }

        logger.info("best results:\n");
        showResults(bestResults, numRuns);
        
        logger.info("\n\nall results:\n");
        showResults(allResults, numRuns);
        
        
        logger.info("\n\nThese are the counts of the ranks and suits:");
        logger.info("suit");
        for(suit = 0; suit < 4; suit++) {
            logger.info(suits[suit] + "  " + Suit.getSuit(suit));
        }
        logger.info("suit");
        for(rank = 0; rank < 13; rank++) {
            logger.info(ranks[rank] + "  " + Rank.getRank(rank));
        }
        timestampLogger.info("ending simulation");
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

    private void showHand(Card[] hand, Logger logger) {
        for(Card card: hand) {
            logger.debug(card.toString());
        }
    }
    
    protected int[] incrementBestResults(Card[] hand, int[] results) {
        if(results == null) {
            results = new int[NUM_RANKS];
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
    
    private void showResults(int[] results, int numRuns) {
        System.out.println("High Card:  " + results[0] + "   " + (((double)results[0]) / numRuns) * 100.0 + "%");
        System.out.println("One Pair:  " + results[1] + "   " + (((double)results[1]) / numRuns) * 100.0 + "%");
        System.out.println("Two Pairs:  " + results[2] + "   " + (((double)results[2]) / numRuns) * 100.0 + "%");
        System.out.println("Three of a Kind:  " + results[3] + "   " + (((double)results[3]) / numRuns) * 100.0 + "%");
        System.out.println("Straight:  " + results[4] + "   " + (((double)results[4]) / numRuns) * 100.0 + "%");
        System.out.println("Flush:  " + results[5] + "   " + (((double)results[5]) / numRuns) * 100.0 + "%");
        System.out.println("Full House:  " + results[6] + "   " + (((double)results[6]) / numRuns) * 100.0 + "%");
        System.out.println("Four of a Kind:  " + results[7] + "   " + (((double)results[7]) / numRuns) * 100.0 + "%");
        System.out.println("Straight Flush:  " + results[8] + "   " + (((double)results[8]) / numRuns) * 100.0 + "%");
        System.out.println("Royal Flush:  " + results[9] + "   " + (((double)results[9]) / numRuns) * 100.0 + "%");
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
            //System.out.println("\n\n\n\nrun " + runNum);
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
}
