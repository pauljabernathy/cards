/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;
import java.util.Comparator;

/**
 *
 * @author paul
 */
public class SuitSort implements Comparator<Card> {

    public int compare(Card left, Card right) {
        
        if(left == null && right == null) {
            return 0;
        } else if(left == null && right != null) {
            return 1;
        } else if(left != null && right == null) {
            return -1;
        }

        int leftValue = Suit.getIntValue(left.getSuit());
        int rightValue = Suit.getIntValue(right.getSuit());

        if(leftValue < rightValue) {
            return -1;
        } else if(leftValue == rightValue) {
            return 0;
        } else {
            return 1;
        }
    }
}
