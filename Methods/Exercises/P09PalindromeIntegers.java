package P15Methods_Exercises;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            if (input.length() % 2 == 0) {
                System.out.println(isPalindromeForEvenDigitNumbers(input));
            } else {
                System.out.println(isPalindromeForOddDigitNumbers(input));
            }
            input = scanner.nextLine();
        }

    }

    public static boolean isPalindromeForEvenDigitNumbers (String input) {
        char[] inputArr = input.toCharArray();
        int counter = inputArr.length / 2;
        for (int i = (inputArr.length / 2) - 1; i >= 0; i--) {
            if (inputArr[i] != inputArr[counter]) {
                return false;
            }
            counter++;
        }
        return true;
    }

    public static boolean isPalindromeForOddDigitNumbers (String input) {
        char[] inputArr = input.toCharArray();
        int counter = (inputArr.length / 2) + 1;
        for (int i = (inputArr.length / 2) - 1; i >= 0; i--) {
            if (inputArr[i] != inputArr[counter]) {
                return false;
            }
            counter++;
        }
        return true;
    }

}
