package WarGame;

import java.util.*;

/**
 * Creates a War Game which requires 2 ArrayLists for ech of the player to play.
 * The rules of the game are:
 * Both players show their top card, the higher card wins.
 * If a player loses they may chose to play a second card. The sum of the new card with the previous has to be higher in order for the player to take all the cards, otherwise they lose
 * It there is a tie, both players draw 3 more card and compare the 4th. This is called war.
 *  @author Vinicius Rocha
 *  @version 1.0.0
 */
public class Game {

// Variables
    ArrayList<Card> table = new ArrayList<Card>();

    /**
     * Creates and start the a war game
     * @param player - This is the players deck of cards
     * @param cpu - This is the computer deck of cards
     */
    public Game(ArrayList<Card> player, ArrayList<Card> cpu) {

        System.out.println(" ");
        System.out.println("                W A R   G A M E                ");
        System.out.println(" ");


        System.out.println("Rules: ");
        System.out.println("1) You must play war until the game is over. There is no quitters here");
        System.out.println("2) If you lose you may chose to play a second card. \n If the second card + the first card is higher then you opponent you win their card \n Otherwise you lose both cards");
        System.out.println("3) Enter 'Y' or 'Yes' to play a second card or 'N' or No to not play a second card when asked from the game");
        System.out.println(" ");

        System.out.println("Let's War");
        System.out.println(" ");

        // Round Counter
        int r=0;

        // Get username
        Scanner user = new Scanner(System.in);
        System.out.println("Enter username: ");
        String userName = user.nextLine();
        System.out.println("Username is: " + userName);

        while (player.size() !=0 && cpu.size() !=0 ) {
            //Round counter
            r++;
            System.out.println(" ============== Round " +r+ " ============== ");

            //CPU orders if the difference is less then 7 play it otherwise do not plat it
            // Place player cards on the table
            table.add(0,player.remove(0));
            table.add(1,cpu.remove(0));
            System.out.println(userName+" > "+table.toString()+" < CPU ");

            // User wins
            if (table.get(0).getRank() > table.get(1).getRank()) {

                // CPU decided to play a second card when the difference between the cards is less then or equal to 5
                // CPU should not play when there is a tie
                if (table.get(0).getRank() - table.get(1).getRank() <= 5 && table.get(0).getRank() - table.get(1).getRank() > 0) {
                    System.out.println(" ");
                    System.out.println("CPU lost, but will play another card");
                    // Add new card to position 1
                    table.add(1,cpu.remove(0));
                    // Print the new table
                    System.out.println(userName+" > "+table.toString()+" < CPU ");

                    // create a variable to store the sum of the CPU's card
                    int sumOfCard;
                    sumOfCard=  table.get(1).getRank() + table.get(2).getRank();
                    System.out.println("The sum of your cards is :"+sumOfCard);

                    // If the player's cards is higher then sum of the CPU cards then give the card to the player
                    if (table.get(0).getRank() > sumOfCard) {
                        System.out.println(" ");
                        // Clean the table and give to the player
                        System.out.println(userName+" wins");
                        while (table.size() > 0) {
                            player.add(table.remove(0));
                        }

                    } else {
                        System.out.println(" ");
                        // Clean the table and give to CPU
                        System.out.println("CPU wins");
                        while (table.size() > 0) {
                            cpu.add(table.remove(0));
                        }
                    }

                }
                else {
                    System.out.println("CPU will NOT play another card");
                    System.out.println(userName+" wins");
                    // Clean the table and give to the player
                    while (table.size() > 0) {
                        player.add(table.remove(0));
                    }
                }


                System.out.println(" ");
                System.out.println(userName+" deck size: " + player.size());
                System.out.println("CPU deck size: " + cpu.size());
                System.out.println(" ");

            // CPU wins
            } else if (table.get(0).getRank() < table.get(1).getRank()) {
                System.out.println("CPU wins");

                // If the play is a tie, the player should not play a second card
                if (table.get(0).getRank() - table.get(1).getRank() != 0) {
                    // Ask the user for another try
                    Scanner userChoice = new Scanner(System.in);
                    System.out.println("Do you want to try a another card: ");
                    String userDecision = userChoice.nextLine();

                    if (userDecision.contains("Y") || userDecision.contains("y")) {
                        // add  a card on the first position of the table ArrayList
                        table.add(0,player.remove(0));
                        System.out.println(userName+" > "+table.toString()+" < CPU ");

                        // Add the new card rank with the old card
                        int newTry;
                        newTry = table.get(0).getRank() + table.get(1).getRank();
                        System.out.println("The sum of your cards is :"+newTry);

                        //User won
                        if (newTry > table.get(table.size()-1).getRank()){
                            System.out.println(userName+" wins");
                            // Clean the table and give to the winner
                            while (table.size() > 0) {
                                player.add(table.remove(0));
                            }
                            System.out.println(" ");
                            System.out.println(userName+" deck size: " + player.size());
                            System.out.println("CPU deck size: " + cpu.size());
                            System.out.println(" ");

                        }
                        else {
                            System.out.println("CPU wins");
                            while (table.size() > 0) {
                                cpu.add(table.remove(0));
                            }
                            System.out.println(" ");
                            System.out.println(userName+" deck size: " + player.size());
                            System.out.println("CPU deck size: " + cpu.size());
                            System.out.println(" ");
                        }

                    } else {
                        System.out.println(userName+" decided not to play a second card");
                        while (table.size() > 0) {
                            cpu.add(table.remove(0));
                        }
                        System.out.println(" ");
                        System.out.println(userName+" deck size: " + player.size());
                        System.out.println("CPU deck size: " + cpu.size());
                        System.out.println(" ");
                    }
                } else {
                    while (table.size() > 0) {
                        cpu.add(table.remove(0));
                    }
                    System.out.println(" ");
                    System.out.println(userName+" deck size: " + player.size());
                    System.out.println("CPU deck size: " + cpu.size());
                    System.out.println(" ");
                }

            // Tie scenarios
            } else {
                // Both player have 4 or more cards
                if(player.size()>=4 && cpu.size()>=4) {
                    System.out.println("It was a tie ... Time for WAR!");

                    //Add three cards to the table
                    for (int j = 0; j < 3; j++) {
                        table.add(player.remove(0));
                        table.add(cpu.remove(0));
                    }
                }

                // User has less then 4 cards
                else if (player.size()<4){
                    System.out.println("It was a tie ... Time for WAR!");

                    // Use the size for looping over the rest of the card
                    for (int i = 0; i < player.size(); i++) {
                        table.add(player.remove(0));
                    }

                    // Add CPU 3 card to the table
                    for (int j = 0; j < 3; j++) {
                        table.add(cpu.remove(0));
                    }

                    // add cards to the right position for comparison
                    table.add(0,player.remove(0));
                    table.add(1,cpu.remove(0));

                // CPU has less then 4 cards
                } else if (cpu.size()<4) {
                    System.out.println("It was a tie ... Time for WAR!");

                    // Use the size for looping over the rest of the card
                    for (int i = 0; i < cpu.size(); i++) {
                        table.add(cpu.remove(0));
                    }

                    //Add three cards to the table
                    for (int j = 0; j < 3; j++) {
                        table.add(player.remove(0));
                    }
                    // add cards to the right position for comparison
                    table.add(0, player.remove(0));
                    table.add(1, cpu.remove(0));
                }

                // If one of the players has only one card
                else if (player.size()==1 || cpu.size()==1){
                    // add cards to the right position for comparison
                    table.add(0, player.remove(0));
                    table.add(1, cpu.remove(0));
                }
                // Add case of for the last game to be a draw

            }
        }

        System.out.println(" ");
        System.out.println("********* GAME IS OVER *********");
        if (player.size()>cpu.size()){
            System.out.println(userName+" is the winner");
        } else {
            System.out.println("CPU is the winner");
        }
        System.out.println(" ");

    }

}
