package WarGame;

public class Card{
    public String rank;
    public String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank+" "+suit;
    }

    public String getRank () {return rank;}
    }
