/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;

/**
 *
 * @author paul
 */
public class Card {

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return this.rank.toString() + " of " + this.suit.toString();
    }
}
