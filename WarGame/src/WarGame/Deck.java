package WarGame;

import java.util.*;

/**
 * Constructor to create a new deck of cards with 52 cards with 4 suites
 * @author Vinicius Rocha
 * @version 1.0.0
 */
public class Deck {

// Variables
    private ArrayList<Card> deck = new ArrayList<Card>();

// Constructor

    /**
     * Construct a deck of cards
     * Created a card object, which are of the following ranks: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)
     * and a suit like: Diamond, Clover, Spades, Hearts
     */
    public Deck () {

         // Create a deck of card with suites
         for (int i = 1; i <= 13; i++) {
             for (int j = 0; j <= 3; j++) {
                 Card c = new Card(i,j);
                 deck.add(c);
                 }
            }
        }

// Other Methods

    /**
     * Uses the .shuffle() method to shuffle the cards in the array
     * Override - This method overrites the shuffle method from the ArrayList class
     */
    public void shuffle () {
        Collections.shuffle(deck);
    }

    /**
     * Deals the card to the users. This method gives the cards to the users one at a time.
     * @param hand1 - takes in a ArrayList that it will put the cards into for the player
     * @param hand2 - takes in a ArrayList that it will put the cards into for the CPU
     */
    public void deal (ArrayList hand1, ArrayList hand2) {
            for (int i = 0; i < deck.size(); i++) {
                hand1.add(deck.get(i));
                i++;
                hand2.add(deck.get(i));
            }
        }

}
