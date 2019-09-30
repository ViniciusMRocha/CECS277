package WarGame;

/**
 * Creates a card object with a rank and a suit
 * @author Vinicius Rocha
 * @version 1.0.0
 */
public class Card{
    public int rank;
    public String suit;

    /**
     * Construct a card
     * @param rankValue - takes in an integer that represents the rank. Integer goes from 1 - 13
     * @param suitValue - takes in an integer that represents the suit. Integer goes from 0 - 3
     */
    public Card(int rankValue, int suitValue) {
        rank=rankValue;

        if (suitValue == 0) {
            // Spades
            suit = "\u2660";
        }
        else if (suitValue == 1) {
            // Clover
            suit = "\u2663";
        }
        else if (suitValue == 2) {
            // Hearts
            suit = "\u2665";
        }
        else if (suitValue == 3) {
            // Diamond
            suit = "\u2666";
        }
    }

    /**
     * Override the toSting Method to be able to pring a card object with its rank and suit as a string
     * @return the string of a card object containing a rank and a suit
     */
    public String toString() {

        if (rank==1){
            return "A" + "" +suit;
        }
        else if (rank==11){
            return "J" + "" +suit;
        }
        else if (rank==12){
            return "Q" + "" +suit;
        }
        else if (rank==13){
            return "K" + "" +suit;
        } else {
            return rank + "" +suit;
        }


    }

    /**
     * This method gets the rank of a card object, so it can be compared to other cards.
     * @return the rank of a card object as an integer
     */
    public int getRank () {return rank;}
}