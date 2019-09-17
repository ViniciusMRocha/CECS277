package WarGame;

import java.util.ArrayList;

public class Play {

    public ArrayList turn;

    public Play(ArrayList round){
        this.turn = round;
        System.out.println("Printin round");
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
        }

    }

}