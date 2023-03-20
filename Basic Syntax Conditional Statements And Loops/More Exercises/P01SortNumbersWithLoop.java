package P06BasicSyntaxConditionalStatementsAndLoops_More_Exercizes;

import java.util.Scanner;

public class P01SortNumbersWithLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int highestNumber = 0;
        int lowestNumber = 0;
        int middleNumber = 0;

        for (int i = 1; i <= 3; i++) {
            int input = Integer.parseInt(scanner.nextLine());

            if (i == 1) {
                highestNumber = input;
            } else if (i == 2) {
                if (input >= highestNumber) {
                    middleNumber = highestNumber;
                    highestNumber = input;
                } else {
                    middleNumber = input;
                }
            } else if (i == 3) {
                if (input <= middleNumber) {
                    lowestNumber = input;
                } else {
                    if (input > highestNumber) {
                        lowestNumber = middleNumber;
                        middleNumber = highestNumber;
                        highestNumber = input;
                    } else {
                        lowestNumber = middleNumber;
                        middleNumber = input;
                    }
                }
            }

        }

        System.out.println(highestNumber);
        System.out.println(middleNumber);
        System.out.println(lowestNumber);

    }
}
