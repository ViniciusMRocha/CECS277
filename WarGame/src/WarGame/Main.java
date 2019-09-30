package WarGame;

import java.util.ArrayList;

/**
 * Models a card game called war. In this game users play a card from their deck of cards whoever has the higher card wins both cards.
 * If there is a tie user go to 'War', where they add 3 more cards each to the play and reveal the 4th card. Their 4th card is compared to and the higher cards wins
 * If a player loses a round, they may chose to play a second card, which summed to their original card will be compared to the opponents card.
 * @author Vinicius Rocha
 * @version 1.0.0
 * **/

public class Main {

        /**
         * Run the War game
         * @param args
         */
        public static void main(String[] args) {

            /**
             * Creates a new deck of cards containing 52 cards with 4 suites
             */
            Deck d = new Deck();

            /**
             * Shuffles the deck of cards
             */
            d.shuffle();


            /**
             * Creates hands for the players to use on the game
             */
            ArrayList<Card> player1 = new ArrayList<Card>();
            ArrayList<Card> player2 = new ArrayList<Card>();

            /**
             * Deal the shuffled cards to each user
             */
            d.deal(player1,player2);

            /**
             * Start a new game
             */
            new Game(player1,player2);

        }
}
