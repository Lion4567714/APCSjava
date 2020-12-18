/**
 * This is a class that tests the Card class.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<Card>();

        //  Call the cardCreator method 3 times
        for (int i = 0; i < 3; i++) {
            cards.add(cardCreator());
        }

        //  Test card to compare other cards to
        Card card = new Card("7", "Diamonds", 7);

        //  Display the data for all cards
        System.out.println("Cards:");
        System.out.println("--------------------");
        for (Card c : cards) {
            System.out.println(c.toString());
            System.out.println("CompareTo test card: " + c.compareTo(card));
            System.out.println();
        }
        System.out.println("--------------------");
    }

    //  Method for creating a new card
    //  Constructs card with user input from the console
    public static Card cardCreator() {
        Scanner scanner = new Scanner(System.in);

        String rank;
        String suit;
        int value;

        //  Get the card's rank
        System.out.print("Card Rank:          ");
        rank = scanner.next();

        //  Get the card's suit
        System.out.print("Card Suit:          ");
        suit = scanner.next();

        //  Get the card's point value
        System.out.print("Card Point Value:   ");
        value = scanner.nextInt();

        System.out.print("\n");

        //  Return the new card
        return new Card(rank, suit, value);
    }
}
