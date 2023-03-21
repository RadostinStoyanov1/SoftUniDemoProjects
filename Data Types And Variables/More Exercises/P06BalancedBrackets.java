package P09dataTypesAndVariables_More_Exercises;

import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nLines = Integer.parseInt(scanner.nextLine());

        boolean isPreviousBracketOpening = false;
        int openingCounter = 0;
        int closingCounter = 0;
        boolean twoConsecutiveOpenings = false;

        for (int i = 1; i <= nLines; i++) {
            String currentInput = scanner.nextLine();

            if (currentInput.equals("(")) {
                if (isPreviousBracketOpening) {
                    System.out.println("UNBALANCED");
                    twoConsecutiveOpenings = true;
                    break;
                } else {
                    openingCounter++;
                }
                isPreviousBracketOpening = true;
            } else if (currentInput.equals(")")) {
                if (isPreviousBracketOpening) {
                    closingCounter++;
                    isPreviousBracketOpening = false;
                } else {
                    System.out.println("UNBALANCED");
                    twoConsecutiveOpenings = true;
                    break;
                }
            }

        }

        if (!twoConsecutiveOpenings) {
            if (openingCounter == closingCounter) {
                System.out.println("BALANCED");
            } else {
                System.out.println("UNBALANCED");
            }
        }

    }
}
