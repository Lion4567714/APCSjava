//  Name:       Anders Gilliland
//  Project:    GS06-01 through 03 Ticket Class
//  Purpose:    Implement ticket class and other subclasses for keeping track of tickets

public class Ticket {

    int number;
    int price;

    Ticket (int number) {
        this.number = number;
    }

    int getPrice() {
        return 0;
    }

    public String toString() {
        return "Number: " + number + ", Price: " + price;
    }
}