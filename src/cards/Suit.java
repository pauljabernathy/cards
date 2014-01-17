/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;
import java.util.HashMap;
import java.lang.Integer;

/**
 *
 * @author paul
 */
public enum Suit {
    //SPADES(0), HEARTS(1), DIAMONDS(2), CLUBS(3);
    SPADES, HEARTS, DIAMONDS, CLUBS;


    public static final int SPADES_VALUE = 0;
    public static final int HEARTS_VALUE = 1;
    public static final int DIAMONDS_VALUE = 2;
    public static final int CLUBS_VALUE = 3;

    public static HashMap<Suit, Integer> intValues;
    static {
        intValues = new HashMap<Suit, Integer>();
        intValues.put(Suit.SPADES, Suit.SPADES_VALUE);
        intValues.put(Suit.HEARTS, Suit.HEARTS_VALUE);
        intValues.put(Suit.DIAMONDS, Suit.DIAMONDS_VALUE);
        intValues.put(Suit.CLUBS, Suit.CLUBS_VALUE);
    }

    public static Suit getSuit(int suit) {
        switch(suit) {
            case SPADES_VALUE:
                return Suit.SPADES;
            case HEARTS_VALUE:
                return Suit.HEARTS;
            case DIAMONDS_VALUE:
                return Suit.DIAMONDS;
            case CLUBS_VALUE:
                return Suit.CLUBS;
            default:
                return Suit.SPADES; //need better error handling
        }
    }

    public static int getIntValue(Suit suit) {
        return intValues.get(suit).intValue();
    }
}
