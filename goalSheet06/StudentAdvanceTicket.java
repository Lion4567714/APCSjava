public class StudentAdvanceTicket extends Ticket {

    StudentAdvanceTicket(int number) {
        super(number);
    }

    int getPrice(int days) {
        if (days < 10) {
            return 20;
        } else {
            return 15;
        }
    }

    public String toString() {
        return "Number: " + number + ", Price: " + price + " (ID Required)";
    }
}
