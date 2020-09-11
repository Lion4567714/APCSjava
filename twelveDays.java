public class twelveDays {
    public static void main(String[] args) {
        System.out.println("The Twelve Days of Christmas\n");
        int i = 1;
        while (i < 13) {
            System.out.println("One the " + adjective(i) + " day of Christmas,");
            System.out.println("my true love gave to me");
            System.out.println(days(i));
            i++;
        }
    }

    public static String adjective(int day) {
        return switch (day) {
            case 1 -> "first";
            case 2 -> "second";
            case 3 -> "third";
            case 4 -> "fourth";
            case 5 -> "fifth";
            case 6 -> "sixth";
            case 7 -> "seventh";
            case 8 -> "eighth";
            case 9 -> "ninth";
            case 10 -> "tenth";
            case 11 -> "eleventh";
            case 12 -> "twelfth";
            default -> "ERROR";
        };

    }

    public static String days(int day) {
        String gifts = "";
        if (day == 12) {
            gifts += "twelve drummers drumming,\n";
        }
        if (day >= 11) {
            gifts += "eleven pipers piping,\n";
        }
        if (day >= 10) {
            gifts += "ten lords a-leaping,\n";
        }
        if (day >= 9) {
            gifts += "nine ladies dancing,\n";
        }
        if (day >= 8) {
            gifts += "eight maids a-milking,\n";
        }
        if (day >= 7) {
            gifts += "seven swans a-swimming,\n";
        }
        if (day >= 6) {
            gifts += "six geese a-laying,\n";
        }
        if (day >= 5) {
            gifts += "five golden rings,\n";
        }
        if (day >= 4) {
            gifts += "four calling birds,\n";
        }
        if (day >= 3) {
            gifts += "three French hens,\n";
        }
        if (day >= 2) {
            gifts += "two turtle doves, and\n";
        }
        if (day >= 1) {
            gifts += "a partridge in a pear tree.\n";
        }
        return gifts;
    }
}
