package motioncbs.shared;

public class FieldVerifier {


    //Fieldverifier til vores brugernavn, efternavn samt fornavn
    public static boolean isValidName(String name) {
        // checker for at navn felet er tomt - ikke tilladt
        if (name.isEmpty()) {
            return false;
        }
        // checker for at navn felet indeholdet tal - ikke tilladt
        for (int n=0 ; n < name.length() ;n++) {
            if (Character.isDigit(name.charAt(n)))
                return false;
        }

        // checker for at navnet er af mindst 2 bogstaver - hvis ikke accepteres det ikke

        return name.length() > 1;
    }

    public static boolean isValidAge(String age) {
        int ageNumber;

        // checker for at alder felet er tomt - ikke tilladt
        if (age.isEmpty()) {
            return false;
        }

        // checker for at alder feltet ikke indeholder bogstaver - ikke tilladt
        try {
            // try to convert to a number
            ageNumber = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            // invalid number
            return false;
        }

        // checker at det indtastede er mellem 14 og 99 - andet er ikke tilladt
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

    public static boolean isGenderPicked(Boolean gender){
      if (gender.equals(true))
          return true;
      else {
          return false;
      }
    }

    public static boolean isCustomertypePicked(Boolean customerType){
        if (customerType.equals(true))
            return true;
        else {
            return false;
        }


    }



}
