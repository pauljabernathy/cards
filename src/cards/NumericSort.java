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
    public int compare(Card left, Card right) {
        //null is considered less than not null
        //TODO:  unit test nulls
        //TODO:  throw an error message?
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
