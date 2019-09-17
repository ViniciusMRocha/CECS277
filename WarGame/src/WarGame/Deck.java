package WarGame;

import java.lang.reflect.Array;
import java.util.*;

public class Deck {
     /**
      * Variables
      *
      */
     private ArrayList<Card> deck = new ArrayList<Card>();
     private ArrayList<String> suit = new ArrayList<String>();


     /**
      * Constructor
      */

     public Deck () {

         // Add suites for in the suites array list
         suit.add("\u2660");
         suit.add("\u2663");
         suit.add("\u2665");
         suit.add("\u2666");

         System.out.println("Created Shuffled Deck");

         // Create a deck of card with suites
         for (int i = 1; i <= 13; i++) {
             for (int j = 0; j <= 3; j++) {
                 String str1 = Integer.toString(i);

                 // creating the face cards
                 if (i == 11) {
                     // creating Joker
                     str1 ="J";
                     Card jc = new Card (str1,suit.get(j));
                     deck.add(jc);
                     // Debug:
                     // System.out.println(jc.toString());
                 } else if (i == 12) {
                     // creating Queen
                     str1 ="Q";
                     Card qc = new Card (str1,suit.get(j));
                     deck.add(qc);
                     // Debug:
                     // System.out.println(qc.toString());
                 } else if (i == 13) {
                     // creating King
                     str1 ="K";
                     Card kc = new Card (str1,suit.get(j));
                     deck.add(kc);
                     // Debug:
                     // System.out.println(kc.toString());
                 } else if (i == 1) {
                     // creating Ace
                     str1 ="A";
                     Card ac = new Card (str1,suit.get(j));
                     deck.add(ac);
                     // Debug:
                     // System.out.println(ac.toString());
                 } else {
                     // creating number cards
                     Card nc = new Card(str1, suit.get(j));
                     deck.add(nc);
                     // Debug:
                     // System.out.println(nc.toString());
                 }
                 }
            }
         // shuffle the array when the deck is created
         Collections.shuffle(deck);
        }

    /**
     * Other Methods
     */

        public void deal (ArrayList hand1, ArrayList hand2) {
            for (int i = 0; i < deck.size(); i++) {
                hand1.add(deck.get(i));
                i++;
                hand2.add(deck.get(i));
            }
            System.out.println("PLayer 1 hand: "+hand1);
            System.out.println("PLayer 2 hand: "+hand2);
        }






}
