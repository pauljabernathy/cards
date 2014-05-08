/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import java.util.HashMap;

/**
 *
 * @author paul
 */
public enum Hand {
    ROYAL_FLUSH, STRAIGHT_FLUSH, FOUR_OF_A_KIND, FULL_HOUSE, FLUSH, STRAIGHT, THREE_OF_A_KIND, TWO_PAIRS, ONE_PAIR, HIGH_CARD;
    
    public static final String ROYAL_FLUSH_STR = "Royal Flush";
    public static final String STRAIGHT_FLUSH_STR = "STRAIGHT_FLUSH";
    public static final String FOUR_OF_A_KIND_STR = "Four of a Kind";
    public static final String FULL_HOUSE_STR = "Full House";
    public static final String FLUSH_STR = "Flush";
    public static final String STRAIGHT_STR = "Straight";
    public static final String THREE_OF_A_KIND_STR = "Three of a Kind";
    public static final String TWO_PAIRS_STR = "Two Pairs";
    public static final String ONE_PAIR_STR = "One Pair";
    public static final String HIGH_CARD_STR = "High Card / Nothing";
    
    public static final int ROYAL_FLUSH_INT = 9;
    public static final int STRAIGHT_FLUSH_INT = 8;
    public static final int FOUR_OF_A_KIND_INT = 7;
    public static final int FULL_HOUSE_INT = 6;
    public static final int FLUSH_INT = 5;
    public static final int STRAIGHT_INT = 4;
    public static final int THREE_OF_A_KIND_INT = 3;
    public static final int TWO_PAIRS_INT = 2;
    public static final int ONE_PAIR_INT = 1;
    public static final int HIGH_CARD_INT = 0;
    
    public static final HashMap<Hand, Integer> handValues;
    
    static {
        handValues = new HashMap<Hand, Integer>();
        handValues.put(ROYAL_FLUSH, ROYAL_FLUSH_INT);
        handValues.put(STRAIGHT_FLUSH, STRAIGHT_FLUSH_INT);
        handValues.put(FOUR_OF_A_KIND, FOUR_OF_A_KIND_INT);
        handValues.put(FULL_HOUSE, FULL_HOUSE_INT);
        handValues.put(FLUSH, FLUSH_INT);
        handValues.put(STRAIGHT, STRAIGHT_INT);
        handValues.put(THREE_OF_A_KIND, THREE_OF_A_KIND_INT);
        handValues.put(TWO_PAIRS, TWO_PAIRS_INT);
        handValues.put(ONE_PAIR, ONE_PAIR_INT);
        handValues.put(HIGH_CARD, HIGH_CARD_INT);
    }
    
    public static Hand getHand(int intValue) {
        switch(intValue) {
            case ROYAL_FLUSH_INT:
                return ROYAL_FLUSH;
            case STRAIGHT_FLUSH_INT:
                return STRAIGHT_FLUSH;
            case FOUR_OF_A_KIND_INT:
                return FOUR_OF_A_KIND;
            case FULL_HOUSE_INT:
                return FULL_HOUSE;
            case FLUSH_INT:
                return FLUSH;
            case STRAIGHT_INT:
                return STRAIGHT;
            case THREE_OF_A_KIND_INT:
                return THREE_OF_A_KIND;
            case TWO_PAIRS_INT:
                return TWO_PAIRS;
            case ONE_PAIR_INT:
                return ONE_PAIR;
            case HIGH_CARD_INT:
                return HIGH_CARD;
            default: return HIGH_CARD;
        }
    }
    
    public static int getIntValue(Hand hand) {
        return handValues.get(hand);
    }
}
