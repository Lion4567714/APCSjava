import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * <b>Data Processing GS12-04</b>
 * Write a program that processes a data file of students' grade data. The data should arrive in a
 * random order, each line stores information about a student's last name, first name, student ID
 * number, grade as a percentage, and letter grade. It should be able to sort the data by any of the
 * columns. Use comparators to achieve sort orderings. Make the data sortable by any category in
 * ascending or descending order.
 *
 * @author Anders Gilliland
 */
public class DataProcessing {
    public static void main (String[] args) throws IOException {
        // Initialize and populate an ArrayList of students from the .txt file
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner file = new Scanner(new File("src\\studentData.txt"));
        file.useDelimiter("\t");

        while (file.hasNextLine()) {
            String lastName = file.next();
            String firstName = file.next();
            int idNumber = file.nextInt();
            float gradePer = file.nextFloat();
            char gradeLet = file.next().charAt(0);

            System.out.println(lastName + " " + firstName + " " + idNumber + " " + gradePer + " " +
                    gradeLet);

            Student s = new Student(lastName, firstName, idNumber, gradePer, gradeLet);
            students.add(s);
        }

        file.close();

        // Interact with the user to determine how the data should be sorted
        Scanner console = new Scanner(System.in);
        System.out.println("Student Data Processor");
        System.out.println("How would you like to sort the data?");
        System.out.println("(1) Last Name   (2) First Name   (3) Student ID   (4) Grade (Percent)" +
                "   (5) Grade (Letter)");
        int sortBy = console.nextInt();
        System.out.println("Sort by (1) ascending or (2) descending?");
        int direction = console.nextInt();

        // Sort the students
        students = sort(students, sortBy, direction);

        // Print the student's sorted data
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    public static ArrayList<Student> sort (ArrayList<Student> students, int sortBy, int direction) {
        return students;
    }
}
