package motioncbs.shared;

public class FieldVerifier {


    //Fieldverifier til vores brugernavn, efternavn samt fornavn
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
        if (ageNumber < 15 || ageNumber > 99)
            return false;
        else
            return true;
    }

    //Fieldverifier til vores password der som minimum skal indeholde 4 karakterer
    public static boolean isValidPass(String pass) {
        // check if name field is empty (not allowed)
        if (pass.isEmpty()) {
            return false;
        }
        // checker om passwordet indeholder minimumer 4 bogstaver/tal. Hvis det gør accepterer den!
        return pass.length() > 3;
    }

    //Fieldverifier til vores password der som minimum skal indeholde 4 karakterer
    public static boolean isValidBrugernavn(String pass) {
        // check if name field is empty (not allowed)
        if (pass.isEmpty()) {
            return false;
        }
        // checker om passwordet indeholder minimum 3 bogstaver/tal. Hvis det gør accepterer den!
        return pass.length() > 2;
    }



}
