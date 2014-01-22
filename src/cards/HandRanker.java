/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author paul
 */
public class HandRanker {

    public static final int MIN_NUMBER_OF_CARDS = 5;
    private static final int NUM_RANKS = 9;

    public static int getNumRanks() {
        return NUM_RANKS;
    }
    
    public static boolean checkForPair(Card[] cards) {
        if(cards == null) {
            return false;
        }

       Arrays.sort(cards, new NumericSort());

        /*for(int i = 0; i < cards.length - 1; i++) {
            if(cards[i].getRank() == cards[i + 1].getRank()) {
                return true;
            }
        }*/
        int[] indeces = findPair(cards);
        if(indeces[0] != -1 && indeces[1] != -1) {
            return true;
        }
        return false;
    }

    public static boolean checkForTwoPairs(Card[] cards) {
        if(cards == null) {
            return false;
        }

        Arrays.sort(cards, new NumericSort());
        //first, see if there is one pair
        int[] indeces = findPair(cards);
        //System.out.println("int[] indeces = findPair(cards);");
        if(indeces[0] != -1 && indeces[1] != -1) {
            //System.out.println("if(indeces[0] != -1 && indeces[1] != -1) {");
            //if you found one pair, remove those two cards and look for a second pair
            //Card[] newCards = new Card[cards.length - 2];
            ArrayList<Card> newCards = new ArrayList<Card>();
            for(int i = 0; i < cards.length; i++) {
                if(i != indeces[0] && i != indeces[1]) {
                    newCards.add(cards[i]);
                }
            }
            Card[] newCards2 = new Card[cards.length - 2];

            newCards.toArray(newCards2);
            /*System.out.println("newCards2");
            for(int j = 0; j < newCards2.length; j++) {
                System.out.println(newCards2[j]);
            }*/
            return checkForPair(newCards2);
        }

        return false;

    }

    /**
     * returns the indeces of the input array of the first pair found; if no pair is found, returns { -1, -1 }
     * @param cards - an array that must be sorted
     * @return
     */
    private static int[] findPair(Card[] cards) {
        int[] indeces = new int[] { -1, -1 };

        for(int i = 0; i < cards.length - 1; i++) {
            if(cards[i].getRank() == cards[i + 1].getRank()) {
                return new int[] { i, i + 1};
            }
        }

        return indeces;
    }

    public static boolean checkForThreeOfAKind(Card[] cards) {
        if(cards == null) {
            return false;
        }

        /*System.out.println("\n\nthree of a kind");
        for(Card card: cards) {
            System.out.println(card);
        }*/

        Arrays.sort(cards, new NumericSort());
        for(int i = 0; i < cards.length - 2; i++) {
            if(cards[i].getRank() == cards[i + 1].getRank() && cards[i + 1].getRank() == cards[i + 2].getRank()) {
                //System.out.println("three of a kind is " + cards[i] + " " + cards[i + 1] + " " + cards[i + 2]);
                return true;
            }
        }
        return false;
    }

    public static boolean checkForStraight(Card[] cards) {
        if(cards == null) {
            return false;
        }

        Arrays.sort(cards, new NumericSort());
        for(int i = 0; i < cards.length - 4; i++) { //4 because you need 5 cards for a straight
            if(isStraight(new Card[] { cards[i], cards[i+1], cards[i+2], cards[i+3], cards[i+4] })) {
                return true;
            }
        }

        return false;
    }

    /**
     * returns an array of Cards that are a straight from the input, if the input has a straight
     * @param cards
     * @return
     */
    public static Card[] findStraight(Card[] cards) {
        if(cards == null) {
            return null;
        }
        Arrays.sort(cards, new NumericSort());
        for(int i = 0; i < cards.length - 4; i++) { //4 because you need 5 cards for a straight
            if(isStraight(new Card[] { cards[i], cards[i+1], cards[i+2], cards[i+3], cards[i+4] })) {
                return new Card[] { cards[i], cards[i+1], cards[i+2], cards[i+3], cards[i+4] };
            }
        }
        return null;
    }

    /**
     * Returns try if the given array is a straight.  All cards in this array must be part of the straight for it to return true;
     *This must be a sorted array for a straight to be detected.
     */
    private static boolean isStraight(Card[] cards) {
        for(int i = 0; i < cards.length - 1; i++) {
            if(Rank.getIntValue(cards[i].getRank()) + 1 != Rank.getIntValue(cards[i + 1].getRank())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkForFlush(Card[] cards) {
        if(cards == null) {
            return false;
        }

        Arrays.sort(cards, new SuitSort());
        for(int i = 0; i < cards.length - 4; i++) {
            if(cards[i].getSuit() == cards[i+1].getSuit() && cards[i].getSuit() == cards[i+2].getSuit() && cards[i].getSuit() == cards[i+3].getSuit() && cards[i].getSuit() == cards[i+4].getSuit()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkForFullHouse(Card[] cards) {
        if(cards == null) {
            return false;
        }

        /*System.out.println("\n\ncheck for full house");
        for(Card card: cards) {
            System.out.println(card);
        }*/

        //use findPair
        int[] pairIndeces = findPair(cards);
        if(pairIndeces[0] != -1 && pairIndeces[1] != -1) {
            //if there is a pair, remove it and check for three of a kind
            Card[] pairLess = remove(cards, pairIndeces);
            /*System.out.println("\n\n\nfound a pair; these cards remain:");
            for(Card card : pairLess) {
                System.out.println(card);
            }*/
            if(checkForThreeOfAKind(pairLess)) {
                return true;
            }

        }
        return false;
    }

    public static boolean checkForFourOfAKind(Card[] cards) {
        if(cards == null) {
            return false;
        }

        Arrays.sort(cards, new NumericSort());
        for(int i = 0; i < cards.length - 3; i++) {
            if(cards[i].getRank() == cards[i + 1].getRank() && cards[i + 1].getRank() == cards[i + 2].getRank() && cards[i + 2].getRank() == cards[i + 3].getRank()) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkForStraightFlush(Card[] cards) {
        if(cards == null) {
            return false;
        }

        //find a set of 5 cards that are a straight
        Card[] straight = findStraight(cards);
        if(straight != null) {
            //do checkForFlush
            return checkForFlush(straight);
        }

        return false;
    }
    
    public static boolean checkForRoyalFlush(Card[] cards) {
        if(cards == null) {
            return false;
        }

        //check if the first is 10 or last is Ace
        //find a set of 5 cards that are a straight
        
        //do checkForFlush

        return false;
    }
    
    /**
     * removes the cards at the given indeces from the input array
     * @param cards
     * @param indeces
     */
    private static Card[] remove(Card[] cards, int[] indeces) {
        if(indeces == null) {
            return cards;
        }
        if(cards == null) {
            return null;
        }
        /*System.out.println("\n\nremove");
        for(Card card: cards) {
            System.out.println(card);
        }*/
        
        ArrayList<Card> newCards = new ArrayList<Card>();
        //iterate through cards
        for(int i = 0; i < cards.length; i++) {
            //if the current index is not in indeces, add to newCards
            boolean isPresent = false;
            for(int index = 0; index < indeces.length; index++) {
                if(indeces[index] == i) {
                    //newCards.add(cards[i]);
                    isPresent = true;
                    break;
                }
            }
            if(!isPresent) {
                newCards.add(cards[i]);
            }
        }
        Card[] toReturn = new Card[newCards.size()];
        newCards.toArray(toReturn);

        /*System.out.println("\n\nreturing from remove:");
        for(Card card: toReturn) {
            System.out.println(card);
        }*/

        return toReturn;
    }

}
