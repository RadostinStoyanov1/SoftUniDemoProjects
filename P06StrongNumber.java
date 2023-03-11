package P06BasicSyntaxConditionalStatementsAndLoops_Exercizes;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int numDigits = input.length();
        int sumFactorials = 0;
        int inputNumber = Integer.parseInt("" + input);

        for (int i = 0; i < numDigits; i++) {
            int currentDigit = Integer.parseInt("" + input.charAt(i));
            int currentFactorial = 1;
            for (int j = currentDigit; j > 1; j--) {
                currentFactorial *= j;
            }
            sumFactorials += currentFactorial;
        }

        if (sumFactorials == inputNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
