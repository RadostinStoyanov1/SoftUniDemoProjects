package P12Arrays_More_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] input = new String[n];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextLine();
            String currentString = input[i];

            int currentSum = 0;

            for (int j = 0; j < currentString.length(); j++) {
                if ((currentString.charAt(j) == 'a') || (currentString.charAt(j) == 'e') || (currentString.charAt(j) == 'i') ||
                        (currentString.charAt(j) == 'o') || (currentString.charAt(j) == 'u') || (currentString.charAt(j) == 'A') ||
                        (currentString.charAt(j) == 'E') || (currentString.charAt(j) == 'I') || (currentString.charAt(j) == 'O') ||
                        (currentString.charAt(j) == 'U')) {
                    currentSum += currentString.charAt(j) * currentString.length();
                } else {
                    currentSum += currentString.charAt(j) / currentString.length();
                }

            }

            output[i] = currentSum;

        }

        Arrays.sort(output);

        for (int i : output) {
            System.out.println(i);
        }

    }
}
