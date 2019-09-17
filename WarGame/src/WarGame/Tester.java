package WarGame;

import java.util.*;

public class Tester {


    public static void main(String[] args) {
        System.out.println("TESTER");

        /**
         * Variables
         *
         */

        // Deck of cards
        Deck d = new Deck();

        // Payers decks
        ArrayList<Card> player1 = new ArrayList<Card>();
        ArrayList<Card> player2 = new ArrayList<Card>();

        // Deal the cards
        d.deal(player1,player2);

        // Create a game
        Game war = new Game(player1,player2);

        // Start the game
        war.playWar(player1,player2);

    }
}
