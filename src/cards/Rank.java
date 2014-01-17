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
public enum Rank {

    //TWO(0), THREE(1), FOUR(2), FIVE(3), SIX(4), SEVEN(5), EIGHT(6), NINE(7), TEN(8), JACK(9), QUEEN(10), KING(11), ACE(12);
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

    public static final int TWO_VALUE = 0;
    public static final int THREE_VALUE = 1;
    public static final int FOUR_VALUE = 2;
    public static final int FIVE_VALUE = 3;
    public static final int SIX_VALUE = 4;
    public static final int SEVEN_VALUE = 5;
    public static final int EIGHT_VALUE = 6;
    public static final int NINE_VALUE = 7;
    public static final int TEN_VALUE = 8;
    public static final int JACK_VALUE = 9;
    public static final int QUEEN_VALUE = 10;
    public static final int KING_VALUE = 11;
    public static final int ACE_VALUE = 12;

    public static HashMap<Rank, Integer> intValues;
    static {
        intValues = new HashMap<Rank, Integer>();
        intValues.put(Rank.TWO, Rank.TWO_VALUE);
        intValues.put(Rank.THREE, Rank.THREE_VALUE);
        intValues.put(Rank.FOUR, Rank.FOUR_VALUE);
        intValues.put(Rank.FIVE, Rank.FIVE_VALUE);
        intValues.put(Rank.SIX, Rank.SIX_VALUE);
        intValues.put(Rank.SEVEN, Rank.SEVEN_VALUE);
        intValues.put(Rank.EIGHT, Rank.EIGHT_VALUE);
        intValues.put(Rank.NINE, Rank.NINE_VALUE);
        intValues.put(Rank.TEN, Rank.TEN_VALUE);
        intValues.put(Rank.JACK, Rank.JACK_VALUE);
        intValues.put(Rank.QUEEN, Rank.QUEEN_VALUE);
        intValues.put(Rank.KING, Rank.KING_VALUE);
        intValues.put(Rank.ACE, Rank.ACE_VALUE);

    }
    public static Rank getRank(int rank) {
        switch(rank) {
            case TWO_VALUE:
                return Rank.TWO;
            case THREE_VALUE:
                return Rank.THREE;
            case FOUR_VALUE:
                return Rank.FOUR;
            case FIVE_VALUE:
                return Rank.FIVE;
            case SIX_VALUE:
                return Rank.SIX;
            case SEVEN_VALUE:
                return Rank.SEVEN;
            case EIGHT_VALUE:
                return Rank.EIGHT;
            case NINE_VALUE:
                return Rank.NINE;
            case TEN_VALUE:
                return Rank.TEN;
            case JACK_VALUE:
                return Rank.JACK;
            case QUEEN_VALUE:
                return Rank.QUEEN;
            case KING_VALUE:
                return Rank.KING;
            case ACE_VALUE:
                return Rank.ACE;
            default:
                return Rank.TWO;
        }
    }

    public static int getIntValue(Rank rank) {
        return intValues.get(rank).intValue();
    }
}
