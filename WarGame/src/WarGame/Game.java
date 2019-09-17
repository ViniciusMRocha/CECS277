package WarGame;

import java.util.*;

public class Game {

    /**
     * Variables
     *
     */
    ArrayList<Object> table = new ArrayList<>();

    public Game(ArrayList player1, ArrayList player2) {

            System.out.println("Running the game");

            System.out.println("Player 1 size: " + player1.size());
            System.out.println("Player 2 size: " + player2.size());

    }

    public void playWar (ArrayList player1, ArrayList player2) {

        System.out.println("player1 Hand Before: " + player1.toString());
        System.out.println("player2 Hand Before: " + player2.toString());


        while (player1.size() != 0 || player2.size()!=0) {

            table.add(player1.get(0));
            player1.remove(0);
            table.add(player2.get(0));
            player2.remove(0);

        }

        System.out.println("player1 Hand After: " + player1.toString());
        System.out.println("player2 Hand After: " + player2.toString());

        System.out.println("Table: "+table.toString());
        System.out.println("Table Size: "+table.size());

    }
}
