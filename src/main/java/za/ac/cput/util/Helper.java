package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {

    public static boolean isNullOrEmpty(String str) {
        if ((str == null) || (str.isEmpty())) {
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);

    }

    public static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    public static boolean isNumeric(String str) {
        if (isNullOrEmpty(str)) return false;

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static boolean isValidPostalCode(String postalCode) {
        if (isNullOrEmpty(postalCode)) return false;
        return postalCode.matches("\\d{4}");
    }
}
