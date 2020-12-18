//  Name:       Anders Gilliland
//  Project:    GS07-04 CalendarDate
//  Purpose:    Modify the CalendarDate class to include a year field, and modify its compareTo
//              to take years into account when making comparisons. (BJP Ch 10 Ex 19)

public class CalendarDate implements Comparable<CalendarDate> {
    private int month;
    private int day;
    private int year;

    public CalendarDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    //  Compares this calendar date to another date.
    //  Dates are compared by year, month, then by day.
    public int compareTo(CalendarDate other) {
        if (this.year != other.year) {
            return this.year - other.year;
        } else if (this.month != other.month) {
            return this.month - other.month;
        } else {
            return this.day - other.day;
        }
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getYear() {
        return this.year;
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
