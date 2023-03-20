package P06BasicSyntaxConditionalStatementsAndLoops_More_Exercizes;

import java.util.Scanner;

public class P05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numInputs = Integer.parseInt(scanner.nextLine());
        String smsText = "";

        for (int i = 1; i <= numInputs; i++) {
            int currentInput = Integer.parseInt(scanner.nextLine());
            String currentInputAsString = "" + currentInput;
            int currentNumDigits = currentInputAsString.length();
            int currentMainDigit = currentInput % 10;
            int currentOffset = 0;
            if (currentMainDigit >= 0 && currentMainDigit < 8) {
                currentOffset = (currentMainDigit - 2) * 3;
            } else if (currentMainDigit >= 8 && currentMainDigit <= 9) {
                currentOffset = ((currentMainDigit - 2) * 3) + 1;
            }

            int letterIndex = (currentOffset + currentNumDigits - 1);
            char currentChar = 'a';
            if (letterIndex < 0) {
                currentChar = ' ';
            } else {
                currentChar += letterIndex;
            }
            smsText = smsText + currentChar;

        }

        System.out.println(smsText);

    }
}
