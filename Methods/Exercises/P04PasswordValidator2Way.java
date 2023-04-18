package P15Methods_Exercises;

import java.util.Scanner;

public class P04PasswordValidator2Way {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean isLengthValid = isLengthValid(input);
        if (!isLengthValid) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        
        boolean isLettersAndDigits = isLettersAndDigits(input);
        if (!isLettersAndDigits) {
            System.out.println("Password must consist only of letters and digits");
        }
        
        boolean isTwoDigits = isTwoDigits(input);
        if (!isTwoDigits) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isLengthValid && isLettersAndDigits && isTwoDigits) {
            System.out.println("Password is valid");
        }

    }

    public static boolean isLengthValid (String input) {
        if (input.length() >= 6 && input.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isLettersAndDigits (String input) {
        char[] inputArr = input.toCharArray();
        for (char c : inputArr) {
            if (!Character.isDigit(c) && !Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isTwoDigits (String input) {
        char[] inputArr = input.toCharArray();
        int digitsCounter = 0;
        for (char c : inputArr) {
            if (Character.isDigit(c)) {
                digitsCounter++;
            }
        }
        if (digitsCounter >= 2) {
            return true;
        } else {
            return false;
        }
    }

}
