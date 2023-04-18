package P15Methods_Exercises;

import java.util.Scanner;

public class P04PasswordValidator {

    static boolean isLengthOK = false;
    static boolean isLettersAndDigitsOK = false;
    static boolean isTwoDigitsOK = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] inputAsCharArr = input.toCharArray();

        checkPasswordLength(inputAsCharArr);
        checkForLettersAndDigits(inputAsCharArr);
        checkForTwoDigits(inputAsCharArr);

        if (isLengthOK && isLettersAndDigitsOK && isTwoDigitsOK) {
            System.out.println("Password is valid");
        }

    }

    public static void checkPasswordLength (char[] inputArr) {
        if (inputArr.length >= 6 && inputArr.length <= 10) {
            isLengthOK = true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
        }
    }

    public static void checkForLettersAndDigits (char[] inputArr) {
        boolean isCheckSuccessful = true;
        for (char c : inputArr) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                continue;
            } else {
                System.out.println("Password must consist only of letters and digits");
                isCheckSuccessful = false;
                break;
            }
        }
        if (isCheckSuccessful) {
            isLettersAndDigitsOK = true;
        }
    }

    public static void checkForTwoDigits (char[] inputArr) {
        int digitCounter = 0;
        for (char c : inputArr) {
            if (Character.isDigit(c)) {
                digitCounter++;
            }
        }
        if (digitCounter < 2) {
            System.out.println("Password must have at least 2 digits");
        } else {
            isTwoDigitsOK = true;
        }
    }

}
