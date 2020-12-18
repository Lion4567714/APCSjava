//  Name:       Anders Gilliland
//  Project:    Card Class - "Elevens" Lab
//  Purpose:    Implement the Card class with the requirements:
//                  -A constructor that takes two String parameters representing rank and suit, with
//                  an Int parameter representing the point value of the card.
//                  -Accessor method for the card's rank, suit, and point value.
//                  -A method to test equality between two card objects.
//                  -ToString method to create a String with rank, suit, and value of the card.

public class Card implements Comparable<Card> {

    private String rank;
    private String suit;
    private int value;

    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    public String getRank() {
        return this.rank;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return this.rank + " of " + this.suit + " (point value = " + this.value + ")";
    }

    @Override
    public int compareTo(Card o) {
        //  Integer.compare recommended to me by IntelliJ
        //  Returns...
        //      0 if the integers are equal
        //      1 if the original integer is greater
        //      -1 if the original integer is lesser
        return Integer.compare(this.value, o.getValue());
    }
}
