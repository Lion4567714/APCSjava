public class AdvanceTicket extends Ticket {

    AdvanceTicket(int number) {
        super(number);
    }

    int getPrice(int days) {
        if (days < 10) {
            return 40;
        } else {
            return 30;
        }
    }
}
