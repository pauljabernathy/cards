/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;
import java.util.ArrayList;
import java.security.SecureRandom;
import RandomNumberGenerator.EvenDistributionGenerator;

/**
 *
 * @author paul
 */
public class Deck {

    //private Card[] cards;
    private ArrayList<Card> cards;
    private EvenDistributionGenerator random;

    public Deck(boolean hasJokers) {
        /*if(hasJokers) {
            cards = new Card[54];
        } else {
            cards = new Card[52];
        }*/
        cards = new ArrayList<Card>();
        random = new EvenDistributionGenerator();
        initializeDeck(hasJokers);
    }

    public void initializeDeck(boolean hasJokers) {
        Suit suit = null;
        Rank rank = null;
        cards = new ArrayList<Card>();
        for(int i = 0; i < 52; i++) {
            rank = Rank.getRank(i / 4);
            suit = Suit.getSuit(i % 4);
            //cards[i] = new Card(rank, suit);
            cards.add(new Card(rank, suit));
        }
    }

    public void shuffle() {
        for(int i = 0; i < 5; i++) {
            shuffleOnce();
        }
    }

    private void shuffleOnce() {
        int swapWith = random.getIntInRange(0, 51); //(int)(Math.random() * (cards.size() - 1));
        Card temp = null;
        for(int i = 0; i < cards.size(); i++) {
            swapWith = random.getIntInRange(0, 51); //(int)(Math.random() * (cards.size() - 1));
            //System.out.println("i = " + i + ";  swapWith = " + swapWith);
            while(swapWith == i) {  //don't sawp this with itself
                swapWith = random.getIntInRange(0, 51); //(int)(Math.random() * (cards.size() - 1));
                //System.out.println("i = " + i + ";  swapWith = " + swapWith);
            }
            //System.out.println("swapping " + cards.get(i) + " and " + cards.get(swapWith));
            temp = cards.get(swapWith);
            cards.set(swapWith, cards.get(i));
            cards.set(i, temp);
        }
    }

    public ArrayList getCards() {
        return this.cards;
    }

    //TODO:  need to synchronize?
    public ArrayList<Card> deal(int numberToDeal) {
        ArrayList<Card> toReturn = new ArrayList<Card>();
        for(int i = 0; i < numberToDeal; i++) {
            toReturn.add(cards.get(0));
            cards.remove(0);
        }
        return toReturn;
    }

}
