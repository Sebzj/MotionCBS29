package motioncbs.shared;

public class FieldVerifier {


    public static boolean isValidName(String name) {
        // check if name field is empty (not allowed)
        if (name.isEmpty()) {
            return false;
        }
        // check if name fields contains digits (not allowed)
        for (int n=0 ; n < name.length() ;n++) {
            if (Character.isDigit(name.charAt(n)))
                return false;
        }

        // check if name contains at least two characters
        // if it does we accept the name, otherwise not
        return name.length() > 1;
    }

    public static boolean isValidAge(String age) {
        int ageNumber;

        // check if age field is empty (not allowed)
        if (age.isEmpty()) {
            return false;
        }

        // check if age field contains a number
        try {
            // try to convert to a number
            ageNumber = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            // invalid number
            return false;
        }

        // check if number is between 0 and 99
        if (ageNumber < 0 || ageNumber > 99)
            return false;
        else
            return true;
    }



}
