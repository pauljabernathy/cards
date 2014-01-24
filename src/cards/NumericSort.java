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
public class NumericSort implements Comparator<Card> {
    
    /**
     * compares the two cards based on the rank (that is, the number or royalty), with Ace being the highest; a null is considered lower than any non null card
     * @param left
     * @param right
     * @return 
     */
    public int compare(Card left, Card right) {
        if(left == null && right == null) {
            return 0;
        } else if(left == null && right != null) {
            return -1;
        } else if(left != null && right == null) {
            return 1;
        }
        int leftValue = Rank.getIntValue(left.getRank());
        int rightValue = Rank.getIntValue(right.getRank());
        if(leftValue < rightValue) {
            return -1;
        } else if(leftValue == rightValue) {
            return 0;
        } else {
            return 1;
        }
    }
}
