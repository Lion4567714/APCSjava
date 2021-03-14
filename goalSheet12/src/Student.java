/**
 * <b>Student</b>
 * "Data" for DataProcessing GS12-04
 *
 * @author Anders Gilliland
 * @version 1.1
 * @since 2021-3-13
 */
public class Student {
    private String lastName;
    private String firstName;
    private int idNumber;
    private float gradePer;
    private char gradeLet;

    public Student(String lastName, String firstName, int idNumber, float gradePer, char gradeLet) {
        setLastName(lastName);
        setFirstName(firstName);
        setIdNumber(idNumber);
        setGradePer(gradePer);
        setGradeLet(gradeLet);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setGradePer(float gradePer) {
        this.gradePer = gradePer;
    }

    public void setGradeLet(char gradeLet) {
        this.gradeLet = gradeLet;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public float getGradePer() {
        return gradePer;
    }

    public char getGradeLet() {
        return gradeLet;
    }

    public String toString() {
        return lastName + "\t" + firstName + "\t" + idNumber + "\t" + gradePer + "\t" + gradeLet;
    }

    /**
     * Method to compare Student objects with other students
     * @param s Other student
     * @param compareType Characteristic to compare (last name, first name, student ID,
     *                    grade percentage, and letter grade)
     * @return The relation this Student object has with the other Student. In ascending order:
     *          1   - This Student should be placed above
     *          -1  - This Student should be places below
     */
    public int compareTo(Student s, int compareType) {
        if (compareType == 1) { // Last Name
            // Compare lengths of last names, use whichever is longest to decide how long the
            // letter-comparing loops goes for.
            int len;
            if (this.lastName.length() >= s.getLastName().length()) {
                len = this.lastName.length();
            } else {
                len = s.getLastName().length();
            }

            // Compare both last names, letter-by-letter. When the first difference between names is
            // detected, return the comparison value.
            // If the names have been the same thus far, but one name is longer than another, catch
            // the out of bounds exception and compare based on length.
            for (int i = 0; i < len; i++) {
                try {
                    if (this.lastName.charAt(i) < s.getLastName().charAt(i)) {
                        return 1;
                    } else if (this.lastName.charAt(i) > s.getLastName().charAt(i)) {
                        return -1;
                    }
                } catch (IndexOutOfBoundsException e) {
                    if (this.lastName.length() < s.getLastName().length()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }

            // If no difference between names was detected (same last name), compare by first name.
            return compareTo(s, 2);
        } else if (compareType == 2) { // First Name
            int len;
            if (this.firstName.length() >= s.getFirstName().length()) {
                len = this.firstName.length();
            } else {
                len = s.getFirstName().length();
            }

            for (int i = 0; i < len; i++) {
                try {
                    if (this.firstName.charAt(i) < s.getFirstName().charAt(i)) {
                        return 1;
                    } else if (this.firstName.charAt(i) > s.getFirstName().charAt(i)) {
                        return -1;
                    }
                } catch (IndexOutOfBoundsException e) {
                    if (this.firstName.length() < s.getFirstName().length()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }

            return compareTo(s, 1);
        } else if (compareType == 3) { // Student ID
            if (this.idNumber == s.getIdNumber()) {
                throw new IllegalArgumentException();
            } else if (this.idNumber > s.getIdNumber()) {
                return 1;
            } else {
                return -1;
            }
        } else if (compareType == 4) { // Grade Percentage
            if (this.gradePer == s.getGradePer()) {
                return compareTo(s, 1);
            } else if (this.gradePer > s.getGradePer()) {
                return 1;
            } else {
                return -1;
            }
        } else if (compareType == 5) { // Grade Letter
            if (this.gradeLet == s.getGradeLet()) {
                return compareTo(s, 4);
            } else if (this.gradeLet > s.getGradeLet()) {
                return 1;
            } else {
                return -1;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /*public int compareLastName(Student s) {
        // Compare lengths of last names, use whichever is longest to decide how long the letter-
        // comparing loops goes for.
        int len;
        if (this.lastName.length() >= s.getLastName().length()) {
            len = this.lastName.length();
        } else {
            len = s.getLastName().length();
        }

        // Compare both last names, letter-by-letter. When the first difference between names is
        // detected, return the comparison value.
        // If the names have been the same thus far, but one name is longer than another, catch the
        // out of bounds exception and compare based on length.
        for (int i = 0; i < len; i++) {
            try {
                if (this.lastName.charAt(i) < s.getLastName().charAt(i)) {
                    return 1;
                } else if (this.lastName.charAt(i) > s.getLastName().charAt(i)) {
                    return -1;
                }
            } catch (IndexOutOfBoundsException e) {
                if (this.lastName.length() < s.getLastName().length()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        // If no difference between names was detected (same last name), compare by first name.
        return compareFirstName(s);
    }

    public int compareFirstName(Student s) {
        int len;
        if (this.firstName.length() >= s.getFirstName().length()) {
            len = this.firstName.length();
        } else {
            len = s.getFirstName().length();
        }

        for (int i = 0; i < len; i++) {
            try {
                if (this.firstName.charAt(i) < s.getFirstName().charAt(i)) {
                    return 1;
                } else if (this.firstName.charAt(i) > s.getFirstName().charAt(i)) {
                    return -1;
                }
            } catch (IndexOutOfBoundsException e) {
                if (this.firstName.length() < s.getFirstName().length()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        return compareLastName(s);
    }

    public int compareIdNumber(Student s) {
        if (this.idNumber == s.getIdNumber()) {
            throw new IllegalArgumentException();
        } else if (this.idNumber > s.getIdNumber()) {
            return 1;
        } else {
            return -1;
        }
    }

    public int compareGradePer(Student s) {
        if (this.gradePer == s.getGradePer()) {
            return compareLastName(s);
        } else if (this.gradePer > s.getGradePer()) {
            return 1;
        } else {
            return -1;
        }
    }

    public int compareGradeLet(Student s) {
        if (this.gradeLet == s.getGradeLet()) {
            return compareGradePer(s);
        } else if (this.gradeLet > s.getGradeLet()) {
            return 1;
        } else {
            return -1;
        }
    }*/
}